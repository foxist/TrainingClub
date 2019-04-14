import com.company.model.account.Data;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class GetCompPasswordTest {

    @Test
    public void getCompPasswordTest() throws IOException {
        assertTrue(new Data().getComparePassword("fox", "123"));
    }

    @Test
    public void getCompPasswordTestNeg() throws IOException {
        assertNotEquals(true, new Data().getComparePassword("fox", "321"));
    }
}
