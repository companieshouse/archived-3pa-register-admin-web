package uk.gov.companieshouse.tpa.register.admin.web.model;

import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class TpaDetails {

    private String agentName;
    private String contactName;
    private String email;
    private Address address;
    private String supervisoryBody;
    private String amlRegistrationNumber;
    private String responsiblePersonName;
    private List<AssuranceCode> codes;

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSupervisoryBody() {
        return supervisoryBody;
    }

    public void setSupervisoryBody(String supervisoryBody) {
        this.supervisoryBody = supervisoryBody;
    }

    public String getAmlRegistrationNumber() {
        return amlRegistrationNumber;
    }

    public void setAmlRegistrationNumber(String amlRegistrationNumber) {
        this.amlRegistrationNumber = amlRegistrationNumber;
    }

    public String getResponsiblePersonName() {
        return responsiblePersonName;
    }

    public void setResponsiblePersonName(String responsiblePersonName) {
        this.responsiblePersonName = responsiblePersonName;
    }

    public List<AssuranceCode> getCodes() {
        return codes;
    }

    public void setCodes(List<AssuranceCode> codes) {
        this.codes = codes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        TpaDetails that = (TpaDetails) o;

        return new EqualsBuilder().append(getAgentName(), that.getAgentName())
                .append(getContactName(), that.getContactName()).append(getEmail(), that.getEmail())
                .append(getAddress(), that.getAddress()).append(getSupervisoryBody(), that.getSupervisoryBody())
                .append(getAmlRegistrationNumber(), that.getAmlRegistrationNumber())
                .append(getResponsiblePersonName(), that.getResponsiblePersonName()).append(getCodes(), that.getCodes())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getAgentName()).append(getContactName()).append(getEmail())
                .append(getAddress()).append(getSupervisoryBody()).append(getAmlRegistrationNumber())
                .append(getResponsiblePersonName()).append(getCodes()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("agentName", agentName)
                .append("contactName", contactName).append("email", email).append("address", address)
                .append("supervisoryBody", supervisoryBody).append("amlRegistrationNumber", amlRegistrationNumber)
                .append("responsiblePersonName", responsiblePersonName).append("codes", codes).toString();
    }
}
