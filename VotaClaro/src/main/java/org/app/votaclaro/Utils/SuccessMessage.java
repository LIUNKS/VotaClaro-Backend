package org.app.votaclaro.Utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SuccessMessage <T>{
    @Builder.Default
    private Boolean isError = Boolean.FALSE;
    private String message;
    private int status;
    private T body;
}
