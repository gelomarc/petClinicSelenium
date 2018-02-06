package menuChecks;

import com.petClinic.pages.FindOwnersPage;
import com.petClinic.pages.HomePage;
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

    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            findOwnersPage.getPage("localhost:8080");
            findOwnersPage.click(homePage.getMenu().getFindOwnersButton());
            findOwnersPage.waitForElementVisible(findOwnersPage.getLastElementTextBox(), 2);
        }

        @Override
        protected void finished(Description description) {
            findOwnersPage.quit();
        }

    };

    @Rule
    public TestWatcher testRule = new ScreenshotOnFailTestRule(findOwnersPage);


    @Test
    public void shouldSeeTitle() {
        findOwnersPage.shouldSeeText(findOwnersPage.getCommonStaticElements().getTittleMessageLabel(), "Find Owners");
    }

    @Test
    public void shouldSeeLastNameTextBox() {
        findOwnersPage.shouldSee(findOwnersPage.getLastElementTextBox());
    }

    @Test
    public void shouldSeeFindOwnerButton() {
        findOwnersPage.shouldSee(findOwnersPage.getFindOwnerButton());
    }

    @Test
    public void shouldSeeAddOwnerButton() {
        findOwnersPage.shouldSee(findOwnersPage.getAddOwnerButton());
    }

    @Test
    public void shouldSeeSpringImage() {
        findOwnersPage.shouldSee(findOwnersPage.getCommonStaticElements().getSpringImage());
    }
}
