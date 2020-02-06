

package com.codeabovelab.dm.common.kv.mapping;

/**
 * Adapter which allow to obtain object for save from source, and verse versa.
 */
public interface KvMapAdapter<T> {

    /**
     * Default adapter implementation.
     */
    KvMapAdapter<Object> DIRECT = new KvMapAdapter<Object>() {
        @Override
        public Object get(String key, Object source) {
            return source;
        }

        @Override
        public Object set(String key, Object source, Object value) {
            return value;
        }
    };

    @SuppressWarnings("unchecked")
    static <T> KvMapAdapter<T> direct() {
        return (KvMapAdapter<T>) DIRECT;
    }

    /**
     * Retrieve object from source for saving.
     * @param source source object, can not be null
     * @return value null is not allowed
     */
    Object get(String key, T source);

    /**
     * Set loaded object to source object.
     * @param source old source object, may be null
     * @param value loaded value, null not allowed.
     * @return new source object, also you can return 'source'
     */
    T set(String key, T source, Object value);

    /**
     * Return default type or value for specified source. Value - the object which is returned by {@link #get(String, Object)}
     * @param source - source object, can be null
     * @return type, can be null
     */
    default Class<?> getType(T source) {
        return null;
    }
}
