package org.app.votaclaro.Infrastructure.Controller;

import lombok.RequiredArgsConstructor;

import org.app.votaclaro.Application.Service.PolicyPlanService;
import org.app.votaclaro.Http.Request.PolicyPlanRequest;
import org.app.votaclaro.Http.Response.PolicyPlanResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.app.votaclaro.Utils.SuccessMessage;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/policyPlan")
@RequiredArgsConstructor
public class PolicyPlanController {

    private final PolicyPlanService policyPlanService;

    @PostMapping("/add")
    public ResponseEntity<SuccessMessage<PolicyPlanResponse>> createPolicyPlan(
            @RequestPart("policyPlanRequest") PolicyPlanRequest policyPlanRequest,
            @RequestPart("urlPdf") MultipartFile urlPdf
    ) throws Exception {

        PolicyPlanResponse response =
                policyPlanService.createPolicyPlan(policyPlanRequest, urlPdf);

        SuccessMessage<PolicyPlanResponse> success = SuccessMessage.<PolicyPlanResponse>builder()
                .message("Policy plan created successfully")
                .status(HttpStatus.CREATED.value())
                .body(response)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(success);
    }

}
