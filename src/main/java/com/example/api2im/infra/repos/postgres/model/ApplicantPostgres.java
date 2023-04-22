package com.example.api2im.infra.repos.postgres.model;

import com.example.api2im.domain.type.ExperienceType;
import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@Table(name = "candidato")
public class ApplicantPostgres {
    @Id
    private String id;

    @Column(name = "nome")
    private String name;
    //
    @Column(name = "telefone")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "front_end_experiencia")
    private ExperienceType frontEndExperience;

    @Enumerated(EnumType.STRING)
    @Column(name = "back_end_experiencia")
    private ExperienceType backEndExperience;

    @Enumerated(EnumType.STRING)
    @Column(name = "banco_experiencia")
    private ExperienceType dataBaseExperience;

    @Enumerated(EnumType.STRING)
    @Column(name = "camunda_experiencia")
    private ExperienceType camundaExperience;

    @Enumerated(EnumType.STRING)
    @Column(name = "saude_experiencia")
    private ExperienceType healthAreaExperience;

    @Column(name = "front_end_anos_experiencia")
    private Long yearsOfExperienceFrontEnd;

    @Column(name = "back_end_anos_experiencia")
    private Long yearsOfExperienceBackEnd;

    @Column(name = "banco_anos_experiencia")
    private Long yearsOfExperienceDatabase;

    @Column(name = "processo_seletivo_id")
    private String processId;

    @Column(name = "informacao_adicional")
    private String additionalInformation;
}

