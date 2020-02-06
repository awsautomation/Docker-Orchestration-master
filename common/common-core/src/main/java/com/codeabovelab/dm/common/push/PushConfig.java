

package com.codeabovelab.dm.common.push;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 */
public class PushConfig {

    public static class Builder {
        private long ttl;
        private boolean persisted;

        /**
         * Time to live for pushed command.
         * @return
         */
        public long getTtl() {
            return ttl;
        }

        /**
         * Time to live for pushed command.
         * @param ttl
         * @return
         */
        public Builder ttl(long ttl) {
            setTtl(ttl);
            return this;
        }

        /**
         * Time to live for pushed command.
         * @param ttl
         */
        public void setTtl(long ttl) {
            this.ttl = ttl;
        }

        /**
         * Pushed command will be stored in persisted storage, otherwise in runtime storage.
         * @return
         */
        public boolean isPersisted() {
            return persisted;
        }

        /**
         * Pushed command will be stored in persisted storage, otherwise in runtime storage.
         * @param persisted
         * @return
         */
        public Builder persisted(boolean persisted) {
            setPersisted(persisted);
            return this;
        }

        /**
         * Pushed command will be stored in persisted storage, otherwise in runtime storage.
         * @param persisted
         */
        public void setPersisted(boolean persisted) {
            this.persisted = persisted;
        }

        public PushConfig builder() {
            return new PushConfig(this);
        }
    }

    private final long ttl;
    private final boolean persisted;

    @JsonCreator
    public PushConfig(Builder b) {
        this.ttl = b.ttl;
        this.persisted = b.persisted;
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Time to live for pushed command.
     * @return
     */
    public long getTtl() {
        return ttl;
    }

    /**
     * Pushed command will be stored in persisted storage, otherwise in runtime storage.
     * @return
     */
    public boolean isPersisted() {
        return persisted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PushConfig)) {
            return false;
        }

        PushConfig that = (PushConfig) o;

        if (persisted != that.persisted) {
            return false;
        }
        if (ttl != that.ttl) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (ttl ^ (ttl >>> 32));
        result = 31 * result + (persisted ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PushConfig{" +
          "ttl=" + ttl +
          ", persisted=" + persisted +
          '}';
    }
}
