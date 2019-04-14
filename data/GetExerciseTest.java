import com.company.model.account.Data;
import com.company.view.training.Training;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GetExerciseTest {

    @Test
    public void getExerciseTest() throws IOException {
        String string = "���� 1)\n" +
                "����� � ������";
        assertEquals(string, new Data().getDay(new Training("Day 1", 1)));
    }

    @Test
    public void getExerciseTestNeg() throws IOException {
        String string = "���� 30)\n" +
                "����� � �����";
        assertNotEquals(string, new Data().getDay(new Training("Day 4", 4)));
    }
}
