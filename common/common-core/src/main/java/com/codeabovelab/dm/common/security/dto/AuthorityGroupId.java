

package com.codeabovelab.dm.common.security.dto;

import com.codeabovelab.dm.common.security.OwnedByTenant;

/**
 * Object which identity authority group.
 */
public interface AuthorityGroupId extends OwnedByTenant {
    String getName();

}
