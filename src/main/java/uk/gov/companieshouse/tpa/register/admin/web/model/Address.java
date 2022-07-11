package uk.gov.companieshouse.tpa.register.admin.web.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class Address {

    private String premise;
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String county;
    private String country;
    private String postcode;

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Address address = (Address) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder().append(getPremise(), address.getPremise())
                .append(getAddressLine1(), address.getAddressLine1())
                .append(getAddressLine2(), address.getAddressLine2()).append(getTown(), address.getTown())
                .append(getCounty(), address.getCounty()).append(getCountry(), address.getCountry())
                .append(getPostcode(), address.getPostcode()).isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37).append(getPremise())
                .append(getAddressLine1()).append(getAddressLine2()).append(getTown()).append(getCounty())
                .append(getCountry()).append(getPostcode()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("premise", premise)
                .append("addressLine1", addressLine1).append("addressLine2", addressLine2).append("town", town)
                .append("county", county).append("country", country).append("postcode", postcode).toString();
    }
}
