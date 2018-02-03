package menuChecks;

import com.petClinic.pages.ErrorPage;
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

public class ErrorPageElementsTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    private static ErrorPage errorPage = new ErrorPage(driver);

    private static WebDriverSteps steps = new WebDriverSteps(driver);

    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            steps.getPage("localhost:8080");
            steps.click(homePage.getMenu().getErrorButton());
            steps.waitForElementVisible(errorPage.getErrorMessage(), 2);
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
        steps.shouldSeeText(errorPage.getCommonStaticElements().getTittleMessageLabel(), "Something happened...");
    }

    @Test
    public void shouldSeeErrorMessage() {
        steps.shouldSeeText(errorPage.getErrorMessage(), "Expected: controller used to showcase what happens when an exception is thrown");
    }

    @Test
    public void shouldSeePetsImage() {
        steps.shouldSee(errorPage.getPetsImage());
    }

    @Test
    public void shouldSeeSpringImage() {
        steps.shouldSee(errorPage.getCommonStaticElements().getSpringImage());
    }
}
