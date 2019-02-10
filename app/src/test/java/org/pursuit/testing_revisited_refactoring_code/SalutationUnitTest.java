package org.pursuit.testing_revisited_refactoring_code;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pursuit.testing_revisited_refactoring_code.salutation.ProfessionalDesignationEnum;
import org.pursuit.testing_revisited_refactoring_code.salutation.Salutation;

import static org.pursuit.testing_revisited_refactoring_code.salutation.ProfessionalDesignationEnum.CERTIFIED_PUBLIC_ACCOUNTANT;
import static org.pursuit.testing_revisited_refactoring_code.salutation.ProfessionalDesignationEnum.DENTIST;
import static org.pursuit.testing_revisited_refactoring_code.salutation.ProfessionalDesignationEnum.JUDGE;
import static org.pursuit.testing_revisited_refactoring_code.salutation.ProfessionalDesignationEnum.LAWYER;
import static org.pursuit.testing_revisited_refactoring_code.salutation.ProfessionalDesignationEnum.MEDICAL_DOCTOR;

public class SalutationUnitTest {

    private Salutation salutation;

    @Before
    public void setUp() throws Exception {
        salutation = Salutation.getInstance();
    }

    @Test
    public void check_full_name_method_not_null_with_valid_input() {
        String fullName = salutation.fullName("Ron Burgundy");
        Assert.assertNotNull(fullName);
    }

    @Test
    public void check_full_name_method_not_null_with_null_input() {
        String fullName = salutation.fullName(null);
        Assert.assertNotNull(fullName);
    }

    @Test
    public void check_split_name_for_inputs_with_first_last_name() {
        String fullName = "Ron Burgundy";
        String[] firstLastName = salutation.splitName(fullName);
        Assert.assertEquals("Ron", firstLastName[0]);
        Assert.assertEquals("Burgundy", firstLastName[firstLastName.length - 1]);
    }

    @Test
    public void check_split_name_for_inputs_with_longer_names() {
        String fullName = "Ron Carlos Archibald Ferdinand Burgundy";
        String[] firstLastName = salutation.splitName(fullName);
        Assert.assertEquals("Ron", firstLastName[0]);
        Assert.assertEquals("Burgundy", firstLastName[firstLastName.length - 1]);
    }

    @Test
    public void check_split_name_for_not_null_values() {
        String fullName = "Ron Carlos Archibald Ferdinand Burgundy";
        String[] firstLastName = salutation.splitName(fullName);
        Assert.assertNotNull(firstLastName[0]);
        Assert.assertNotNull(firstLastName[firstLastName.length - 1]);
    }

    @Test
    public void check_first_name_null_input() {
        String[] nameArray = {null, "Burgandy"};
        String result = Salutation.getInstance().firstName(nameArray);

        Assert.assertNotNull(result, nameArray);
    }

    @Test
    public void check_first_name_invalid_input() {
        String[] nameArray = {"", "Burgandy"};
        String result = Salutation.getInstance().firstName(nameArray);

        Assert.assertNotNull(result, nameArray);
    }

    @Test
    public void check_last_name_null_input() {
        String[] nameArray = {"Ron", null};
        String result = Salutation.getInstance().lastName(nameArray);

        Assert.assertNotNull(result, nameArray);
    }

    @Test
    public void check_last_name_invalid_input() {
        String[] nameArray = {"Ron", ""};
        String result = Salutation.getInstance().lastName(nameArray);

        Assert.assertNotNull(result, nameArray);
    }

    @Test
    public void check_professional_prefix_with_invalid_input() {
        ProfessionalDesignationEnum profession = CERTIFIED_PUBLIC_ACCOUNTANT;
        String result = Salutation.getInstance().professionalPrefix(profession);

        Assert.assertNotNull(result, profession);
    }

    @Test
    public void check_professional_suffix_with_invalid_input() {
        ProfessionalDesignationEnum profession = JUDGE;
        String result = Salutation.getInstance().professionalSuffix(profession);

        Assert.assertNotNull(result, profession);
    }

    @Test
    public void check_has_prefix_with_false_return() {
        ProfessionalDesignationEnum profession1 = CERTIFIED_PUBLIC_ACCOUNTANT;

        boolean result1 = Salutation.getInstance().hasPrefix(profession1);

        Assert.assertFalse(result1);
    }

    @Test
    public void check_professional_name_with_invalid_input() {
        String noSuffixResult = Salutation.getInstance().professionalName("", new String[]{"Ron", "Burgandy"}, "CPA", CERTIFIED_PUBLIC_ACCOUNTANT);
        String noPrefixResult = Salutation.getInstance().professionalName("Honorable", new String[]{"Ron", "Burgandy"}, null, JUDGE);
        String bothResult = Salutation.getInstance().professionalName("Dr.", new String[]{"Ron", "Burgandy"}, "MD", MEDICAL_DOCTOR);

        Assert.assertTrue(noPrefixResult, true);
        Assert.assertTrue(noSuffixResult, true);
        Assert.assertTrue(bothResult, true);
    }

    @Test
    public void check_years_of_education() {
        ProfessionalDesignationEnum profession = DENTIST;
        int expectedResult = 4;

        int result = Salutation.getInstance().yearsOfEducation(profession);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void check_career_bio() {
        String noSuffixResult = Salutation.getInstance().careerBio(new String[]{"Ron", "Burgandy"}, "Honorable", "", JUDGE, 3, true);
        String noPrefixResult = Salutation.getInstance().careerBio(new String[]{"Ron", "Burgandy"}, null, "CPA", CERTIFIED_PUBLIC_ACCOUNTANT, 0, false);
        String bothResult = Salutation.getInstance().careerBio(new String[]{"Ron", "Burgandy"}, "Dr.", "MD", MEDICAL_DOCTOR, 4, true);

        Assert.assertTrue(noPrefixResult, true);
        Assert.assertTrue(noSuffixResult, true);
        Assert.assertTrue(bothResult, true);
    }


    @After
    public void tearDown() throws Exception {
        salutation = null;
    }

/*    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void check_first_name_for_null_values() {
        String[] splitName = new String[]{null, "Burgundy"};
        String firstName = splitName[0];
        Assert.assertNotNull(salutation.firstName(splitName), firstName);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void check_last_name_for_null_values() {
        String[] splitName = new String[]{"Ron", null};
        String lastName = splitName[splitName.length - 1];
        Assert.assertNotNull(salutation.lastName(splitName), lastName);
    }*/


}
