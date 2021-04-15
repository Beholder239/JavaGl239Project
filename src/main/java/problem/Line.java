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
        this.y2 = y2;
    }
    public void renderSect(GL2 gl, double size){
        gl.glPointSize((float) size);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(x1, y1);
        gl.glVertex2d(x2, y2);
        gl.glEnd();
    }
    public void renderLine(GL2 gl, double size){
        Vector2 v1 = new Vector2(x1,y1);
        Vector2 v2 = new Vector2(x2,y2);
        double w1 = x2-x1;
        double w2 = y2-y1;

        Vector2 v0 = new Vector2(w1/Math.sqrt(w1*w1+w2*w2), w2/Math.sqrt(w1*w1+w2*w2));

        double k1 = x2 + 3*v0.x ;
        double k2 = y2 + 3*v0.y ;
        double k3 = x2-3*v0.x ;
        double k4 = y2-3*v0.y ;
        gl.glPointSize((float) size);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(k1, k2);
        gl.glVertex2d(k3, k4);
        gl.glEnd();
    }
}
