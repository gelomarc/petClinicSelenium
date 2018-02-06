package menuChecks;

import com.petClinic.pages.ErrorPage;
import com.petClinic.pages.HomePage;
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


    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            errorPage.getPage("localhost:8080");
            errorPage.click(homePage.getMenu().getErrorButton());
            errorPage.waitForElementVisible(errorPage.getErrorMessage(), 2);
        }

        @Override
        protected void finished(Description description) {
            errorPage.quit();
        }

    };

    @Rule
    public TestWatcher testRule = new ScreenshotOnFailTestRule(errorPage);


    @Test
    public void shouldSeeTitle() {
        errorPage.shouldSeeText(errorPage.getCommonStaticElements().getTittleMessageLabel(), "Something happened...");
    }

    @Test
    public void shouldSeeErrorMessage() {
        errorPage.shouldSeeText(errorPage.getErrorMessage(), "Expected: controller used to showcase what happens when an exception is thrown");
    }

    @Test
    public void shouldSeePetsImage() {
        errorPage.shouldSee(errorPage.getPetsImage());
    }

    @Test
    public void shouldSeeSpringImage() {
        errorPage.shouldSee(errorPage.getCommonStaticElements().getSpringImage());
    }
}
