package com.example.api2im.infra.camunda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CamundaProcessResponse {
        protected String id;
        protected String key;
        protected String category;
        protected String description;
        protected String name;
        protected int version;
        protected String resource;
        protected String deploymentId;
        protected String diagram;
        protected boolean suspended;
        protected String tenantId;
        protected String versionTag;
        protected Integer historyTimeToLive;
        protected boolean isStartableInTasklist;
}
