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
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(posA.x, posA.y);
        gl.glVertex2d(posB.x, posB.y);
        gl.glEnd();
    }
    public static void renderTriangle(GL2 gl, Vector2 posA, Vector2 posB, Vector2 posC, boolean b) {

        if(b == (1==1)) {
            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glVertex2d(posA.x, posA.y);
            gl.glVertex2d(posB.x, posB.y);
            gl.glVertex2d(posC.x, posC.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex2d(posA.x, posA.y);
            gl.glVertex2d(posB.x, posB.y);

            gl.glVertex2d(posA.x, posA.y);
            gl.glVertex2d(posC.x, posC.y);

            gl.glVertex2d(posB.x, posB.y);
            gl.glVertex2d(posC.x, posC.y);
            gl.glEnd();
        }
    }
    public static void renderQuad(GL2 gl, Vector2 posA, Vector2 posB, Vector2 posC, Vector2 posD, boolean b) {
        if(b == (1==1)) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2d(posA.x, posA.y);
            gl.glVertex2d(posB.x, posB.y);
            gl.glVertex2d(posC.x, posC.y);
            gl.glVertex2d(posD.x, posD.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex2d(posA.x, posA.y);
            gl.glVertex2d(posB.x, posB.y);

            gl.glVertex2d(posA.x, posA.y);
            gl.glVertex2d(posD.x, posD.y);

            gl.glVertex2d(posB.x, posB.y);
            gl.glVertex2d(posC.x, posC.y);

            gl.glVertex2d(posD.x, posD.y);
            gl.glVertex2d(posC.x, posC.y);
            gl.glEnd();
        }
    }
    public static void renderCircle(GL2 gl, Vector2 cent, double rad, boolean b) {
        if(b == (1==1)) {
            gl.glBegin(GL2.GL_TRIANGLE_FAN);
            gl.glVertex2d(cent.x, cent.y);
            for(int i = 0;i<2500;i++) {
                gl.glVertex2d(cent.x + rad*Math.cos(2*Math.PI*i/2500), cent.y + rad*Math.sin(2*Math.PI*i/2500));
            }
            gl.glEnd();
        } else {
            gl.glBegin(GL2.GL_LINE_STRIP);
            for(int i = 0;i<2500;i++) {
                gl.glVertex2d(cent.x + rad*Math.cos(2*Math.PI*i/2500), cent.y + rad*Math.sin(2*Math.PI*i/2500));
            }
            gl.glEnd();
        }
    }
}
