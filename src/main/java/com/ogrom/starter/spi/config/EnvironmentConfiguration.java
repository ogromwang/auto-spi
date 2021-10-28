package com.ogrom.starter.spi.config;


import com.ogrom.starter.spi.utils.SpiStringUtils;

/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @author ogrom
 * @version 1.8.0
 * @date 2021.02.26 17:47
 * @since 1.8.0
 */
public class EnvironmentConfiguration extends AbstractPrefixConfiguration {

    /**
     * Environment configuration
     *
     * @param prefix prefix
     * @param id     id
     * @since 1.8.0
     */
    public EnvironmentConfiguration(String prefix, String id) {
        super(prefix, id);
    }

    /**
     * Environment configuration
     *
     * @since 1.8.0
     */
    public EnvironmentConfiguration() {
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
        String value = System.getenv(key);
        if (SpiStringUtils.isEmpty(value)) {
            value = System.getenv(SpiStringUtils.toOSStyleKey(key));
        }
        return value;
    }

}
