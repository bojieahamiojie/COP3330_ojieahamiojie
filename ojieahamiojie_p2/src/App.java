import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while(moreInput()){
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to enter more data?: ");
        String choice = input.nextLine();
        return !choice.equalsIgnoreCase("n");
    }

    public static double getUserHeight(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your height in inches: ");
        double height;
        height = input.nextDouble();

        while(height < 0) {
            System.out.println("Please enter positive values!\n");
            System.out.println("Enter your height in inches: ");
            height = input.nextDouble();
        }
        input.nextLine();
        return height;
    }

    public static double getUserWeight(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your weight: ");
        double weight;
        weight = input.nextDouble();
        while (weight < 0) {
            System.out.println("Please enter positive values!\n");
            System.out.println("Enter your weight in inches: ");
            weight = input.nextDouble();
        }
        input.nextLine();
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi){
        System.out.println(bmi);
        System.out.println("\n\n");
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double total = 0;
        BodyMassIndex bmi;

        for (BodyMassIndex bmiDatum : bmiData) {
            bmi = bmiDatum;
            total += bmi.getBMI();
        }
        System.out.println("Average BMI for the " + bmiData.size() + " participants is : " + (total / bmiData.size()));
    }
}
