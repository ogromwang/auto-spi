package com.ogrom.starter.spi.config;


import com.ogrom.starter.spi.utils.SpiStringUtils;

import lombok.experimental.UtilityClass;
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
@UtilityClass
public class ConfigurationUtils {
    /**
     * Gets property *
     *
     * @param property property
     * @return the property
     * @since 1.8.0
     */
    public static String getProperty(String property) {
        return getProperty(property, null);
    }

    /**
     * Gets property *
     *
     * @param property     property
     * @param defaultValue default value
     * @return the property
     * @since 1.8.0
     */
    public static String getProperty(String property, String defaultValue) {
        return SpiStringUtils.trim(Environment.getInstance().getConfiguration().getString(property, defaultValue));
    }
}
