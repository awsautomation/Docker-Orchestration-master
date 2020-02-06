

package com.codeabovelab.dm.common.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;

import java.beans.ConstructorProperties;
import java.util.Objects;

/**
 * implementation of granted authority with tenant support
 *
 */
public class GrantedAuthorityImpl implements TenantGrantedAuthority {
    private final String tenantId;
    private final String authority;

    @JsonCreator
    @ConstructorProperties({"authority", "tenantId"})
    public GrantedAuthorityImpl(@JsonProperty("authority") String authority,
                                @JsonProperty("tenant") String tenant) {
        this.tenantId = tenant;
        this.authority = authority;
    }

    @Override
    public String getTenant() {
        return tenantId;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    @JsonIgnore
    @Override
    public String getAttribute() {
        return authority;
    }

    @Override
    public String toString() {
        return "GrantedAuthorityImpl{" + "tenantId=" + tenantId + ", authority='" + authority + '\'' + '}';
    }

    /**
     * create instance with data from specified authority
     * @param authority
     * @return
     */
    public static GrantedAuthorityImpl from(GrantedAuthority authority) {
        return new GrantedAuthorityImpl(authority.getAuthority(), MultiTenancySupport.getTenant(authority));
    }

    public static GrantedAuthority convert(GrantedAuthority authority) {
        if(authority instanceof GrantedAuthorityImpl) {
            return authority;
        }
        return from(authority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantedAuthorityImpl that = (GrantedAuthorityImpl) o;
        return Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId, authority);
    }
}
