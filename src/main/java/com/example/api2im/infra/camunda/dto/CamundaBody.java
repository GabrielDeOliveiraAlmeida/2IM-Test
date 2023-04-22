package com.example.api2im.infra.camunda.dto;

import com.example.api2im.infra.camunda.dto.CamundaVariableType;
import lombok.Builder;
import lombok.Setter;

import java.util.Map;

@Setter
@Builder
public class CamundaBody {
    Map<String, CamundaVariableType> variables;
}
