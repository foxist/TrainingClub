import com.company.io.DataText;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GetExerciseOfTrainingDayTest {

    @Test
    public void getExerciseOfTrainingDayTest() throws IOException {
        String string = "���� 1)\n" +
                "����� � ������";
        assertEquals(string, new DataText().getExerciseOfTrainingDay(1));
    }

    @Test
    public void getExerciseOfTrainingDayTestNeg() throws IOException {
        String string = "���� 30)\n" +
                "����� � �����";
        assertNotEquals(string, new DataText().getExerciseOfTrainingDay(4));
    }
}
