package problem;

public class Line{
    double A;
    double B;
    double C;
    @Override
    public String toString() {
        String s=String.format("%.2fx + %.2fy + %.2f = 0", A, Math.abs(B), Math.abs(C));
        String s1=String.format("%.2fx + %.2fy - %.2f = 0", A, Math.abs(B), Math.abs(C));
        String s2=String.format("%.2fx - %.2fy + %.2f = 0", A, Math.abs(B), Math.abs(C));
        String s3=String.format("%.2fx - %.2fy - %.2f = 0", A, Math.abs(B), Math.abs(C));
        if(C>=0){
            if(B>=0){
                return s;
            }else{
                return s2;
            }
        }else{
            if(B>=0){
                return s1;
            }else{
                return s3;
            }
        }
    }
    public Line(double x1, double y1,double x2,double y2){
        this.A=y1-y2;
        this.B=x2-x1;
        this.C=x1*y2-x2*y1;
    }
    public double distanceToZero(){
        double d=Math.abs(C)/Math.sqrt(A*A+B*B);
        return d;
    }
    public double distanceToPoint(Point p){
        double d=Math.abs(A*p.x+B*p.y+C)/Math.sqrt(A*A+B*B);
        return d;
    }
    public boolean isParallel(Line l1){
        boolean s;
        if(B!=l1.B){
            s=Math.abs(A/B-l1.A/l1.B)<0.0001;
        }else{
            s=1==1;
        }
        return s;
    }
    public Point intersection(Line l){
        Point p=new Point();
        boolean s;
        if(B!=l.B){
            s=Math.abs(A/B-l.A/l.B)<0.0001;
        }else{
            s=1==1;
        }
        if(s==(1==1)){
            return null;
        }else{
            p.y=(l.A*C-l.C*A)/(l.B*A-l.A*B);
            p.x=(l.B*C-l.C*B)/(l.A*B-l.B*A);
            return p;
        }
    }
    public Point nearPoint(Point p){
        Point a=new Point();
        a.x=(B*B*p.x-A*B*p.y-A*C)/(A*A+B*B);
        a.y=(A*A*p.y-A*B*p.x-B*C)/(A*A+B*B);
        return a;
    }
    public boolean oneSide(Point p1,Point p2){
        if(p2.y==-0.9999){
            p2.y=-1;
        }
        Point a = nearPoint(p1);
        Point b = nearPoint(p2);
        Line l=new Line(p1.x, p1.y, p2.x, p2.y);
        if(isParallel(l)){
            return 1==1;
        }else{
            Point q=intersection(l);
            if(((a.x>=q.x)&&(b.x>=q.x))||((a.x<=q.x)&&(b.x<=q.x))){
                return 1==1;
            }else{
                return 0==1;
            }
        }
    }
    public Line normalize(){
        Line l=new Line(0,0,1,1);
        if(C!=0){
            A=A/C;
            B=B/C;
            C=1;
        }else{
            if(A!=0){
                B=B/A;
                A=1;
            }else{
                B=1;
            }
        }
        l.A=A;
        l.B=B;
        l.C=C;
        return l;
    }
    public Line perpendicularLine(Point p){
        Line l = new Line(p.x,p.y,p.x+A,p.y+B);
        return l;
    }
    public Line parallelLine(Point p){
        Line l = new Line(p.x,p.y,p.x+A,p.y+B);
        double a=A;
        double b=B;
        double c=C;
        A=l.A;
        B=l.B;
        C=l.C;
        Line l1 = new Line(p.x,p.y,p.x+A,p.y+B);
        A=a;
        B=b;
        C=c;
        return l1;
    }
    public double projectionLength(Point p1,Point p2){
        Point p3 = nearPoint(p1);
        Point p4 = nearPoint(p2);
        return Math.sqrt((p3.x-p4.x)*(p3.x-p4.x)+(p3.y-p4.y)*(p3.y-p4.y));
    }
    public Point middlePoint(Point p){
        Point p1 = nearPoint(p);
        Point h = new Point(1,1);
        h.x=(p.x+p1.x)/2;
        h.y=(p.y+p1.y)/2;
        return h;
    }
    public Point symmetricPoint(Point p){
        Point p1 = nearPoint(p);
        Point h = new Point(1,1);
        h.x=-p.x+2*p1.x;
        h.y=-p.y+2*p1.y;
        return h;
    }
    public boolean insideTreug(Point p) {
        Line ox = new Line(0,1,0,0);
        Line oy = new Line(0,0,1,0);
        Point l = new Point(-C/A,-C/B);
        if(((oneSide(p,l) == (1==0))||(A*p.x+B*p.y+C==0))&&(l.x*p.x>=0)&&(l.y*p.y>=0)) {
            return (0==0);
        } else {
            return (0==1);
        }
    }
}
