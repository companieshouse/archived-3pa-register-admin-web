package uk.gov.companieshouse.tpa.register.admin.web.model;

import org.mapstruct.Mapper;
import uk.gov.companieshouse.api.model.roe3pa.ThirdPartyAgentDTO;

@Mapper(componentModel = "spring")
public interface TpaMapper {

    ThirdPartyAgentDTO detailsToDto(TpaDetails details);
}
