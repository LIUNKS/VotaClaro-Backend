package org.app.votaclaro.Infrastructure.Controller;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Service.NomineeService;
import org.app.votaclaro.Http.Request.NomineeRequest;
import org.app.votaclaro.Http.Response.NomineeResponse;
import org.app.votaclaro.Utils.SuccessMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nominee")
@RequiredArgsConstructor
public class NomineeController {
    private final NomineeService nomineeService;
    @PostMapping("/add")
    public ResponseEntity<SuccessMessage<NomineeResponse>> createNominee(
            @RequestBody NomineeRequest nomineeRequest
    ) throws Exception {
        NomineeResponse response = nomineeService.createNominee(nomineeRequest);
        SuccessMessage<NomineeResponse> success = SuccessMessage.<NomineeResponse>builder()
                .message("Nominee created successfully")
                .status(HttpStatus.CREATED.value())
                .body(response)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(success);
    }
}
