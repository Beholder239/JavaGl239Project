//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Point {
    boolean isSolution = false;
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static Point getRandomPoint() {
        Random r = new Random();
        double nx = (double)r.nextInt(50) / 25.0D - 1.0D;
        double ny = (double)r.nextInt(50) / 25.0D - 1.0D;
        return new Point(nx, ny);
    }

    void render(GL2 gl) {
//        if (this.isSolution) {
//            gl.glColor3d(1.0D, 0.0D, 0.0D);
//        } else {
//            switch(this.setNumber) {
//                case 0:
//                    gl.glColor3d(0.0D, 1.0D, 0.0D);
//                    break;
//                case 1:
//                    gl.glColor3d(0.0D, 0.0D, 1.0D);
//            }
//        }

        gl.glPointSize(3.0F);
        gl.glBegin(0);
        gl.glVertex2d(this.x, this.y);
        gl.glEnd();
        gl.glPointSize(1.0F);
    }

    public String toString() {
        return "Точка с координатами: {" + this.x + "," + this.y + "}";
    }
}
