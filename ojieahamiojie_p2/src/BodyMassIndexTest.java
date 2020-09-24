import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyMassIndexTest {
    @Test
    public void testBMI1(){
        BodyMassIndex bmi = new BodyMassIndex(69, 129);
        assertEquals(19.0, bmi.getBMI());
    }

    @Test
    public void testBMI2(){
        BodyMassIndex bmi = new BodyMassIndex(64, 126);
        assertEquals(21.6, bmi.getBMI());
    }

    @Test
    public void testBMI3(){
        BodyMassIndex bmi = new BodyMassIndex(72, 187);
        assertEquals(25.4, bmi.getBMI());
    }

    @Test
    public void testBMI4(){
        BodyMassIndex bmi = new BodyMassIndex(60, 159);
        assertEquals(31.0, bmi.getBMI());
    }

    @Test
    public void testBodyMassIndex(){
    }

    @Test
    public void testgetBMI(){
    }

    @Test
    public void testcalculateBMI(){
    }

    @Test
    public void testBMICategory(){
    }

    @Test
    public void testgetBMICategory(){
    }

    @Test
    public void testtoString(){
    }
}
