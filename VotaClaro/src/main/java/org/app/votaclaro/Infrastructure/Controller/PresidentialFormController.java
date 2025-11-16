package org.app.votaclaro.Infrastructure.Controller;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Input.PresidentialFormUseCase.CreatePresidentialFormUseCase;
import org.app.votaclaro.Http.Request.PresidentialFormRequest;
import org.app.votaclaro.Http.Response.PresidentialFormResponse;
import org.app.votaclaro.Utils.SuccessMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/presidentialForm")
@RequiredArgsConstructor
public class PresidentialFormController {
    private final CreatePresidentialFormUseCase createPresidentialFormUseCase;

    @PostMapping("/add")
    public ResponseEntity<SuccessMessage<PresidentialFormResponse>> createPresidentialForm(
            @RequestBody PresidentialFormRequest presidentialFormRequest
    ) {

        PresidentialFormResponse response =
                createPresidentialFormUseCase.createPresidentialForm(presidentialFormRequest);

        SuccessMessage<PresidentialFormResponse> success =
                SuccessMessage.<PresidentialFormResponse>builder()
                        .message("Presidential form created successfully")
                        .status(HttpStatus.CREATED.value())
                        .body(response)
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(success);
    }
}
