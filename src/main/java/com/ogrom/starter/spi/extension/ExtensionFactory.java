package com.ogrom.starter.spi.extension;

/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @author ogrom
 * @version 1.8.0
 * @date 2021.02.26 17:47
 * @since 1.8.0
 */
@SPI
public interface ExtensionFactory {

    /**
     * Gets extension *
     *
     * @param <T>  parameter
     * @param type type
     * @param name name
     * @return the extension
     * @since 1.8.0
     */
    <T> T getExtension(Class<T> type, String name);

}
