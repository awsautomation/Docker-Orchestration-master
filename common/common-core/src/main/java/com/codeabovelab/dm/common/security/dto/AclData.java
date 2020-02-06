

package com.codeabovelab.dm.common.security.dto;

import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Sid;

import java.io.Serializable;
import java.util.List;

/**
 * common ACL DTO iface <p/>
 * TODO add version info for CAS-like resolving of concurrent  modification problem <p/>
 */
public interface AclData extends Serializable {
    Long getId();
    List<AceData> getEntries();
    ObjectIdentity getObjectIdentity();
    Sid getOwner();
    AclData getParentAclData();
    boolean isEntriesInheriting();

}
