public class BodyMassIndex {
    private double height;
    private double weight;
    public BodyMassIndex(double height, double weight){
        this.height = height;
        this.weight = weight;
    }

    public double getBMI(){
        return calculateBMI(this.height, this.weight);
    }

    public static double calculateBMI(double height, double weight){
        return (703 * weight) / (height * height);
    }

    public static String BMICategory(double height, double weight){
        double bmi = calculateBMI(height, weight);

        if (bmi >= 30){
            return "You are obese.";
        }
        else if (25 <= bmi){
            return "You are overweight.";
        }
        else if (24.9 <= bmi){
            return "Your weight is normal.";
        }
        return "You are underweight.";
    }

    public String getBMICategory(){
        return BMICategory(this.height, this.weight);
    }

    public String toString(){
        return "Category: " + getBMICategory() + "\n" + "BMI score: " + getBMI();
    }
}
