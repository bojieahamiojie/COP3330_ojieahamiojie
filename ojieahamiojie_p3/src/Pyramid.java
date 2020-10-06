public class Pyramid extends Shape3D{
    private double l;
    private double w;
    private double h;
    private String name;

    public Pyramid(double l, double w, double h) {
        this.l = l;
        this.w = w;
        this.h = h;
        this.name = "pyramid";
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return (l * w) + (l * Math.sqrt(Math.pow(w / 2, 2) + Math.pow(h, 2))) + w * Math.sqrt(Math.pow(l / 2, 2) + Math.pow(h, 2));
    }

    public double getVolume(){
        return (l * w * h) / 3;
    }
}
