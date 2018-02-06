package ValidationChecks;

import com.petClinic.entities.Owner;
import com.petClinic.entities.Pet;
import com.petClinic.pages.FindOwnersPage;
import com.petClinic.pages.HomePage;
import com.petClinic.utils.PetType;
import com.petClinic.utils.ScreenshotOnFailTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

import static com.petClinic.utils.Utils.initDriver;

public class AddPetFormValidationTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    private static FindOwnersPage findOwnersPage = new FindOwnersPage(driver);

    private static LocalDateTime birthDate = LocalDateTime.now().plusDays(1);

    private static Owner owner = new Owner("Brian", "Adams", "South Street 11", "North Hampshire", "111222333");

    private static Pet pet = new Pet("", birthDate, PetType.DOG, owner);

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
            findOwnersPage.click(findOwnersPage.getOwnerInformation().getAddNewPetButton());
            findOwnersPage.waitForElementVisible(findOwnersPage.getAddOrEditPetForm().getAddPetButton(), 2);
            findOwnersPage.fillInAddPetForm(pet);
        }

        @Override
        protected void finished(Description description) {
            findOwnersPage.quit();
        }

    };

    @Rule
    public TestWatcher testRule = new ScreenshotOnFailTestRule(findOwnersPage);


    @Test
    public void shouldSeeNameValidationMessage() {
        findOwnersPage.shouldSeeText(findOwnersPage.getAddOrEditPetForm().getNameValidationMessage(), "is required");
    }

    @Test
    public void shouldSeeBirthDateValidationMessage() {
        findOwnersPage.shouldSeeText(findOwnersPage.getAddOrEditPetForm().getBirthDateValidationMessage(), "invalid date");
    }

    @Test
    public void shouldSeeSpringImage() {
        findOwnersPage.shouldSee(findOwnersPage.getCommonStaticElements().getSpringImage());
    }
}