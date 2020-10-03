public class Square{
    private double length;
    private double width;
    private String name;

    public Square(double length, double width){
        this.length = length;
        this.width = width;
        this.name = "square";
    }

    public double getArea(){
        return length * width;
    }

    public String getName(){
        return name;
    }
}
