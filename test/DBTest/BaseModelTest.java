package DBTest;

import org.junit.*;
import play.Application;
import play.test.Helpers;

/**
 * class for creating test database
 */
public class BaseModelTest {

    public static Application app;

    @BeforeClass
    public static void startApp() {
        app = Helpers.fakeApplication();
        Helpers.start(app);
    }

    @AfterClass
    public static void stopApp() {
        Helpers.stop(app);
    }
}