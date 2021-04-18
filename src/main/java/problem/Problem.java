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
        double max = 0;
        Point max_p1 = new Point(5, 5);
        Point max_p2 = new Point(5, 5);
        Point Pi = new Point(5, 5);
        Point Pj = new Point(5, 5);
        // перебираем пары точек
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них не совпадают
                    if (Math.abs(p.x - p2.x) >= 0.01 && Math.abs(p.y - p2.y) > 0.01) {
                        Line l = new Line(rect.a1, rect.a2, rect.a3, rect.a4);
                        Line l1 = new Line(rect.a5, rect.a6, rect.a5 + l.A, rect.a6 + l.B);
                        Line l2 = new Line(rect.a5, rect.a6, rect.a5 + l1.A, rect.a6 + l1.B);
                        Line lp1 = new Line(rect.a1, rect.a2, rect.a1 + l.A, rect.a2 + l.B);
                        Line lp2 = new Line(rect.a3, rect.a4, rect.a3 + l.A, rect.a4 + l.B);
                        Point o2 = new Point((lp1.B * l2.C - lp1.C * l2.B) / (lp1.A * l2.B - lp1.B * l2.A), (lp1.A * l2.C - lp1.C * l2.A) / (lp1.B * l2.A - lp1.A * l2.B));
                        Point o1 = new Point((lp2.B * l2.C - lp2.C * l2.B) / (lp2.A * l2.B - lp2.B * l2.A), (lp2.A * l2.C - lp2.C * l2.A) / (lp2.B * l2.A - lp2.A * l2.B));
                        Line line = new Line(p.x, p.y, p2.x, p2.y);
                        Point inter1 = new Point(2, 2);
                        Point inter2 = new Point(2, 2);
                        Point inter3 = new Point(2, 2);
                        Point inter4 = new Point(2, 2);
                        int par1 = 0;
                        int par2 = 0;
                        int par3 = 0;
                        int par4 = 0;
                        boolean b;
                        if (line.B != l.B) {
                            b = Math.abs(l.A / l.B - line.A / line.B) < 0.0001;
                        } else {
                            b = 1 == 1;
                        }
                        if (b == (1 == 0)) {
                            inter1.y = (line.A * l.C - line.C * l.A) / (line.B * l.A - line.A * l.B);
                            inter1.x = (line.B * l.C - line.C * l.B) / (line.A * l.B - line.B * l.A);
                        }
                        if ((Math.abs(inter1.x - rect.a1) + Math.abs(inter1.x - rect.a3) == Math.abs(rect.a3 - rect.a1)) && (Math.abs(inter1.y - rect.a2) + Math.abs(inter1.y - rect.a4) == Math.abs(rect.a2 - rect.a4))) {
                            par1++;
                        }
                        if (line.B != lp2.B) {
                            b = Math.abs(lp2.A / lp2.B - line.A / line.B) < 0.0001;
                        } else {
                            b = 1 == 1;
                        }
                        if (b == (1 == 0)) {
                            inter2.y = (line.A * lp2.C - line.C * lp2.A) / (line.B * lp2.A - line.A * lp2.B);
                            inter2.x = (line.B * lp2.C - line.C * lp2.B) / (line.A * lp2.B - line.B * lp2.A);
                        }
                        if ((Math.abs(inter2.x - o1.x) + Math.abs(inter2.x - rect.a3) == Math.abs(rect.a3 - o1.x)) && (Math.abs(inter2.y - rect.a2) + Math.abs(inter2.y - o1.y) == Math.abs(rect.a2 - o1.y))) {
                            par2++;
                        }
                        if (line.B != l2.B) {
                            b = Math.abs(l2.A / l2.B - line.A / line.B) < 0.0001;
                        } else {
                            b = 1 == 1;
                        }
                        if (b == (1 == 0)) {
                            inter3.y = (line.A * l2.C - line.C * l2.A) / (line.B * l2.A - line.A * l2.B);
                            inter3.x = (line.B * l2.C - line.C * l2.B) / (line.A * l2.B - line.B * l2.A);
                        }
                        if ((Math.abs(inter3.x - o1.x) + Math.abs(inter3.x - o2.x) == Math.abs(o1.x - o2.x)) && (Math.abs(inter3.y - o1.y) + Math.abs(inter3.y - o2.y) == Math.abs(o1.y - o2.y))) {
                            par3++;
                        }
                        if (line.B != lp1.B) {
                            b = Math.abs(lp1.A / lp1.B - line.A / line.B) < 0.0001;
                        } else {
                            b = 1 == 1;
                        }
                        if (b == (1 == 0)) {
                            inter4.y = (line.A * lp1.C - line.C * lp1.A) / (line.B * lp1.A - line.A * lp1.B);
                            inter4.x = (line.B * lp1.C - line.C * lp1.B) / (line.A * lp1.B - line.B * lp1.A);
                        }
                        if ((Math.abs(inter4.x - rect.a1) + Math.abs(inter4.x - o2.x) == Math.abs(o2.x - rect.a1)) && (Math.abs(inter4.y - rect.a2) + Math.abs(inter4.y - o2.y) == Math.abs(rect.a2 - o2.y))) {
                            par4++;
                        }
                        if ((par1 != 0) && (par2 != 0)) {
                            if ((inter1.x - inter2.x) * (inter1.x - inter2.x) + (inter1.y - inter2.y) * (inter1.y - inter2.y) > max) {
                                max = (inter1.x - inter2.x) * (inter1.x - inter2.x) + (inter1.y - inter2.y) * (inter1.y - inter2.y);
                                max_p1.x = inter1.x;
                                max_p1.y = inter1.y;
                                max_p2.x = inter2.x;
                                max_p2.y = inter2.y;
                                Pi.x=p.x;
                                Pi.y=p.y;
                                PJ.x=p2.x;
                                PJ.y=p2.y;
                            }
                        }
                        if ((par1 != 0) && (par3 != 0)) {
                            if ((inter1.x - inter3.x) * (inter1.x - inter3.x) + (inter1.y - inter3.y) * (inter1.y - inter3.y) > max) {
                                max = (inter1.x - inter3.x) * (inter1.x - inter3.x) + (inter1.y - inter3.y) * (inter1.y - inter3.y);
                                max_p1.x = inter1.x;
                                max_p1.y = inter1.y;
                                max_p2.x = inter3.x;
                                max_p2.y = inter3.y;
                                Pi.x=p.x;
                                Pi.y=p.y;
                                PJ.x=p2.x;
                                PJ.y=p2.y;
                            }
                        }
                        if ((par1 != 0) && (par4 != 0)) {
                            if ((inter1.x - inter4.x) * (inter1.x - inter4.x) + (inter1.y - inter4.y) * (inter1.y - inter4.y) > max) {
                                max = (inter1.x - inter4.x) * (inter1.x - inter4.x) + (inter1.y - inter4.y) * (inter1.y - inter4.y);
                                max_p1.x = inter1.x;
                                max_p1.y = inter1.y;
                                max_p2.x = inter4.x;
                                max_p2.y = inter4.y;
                                Pi.x=p.x;
                                Pi.y=p.y;
                                PJ.x=p2.x;
                                PJ.y=p2.y;
                            }
                        }
                        if ((par2 != 0) && (par3 != 0)) {
                            if ((inter2.x - inter3.x) * (inter2.x - inter3.x) + (inter2.y - inter3.y) * (inter2.y - inter3.y) > max) {
                                max = (inter2.x - inter3.x) * (inter2.x - inter3.x) + (inter2.y - inter3.y) * (inter2.y - inter3.y);
                                max_p1.x = inter2.x;
                                max_p1.y = inter2.y;
                                max_p2.x = inter3.x;
                                max_p2.y = inter3.y;
                            }
                        }
                        if ((par2 != 0) && (par4 != 0)) {
                            if ((inter2.x - inter4.x) * (inter2.x - inter4.x) + (inter2.y - inter4.y) * (inter2.y - inter4.y) > max) {
                                max = (inter2.x - inter4.x) * (inter2.x - inter4.x) + (inter2.y - inter4.y) * (inter2.y - inter4.y);
                                max_p1.x = inter2.x;
                                max_p1.y = inter2.y;
                                max_p2.x = inter4.x;
                                max_p2.y = inter4.y;
                                Pi.x=p.x;
                                Pi.y=p.y;
                                PJ.x=p2.x;
                                PJ.y=p2.y;
                            }
                        }
                        if ((par3 != 0) && (par4 != 0)) {
                            if ((inter4.x - inter3.x) * (inter4.x - inter3.x) + (inter4.y - inter3.y) * (inter4.y - inter3.y) > max) {
                                max = (inter4.x - inter3.x) * (inter4.x - inter3.x) + (inter4.y - inter3.y) * (inter4.y - inter3.y);
                                max_p1.x = inter4.x;
                                max_p1.y = inter4.y;
                                max_p2.x = inter3.x;
                                max_p2.y = inter3.y;
                                Pi.x=p.x;
                                Pi.y=p.y;
                                PJ.x=p2.x;
                                PJ.y=p2.y;
                            }
                        }
                    }
                }
            }
        }
        if (max_p1.x == 5) {
            System.out.println("ERROR");
        } else {
            System.out.println(max_p1);
            System.out.println(max_p2);
            resA = new Point(max_p1.x, max_p1.y);
            resB = new Point(max_p2.x, max_p2.y);

            resLine = new Line(resA.x, resA.y, resB.x, resB.y);
            System.out.printf("resA.x = %.2f, resA.y = %.2f\n", resA.x, resA.y);
            System.out.printf("resB.x = %.2f, resB.y = %.2f\n", resB.x, resB.y);
            System.out.printf("resLine.A = %.2f,resLine.B = %.2f,resLine.C = %.2f\n", resLine.A, resLine.B, resLine.C);
        }
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
            rect = new Rect(x1, y1, x2, y2, x3, y3);
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
        gl.glLineWidth(1);
        gl.glColor3d(1, 1, 1);
        for (Point point : points) {
            point.render(gl);
        }
//        Rect.renderRect(gl, new Vector2(0,0), new Vector2(0.1,0.1), new Vector2(0,-0.3), 1==1);
        if (rect != null)
            rect.renderRect(gl);

        if (resLine != null) {
            resLine.renderLine(gl, 1);
            gl.glColor3d(1, 0, 0);
            resA.render(gl);
            resB.render(gl);
            gl.glLineWidth(5);
            resLine.renderSect(gl, 5);
        }
    }

}
