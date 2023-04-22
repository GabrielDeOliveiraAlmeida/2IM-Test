package com.example.api2im.infra.repos.postgres;

import com.example.api2im.domain.contracts.entities.Applicant;
import com.example.api2im.domain.contracts.repos.ApplicantRepo;
import com.example.api2im.infra.repos.postgres.model.ApplicantPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Postgres implements ApplicantRepo {
    @Autowired
    PostgresRepo postgresRepo;


    public Applicant save(Applicant applicant) {
        ApplicantPostgres applicantPostgres = ApplicantPostgres
                .builder()
                .name(applicant.getName())
                .phoneNumber(applicant.getPhoneNumber())
                .backEndExperience(applicant.getBackEndExperience())
                .frontEndExperience(applicant.getFrontEndExperience())
                .dataBaseExperience(applicant.getDataBaseExperience())
                .camundaExperience(applicant.getCamundaExperience())
                .healthAreaExperience(applicant.getHealthAreaExperience())
                .yearsOfExperienceDatabase(applicant.getYearsOfExperienceDatabase())
                .yearsOfExperienceFrontEnd(applicant.getYearsOfExperienceFrontEnd())
                .yearsOfExperienceBackEnd(applicant.getYearsOfExperienceBackEnd())
                .processId(applicant.getProcessId())
                .id(UUID.randomUUID().toString())
                .additionalInformation(applicant.getAdditionalInformation())
                .build();
        postgresRepo.save(applicantPostgres);
        return applicant;
    }

    @Override
    public List<Applicant> getAll() {
        return postgresRepo.findAll().stream().map(applicantPostgres ->
                Applicant
                        .builder()
                        .name(applicantPostgres.getName())
                        .phoneNumber(applicantPostgres.getPhoneNumber())
                        .processId(applicantPostgres.getProcessId())
                        .build()
        ).collect(Collectors.toList());
    }
}
