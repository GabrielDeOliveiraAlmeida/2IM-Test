package com.example.api2im.domain.contracts.to;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProcessStatus {
    private String id;
    private boolean ended;
    private boolean suspended;
}
