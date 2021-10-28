package com.ogrom.starter.spi.support;

import com.ogrom.starter.spi.extension.SPILoader;
import com.ogrom.starter.spi.extension.factory.SpringExtensionFactory;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> </p>
 * <p>Description: loader </p>
 *
 * @author ogrom
 * @version 1.0.0
 * @date 2021.02.25 13:50
 * @since 1.0.0
 */
@Slf4j
@Component
public class SpiFactoriesLoader implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    /**
     * Initialize
     *
     * @param configurableApplicationContext configurable application context
     * @since 1.0.0
     */
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        log.debug("初始化 SpiFactoriesLoader :{}", configurableApplicationContext);
        SpringExtensionFactory.addApplicationContext(configurableApplicationContext);
    }

    /**
     * Shovel
     *
     * @param <D>      parameter
     * @param clazz    clazz
     * @param strategy strategy
     * @return the d
     * @since 1.0.0
     */
    public static <D> D shovel(Class<D> clazz, String strategy) {
        SPILoader<D> extensionLoader = SPILoader.getExtensionLoader(clazz);
        return extensionLoader.getExtension(StringUtils.isBlank(strategy) ? "true" : strategy);
    }

}
