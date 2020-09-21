import java.util.ArrayList;

public class App {

    public static void main(String[] args){
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while(moreInput()){
            double height = getUserheight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
}
