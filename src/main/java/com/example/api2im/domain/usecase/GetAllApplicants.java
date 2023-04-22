package com.example.api2im.domain.usecase;

import com.example.api2im.domain.contracts.entities.Applicant;
import com.example.api2im.domain.contracts.entities.ApplicantProcess;
import com.example.api2im.domain.contracts.in.ApplicantForm;
import com.example.api2im.domain.contracts.repos.ApplicantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllApplicants {

    @Autowired
    ApplicantRepo applicantRepo;

    public List<Applicant> perform() {
        return applicantRepo.getAll();
    }
}
