package problem;

import javax.media.opengl.GL2;

public class Figure {
    public static void renderPoint(GL2 gl, Vector2 pos, double size) {
        gl.glPointSize((float) size);
        gl.glBegin(GL2.GL_POINTS);
        //        for (Point point : points) {
        //            point.render(gl);
        //        }
        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
    }
    public static void renderLine(GL2 gl, Vector2 posA, Vector2 posB, double size) {
        gl.glPointSize((float) size);
        gl.glBegin(GL2.GL_LINE);
        gl.glVertex2d(posA.x, posA.y);
        gl.glVertex2d(posB.x, posB.y);
        gl.glEnd();
    }
}
