
package com.codeabovelab.dm.common.kv;

import com.codeabovelab.dm.common.utils.ExecutorUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryKeyValueStorageTest {

    @Test
    public void test() {
        InMemoryKeyValueStorage kvs = InMemoryKeyValueStorage.builder()
          .eventsExecutor(ExecutorUtils.DIRECT)
          .build();
        KvStorageEvent[] holder = new KvStorageEvent[1];
        kvs.subscriptions().subscribe(e -> {
            System.out.println(e);
            holder[0] = e;
        });

        kvs.setdir("/root", null);
        kvs.set("/root/23", "23");

        assertEvent(holder, KvStorageEvent.Crud.CREATE, "/root/23", "23");
        kvs.set("/root/23", "231");
        assertEvent(holder, KvStorageEvent.Crud.UPDATE, "/root/23", "231");

        kvs.set("/root/one/two/three", "something");
        kvs.delete("/root/one/two/three", null);
        assertEvent(holder, KvStorageEvent.Crud.DELETE, "/root/one/two/three", "something");
        assertNotNull(kvs.get("/root/one"));
        kvs.deletedir("/root/one", null);
        assertEvent(holder, KvStorageEvent.Crud.DELETE, "/root/one", null);
        assertNull(kvs.get("/root/one"));
    }

    private void assertEvent(KvStorageEvent[] holder, KvStorageEvent.Crud create, String key, String val) {
        KvStorageEvent e = holder[0];
        Assert.assertEquals(create, e.getAction());
        Assert.assertEquals(key, e.getKey());
        Assert.assertEquals(val, e.getValue());
    }
}