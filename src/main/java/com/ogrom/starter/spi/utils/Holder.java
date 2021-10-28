package com.ogrom.starter.spi.utils;

/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @param <T> parameter
 * @author ogrom
 * @version 1.8.0
 * @date 2021.02.26 17:47
 * @since 1.8.0
 */
@SuppressWarnings("all")
public class Holder<T> {

    /** Value */
    private volatile T value;

    /**
     * Set
     *
     * @param value value
     * @since 1.8.0
     */
    public void set(T value) {
        this.value = value;
    }

    /**
     * Get
     *
     * @return the t
     * @since 1.8.0
     */
    public T get() {
        return value;
    }

}
