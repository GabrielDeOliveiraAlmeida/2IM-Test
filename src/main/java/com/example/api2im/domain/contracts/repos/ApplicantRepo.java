package com.example.api2im.domain.contracts.repos;

import com.example.api2im.domain.contracts.entities.Applicant;

import java.util.List;

public interface ApplicantRepo {
    public Applicant save(Applicant applicant);

    List<Applicant> getAll();
}
