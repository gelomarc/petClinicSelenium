package menuChecks;

import com.petClinic.pages.HomePage;
import com.petClinic.steps.WebDriverSteps;
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

    private static WebDriverSteps steps = new WebDriverSteps(driver);

    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            steps.getPage("localhost:8080");
            steps.click(homePage.getMenu().getHomeButton());
            steps.waitForElementVisible(homePage.getPetsImage(), 2);
        }

        @Override
        protected void finished(Description description) {
            steps.quit();
        }

    };

    @Rule
    public TestWatcher testRule = new ScreenshotOnFailTestRule(steps);


    @Test
    public void shouldSeeTitle() {
        steps.shouldSeeText(homePage.getCommonStaticElements().getTittleMessageLabel(), "Welcome");
    }

    @Test
    public void shouldSeePetsImage() {
        steps.shouldSee(homePage.getPetsImage());
    }

    @Test
    public void shouldSeeSpringImage() {
        steps.shouldSee(homePage.getCommonStaticElements().getSpringImage());
    }
}
