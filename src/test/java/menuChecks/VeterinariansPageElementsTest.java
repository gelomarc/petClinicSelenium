package menuChecks;

import com.petClinic.entities.Veterinary;
import com.petClinic.pages.HomePage;
import com.petClinic.pages.VeterinariansPage;
import com.petClinic.utils.ScreenshotOnFailTestRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.petClinic.utils.Utils.initDriver;

public class VeterinariansPageElementsTest {

    private static final WebDriver driver = initDriver();

    private static HomePage homePage = new HomePage(driver);

    private static VeterinariansPage veterinariansPage = new VeterinariansPage(driver);

    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            veterinariansPage.getPage("localhost:8080");
            veterinariansPage.click(homePage.getMenu().getVeterinariansButton());
            veterinariansPage.waitForElementVisible(veterinariansPage.getViewAsJSONButton(), 2);
        }

        @Override
        protected void finished(Description description) {
            veterinariansPage.quit();
        }

    };
    private static List<Veterinary> veterinaries = veterinariansPage.populateVeterinariansTable();
    @Rule
    public TestWatcher testRule = new ScreenshotOnFailTestRule(veterinariansPage);


    @Test
    public void shouldSeeTitle() {
        veterinariansPage.shouldSeeText(veterinariansPage.getCommonStaticElements().getTittleMessageLabel(), "Veterinarians");
    }

    @Test
    public void shouldSeeAllVets() {
        for (int i = 0; i < veterinaries.size(); i++) {
            veterinariansPage.shouldSeeText(veterinariansPage.getVeterinarianListItems().get(i).getNameLabel(), veterinaries.get(i).getName());
            for (int j = 0; j < veterinaries.get(i).getSpecialities().size(); j++)
                veterinariansPage.shouldSeeText(veterinariansPage.getVeterinarianListItems().get(i).getSpecialityLabels().get(j), veterinaries.get(i).getSpecialities().get(j));
        }
    }

    @Test
    public void shouldSeeSpringImage() {
        veterinariansPage.shouldSee(veterinariansPage.getCommonStaticElements().getSpringImage());
    }

    @Test
    public void shouldSeeViewAsXML() {
        veterinariansPage.shouldSee(veterinariansPage.getViewAsXMLButton());
    }

    @Test
    public void shouldSeeViewAsJSON() {
        veterinariansPage.shouldSee(veterinariansPage.getViewAsJSONButton());
    }
}
