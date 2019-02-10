package org.pursuit.testing_revisited_refactoring_code.salutation;

public class Salutation implements SalutationInterface {

    private static Salutation instance;

    /**
     * Singleton Static Factory Method to create an instance of the class, store it statically (if null), and return it to the user.
     *
     * @return Salutation instance.
     */

    public static Salutation getInstance() {
        if (instance == null) {
            instance = new Salutation();
        }
        return instance;
    }

    private Salutation() {
    }

    /**
     * This method returns the name entered by the user.
     *
     * @param name String input of full name.
     */

    @Override
    public String fullName(String name) {
        if (name == null) {
            return "";
        }
        return name;
    }

    /**
     * This method returns a String array consisting of two elements, a first name and a last name.
     *
     * @param name String input of full name.
     * @return String array of first and last name at indices 0 and 1, respectively.
     */

    @Override
    public String[] splitName(String name) {
        String first = null;
        String last = null;
        int temp = 0;

        String[] newStrArr = name.split(" ");
        for (int i = 0; i < newStrArr.length; i++) {
            if (newStrArr[i] == null) {
                return new String[]{};
            }
            first = newStrArr[0].trim();
            last = newStrArr[newStrArr.length - 1].trim();
        }
        return new String[]{first, last};
    }

    /**
     * This method returns a String, the user's first name.
     *
     * @param nameArray String array consisting of first and last name values.
     * @return the String value of the user's first name.
     */

    @Override
    public String firstName(String[] nameArray) {
        if (nameArray == null || nameArray[0] == "") {
            return "";
        }
        return nameArray[0];
    }

    /**
     * This method returns a String, the user's last name.
     *
     * @param nameArray String array consisting of first and last name values.
     * @return the String value of the user's last name.
     */

    @Override
    public String lastName(String[] nameArray) {
        String last = nameArray[nameArray.length - 1];
        if (last == null || last.equals("")) {
            return "";
        }
        return nameArray[nameArray.length - 1];
    }

    /**
     * This method returns a prefix value based on the profession - i.e. "Dr,", "Honorable", etc.
     *
     * @param profession ProfessionalDesignationEnum enum value.
     * @return the String prefix value for a particular profession.
     */

    @Override
    public String professionalPrefix(ProfessionalDesignationEnum profession) {
        String prefix = null;
        switch (profession) {
            case MEDICAL_DOCTOR:
                prefix = "Dr.";
                break;
            case ACADEMIC_PROFESSONAL:
                prefix = "Dr.";
                break;
            case DENTIST:
                prefix = "Dr.";
                break;
            case VETERNARIAN:
                prefix = "Dr.";
                break;
            case JUDGE:
                prefix = "Honorable";
                break;
            default:
                prefix = "";
                break;
        }
        return prefix;
    }

    /**
     * This method returns a suffix value based on the profession - i.e. "MD", "DDS", etc.
     *
     * @param profession ProfessionalDesignationEnum enum value.
     * @return the String suffix value for a particular profession.
     */

    @Override
    public String professionalSuffix(ProfessionalDesignationEnum profession) {
        String suffix = null;
        switch (profession) {
            case MEDICAL_DOCTOR:
                suffix = "MD";
                break;
            case LAWYER:
                suffix = "Esq.";
                break;
            case ACADEMIC_PROFESSONAL:
                suffix = "PhD";
                break;
            case DENTIST:
                suffix = "DDS";
                break;
            case CERTIFIED_PUBLIC_ACCOUNTANT:
                suffix = "CPA";
                break;
            case VETERNARIAN:
                suffix = "DVM";
                break;
                default:
                    suffix = "";
                    break;
        }

        return suffix;
    }

    /**
     * This method returns a boolean value based on whether the profession has a prefix.
     *
     * @param profession ProfessionalDesignationEnum enum value.
     * @return the boolean value based on the prefix value.
     */

    @Override
    public boolean hasPrefix(ProfessionalDesignationEnum profession) {
        return !professionalPrefix(profession).equals("");
    }

    /**
     * This method returns a String value for the complete professional name of a person: i.e. - "Dr. Amy Martinez, DDS.", etc.
     *
     * @param prefix     prefix String value.
     * @param splitName  String[] array of first/last name.
     * @param suffix     suffix String value.
     * @param profession ProfessionalDesignationEnum enum value.
     * @return a String value for the complete professional name of a person.
     */

    @Override
    public String professionalName(String prefix, String[] splitName, String suffix, ProfessionalDesignationEnum profession) {
        if (prefix == null || prefix.equals("")) {
            return splitName[0] + " " + splitName[splitName.length - 1] + " " + suffix + " " + profession;
        } else if (suffix == null || suffix.equals("")) {
            return prefix + " " + splitName[0] + " " + splitName[splitName.length - 1] + " " + profession;
        }
        return prefix + " " + splitName[0] + " " + splitName[splitName.length - 1] + " " + suffix + " " + profession;
    }

    /**
     * This method returns an int value for the number of years of additional education after a bachelor's degree it takes to join a profession - i.e. Accountant: 2 years, Lawyer: 3 years, Doctor: 5 years, etc.
     *
     * @param profession ProfessionalDesignationEnum enum value.
     * @return int value for the number of years of additional education after a bachelor's degree
     */

    @Override
    public int yearsOfEducation(ProfessionalDesignationEnum profession) {
        int yearsOfSchool = 0;
        switch (profession) {
            case MEDICAL_DOCTOR:
                yearsOfSchool = 8;
                break;
            case LAWYER:
                yearsOfSchool = 3;
                break;
            case JUDGE:
                yearsOfSchool = 3;
                break;
            case DENTIST:
                yearsOfSchool = 4;
                break;
            case VETERNARIAN:
                yearsOfSchool = 2;
                break;
            case ACADEMIC_PROFESSONAL:
                yearsOfSchool = 4;
                break;
            case CERTIFIED_PUBLIC_ACCOUNTANT:
                yearsOfSchool = 0;
                break;
        }
        return yearsOfSchool;
    }

    /**
     * This method returns a String value for a mini-biography of a professional, i.e. - "Dr. Amy Martinez, DDS. went to school for an additional 5 years to join their profession."
     *
     * @param splitName      String[] array of first/last name.
     * @param prefix         prefix String value.
     * @param suffix         suffix String value.
     * @param profession     ProfessionalDesignationEnum enum value.
     * @param educationYears int value for the number of years of additional education after a bachelor's degree
     * @param hasPrefix      the boolean value based on the prefix value.
     * @return a String value for a mini-biography of a professional
     */

    @Override
    public String careerBio(String[] splitName, String prefix, String suffix, ProfessionalDesignationEnum profession, int educationYears, boolean hasPrefix) {
        educationYears = yearsOfEducation(profession);
        if (!hasPrefix || prefix == null || prefix.equals("")) {
            return splitName[0] + " " + splitName[splitName.length - 1] + " is a " + profession + ". They went to school for " + educationYears + " years after a bachelor's degree.";
        } else if (suffix == null || suffix.equals("")) {
            return prefix + " " + splitName[0] + " " + splitName[splitName.length - 1] + " is a " + profession + ". They went to school for " + educationYears + " years after a bachelor's degree.";
        }
        return prefix + " " + splitName[0] + " " + splitName[splitName.length - 1] + " " + suffix + " is a " + profession + ". They went to school for " + educationYears + " years after a bachelor's degree.";
    }
}
