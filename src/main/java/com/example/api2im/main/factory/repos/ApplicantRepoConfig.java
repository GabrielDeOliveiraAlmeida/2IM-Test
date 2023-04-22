package com.example.api2im.main.factory.repos;

import com.example.api2im.domain.contracts.repos.ApplicantRepo;
import com.example.api2im.infra.repos.postgres.Postgres;
import org.springframework.context.annotation.Bean;

public class ApplicantRepoConfig {

    @Bean
    ApplicantRepo applicantRepo(ApplicantRepo applicantRepo) { return new Postgres(); }
}
