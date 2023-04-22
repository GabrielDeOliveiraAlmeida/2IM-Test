package com.example.api2im.infra.repos.postgres;

import com.example.api2im.infra.repos.postgres.model.ApplicantPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRepo extends JpaRepository<ApplicantPostgres, String> {}

