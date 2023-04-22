package com.example.api2im.infra.camunda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
@AllArgsConstructor
public class CamundaVariableType {
    public String value;
    public String type;
}
