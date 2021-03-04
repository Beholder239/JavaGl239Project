package problem;

public class Point{
    public double x;
    public double y;
    @Override
    public String toString() {
        String s=String.format("(%.2f, %.2f)", x, y);
        return s;
    }
    public Point(){
        x=0;
        y=0;
    }
    public Point(double x,double y){
        this.x=x;
        this.y=y;
    }
    public double distanceToZero(){
        double a=Math.sqrt(x*x+y*y);
        return a;
    }
    public double distanceTo(Point p){
        double q=Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
        return q;
    }
}