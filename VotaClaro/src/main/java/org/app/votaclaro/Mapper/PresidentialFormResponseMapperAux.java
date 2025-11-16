package org.app.votaclaro.Mapper;


import org.app.votaclaro.Domain.Model.PresidentialForm;
import org.app.votaclaro.Http.Response.PresidentialFormResponse;
import org.app.votaclaro.Infrastructure.DB.Entity.PresidentialFormEntity;

public class PresidentialFormResponseMapperAux {
    public static PresidentialForm presidentialFormToPresidentialFormEntity(PresidentialFormEntity presidentialFormEntity){
        return new PresidentialForm(presidentialFormEntity.getId(),presidentialFormEntity.getCount(),presidentialFormEntity.getIsFull(),null);
    };

    public static PresidentialFormResponse presidentialFormToPresidentialFormResponse(PresidentialForm presidentialForm){
        return new PresidentialFormResponse(presidentialForm.getId(),presidentialForm.getCount(),presidentialForm.getFull(),presidentialForm.getPoliticalParty().getId());
    }

}
