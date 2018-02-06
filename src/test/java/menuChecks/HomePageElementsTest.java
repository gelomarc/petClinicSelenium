package menuChecks;

import com.petClinic.pages.HomePage;
import com.petClinic.utils.ScreenshotOnFailTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import static com.petClinic.utils.Utils.initDriver;

public class HomePageElementsTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            homePage.getPage("localhost:8080");
            homePage.click(homePage.getMenu().getHomeButton());
            homePage.waitForElementVisible(homePage.getPetsImage(), 2);
        }

        @Override
        protected void finished(Description description) {
            homePage.quit();
        }

    };

    @Rule
    public TestWatcher testRule = new ScreenshotOnFailTestRule(homePage);


    @Test
    public void shouldSeeTitle() {
        homePage.shouldSeeText(homePage.getCommonStaticElements().getTittleMessageLabel(), "Welcome");
    }

    @Test
    public void shouldSeePetsImage() {
        homePage.shouldSee(homePage.getPetsImage());
    }

    @Test
    public void shouldSeeSpringImage() {
        homePage.shouldSee(homePage.getCommonStaticElements().getSpringImage());
    }
}
