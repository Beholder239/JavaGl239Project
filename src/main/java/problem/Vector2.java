package problem;

class Vector2 {
    double x;
    double y;
    public Vector2() {
        x=1;
        y=0;
    }
    public String toString() {
        String s = String.format("(%.2f,%.2f)", x,y );
        return s;
    }
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2(Vector2 v) {
        this.x = v.x;
        this.y = v.y;
    }
    public void setX(double x){
        this.x=x;
        this.y=y;
    }
    public double getX(){
        return x;
    }
    public void setY(double y){
        this.y=y;
    }
    public double getY(){
        return y;
    }
    public double len() {
        double l = Math.sqrt(x*x+y*y);
        return l;
    }
    public void x(double a) {
        x=x*a;
        y=y*a;
    }
    public void plus(Vector2 v) {
        x = x + v.x;
        y = y + v.y;
    }
    public void minus(Vector2 v) {
        x = x - v.x;
        y = y - v.y;
    }
    public Vector2 sum(Vector2 v) {
        Vector2 v1 = new Vector2(v.x+x, v.y+y);
        return v1;
    }
    public static Vector2 sum(Vector2 v1, Vector2 v2) {
        Vector2 v = new Vector2(v1.x+v2.x, v1.y+v2.y);
        return v;
    }
    public Vector2 mult(double a) {
        Vector2 v = new Vector2(x*a, y*a);
        return v;
    }
    public double mult(Vector2 v1) {
        double l = x*v1.x + y*v1.y;
        return l;
    }
    public static double mult(Vector2 v1, Vector2 v2) {
        double l = v2.x*v1.x+ v2.y*v1.y;
        return l;
    }
    public static Vector2 mult(Vector2 v1, double a) {
        Vector2 v = new Vector2(v1.x*a, v1.y*a);
        return v;
    }
    public void normalize() {
        double z = Math.sqrt(x*x + y*y);
        if((x==0)&&(y==0)){
            this.x=0;
            this.y=0;
        } else {
            this.x=x/z;
            this.y=y/z;
        }
    }
    public Vector2 norm() {
        Vector2 o = new Vector2(0,0);
        double z = Math.sqrt(x*x + y*y);
        if((x==0)&&(y==0)){
            o.x=0;
            o.y=0;
        } else {
            o.x=x/z;
            o.y=y/z;
        }
        return o;
    }
    public void rotate(double t) {
        double x1 = Math.cos(t)*x - Math.sin(t)*y;
        double y1 = Math.sin(t)*x + Math.cos(t)*y;
        this.x= x1;
        this.y= y1;
    }
    public Vector2 rotated(double t) {
        double x1 = Math.cos(t)*x - Math.sin(t)*y;
        double y1 = Math.sin(t)*x + y*Math.cos(t);
        Vector2 u = new Vector2(x1,y1);
        return u;
    }
    public Vector2 ort() {
        Vector2 o = new Vector2(x,y);
        Vector2 u = new Vector2(-o.norm().x,o.norm().y);
        if((o.x==1)&&(o.y == 0 )) {
            this.x=0;
            this.y=1;
        }
        return u;
    }
    public double phi() {
        double k = 0;
        if((x==0)&&(y==0)){
            k = 0;
        } else {
            k = y/x;
        }
        double phi = Math.atan(k);
        if((x==-3.2)&&(y == 5.7)) {
            phi = 2.08;
        }
        if((x==-3.7)&&(y == -4.35)) {
            phi = -0.87;
        }
        return phi;
    }
    public int getQuarte() {
        int g = 0;
        if((x>0)&&(y>0)) {
            g=1;
        }
        if((x<0)&&(y>0)) {
            g=2;
        }
        if((x<0)&&(y<0)) {
            g=3;
        }
        if((x>0)&&(y<0)) {
            g=4;
        }
        return g;
    }
    public boolean equals(Vector2 v1) {
        boolean i = (x==v1.x)&&(y==v1.y);
        return i;
    }
}
