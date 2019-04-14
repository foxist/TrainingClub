import com.company.io.DataText;
import com.company.model.account.Data;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GetDayCheckBoxTest {
    @Test
    public void getDayCheckBoxTest() throws IOException {
        assertEquals(new DataText().getDayCheckBoxText("fox", new Data()), 2);
    }

    @Test
    public void getDayCheckBoxTestNeg() throws IOException {
        assertNotEquals(new DataText().getDayCheckBoxText("fox", new Data()), 8);
    }
}
