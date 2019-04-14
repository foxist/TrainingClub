import com.company.model.account.Data;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class GetCompLoginTest {

    @Test
    public void getCompLoginTest() throws IOException {
        assertFalse(new Data().getCompareLogin("fox"));
    }

    @Test
    public void getCompLoginTestNeg() throws IOException {
        assertNotEquals(false, new Data().getCompareLogin("foxxist"));
    }
}
