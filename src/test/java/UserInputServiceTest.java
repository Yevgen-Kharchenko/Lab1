import vancoffee.service.UserInputService;

import static org.junit.Assert.*;

public class UserInputServiceTest {
    private UserInputService userInputService = new UserInputService();


    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void showQuestion() {

        assertTrue(userInputService.showQuestion(""));
    }

    @org.junit.Test
    public void getUserInput() {
    }
}