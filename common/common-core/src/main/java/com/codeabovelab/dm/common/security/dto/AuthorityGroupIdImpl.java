

package com.codeabovelab.dm.common.security.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 */
public class AuthorityGroupIdImpl implements AuthorityGroupId {
    @NotNull
    private final String name;
    private final String tenant;

    /**
     *
     * @param name
     * @param tenant allow null
     */
    @JsonCreator
    public AuthorityGroupIdImpl(@JsonProperty("name") String name, @JsonProperty("tenant") String tenant) {
        this.name = name;
        this.tenant = tenant;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTenant() {
        return tenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityGroupIdImpl that = (AuthorityGroupIdImpl) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(tenant, that.tenant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tenant);
    }

    @Override
    public String toString() {
        return "AuthorityGroupIdImpl{" +
                "name='" + name + '\'' +
                ", tenantId=" + tenant +
                '}';
    }
}
