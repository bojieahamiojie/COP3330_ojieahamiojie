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
        else if (bmi >= 25 || bmi <= 29){
            return "You are overweight.";
        }
        else if (bmi >= 18.5 || bmi <= 24.9){
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
