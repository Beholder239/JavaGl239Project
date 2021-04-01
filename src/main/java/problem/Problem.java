package problem;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "На плоскости задано множество точек, и прямоугольник. Множество точек образует\n" +
            "   все возможные прямые, которые могут быть построены парами точек множества.\n" +
            "Требуется найти такую прямую (и такие две точки, через которые она проходит), что эта прямая\n" +
            "   пересекает указанный прямоугольник, и при этом длина отрезка прямой,\n" +
            "   находящейся внутри прямоугольника, максимальна.";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-1 Гладышева Никиты";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private Rect rect;

    private Line resLine;
    private Point resA;
    private Point resB;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x координата X точки
     * @param y координата Y точки
     */
    public void addPoint(double x, double y) {
        Point point = new Point(x, y);
        points.add(point);
    }


    public void setRect(double x1, double y1, double x2, double y2, double x3, double y3) {
        rect = new Rect(x1, y1, x2, y2, x3, y3);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        // перебираем пары точек
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них не совпадают
                    if (Math.abs(p.x - p2.x) >= 0.01 && Math.abs(p.y - p2.y) > 0.01) {
                        Line l = new Line(rect.a1,rect.a2,rect.a3,rect.a4);
                        Line l1 = new Line(rect.a5,rect.a6,rect.a5 + l.A,rect.a6 + l.B);
                        Line l2 = new Line(rect.a5,rect.a6,rect.a5 + l1.A,rect.a6 + l1.B);
                        Line lp1 = new Line(rect.a1,rect.a2,rect.a1 + l.A,rect.a2 + l.B);
                        Line lp2 = new Line(rect.a3,rect.a4,rect.a3 + l.A,rect.a4 + l.B);
                        Point o = new Point((lp1.B*l2.C-lp1.C*l2.B)/(lp1.A*l2.B-lp1.B*l2.A), (lp1.A*l2.C-lp1.C*l2.A)/(lp1.B*l2.A-lp1.A*l2.B));
                        Point o1=new Point((lp2.B*l2.C-lp2.C*l2.B)/(lp2.A*l2.B-lp2.B*l2.A), (lp2.A*l2.C-lp2.C*l2.A)/(lp2.B*l2.A-lp2.A*l2.B));

                    }
                }
            }
        }

//        resA =
//        resB =
//        resLine =
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            sc.nextLine();
            rect = new Rect(x1,y1,x2,y2,x3,y3);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                sc.nextLine();
                Point p = new Point(x, y);
                points.add(p);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            out.printf("%.2f %.2f %.2f %.2f %.2f %.2f\n", rect.a1, rect.a2, rect.a3, rect.a4, rect.a5, rect.a6);
            for (Point point : points) {
                out.printf("%.2f %.2f\n", point.x, point.y);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Point p = Point.getRandomPoint();
            points.add(p);
        }
    }

    public void setRandomRect() {
        rect = Rect.getRandomRect();
    }


    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        rect = null;
        resLine = null;
        resA = null;
        resB = null;
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        for (Point point : points) {
            point.render(gl);
        }
//        Rect.renderRect(gl, new Vector2(0,0), new Vector2(0.1,0.1), new Vector2(0,-0.3), 1==1);
        if (rect != null)
            rect.renderRect(gl);
        if (resLine != null) {
            resLine.renderLine(gl, 0);
            resA.render(gl);
            resB.render(gl);
        }
//        Rect r = Rect.getRandomRect();
//        r.renderRect(gl);
    }

}
