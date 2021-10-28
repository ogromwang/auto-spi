package com.ogrom.starter.spi.config;


/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @author ogrom
 * @version 1.8.0
 * @date 2021.02.26 17:47
 * @since 1.8.0
 */
public class SystemConfiguration extends AbstractPrefixConfiguration {

    /**
     * System configuration
     *
     * @param prefix prefix
     * @param id     id
     * @since 1.8.0
     */
    public SystemConfiguration(String prefix, String id) {
        super(prefix, id);
    }

    /**
     * System configuration
     *
     * @since 1.8.0
     */
    public SystemConfiguration() {
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
        return System.getProperty(key);
    }

}
