package menuChecks;

import com.petClinic.pages.FindOwnersPage;
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

public class FindOwnerElementsTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    private static FindOwnersPage findOwnersPage = new FindOwnersPage(driver);

    private static WebDriverSteps steps = new WebDriverSteps(driver);

    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            steps.getPage("localhost:8080");
            steps.click(homePage.getMenu().getFindOwnersButton());
            steps.waitForElementVisible(findOwnersPage.getLastElementTextBox(), 2);
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
        steps.shouldSeeText(findOwnersPage.getCommonStaticElements().getTittleMessageLabel(), "Find Owners");
    }

    @Test
    public void shouldSeeLastNameTextBox() {
        steps.shouldSee(findOwnersPage.getLastElementTextBox());
    }

    @Test
    public void shouldSeeFindOwnerButton() {
        steps.shouldSee(findOwnersPage.getFindOwnerButton());
    }

    @Test
    public void shouldSeeAddOwnerButton() {
        steps.shouldSee(findOwnersPage.getAddOwnerButton());
    }

    @Test
    public void shouldSeeSpringImage() {
        steps.shouldSee(findOwnersPage.getCommonStaticElements().getSpringImage());
    }
}
