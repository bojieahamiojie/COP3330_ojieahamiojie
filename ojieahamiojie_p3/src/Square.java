public class Square extends Shape {
    private double side;
    private String name;

    public Square(double side){
        this.side = side;
        this.name = "square";
    }

    public double getArea(){
        return side * side;
    }

    public String getName(){
        return name;
    }
}
