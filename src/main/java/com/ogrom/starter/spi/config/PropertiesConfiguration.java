package com.ogrom.starter.spi.config;


import com.ogrom.starter.spi.utils.ConfigUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @author ogrom
 * @version 1.8.0
 * @date 2021.02.26 17:47
 * @since 1.8.0
 */
@Slf4j
public class PropertiesConfiguration extends AbstractPrefixConfiguration {

    /**
     * Properties configuration
     *
     * @param prefix prefix
     * @param id     id
     * @since 1.8.0
     */
    public PropertiesConfiguration(String prefix, String id) {
        super(prefix, id);
    }

    /**
     * Properties configuration
     *
     * @since 1.8.0
     */
    public PropertiesConfiguration() {
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
        return ConfigUtils.getProperty(key);
    }
}
