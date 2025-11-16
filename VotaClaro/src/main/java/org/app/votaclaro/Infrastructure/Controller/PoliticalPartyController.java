package org.app.votaclaro.Infrastructure.Controller;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Service.PoliticalPartyService;
import org.app.votaclaro.Http.Request.PoliticalPartyRequest;
import org.app.votaclaro.Http.Response.PoliticalPartyResponse;
import org.app.votaclaro.Utils.SuccessMessage;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/politicalParty")
@RequiredArgsConstructor
public class PoliticalPartyController {

    private final PoliticalPartyService politicalPartyService;

    @PostMapping("/add")
    public ResponseEntity<SuccessMessage<PoliticalPartyResponse>> createPoliticalParty(
            @RequestPart("politicalPartyRequest") PoliticalPartyRequest politicalPartyRequest,
            @RequestPart("urlLogo") MultipartFile urlLogo,
            @RequestPart("urlListMembers") MultipartFile urlListMembers
    ) throws Exception {

        PoliticalPartyResponse response =
                politicalPartyService.createPoliticalParty(politicalPartyRequest, urlLogo, urlListMembers);

        SuccessMessage<PoliticalPartyResponse> success = SuccessMessage.<PoliticalPartyResponse>builder()
                .message("Political party created successfully")
                .status(HttpStatus.CREATED.value())
                .body(response)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(success);
    }

    /**
     *     @PostMapping
     *     public ResponseEntity<SuccessMessage<MovieResponse>> EndPointSave(
     *             @RequestPart MovieRequest movieRequest,
     *             @RequestPart MultipartFile urlImgFile
     *             ) throws Exception {
     *         MovieResponse movieResponse = createMovieUseCase.createMovie(movieRequest,urlImgFile);
     *         SuccessMessage<MovieResponse>successMessage=SuccessMessage.<MovieResponse>builder()
     *                 .statusCode(HttpStatus.CREATED.value())
     *                 .message("Se guardo correctamente el movie")
     *                 .Body(movieResponse)
     *                 .build();
     *         return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
     *     }
     */

}
