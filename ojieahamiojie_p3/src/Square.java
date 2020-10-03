public abstract class Square extends Shape {
    private double base;
    private double height;
    private String name;

    public Square(double base, double height){
        super();
        this.base = base;
        this.height = height;
        this.name = "square";
    }

    public double getArea(){
        return base * height;
    }

    public String getName(){
        return name;
    }
}
