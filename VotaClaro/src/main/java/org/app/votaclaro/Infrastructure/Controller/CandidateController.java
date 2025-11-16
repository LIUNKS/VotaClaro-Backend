package org.app.votaclaro.Infrastructure.Controller;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Service.CandidateService;
import org.app.votaclaro.Http.Request.CandidateRequest;
import org.app.votaclaro.Http.Response.CandidateResponse;
import org.app.votaclaro.Utils.SuccessMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping("/add")
    public ResponseEntity<SuccessMessage<CandidateResponse>> createCandidate(
            @RequestPart("candidateRequest") CandidateRequest candidateRequest,
            @RequestPart("urlImgPerson") MultipartFile urlImgPerson
    ) throws Exception {
        CandidateResponse response =
                candidateService.createCandidate(candidateRequest, urlImgPerson);
        SuccessMessage<CandidateResponse> success =
                SuccessMessage.<CandidateResponse>builder()
                        .message("Candidate created successfully")
                        .status(HttpStatus.CREATED.value())
                        .body(response)
                        .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(success);
    }
}
