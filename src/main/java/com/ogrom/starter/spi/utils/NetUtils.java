package com.ogrom.starter.spi.utils;


import com.ogrom.starter.spi.constants.CommonConstants;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

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
@SuppressWarnings("all")
public class NetUtils {

    /** LOCAL_IP_PATTERN */
    private static final Pattern LOCAL_IP_PATTERN = Pattern.compile("127(\\.\\d{1,3}){3}$");

    /**
     * Is local host
     *
     * @param host host
     * @return the boolean
     * @since 1.8.0
     */
    public static boolean isLocalHost(String host) {
        return host != null
               && (LOCAL_IP_PATTERN.matcher(host).matches()
                   || host.equalsIgnoreCase(CommonConstants.LOCALHOST_KEY));
    }

    /**
     * Gets ip by host *
     *
     * @param hostName host name
     * @return the ip by host
     * @since 1.8.0
     */
    public static String getIpByHost(String hostName) {
        try {
            return InetAddress.getByName(hostName).getHostAddress();
        } catch (UnknownHostException e) {
            return hostName;
        }
    }

}
