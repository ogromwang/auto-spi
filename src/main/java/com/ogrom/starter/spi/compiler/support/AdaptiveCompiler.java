package com.ogrom.starter.spi.compiler.support;

import com.ogrom.starter.spi.compiler.Compiler;
import com.ogrom.starter.spi.extension.Adaptive;
import com.ogrom.starter.spi.extension.SPILoader;

import java.util.Objects;


/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @author ogrom
 * @version 1.8.0
 * @date 2021.02.26 17:47
 * @since 1.8.0
 */
@Adaptive
public class AdaptiveCompiler implements Compiler {

    /** DEFAULT_COMPILER */
    private static volatile String defaultCompiler;

    /**
     * Sets default compiler *
     *
     * @param compiler compiler
     * @since 1.8.0
     */
    public static void setDefaultCompiler(String compiler) {
        defaultCompiler = compiler;
    }

    /**
     * Compile
     *
     * @param code        code
     * @param classLoader class loader
     * @return the class
     * @since 1.8.0
     */
    @Override
    public Class<?> compile(String code, ClassLoader classLoader) {
        Compiler compiler;
        SPILoader<Compiler> loader = SPILoader.getExtensionLoader(Compiler.class);
        String name = defaultCompiler;
        if (name != null && name.length() > 0) {
            compiler = loader.getExtension(name);
        } else {
            compiler = loader.getDefaultExtension();
        }
        return Objects.requireNonNull(compiler).compile(code, classLoader);
    }

}
