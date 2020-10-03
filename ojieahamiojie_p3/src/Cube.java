public class Cube{
    private double length;
    private double width;
    private double height;
    private String name;

    public Cube(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
        this.name = "cube";
    }

    public double getArea(){
        return 6 * length * width * height;
    }

    public double getVolume(){
        return length * width * height;
    }

    public String getName(){
        return name;
    }
}
