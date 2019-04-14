import com.company.model.account.Data;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GetCounterTest {

    @Test
    public void getCounterTest() throws IOException {
        assertEquals(2, new Data().getCounter("fox", new Data()));
    }

    @Test
    public void getCounterTestNeg() throws IOException {
        assertNotEquals(4, new Data().getCounter("fox", new Data()));
    }
}
