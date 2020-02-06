
package com.codeabovelab.dm.common.security.acl;

import com.codeabovelab.dm.common.security.dto.ObjectIdentityData;
import org.junit.Test;

import static org.junit.Assert.*;

public class AclUtilsTest {
    @Test
    public void test() {
        ObjectIdentityData[] oids = {
          new ObjectIdentityData("1", 2),
          new ObjectIdentityData("bs", ""),
          new ObjectIdentityData("bs", "21:32"),
          new ObjectIdentityData("ba", 292029393939L),
        };
        for(ObjectIdentityData oid: oids) {
            System.out.println("OID: " + oid);
            String oidStr = AclUtils.toId(oid);
            System.out.println("OID String: " + oidStr);
            ObjectIdentityData readedOid = AclUtils.fromId(oidStr);
            assertEquals(oid,  readedOid);
        }
        ObjectIdentityData[] badOids = {
          new ObjectIdentityData("b:s", ""),
        };
        for(ObjectIdentityData oid: badOids) {
            System.out.println("OID: " + oid);
            try {
                String oidStr = AclUtils.toId(oid);
                fail("The " + oid + " must not be serialized.");
            } catch (IllegalArgumentException e) {
                // as expected
                System.out.println("Expected fail for: " + oid + " with error: " + e.getMessage());
            }
        }
    }

}