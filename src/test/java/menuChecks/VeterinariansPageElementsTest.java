package menuChecks;

import com.petClinic.entities.Veterinary;
import com.petClinic.pages.HomePage;
import com.petClinic.pages.VeterinariansPage;
import com.petClinic.steps.ClinicSteps;
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

    private static ClinicSteps steps = new ClinicSteps(driver);
    @ClassRule
    public static TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            steps.getPage("localhost:8080");
            steps.click(homePage.getMenu().getVeterinariansButton());
            steps.waitForElementVisible(veterinariansPage.getViewAsJSONButton(), 2);
        }

        @Override
        protected void finished(Description description) {
            steps.quit();
        }

    };
    private static List<Veterinary> veterinaries = steps.populateVeterinariansTable();
    @Rule
    public TestWatcher testRule = new ScreenshotOnFailTestRule(steps);


    @Test
    public void shouldSeeTitle() {
        steps.shouldSeeText(veterinariansPage.getCommonStaticElements().getTittleMessageLabel(), "Veterinarians");
    }

    @Test
    public void shouldSeeAllVets() {
        for (int i = 0; i < veterinaries.size(); i++) {
            steps.shouldSeeText(veterinariansPage.getVeterinarianListItems().get(i).getNameLabel(), veterinaries.get(i).getName());
            for (int j = 0; j < veterinaries.get(i).getSpecialities().size(); j++)
                steps.shouldSeeText(veterinariansPage.getVeterinarianListItems().get(i).getSpecialityLabels().get(j), veterinaries.get(i).getSpecialities().get(j));
        }
    }

    @Test
    public void shouldSeeSpringImage() {
        steps.shouldSee(veterinariansPage.getCommonStaticElements().getSpringImage());
    }

    @Test
    public void shouldSeeViewAsXML() {
        steps.shouldSee(veterinariansPage.getViewAsXMLButton());
    }

    @Test
    public void shouldSeeViewAsJSON() {
        steps.shouldSee(veterinariansPage.getViewAsJSONButton());
    }
}
