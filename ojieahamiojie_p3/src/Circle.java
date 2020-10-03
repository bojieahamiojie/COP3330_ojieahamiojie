import java.lang.Math.*;
public class Circle {
    private double radius;
    private String name;

    public Circle(double radius){
        this.radius = radius;
        this.name = "circle";
    }

    public double getArea(){
        return radius * Math.PI;
    }

    public String getName(){
        return name;
    }
}
