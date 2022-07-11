package uk.gov.companieshouse.tpa.register.admin.web.controller;

import javax.servlet.ServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;
import uk.gov.companieshouse.tpa.register.admin.web.model.TpaDetails;

public interface TpaDetailsController {

    String getViewName();

    TpaDetails getTpaDetailsAttribute();


    String newTpa(@ModelAttribute TpaDetails tpaDetails, Model model, ServletRequest servletRequest, SessionStatus sessionStatus);

}
