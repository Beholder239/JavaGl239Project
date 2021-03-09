//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Point {
    public static final int SET_1 = 0;
    public static final int SET_2 = 1;
    int setNumber;
    boolean isSolution = false;
    double x;
    double y;

    Point(double x, double y, int setNumber) {
        this.x = x;
        this.y = y;
        this.setNumber = setNumber;
    }

    static Point getRandomPoint() {
        Random r = new Random();
        double nx = (double)r.nextInt(50) / 25.0D - 1.0D;
        double ny = (double)r.nextInt(50) / 25.0D - 1.0D;
        int nSetVal = r.nextInt(2);
        return new Point(nx, ny, nSetVal);
    }

    void render(GL2 gl) {
        if (this.isSolution) {
            gl.glColor3d(1.0D, 0.0D, 0.0D);
        } else {
            switch(this.setNumber) {
                case 0:
                    gl.glColor3d(0.0D, 1.0D, 0.0D);
                    break;
                case 1:
                    gl.glColor3d(0.0D, 0.0D, 1.0D);
            }
        }

        gl.glPointSize(3.0F);
        gl.glBegin(0);
        gl.glVertex2d(this.x, this.y);
        gl.glEnd();
        gl.glPointSize(1.0F);
    }

    public String toString() {
        return "Точка с координатами: {" + this.x + "," + this.y + "} из множества: " + this.setNumber;
    }
}
