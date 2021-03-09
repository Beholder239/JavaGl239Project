package problem;

public class Line {
    double A;
    double B;
    double C;
    public Line(){
       this.A = 0;
       this.B = 0;
       this.C = 0;
    }
    public Line(double x1,double y1,double x2,double y2){
        this.A = y1-y2;
        this.B = x2-x1;
        this.C = x1*y2 - x2*y1;
    }
}
