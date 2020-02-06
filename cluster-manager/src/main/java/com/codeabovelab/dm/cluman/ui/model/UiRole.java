

package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.common.security.MultiTenancySupport;
import com.codeabovelab.dm.common.utils.Comparables;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotNull;

/**
 */
@Data
public class UiRole implements Comparable<UiRole> {
    @NotNull
    private String name;
    private String tenant;

    public static UiRole fromAuthority(GrantedAuthority authority) {
        UiRole g = new UiRole();
        g.setName(authority.getAuthority());
        g.setTenant(MultiTenancySupport.getTenant(authority));
        return g;
    }

    @Override
    public int compareTo(UiRole o) {
        int compare = Comparables.compare(this.tenant, o.tenant);
        if(compare == 0) {
            compare = Comparables.compare(this.name, o.name);
        }
        return compare;
    }
}
