import com.company.io.DataText;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GetComparePasswordTest {

    @Test
    public void getCompareTest() throws IOException {
        assertTrue(new DataText().getComparePassword("fox", "123"));
    }

    @Test
    public void getCompareTestNeg() throws IOException {
        assertNotEquals(true, new DataText().getComparePassword("fox", "124"));
    }
}
