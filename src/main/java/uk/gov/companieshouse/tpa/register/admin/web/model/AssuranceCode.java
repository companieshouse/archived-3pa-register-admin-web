package uk.gov.companieshouse.tpa.register.admin.web.model;

import java.time.Instant;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class AssuranceCode {

    private String assuranceCode;
    private Instant startDate;
    private Instant endDate;

    public String getAssuranceCode() {
        return assuranceCode;
    }

    public void setAssuranceCode(String assuranceCode) {
        this.assuranceCode = assuranceCode;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AssuranceCode that = (AssuranceCode) o;

        return new EqualsBuilder().append(getAssuranceCode(), that.getAssuranceCode())
                .append(getStartDate(), that.getStartDate()).append(getEndDate(), that.getEndDate()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getAssuranceCode()).append(getStartDate()).append(getEndDate())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("assuranceCode", assuranceCode)
                .append("startDate", startDate).append("endDate", endDate).toString();
    }
}
