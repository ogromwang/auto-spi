package com.ogrom.starter.spi.config;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @author ogrom
 * @version 1.8.0
 * @date 2021.02.26 17:47
 * @since 1.8.0
 */
public class InmemoryConfiguration extends AbstractPrefixConfiguration {

    /** Store */
    private Map<String, String> store = new LinkedHashMap<>();

    /**
     * Inmemory configuration
     *
     * @param prefix prefix
     * @param id     id
     * @since 1.8.0
     */
    public InmemoryConfiguration(String prefix, String id) {
        super(prefix, id);
    }

    /**
     * Inmemory configuration
     *
     * @since 1.8.0
     */
    public InmemoryConfiguration() {
        this(null, null);
    }

    /**
     * Gets internal property *
     *
     * @param key key
     * @return the internal property
     * @since 1.8.0
     */
    @Override
    public Object getInternalProperty(String key) {
        return this.store.get(key);
    }

    /**
     * Add property
     *
     * @param key   key
     * @param value value
     * @since 1.8.0
     */
    public void addProperty(String key, String value) {
        this.store.put(key, value);
    }

    /**
     * Add properties
     *
     * @param properties properties
     * @since 1.8.0
     */
    public void addProperties(Map<String, String> properties) {
        if (properties != null) {
            this.store.putAll(properties);
        }
    }

    /**
     * Sets properties *
     *
     * @param properties properties
     * @since 1.8.0
     */
    public void setProperties(Map<String, String> properties) {
        if (properties != null) {
            this.store = properties;
        }
    }
}
