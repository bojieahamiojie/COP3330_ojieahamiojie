public class Triangle extends Shape{
    private double length;
    private double width;
    private String name;

    public Triangle(double length, double width){
        this.length = length;
        this.width = width;
        this.name = "triangle";
    }

    public double getArea(){
        return (length * width) / 2;
    }

    public String getName(){
        return name;
    }
}
