import com.company.model.account.Data;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class GetTrueFalseTest {

    @Test
    public void getFalseTest() {
        assertFalse(new Data().getTrueFalse(0));
    }

    @Test
    public void getTrueTestNeg() {
        assertNotEquals(true, new Data().getTrueFalse(10));
    }
}
