package flowTests;

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

public class AddOwnerAndCheckOwnerDetailsTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    private static FindOwnersPage findOwnersPage = new FindOwnersPage(driver);

    private static Owner owner = new Owner("Brian", "Adams", "South Street 11", "North Hampshire", "111222333");

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
            findOwnersPage.waitForElementVisible(findOwnersPage.getOwnerInformation().getAddNewPetButton(), 2);
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
        findOwnersPage.shouldSeeText(findOwnersPage.getCommonStaticElements().getTittleMessageLabel(), "Owner Information");
    }

    @Test
    public void shouldSeeNameLabel() {
        findOwnersPage.shouldSeeText(findOwnersPage.getOwnerInformation().getNameLabel(), owner.getFirstName() + " " + owner.getLastName());
    }

    @Test
    public void shouldSeeAddressLabel() {
        findOwnersPage.shouldSeeText(findOwnersPage.getOwnerInformation().getAddressLabel(), owner.getAddress());
    }

    @Test
    public void shouldSeeCityLabel() {
        findOwnersPage.shouldSeeText(findOwnersPage.getOwnerInformation().getCityLabel(), owner.getCity());
    }

    @Test
    public void shouldSeeTelephoneLabel() {
        findOwnersPage.shouldSeeText(findOwnersPage.getOwnerInformation().getTelephoneLabel(), owner.getTelephone());
    }

    @Test
    public void shouldSeeEditOwnerButton() {
        findOwnersPage.shouldSee(findOwnersPage.getOwnerInformation().getEditOwnerButton());
    }

    @Test
    public void shouldSeeAddNewPetButton() {
        findOwnersPage.shouldSee(findOwnersPage.getOwnerInformation().getAddNewPetButton());
    }

    @Test
    public void shouldNotSeePetsAndVisits() {
        findOwnersPage.listShouldBeSize(findOwnersPage.getOwnerInformation().getPetListItems(), 0);
    }

    @Test
    public void shouldSeeSpringImage() {
        findOwnersPage.shouldSee(findOwnersPage.getCommonStaticElements().getSpringImage());
    }
}