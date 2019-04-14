import com.company.io.DataText;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GetExerciseOfTrainingDayTest {

    @Test
    public void getExerciseOfTrainingDayTest() throws IOException {
        String string = "День 1)\n" +
                "Грудь и бицепс";
        assertEquals(string, new DataText().getExerciseOfTrainingDay(1));
    }

    @Test
    public void getExerciseOfTrainingDayTestNeg() throws IOException {
        String string = "День 30)\n" +
                "Грудь и Спина";
        assertNotEquals(string, new DataText().getExerciseOfTrainingDay(4));
    }
}
