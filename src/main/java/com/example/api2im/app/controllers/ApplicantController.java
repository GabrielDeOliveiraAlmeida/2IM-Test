package com.example.api2im.app.controllers;

import com.example.api2im.app.in.ApplicantFormIn;
import com.example.api2im.domain.contracts.entities.Applicant;
import com.example.api2im.domain.contracts.to.ProcessStatus;
import com.example.api2im.domain.usecase.GetAllApplicants;
import com.example.api2im.domain.usecase.GetStatusApplicant;
import com.example.api2im.domain.usecase.RegisterNewApplicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/applicant")
public class ApplicantController {

    @Autowired
    RegisterNewApplicant registerNewApplicant;

    @Autowired
    GetStatusApplicant getStatusApplicant;

    @Autowired
    GetAllApplicants getAllApplicants;

    @PostMapping
    public ResponseEntity<String> registerNewApplicant(@RequestBody ApplicantFormIn applicant) {
        Applicant applicant1 = registerNewApplicant.perform(applicant);
        return ResponseEntity.ok().body(applicant1.getProcessId());
    }

    @GetMapping("/{processId}")
    public ResponseEntity<ProcessStatus> getStatusApplicant(@PathVariable String processId) {
        ProcessStatus processStatus = getStatusApplicant.perform(processId);
        return ResponseEntity.ok().body(processStatus);
    }

    @GetMapping
    public ResponseEntity<List<Applicant>> getAllApplicant() {
        List<Applicant> applicants = getAllApplicants.perform();
        return ResponseEntity.ok().body(applicants);
    }
}
