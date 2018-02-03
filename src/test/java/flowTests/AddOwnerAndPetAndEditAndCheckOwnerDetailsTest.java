package flowTests;

import com.petClinic.entities.Owner;
import com.petClinic.entities.Pet;
import com.petClinic.pages.FindOwnersPage;
import com.petClinic.pages.HomePage;
import com.petClinic.steps.ClinicSteps;
import com.petClinic.utils.PetType;
import com.petClinic.utils.ScreenshotOnFailTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

import static com.petClinic.utils.Utils.dateFormat;
import static com.petClinic.utils.Utils.initDriver;

public class AddOwnerAndPetAndEditAndCheckOwnerDetailsTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    private static FindOwnersPage findOwnersPage = new FindOwnersPage(driver);

    private static ClinicSteps steps = new ClinicSteps(driver);

    private static LocalDateTime birthDate = LocalDateTime.now();

    private static Owner owner = new Owner("Brian", "Adams", "South Street 11", "North Hampshire", "111222333");

    private static Pet pet = new Pet("Max", birthDate, PetType.DOG, owner);

    private static Pet editedPet = new Pet("Mr Kittens", birthDate.minusDays(1), PetType.CAT, owner);

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
            steps.click(findOwnersPage.getOwnerInformation().getAddNewPetButton());
            steps.waitForElementVisible(findOwnersPage.getAddOrEditPetForm().getAddPetButton(), 2);
            steps.fillInAddPetForm(pet);
            steps.waitForElementVisible(findOwnersPage.getOwnerInformation().getNameLabel(), 2);
            steps.click(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getEditPetButton());
            steps.waitForElementVisible(findOwnersPage.getAddOrEditPetForm().getAddPetButton(), 2);
            steps.fillInAddPetForm(editedPet);
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
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getNameLabel(), owner.getFirstName() + " " + owner.getLastName());
    }

    @Test
    public void shouldSeeAddressLabel() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getAddressLabel(), owner.getAddress());
    }

    @Test
    public void shouldSeeCityLabel() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getCityLabel(), owner.getCity());
    }

    @Test
    public void shouldSeeTelephoneLabel() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getTelephoneLabel(), owner.getTelephone());
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
    public void shouldSeeOnePet() {
        steps.listShouldBeSize(findOwnersPage.getOwnerInformation().getPetListItems(), 1);
    }

    @Test
    public void shouldSeePetName() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getNameLabel(), editedPet.getName());
    }

    @Test
    public void shouldSeePetBirthDate() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getBirthDateLabel(), dateFormat(editedPet.getBirthDate()));
    }

    @Test
    public void shouldSeePetType() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getTypeLabel(), editedPet.getPetType().getPetType());
    }

    @Test
    public void shouldSeeName() {
        steps.shouldSeeText(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getNameLabel(), editedPet.getName());
    }

    @Test
    public void shouldSeeSpringImage() {
        steps.shouldSee(findOwnersPage.getCommonStaticElements().getSpringImage());
    }
}