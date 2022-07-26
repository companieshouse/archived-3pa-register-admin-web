package uk.gov.companieshouse.tpa.register.admin.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import uk.gov.companieshouse.api.model.ApiResponse;
import uk.gov.companieshouse.api.model.roe3pa.ThirdPartyAgentDTO;
import uk.gov.companieshouse.logging.Logger;
import uk.gov.companieshouse.tpa.register.admin.web.model.TpaDetails;
import uk.gov.companieshouse.tpa.register.admin.web.model.TpaMapper;
import uk.gov.companieshouse.tpa.register.admin.web.service.api.ApiClientService;

@Controller
@RequestMapping("/third-party-agencies")
public class TpaDetailsControllerImpl implements TpaDetailsController {
    public static final String ATTRIBUTE_NAME = "tpaDetails";

    private final Logger logger;
    private TpaDetails tpaDetails;
    private ApiClientService apiClientService;
    private TpaMapper tpaMapper;

    @Override
    public String getViewName() {
        return ViewConstants.NEW.asView();
    }

    @Override
    @ModelAttribute(ATTRIBUTE_NAME)
    public TpaDetails getTpaDetailsAttribute() {
        if (tpaDetails == null) {
            tpaDetails = new TpaDetails();
        }
        return tpaDetails;
    }

    @Autowired
    public TpaDetailsControllerImpl(final ApiClientService apiClientService, final TpaMapper tpaMapper, final Logger logger) {
        this.apiClientService = apiClientService;
        this.tpaMapper = tpaMapper;
        this.logger = logger;
    }

    @GetMapping("/new")
    public String newTpa(@ModelAttribute(ATTRIBUTE_NAME) TpaDetails tpaDetails, Model model,
            ServletRequest servletRequest, SessionStatus sessionStatus) {
        return getViewName();
    }

    @PostMapping("/new")
    public String submitTpaDetails(@ModelAttribute(ATTRIBUTE_NAME) TpaDetails request,
            BindingResult bindingResult, Model model, HttpServletRequest servletRequest) {
        Map<String, Object> map = new HashMap<>(model.asMap());
        logger.info("SUBMITTED", map);

        ThirdPartyAgentDTO dto = tpaMapper.detailsToDto((TpaDetails) model.getAttribute(ATTRIBUTE_NAME));
        logger.info(dto.toString());

         ApiResponse<ThirdPartyAgentDTO> response = apiClientService.createTpa(dto);
        map = new HashMap<>();
        map.put("response", response);
        logger.info("response", map);

        return ViewConstants.SUBMITTED.asView();
    }

}
