

package com.codeabovelab.dm.common.gateway;

import com.codeabovelab.dm.common.utils.Key;
import com.codeabovelab.dm.common.security.dto.AuthenticationData;

/**
 * Common keys for some connections attributes
 */
public interface ConnectionAttributeKeys {
    /**
     * Connection credentials, may be null.
     */
    Key<AuthenticationData> KEY_AUTHENTICATION = new Key<>("dm.auth", AuthenticationData.class);
}
