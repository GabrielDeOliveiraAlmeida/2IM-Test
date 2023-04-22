package com.example.api2im.app.in;

import com.example.api2im.domain.contracts.entities.Applicant;
import com.example.api2im.domain.contracts.in.ApplicantForm;
import com.example.api2im.domain.type.ExperienceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicantFormIn implements ApplicantForm {
    private String name;
    private String phoneNumber;
    private ExperienceType frontEndExperience;
    private ExperienceType backEndExperience;
    private ExperienceType dataBaseExperience;
    private ExperienceType camundaExperience;
    private ExperienceType healthAreaExperience;
    private Long yearsOfExperienceFrontEnd;
    private Long yearsOfExperienceBackEnd;
    private Long yearsOfExperienceDatabase;

    private String additionalInformation;

    public Applicant toModel() {
        return Applicant
                .builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .frontEndExperience(frontEndExperience)
                .backEndExperience(backEndExperience)
                .dataBaseExperience(dataBaseExperience)
                .camundaExperience(camundaExperience)
                .healthAreaExperience(healthAreaExperience)
                .yearsOfExperienceBackEnd(yearsOfExperienceBackEnd)
                .yearsOfExperienceFrontEnd(yearsOfExperienceFrontEnd)
                .yearsOfExperienceDatabase(yearsOfExperienceDatabase)
                .additionalInformation(additionalInformation)
                .build();
    }
}
