package uk.gov.companieshouse.tpa.register.admin.web.controller;

import java.text.MessageFormat;

public enum ViewConstants {
    NEW("new", "newAgent"),
    SUBMITTED("submitted", "submitted"),
    CONFIRMATION("confirmation", "confirmation"),
    ERROR("error/500", "error/500"),
    MISSING("error/404", "error/404"),
    GONE("error/404", "error/404");  // same as 404 for now

    private static final String AGENT = "/third-party-agencies/{0}/";
    private static final String PAGE = AGENT + "{1}";
    private static final String REDIRECT = "redirect:{0}";

    private final String template;
    private final String uri;

    ViewConstants(String uri, String template) {
        this.uri = uri;
        this.template = template;
    }

    /**
     * @return the url of the view to display
     */
    public String asView() {
        return this.template;
    }

    /**
     * @param id the application ID
     * @return the redirect url of the view to display
     */
    public String asAppRedirectUri(final String id) {
        return MessageFormat.format(REDIRECT, asAppUri(id), "redirect:");
    }

    public String asAppUri(final String id) {
        return MessageFormat.format(PAGE, id, this.uri);
    }

    public String asRedirectUri() {
        return MessageFormat.format(REDIRECT, asView(), "redirect:");
    }


}
