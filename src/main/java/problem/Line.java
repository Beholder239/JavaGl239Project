package problem;

import javax.media.opengl.GL2;

class Line
{
    public double A;
    public double B;
    public double C;
    public double x1;
    public double y1;
    public double x2;
    public double y2;
    public Line() {
        this.A = 0;
        this.B = 0;
        this.C = 0;
    }
    public Line(double x1, double y1, double x2, double y2) {
        this.A = y1 - y2;
        this.B = x2 - x1;
        this.C = x1*y2 - x2*y1;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.x1 = y2;
    }
    public void renderSect(GL2 gl, double size){
        gl.glPointSize((float) size);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(x1, x2);
        gl.glVertex2d(y1, y2);
        gl.glEnd();
    }
    public void renderLine(GL2 gl, double size){
        gl.glPointSize((float) size);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(1, -C/B-A/B);
        gl.glVertex2d(-C/A-B/A, 1);
        gl.glEnd();
    }
}
