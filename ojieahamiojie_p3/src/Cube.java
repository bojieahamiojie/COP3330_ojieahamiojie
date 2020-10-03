public class Cube{
    private double side;
    private String name;

    public Cube(double side){
        this.side = side;
        this.name = "cube";
    }

    public double getArea(){
        return 6 * side * side * side;
    }

    public double getVolume(){
        return side * side * side;
    }

    public String getName(){
        return name;
    }
}
