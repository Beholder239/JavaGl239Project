package problem;

import javax.media.opengl.GL2;

class Line
{
    public double A;
    public double B;
    public double C;
    public Line() {
        this.A = 0;
        this.B = 0;
        this.C = 0;
    }
    public Line(double x1, double y1, double x2, double y2) {
        this.A = y1 - y2;
        this.B = x2 - x1;
        this.C = x1*y2 - x2*y1;
    }
    public void renderLine(GL2 gl, double size){
        gl.glPointSize((float) size);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0, -C/B);
        gl.glVertex2d(-C/A, 0);
        gl.glEnd();
    }
}
