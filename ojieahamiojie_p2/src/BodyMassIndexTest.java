import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyMassIndexTest {
    @Test
    public void Testbmi1(){
        BodyMassIndex bmi = new BodyMassIndex(69, 129);
        assertEquals(19.0, bmi.getBMI());
    }

    @Test
    public void Testbmi2(){
        BodyMassIndex bmi = new BodyMassIndex(64, 126);
        assertEquals(21.6, bmi.getBMI());
    }

    @Test
    public void Testbmi3(){
        BodyMassIndex bmi = new BodyMassIndex(72, 187);
        assertEquals(25.4, bmi.getBMI());
    }

    @Test
    public void Testbmi4(){
        BodyMassIndex bmi = new BodyMassIndex(60, 159);
        assertEquals(31.0, bmi.getBMI());
    }
}
