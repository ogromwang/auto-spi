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
@SuppressWarnings("PMD.UndefineMagicConstantRule")
public abstract class AbstractPrefixConfiguration implements Configuration {
    /** Id */
    protected final String id;
    /** Prefix */
    protected final String prefix;

    /**
     * Abstract prefix configuration
     *
     * @param prefix prefix
     * @param id     id
     * @since 1.8.0
     */
    protected AbstractPrefixConfiguration(String prefix, String id) {
        if (SpiStringUtils.isNotEmpty(prefix) && !prefix.endsWith(".")) {
            this.prefix = prefix + ".";
        } else {
            this.prefix = prefix;
        }
        this.id = id;
    }

    /**
     * Gets property *
     *
     * @param key          key
     * @param defaultValue default value
     * @return the property
     * @since 1.8.0
     */
    @Override
    public Object getProperty(String key, Object defaultValue) {
        Object value = null;
        if (SpiStringUtils.isNotEmpty(this.prefix)) {
            if (SpiStringUtils.isNotEmpty(this.id)) {
                value = this.getInternalProperty(this.prefix + this.id + "." + key);
            }
            if (value == null) {
                value = this.getInternalProperty(this.prefix + key);
            }
        } else {
            value = this.getInternalProperty(key);
        }
        return value != null ? value : defaultValue;
    }
}
