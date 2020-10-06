public class Cube extends Shape3D{
    private double side;
    private String name;

    public Cube(double side){
        this.side = side;
        this.name = "cube";
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return 6 * Math.pow(side, 2);
    }

    public double getVolume(){
        return Math.pow(side, 3);
    }
}
