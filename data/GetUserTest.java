import com.company.model.account.Data;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GetUserTest {

    @Test
    public void getUserTest() throws IOException {
        Data d = new Data().getUser("fox");
        String name = "Ruslan";
        String surname = "Zainullin";
        String gender = "male";
        String login = "fox";
        String password = "123";
        assertEquals(name, d.getName());
        assertEquals(surname, d.getSurname());
        assertEquals(gender, d.getGender());
        assertEquals(login, d.getLogin());
        assertEquals(password, d.getPassword());
    }

    @Test
    public void getUserTestNeg() throws IOException {
        Data d = new Data().getUser("fox");
        String name = "Andriana";
        String surname = "Simonova";
        String gender = "female";
        String login = "do4a";
        String password = "qwerty";
        assertNotEquals(name, d.getName());
        assertNotEquals(surname, d.getSurname());
        assertNotEquals(gender, d.getGender());
        assertNotEquals(login, d.getLogin());
        assertNotEquals(password, d.getPassword());
    }
}
