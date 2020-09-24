import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyMassIndexTest {
    @Test
    public void Testbmi(){
        BodyMassIndex bmi = new BodyMassIndex(1, 1);
        assertEquals(bmi.getBMI(), 703);
    }
}
