package problem;


import javax.media.opengl.GL2;

public class Rect {
    double a1;
    double a2;
    double a3;
    double a4;
    double a5;
    double a6;
    public Rect() {
        this.a1=0;
        this.a2=0;
        this.a3=0;
        this.a4=0.1;
        this.a5=0.1;
        this.a6=0.1;
    }
    public Rect(double a1, double a2, double a3, double a4, double a5, double a6){
        this.a1=a1;
        this.a2=a2;
        this.a3=a3;
        this.a4=a4;
        this.a5=a5;
        this.a6=a6;
    }
    public static void renderRect(GL2 gl, Vector2 x, Vector2 y, Vector2 t, boolean b){
        Line l = new Line(x.x,x.y,y.x,y.y);
        Line l1 = new Line(t.x,t.y,t.x + l.A,t.y + l.B);
        Line l2 = new Line(t.x,t.y,t.x + l1.A,t.y + l1.B);
        Line lp1 = new Line(x.x,x.y,x.x + l.A,x.y + l.B);
        Line lp2 = new Line(y.x,y.y,y.x + l.A,y.y + l.B);
        Vector2 p=new Vector2((lp1.B*l2.C-lp1.C*l2.B)/(lp1.A*l2.B-lp1.B*l2.A), (lp1.A*l2.C-lp1.C*l2.A)/(lp1.A*l2.B-lp1.B*l2.A));
        Vector2 p1=new Vector2((lp2.B*l2.C-lp2.C*l2.B)/(lp2.A*l2.B-lp2.B*l2.A), (lp2.A*l2.C-lp2.C*l2.A)/(lp2.B*l2.A-lp2.A*l2.B));
        if(b==(1==1)) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2d(x.x, x.y);
            gl.glVertex2d(p.x, p.y);
            gl.glVertex2d(p1.x, p1.y);
            gl.glVertex2d(y.x, y.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL2.GL_LINE_STRIP);
            gl.glVertex2d(x.x, x.y);
            gl.glVertex2d(y.x, y.y);

            gl.glVertex2d(x.x, x.y);
            gl.glVertex2d(p.x, p.y);

            gl.glVertex2d(p.x, p.y);
            gl.glVertex2d(p1.x, p1.y);

            gl.glVertex2d(p1.x, p1.y);
            gl.glVertex2d(y.x, y.y);
            gl.glEnd();
        }
    }
    public  void render2(GL2 gl, boolean b){
        Line l = new Line(a1,a2,a3,a4);
        Line l1 = new Line(a5,a6,a5 + l.A,a6 + l.B);
        Line l2 = new Line(a5,a6,a5 + l1.A,a6 + l1.B);
        Line lp1 = new Line(a1,a2,a1 + l.A,a2 + l.B);
        Line lp2 = new Line(a3,a4,a3 + l.A,a4 + l.B);
        Vector2 p=new Vector2((lp1.B*l2.C-lp1.C*l2.B)/(lp1.A*l2.B-lp1.B*l2.A), (lp1.A*l2.C-lp1.C*l2.A)/(lp1.A*l2.B-lp1.B*l2.A));
        Vector2 p1=new Vector2((lp2.B*l2.C-lp2.C*l2.B)/(lp2.A*l2.B-lp2.B*l2.A), (lp2.A*l2.C-lp2.C*l2.A)/(lp2.B*l2.A-lp2.A*l2.B));
        if(b==(1==1)) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2d(a1, a2);
            gl.glVertex2d(a3, a4);
            gl.glVertex2d(p1.x, p1.y);
            gl.glVertex2d(p.x, p.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL2.GL_LINE_STRIP);
            gl.glVertex2d(a1, a2);
            gl.glVertex2d(a3, a4);

            gl.glVertex2d(a3, a4);
            gl.glVertex2d(p1.x, p1.y);

            gl.glVertex2d(p1.x, p1.y);
            gl.glVertex2d(p.x, p.y);

            gl.glVertex2d(p.x, p.y);
            gl.glVertex2d(a1, a2);
            gl.glEnd();
        }
    }
}
