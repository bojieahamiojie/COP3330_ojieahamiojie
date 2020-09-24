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
        double total = (703 * weight) / (height * height);
        return Math.round((total) * 10) / 10.0;
    }

    public static String BMICategory(double height, double weight){
        double bmi = calculateBMI(height, weight);

        if (bmi >= 30){
            return "Obese.";
        }
        else if (25 <= bmi){
            return "Overweight.";
        }
        else if (18.5 <= bmi){
            return "Normal weight.";
        }
        return "Underweight.";
    }

    public String getBMICategory(){
        return BMICategory(this.height, this.weight);
    }

    public String toString(){
        return "Category: " + getBMICategory() + "\n" + "BMI score: " + getBMI();
    }
}
