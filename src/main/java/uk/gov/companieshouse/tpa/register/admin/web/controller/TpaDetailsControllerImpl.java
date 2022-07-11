package uk.gov.companieshouse.tpa.register.admin.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import uk.gov.companieshouse.logging.Logger;
import uk.gov.companieshouse.tpa.register.admin.web.model.TpaDetails;

@Controller
@RequestMapping("/third-party-agencies")
public class TpaDetailsControllerImpl implements TpaDetailsController {
    public static final String ATTRIBUTE_NAME = "tpaDetails";

    private final Logger logger;
    private TpaDetails tpaDetails;

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
    public TpaDetailsControllerImpl(final Logger logger) {
        this.logger = logger;
    }

    @GetMapping("/new")
    public String newTpa(@ModelAttribute(ATTRIBUTE_NAME) TpaDetails tpaDetails, Model model,
            ServletRequest servletRequest, SessionStatus sessionStatus) {
        return getViewName();
    }

    @PostMapping("/new")
    public String submitTpaDetails(@ModelAttribute(ATTRIBUTE_NAME) TpaDetails request,
            BindingResult bindingResult, Model model, ServletRequest servletRequest) {
        Map<String, Object> map = new HashMap<>(model.asMap());
        logger.info("SUBMITTED", map);
        return ViewConstants.SUBMITTED.asView();
    }

}
