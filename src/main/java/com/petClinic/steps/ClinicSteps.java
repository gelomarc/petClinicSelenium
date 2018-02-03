package com.petClinic.steps;

import com.petClinic.entities.Owner;
import com.petClinic.entities.Pet;
import com.petClinic.entities.Veterinary;
import com.petClinic.pages.FindOwnersPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static com.petClinic.utils.Utils.dateFormat;


public class ClinicSteps extends WebDriverSteps {

    private FindOwnersPage findOwnersPage = new FindOwnersPage(getDriver());

    public ClinicSteps(WebDriver driver) {
        super(driver);
    }

    public List<Veterinary> populateVeterinariansTable() {
        List<Veterinary> veterinaries = new ArrayList<>();

        Veterinary veterinary = new Veterinary("James Carter");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Helen Leary");
        veterinary.getSpecialities().add("radiology");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Linda Douglas");
        veterinary.getSpecialities().add("dentistry");
        veterinary.getSpecialities().add("surgery");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Rafael Ortega");
        veterinary.getSpecialities().add("surgery");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Henry Stevens");
        veterinary.getSpecialities().add("radiology");
        veterinaries.add(veterinary);

        veterinary = new Veterinary("Sharon Jenkins");
        veterinaries.add(veterinary);

        return veterinaries;
    }

    public String mergeToOneStringMultipleString(List<String> list) {
        String mergedString = "";
        for (String singleString : list) {
            mergedString += singleString;
            if (!list.get(list.size() - 1).equals(singleString))
                mergedString += " ";
        }
        return mergedString;
    }

    public void fillInAddOwnerForm(Owner owner) {
        enterText(findOwnersPage.getAddOrEditOwnerForm().getFirstNameTextBox(), owner.getFirstName());
        enterText(findOwnersPage.getAddOrEditOwnerForm().getLastNameTextBox(), owner.getLastName());
        enterText(findOwnersPage.getAddOrEditOwnerForm().getAddressTextBox(), owner.getAddress());
        enterText(findOwnersPage.getAddOrEditOwnerForm().getCityTextBox(), owner.getCity());
        enterText(findOwnersPage.getAddOrEditOwnerForm().getTelephoneTextBox(), owner.getTelephone());
        click(findOwnersPage.getAddOrEditOwnerForm().getAddOrEditOwnerButton());
    }

    public void fillInAddPetForm(Pet pet) {
        enterText(findOwnersPage.getAddOrEditPetForm().getNameTextField(), pet.getName());
        enterText(findOwnersPage.getAddOrEditPetForm().getBirthDateTextField(), dateFormat(pet.getBirthDate()));
        selectSimilarOption(findOwnersPage.getAddOrEditPetForm().getPetTypeDropdown(), pet.getPetType().getPetType());
        click(findOwnersPage.getAddOrEditPetForm().getAddPetButton());
    }
}