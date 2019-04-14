import com.company.model.account.Data;
import com.company.view.training.Training;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GetDayTest {

    @Test
    public void getDayTest() throws IOException {
        String string = "1. Жим штанги лежа (5 х 10)\n" +
                "50/1; 60/1; 70/1; 80/2.\n" +
                "2. Жим гантелей на наклонной скамье (5 х 12)\n" +
                "12/2; 17/3.\n" +
                "3. Разводка гантелей на прямой скамье (5 х 10/12)\n" +
                "9.5; 12/2; 14.5/2.\n" +
                "4. Подъем гантелей на бицепс (5 х 10/12)\n" +
                "10/1; 15/1; 20/2; 22.5/1.\n" +
                "5. Подъем гантелей в супинации и пронации (5 х 12/15)\n" +
                "12/5.\n";

        assertEquals(string, new Data().getExercise(new Training("Day 1", 1)));
    }

    @Test
    public void getDayTestNeg() throws IOException {
        String string = "1. Жим штанги лежа (4 х 8)\n" +
                "50/1; 60/1; 70/1; 80/2.\n" +
                "2. Жим гантелей на наклонной скамье (4 х 12)\n" +
                "12/2; 17/3.\n" +
                "3. Разводка гантелей на прямой скамье (3 х 10/12)\n" +
                "9.5; 12/2; 14.5/2.\n" +
                "4. Подъем гантелей на бицепс (6 х 10/12)\n" +
                "10/1; 15/1; 20/2; 22.5/1.\n" +
                "5. Подъем гантелей в супинации и пронации (6 х 12/15)\n" +
                "12/5.\n";

        assertNotEquals(string, new Data().getExercise(new Training("Day 4", 4)));
    }
}
