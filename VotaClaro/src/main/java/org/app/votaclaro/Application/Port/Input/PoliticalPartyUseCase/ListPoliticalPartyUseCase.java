package org.app.votaclaro.Application.Port.Input.PoliticalPartyUseCase;

import org.app.votaclaro.Http.Response.PoliticalPartyItem;

import java.util.List;

public interface ListPoliticalPartyUseCase {
    List<PoliticalPartyItem> getList();
}
