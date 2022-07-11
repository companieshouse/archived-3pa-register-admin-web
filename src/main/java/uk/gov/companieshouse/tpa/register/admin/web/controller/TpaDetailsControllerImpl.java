package uk.gov.companieshouse.tpa.register.admin.web.controller;

import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import uk.gov.companieshouse.tpa.register.admin.web.model.TpaDetails;

@Controller
@RequestMapping("/third-party-agencies")
public class TpaDetailsControllerImpl implements TpaDetailsController{

    private TpaDetails tpaDetails;

    @Override
    public String getViewName() {
        return ViewConstants.NEW.asView();
    }


    @Override
    @ModelAttribute("tpaDetails")
    public TpaDetails getTpaDetailsAttribute() {
        if (tpaDetails == null) {
            tpaDetails = new TpaDetails();
        }
        return tpaDetails;
    }

    public TpaDetailsControllerImpl() {
    }

    @GetMapping("/new")
    public String newTpa(@ModelAttribute("tpaDetails") TpaDetails tpaDetails, Model model, ServletRequest servletRequest, SessionStatus sessionStatus ) {
        return getViewName();
    }

    @PostMapping("/new")
    public String submitTpaDetails(@ModelAttribute("applyingAs") TpaDetails request, BindingResult bindingResult, Model model,
                                   ServletRequest servletRequest) {
        return ViewConstants.SUBMITTED.asView();
    }

}
