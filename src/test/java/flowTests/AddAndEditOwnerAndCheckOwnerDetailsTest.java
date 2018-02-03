package flowTests;

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

public class AddAndEditOwnerAndCheckOwnerDetailsTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    private static FindOwnersPage findOwnersPage = new FindOwnersPage(driver);

    private static ClinicSteps steps = new ClinicSteps(driver);

    private static Owner owner = new Owner("Brian", "Adams", "South Street 11", "North Hampshire", "111222333");

    private static Owner editedOwner = new Owner("Carl", "Hanks", "North Street 11", "South Hampshire", "333222111");

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
            steps.waitForElementVisible(findOwnersPage.getOwnerInformation().getAddNewPetButton(), 2);
            steps.click(findOwnersPage.getOwnerInformation().getEditOwnerButton());
            steps.waitForElementVisible(findOwnersPage.getAddOrEditOwnerForm().getAddOrEditOwnerButton(), 2);
            steps.fillInAddOwnerForm(editedOwner);
            steps.waitForElementVisible(findOwnersPage.getOwnerInformation().getAddNewPetButton(), 2);
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
        steps.shouldSeeText(findOwnersPage.getCommonStaticElements().getTittleMessageLabel(), "Owner Information");
    }

    @Test
    public void shouldSeeNameLabel() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getNameLabel(), editedOwner.getFirstName() + " " + editedOwner.getLastName());
    }

    @Test
    public void shouldSeeAddressLabel() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getAddressLabel(), editedOwner.getAddress());
    }

    @Test
    public void shouldSeeCityLabel() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getCityLabel(), editedOwner.getCity());
    }

    @Test
    public void shouldSeeTelephoneLabel() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getTelephoneLabel(), editedOwner.getTelephone());
    }

    @Test
    public void shouldSeeEditOwnerButton() {
        steps.shouldSee(findOwnersPage.getOwnerInformation().getEditOwnerButton());
    }

    @Test
    public void shouldSeeAddNewPetButton() {
        steps.shouldSee(findOwnersPage.getOwnerInformation().getAddNewPetButton());
    }

    @Test
    public void shouldNotSeePetsAndVisits() {
        steps.listShouldBeSize(findOwnersPage.getOwnerInformation().getPetListItems(), 0);
    }

    @Test
    public void shouldSeeSpringImage() {
        steps.shouldSee(findOwnersPage.getCommonStaticElements().getSpringImage());
    }
}