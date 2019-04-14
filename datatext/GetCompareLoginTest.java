import com.company.io.DataText;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GetCompareLoginTest {

    @Test
    public void getCompareLoginTest() throws IOException {
        assertFalse(new DataText().getCompareLogin("fox"));
    }

    @Test
    public void getCompareLoginTestNeg() throws IOException {
        assertNotEquals(false, new DataText().getCompareLogin("foxxist"));
    }
}
