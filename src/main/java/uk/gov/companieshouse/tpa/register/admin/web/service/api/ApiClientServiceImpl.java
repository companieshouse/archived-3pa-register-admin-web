package uk.gov.companieshouse.tpa.register.admin.web.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uk.gov.companieshouse.api.InternalApiClient;
import uk.gov.companieshouse.api.http.ApiKeyHttpClient;
import uk.gov.companieshouse.api.http.HttpClient;
import uk.gov.companieshouse.api.model.ApiResponse;
import uk.gov.companieshouse.api.model.roe3pa.ThirdPartyAgentDTO;
import uk.gov.companieshouse.logging.Logger;

@Service
public class ApiClientServiceImpl extends BaseApiClientServiceImpl implements ApiClientService{

    @Value("${internal.api.url}")
    private String internalApiUrl;

    @Value("${api.url}")
    private String apiUrl;

    @Value("${payments.api.url}")
    private String paymentsApiUrl;

    @Value("${chs.internal.api.key}")
    private String chsApiKey;

    @Autowired
    protected ApiClientServiceImpl(Logger logger) {
        super(logger);
    }

    @Override
    public InternalApiClient getApiClient() {

        InternalApiClient internalApiClient = new InternalApiClient(getHttpClient());
        internalApiClient.setBasePath(apiUrl);
        internalApiClient.setInternalBasePath(internalApiUrl);
        internalApiClient.setBasePaymentsPath(paymentsApiUrl);

        return internalApiClient;
    }

    private HttpClient getHttpClient() {

        ApiKeyHttpClient apiKeyHttpClient = new ApiKeyHttpClient(chsApiKey);

        return apiKeyHttpClient;
    }

    @Override
    public ApiResponse<ThirdPartyAgentDTO> createTpa(ThirdPartyAgentDTO dto) {

        return executeOp("createTpa", TPA_URI,
            getApiClient().privateRoe3paResourceHandler().create3pa().create(TPA_URI, dto));
    }
}