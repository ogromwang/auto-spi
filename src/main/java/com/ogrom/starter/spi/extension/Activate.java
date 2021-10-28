package com.ogrom.starter.spi.extension;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @author ogrom
 * @version 1.8.0
 * @date 2021.02.26 17:47
 * @since 1.8.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@SuppressWarnings("all")
public @interface Activate {
    /**
     * Group
     *
     * @return the string [ ]
     * @since 1.8.0
     */
    String[] group() default {};

    /**
     * Value
     *
     * @return the string [ ]
     * @since 1.8.0
     */
    String[] value() default {};

    /**
     * Before
     *
     * @return the string [ ]
     * @since 1.8.0
     */
    @Deprecated
    String[] before() default {};

    /**
     * After
     *
     * @return the string [ ]
     * @since 1.8.0
     */
    @Deprecated
    String[] after() default {};

    /**
     * Order
     *
     * @return the int
     * @since 1.8.0
     */
    int order() default 0;
}
