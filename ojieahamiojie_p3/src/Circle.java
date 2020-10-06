public class Circle extends Shape2D{
    private double radius;
    private String name;

    public Circle(double radius){
        this.radius = radius;
        this.name = "circle";
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
}
