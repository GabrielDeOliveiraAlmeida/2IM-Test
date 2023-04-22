package com.example.api2im.domain.usecase;

import com.example.api2im.domain.contracts.to.ProcessStatus;
import com.example.api2im.infra.camunda.CamundaAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetStatusApplicant {

    @Autowired
    CamundaAdapter camundaAdapter;

    public ProcessStatus perform(String processId) {
        return camundaAdapter.getStatusProcess(processId);
    }
}
