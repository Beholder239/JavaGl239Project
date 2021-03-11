package problem;

class Line
{
    public double A;
    public double B;
    public double C;
    public Line() {
        A = 0;
        B = 0;
        C = 0;
    }
    public Line(double x1, double y1, double x2, double y2) {
        A = y1 - y2;
        B = x2 - x1;
        C = x1*y2 - x2*y1;
    }
}
