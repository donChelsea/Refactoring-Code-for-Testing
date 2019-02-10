package org.pursuit.testing_revisited_refactoring_code.salutation;

public interface SalutationInterface {

    String fullName(String name);

    String[] splitName(String nameArray);

    String firstName(String[] nameArray);

    String lastName(String[] nameArray);

    String professionalPrefix(ProfessionalDesignationEnum profession);

    String professionalSuffix(ProfessionalDesignationEnum profession);

    boolean hasPrefix(ProfessionalDesignationEnum profession);

    String professionalName(String prefix, String[] splitName, String suffix, ProfessionalDesignationEnum profession);

    int yearsOfEducation(ProfessionalDesignationEnum profession);

    String careerBio(String[] splitName, String prefix, String suffix, ProfessionalDesignationEnum profession, int educationYears, boolean hasPrefix);

}
