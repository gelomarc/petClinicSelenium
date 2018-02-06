package flowTests;

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

import static com.petClinic.utils.Utils.dateFormat;
import static com.petClinic.utils.Utils.initDriver;

public class AddOwnerAndPetAndEditAndCheckOwnerDetailsTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    private static FindOwnersPage findOwnersPage = new FindOwnersPage(driver);

    private static LocalDateTime birthDate = LocalDateTime.now();

    private static Owner owner = new Owner("Brian", "Adams", "South Street 11", "North Hampshire", "111222333");

    private static Pet pet = new Pet("Max", birthDate, PetType.DOG, owner);

    private static Pet editedPet = new Pet("Mr Kittens", birthDate.minusDays(1), PetType.CAT, owner);

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
            findOwnersPage.waitForElementVisible(findOwnersPage.getOwnerInformation().getNameLabel(), 2);
            findOwnersPage.click(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getEditPetButton());
            findOwnersPage.waitForElementVisible(findOwnersPage.getAddOrEditPetForm().getAddPetButton(), 2);
            findOwnersPage.fillInAddPetForm(editedPet);
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
    public void shouldSeeOnePet() {
        findOwnersPage.listShouldBeSize(findOwnersPage.getOwnerInformation().getPetListItems(), 1);
    }

    @Test
    public void shouldSeePetName() {
        findOwnersPage.shouldSeeText(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getNameLabel(), editedPet.getName());
    }

    @Test
    public void shouldSeePetBirthDate() {
        findOwnersPage.shouldSeeText(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getBirthDateLabel(), dateFormat(editedPet.getBirthDate()));
    }

    @Test
    public void shouldSeePetType() {
        findOwnersPage.shouldSeeText(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getTypeLabel(), editedPet.getPetType().getPetType());
    }

    @Test
    public void shouldSeeName() {
        findOwnersPage.shouldSeeText(findOwnersPage.getOwnerInformation().getPetListItems().get(0).getNameLabel(), editedPet.getName());
    }

    @Test
    public void shouldSeeSpringImage() {
        findOwnersPage.shouldSee(findOwnersPage.getCommonStaticElements().getSpringImage());
    }
}