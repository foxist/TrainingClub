import com.company.model.account.Data;
import com.company.view.training.Training;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GetExerciseTest {

    @Test
    public void getExerciseTest() throws IOException {
        String string = "День 1)\n" +
                "Грудь и бицепс";
        assertEquals(string, new Data().getDay(new Training("Day 1", 1)));
    }

    @Test
    public void getExerciseTestNeg() throws IOException {
        String string = "День 30)\n" +
                "Грудь и спина";
        assertNotEquals(string, new Data().getDay(new Training("Day 4", 4)));
    }
}
