package com.example.api2im.domain.contracts.entities;

import com.example.api2im.domain.type.ExperienceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Applicant {
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
    private String processId;
}