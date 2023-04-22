package com.example.api2im.infra.camunda;

import com.example.api2im.domain.contracts.entities.Applicant;
import com.example.api2im.domain.contracts.entities.ApplicantProcess;
import com.example.api2im.domain.contracts.to.ProcessStatus;
import com.example.api2im.infra.camunda.dto.CamundaProcessResponse;
import com.example.api2im.infra.camunda.dto.CamundaStatusProcessResponse;
import com.example.api2im.infra.camunda.dto.CamundaVariableType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;


@Service
public class CamundaAdapter {
    @Value("${camunda.url}")
    private String url;

    public ApplicantProcess startProcess(Applicant applicant) {
        var webClient= WebClient
                .builder()
                .baseUrl(url)
                .build();
        var body = BodyInserters
                .fromValue(this.generateBody(applicant));
        CamundaProcessResponse processDefinitionDto = webClient
                .post()
                .uri(uriBuilder -> uriBuilder
                        .path("/engine-rest/process-definition/key/ProcessoSeletivo/start")
                        .build()
                )
                .body(body)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CamundaProcessResponse.class)
                .blockLast();
        return ApplicantProcess.builder().id(processDefinitionDto.getId()).build();
    }

    public ProcessStatus getStatusProcess(String processId) {
        var webClient= WebClient
                .builder()
                .baseUrl(url)
                .build();
        CamundaStatusProcessResponse processDefinitionDto = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("engine-rest/process-instance/")
                        .path(processId)
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CamundaStatusProcessResponse.class)
                .blockLast();
        return ProcessStatus.builder()
                .id(processDefinitionDto.getId())
                .ended(processDefinitionDto.isEnded())
                .suspended(processDefinitionDto.isSuspended())
                .build();
    }

    private Map<String, Map<String, CamundaVariableType>> generateBody(Applicant applicant) {
        Map<String, CamundaVariableType> variables = new HashMap<>();
        variables.put("name", new CamundaVariableType(applicant.getName(), "String"));
        variables.put("phoneNumber", new CamundaVariableType(applicant.getPhoneNumber(), "String"));
        variables.put("frontEndExperience", new CamundaVariableType(applicant.getFrontEndExperience().toString(), "String"));
        variables.put("backEndExperience", new CamundaVariableType(applicant.getBackEndExperience().toString(), "String"));
        variables.put("dataBaseExperience", new CamundaVariableType(applicant.getDataBaseExperience().toString(), "String"));
        variables.put("camundaExperience", new CamundaVariableType(applicant.getCamundaExperience().toString(), "String"));
        variables.put("healthAreaExperience", new CamundaVariableType(applicant.getHealthAreaExperience().toString(), "String"));
        variables.put("yearsOfExperienceFrontEnd", new CamundaVariableType(applicant.getYearsOfExperienceFrontEnd().toString(), "Long"));
        variables.put("yearsOfExperienceBackEnd", new CamundaVariableType(applicant.getYearsOfExperienceBackEnd().toString(), "Long"));
        variables.put("yearsOfExperienceDatabase", new CamundaVariableType(applicant.getYearsOfExperienceDatabase().toString(), "Long"));
        Map<String, Map<String, CamundaVariableType>> bodyMap = new HashMap();
        bodyMap.put("variables", variables);
        return bodyMap;
    }
}

