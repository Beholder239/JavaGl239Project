package problem;


import javax.media.opengl.GL2;

public class Rect {
    Vector2 x;
    Vector2 y;
    Vector2 t;
    public static void Rectangle(GL2 gl,double x1,double x2, double y1, double y2, double t1, double t2, boolean b){
        if(b==(1==1)) {
            Line l = new Line(x1,x2,y1,y2);
            Line l1 = new Line(t1,t2,t1 + l.A,t2 + l.B);
            Line l2 = new Line(t1,t2,t1 + l1.A,t2 + l1.B);
            Point p=new Point((l.B*l1.C-l.C*l1.B)/(l.A*l1.B-l.B*l1.A), (l.A*l1.C-l.C*l1.A)/(l.B*l1.A-l.A*l1.B));
            Point p1=new Point(p.x+x1-y1,p.y+x2-y2);
            gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2d(x1, x2);
            gl.glVertex2d(y1, y2);
            gl.glVertex2d(p.x, p.y);
            gl.glVertex2d(p1.x, p1.y);
            gl.glEnd();
        }
    }
}
