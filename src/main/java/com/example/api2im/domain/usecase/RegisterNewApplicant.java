package com.example.api2im.domain.usecase;

import com.example.api2im.domain.contracts.entities.ApplicantProcess;
import com.example.api2im.domain.contracts.in.ApplicantForm;
import com.example.api2im.domain.contracts.entities.Applicant;
import com.example.api2im.domain.contracts.repos.ApplicantRepo;
import com.example.api2im.infra.camunda.CamundaAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewApplicant {
    @Autowired
    ApplicantRepo applicantRepo;

    @Autowired
    CamundaAdapter camundaAdapter;

    public Applicant perform(ApplicantForm applicantForm) {
        Applicant applicant = applicantForm.toModel();
        ApplicantProcess applicantProcess = camundaAdapter.startProcess(applicant);
        applicant.setProcessId(applicantProcess.getId());
        applicantRepo.save(applicant);
        return applicant;
    }

}
