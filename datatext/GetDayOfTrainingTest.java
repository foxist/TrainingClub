import com.company.io.DataText;
import com.company.model.account.Data;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GetDayOfTrainingTest {

    @Test
    public void getDayOfTrainingDayTest() throws IOException {
        String string = "1. ��� ������ ���� (5 � 10)\n" +
                "50/1; 60/1; 70/1; 80/2.\n" +
                "2. ��� �������� �� ��������� ������ (5 � 12)\n" +
                "12/2; 17/3.\n" +
                "3. �������� �������� �� ������ ������ (5 � 10/12)\n" +
                "9.5; 12/2; 14.5/2.\n" +
                "4. ������ �������� �� ������ (5 � 10/12)\n" +
                "10/1; 15/1; 20/2; 22.5/1.\n" +
                "5. ������ �������� � ��������� � �������� (5 � 12/15)\n" +
                "12/5.\n";

        assertEquals(string, new DataText().getDayOfTraining(new Data(), 1));
    }

    @Test
    public void getDayOfTrainingDayTestNeg() throws IOException {
        String string = "1. ��� ������ ���� (4 � 8)\n" +
                "50/1; 60/1; 70/1; 80/2.\n" +
                "2. ��� �������� �� ��������� ������ (4 � 12)\n" +
                "12/2; 17/3.\n" +
                "3. �������� �������� �� ������ ������ (3 � 10/12)\n" +
                "9.5; 12/2; 14.5/2.\n" +
                "4. ������ �������� �� ������ (6 � 10/12)\n" +
                "10/1; 15/1; 20/2; 22.5/1.\n" +
                "5. ������ �������� � ��������� � �������� (6 � 12/15)\n" +
                "12/5.\n";

        assertNotEquals(string, new DataText().getDayOfTraining(new Data(), 4));
    }
}
