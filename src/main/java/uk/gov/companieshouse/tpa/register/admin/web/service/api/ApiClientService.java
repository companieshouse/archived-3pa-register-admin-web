package uk.gov.companieshouse.tpa.register.admin.web.service.api;

import uk.gov.companieshouse.api.InternalApiClient;
import uk.gov.companieshouse.api.model.ApiResponse;
import uk.gov.companieshouse.api.model.roe3pa.ThirdPartyAgentDTO;

public interface ApiClientService {

    InternalApiClient getApiClient();


    ApiResponse<ThirdPartyAgentDTO> createTpa(ThirdPartyAgentDTO dto);

}
