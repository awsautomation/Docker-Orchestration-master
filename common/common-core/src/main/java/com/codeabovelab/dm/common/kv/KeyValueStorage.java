

package com.codeabovelab.dm.common.kv;

import com.codeabovelab.dm.common.mb.ConditionalSubscriptions;

import java.util.List;
import java.util.Map;

/**
 * key-value store for shared configuration and service discovery
 */
public interface KeyValueStorage {

    /**
     * Get the value of a key.
     * @param key the key
     * @return the node with corresponding value or null when not found value
     */
    KvNode get(String key);

    /**
     * Setting the value of a key
     * @param key the key
     * @param value the value
     * @return node
     */
    default KvNode set(String key, String value) {
        return set(key, value, null);
    }

    /**
     * Setting the value of a key with options
     * @param key the key
     * @param value the value
     * @param ops ops or null
     * @return node
     */
    KvNode set(String key, String value, WriteOptions ops);

    /**
     * Make or update directory at specified key.
     * @param key
     * @param ops ops or null
     * @throws Exception
     * @return node
     */
    KvNode setdir(String key, WriteOptions ops);

    /**
     * Delete directory
     * @param key
     * @param ops
     * @throws Exception
     * @return node
     */
    KvNode deletedir(String key, DeleteDirOptions ops);


    /**
     * Delete a key
     * @param key the key
     * @param ops ops or null
     * @return node
     */
    KvNode delete(String key, WriteOptions ops);

    /**
     * List keys of specified prefix
     * @param key
     * @return list or null if key is absent
     */
    List<String> list(String key);

    /**
     * Retrieve map of keys and its values from specified prefix.
     * @param key
     * @return map or null if key is absent
     */
    Map<String, String> map(String key);

    /**
     * Subscriptions for key value events of this storage. <p/>
     * Note that subscription may be on '/key' - or on key with its childs '/key*' (also '/key/*')
     * @return
     */
    ConditionalSubscriptions<KvStorageEvent, String> subscriptions();

    String getPrefix();
}
