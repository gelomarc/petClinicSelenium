package ValidationChecks;

import com.petClinic.entities.Owner;
import com.petClinic.pages.FindOwnersPage;
import com.petClinic.pages.HomePage;
import com.petClinic.steps.ClinicSteps;
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

    private static ClinicSteps steps = new ClinicSteps(driver);

    private static Owner owner = new Owner("", "", "", "", "abcd");

    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            steps.getPage("localhost:8080");
            steps.click(homePage.getMenu().getFindOwnersButton());
            steps.waitForElementVisible(findOwnersPage.getLastElementTextBox(), 2);
            steps.click(findOwnersPage.getAddOwnerButton());
            steps.waitForElementVisible(findOwnersPage.getAddOrEditOwnerForm().getAddOrEditOwnerButton(), 2);
            steps.fillInAddOwnerForm(owner);
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
        steps.shouldSeeText(findOwnersPage.getCommonStaticElements().getTittleMessageLabel(), "Owner");
    }

    @Test
    public void shouldSeeAddOwnerButton() {
        steps.shouldSee(findOwnersPage.getAddOrEditOwnerForm().getAddOrEditOwnerButton());
    }

    @Test
    public void shouldSeeFirstNameValidationMessage() {
        steps.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getFirstNameValidationMessage(), "must not be empty");
    }

    @Test
    public void shouldSeeLastNameValidationMessage() {
        steps.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getLastNameValidationMessage(), "must not be empty");
    }

    @Test
    public void shouldSeeAddressValidationMessage() {
        steps.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getAddressValidationMessage(), "must not be empty");
    }

    @Test
    public void shouldSeeCityValidationMessage() {
        steps.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getCityValidationMessage(), "must not be empty");
    }

    @Test
    public void shouldSeeTelephoneValidationMessage() {
        steps.shouldSeeText(findOwnersPage.getAddOrEditOwnerForm().getTelephoneValidationMessage(), "numeric value out of bounds (<10 digits>.<0 digits> expected)");
    }

    @Test
    public void shouldSeeSpringImage() {
        steps.shouldSee(findOwnersPage.getCommonStaticElements().getSpringImage());
    }
}