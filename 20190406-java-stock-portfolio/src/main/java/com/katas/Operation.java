package com.katas;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class Operation {
    private final String companyName;
    private final int amountShares;

    public Operation(String companyName, int amountShares) {
        this.companyName = companyName;
        this.amountShares = amountShares;
    }

    @Override
    public boolean equals(Object other) {
        return reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }
}
