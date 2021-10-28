package com.ogrom.starter.spi.compiler;


import com.ogrom.starter.spi.extension.SPI;

/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @author ogrom
 * @version 1.8.0
 * @date 2021.02.26 17:47
 * @since 1.8.0
 */
@SPI("javassist")
public interface Compiler {

    /**
     * Compile
     *
     * @param code        code
     * @param classLoader class loader
     * @return the class
     * @since 1.8.0
     */
    Class<?> compile(String code, ClassLoader classLoader);

}
