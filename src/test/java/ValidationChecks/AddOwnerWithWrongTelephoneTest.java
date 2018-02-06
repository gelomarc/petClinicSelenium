package ValidationChecks;

import com.petClinic.entities.Owner;
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

public class AddOwnerWithWrongTelephoneTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    private static FindOwnersPage findOwnersPage = new FindOwnersPage(driver);

    private static Owner owner = new Owner("", "", "", "", "abcd");

    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            findOwnersPage.getPage("localhost:8080");
            findOwnersPage.click(homePage.getMenu().getFindOwnersButton());
            findOwnersPage.waitForElementVisible(findOwnersPage.getLastElementTextBox(), 2);
            findOwnersPage.click(findOwnersPage.getAddOwnerButton());
            findOwnersPage.waitForElementVisible(findOwnersPage.getAddOrEditOwnerForm().getAddOrEditOwnerButton(), 2);
            findOwnersPage.fillInAddOwnerForm(owner);
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
        findOwnersPage.shouldSeeText(findOwnersPage.getCommonStaticElements().getTittleMessageLabel(), "Owner");
    }

    @Test
    public void shouldSeeAddOwnerButton() {
        findOwnersPage.shouldSee(findOwnersPage.getAddOrEditOwnerForm().getAddOrEditOwnerButton());
    }

    @Test
    public void shouldSeeFirstNameValidationMessage() {
        findOwnersPage.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getFirstNameValidationMessage(), "must not be empty");
    }

    @Test
    public void shouldSeeLastNameValidationMessage() {
        findOwnersPage.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getLastNameValidationMessage(), "must not be empty");
    }

    @Test
    public void shouldSeeAddressValidationMessage() {
        findOwnersPage.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getAddressValidationMessage(), "must not be empty");
    }

    @Test
    public void shouldSeeCityValidationMessage() {
        findOwnersPage.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getCityValidationMessage(), "must not be empty");
    }

    @Test
    public void shouldSeeTelephoneValidationMessage() {
        findOwnersPage.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getTelephoneValidationMessage(), "numeric value out of bounds (<10 digits>.<0 digits> expected)");
    }

    @Test
    public void shouldSeeSpringImage() {
        findOwnersPage.shouldSee(findOwnersPage.getCommonStaticElements().getSpringImage());
    }
}