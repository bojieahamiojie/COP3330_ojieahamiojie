public class Square extends Shape2D{
    private double side;
    private String name;

    public Square(double side){
        this.side = side;
        this.name = "square";
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return Math.pow(side, 2);
    }
}
