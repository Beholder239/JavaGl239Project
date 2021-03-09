package problem;


import javax.media.opengl.GL2;

public class Rect {
    Vector2 x;
    Vector2 y;
    Vector2 t;
    public static void Rectangle(GL2 gl,Vector2 x , Vector2 y, Vector2 t, boolean b){
        Line l = new Line(x.x,x.y,y.x,y.y);
        Line l1 = new Line(t.x,t.y,t.x + l.A,t.y + l.B);
        Line l2 = new Line(t.x,t.y,t.x + l1.A,t.y + l1.B);
        Vector2 p=new Vector2((l.B*l1.C-l.C*l1.B)/(l.A*l1.B-l.B*l1.A), (l.A*l1.C-l.C*l1.A)/(l.B*l1.A-l.A*l1.B));
        Vector2 p1=new Vector2(p.x+x.x-y.x,p.y+x.y-y.y);
        if(b==(1==1)) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2d(x.x, x.y);
            gl.glVertex2d(y.x, y.y);
            gl.glVertex2d(p.x, p.y);
            gl.glVertex2d(p1.x, p1.y);
            gl.glEnd();
        }
    }
}
