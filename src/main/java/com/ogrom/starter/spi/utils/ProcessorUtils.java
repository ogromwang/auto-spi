package com.ogrom.starter.spi.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;

import javax.annotation.processing.Filer;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

import lombok.experimental.UtilityClass;

/**
 * <p>  </p>
 * <p>Description: </p>
 *
 * @author ogrom
 * @version 1.0.0
 * @date 2021.10.28 10:13
 * @since 1.0.0
 */
@UtilityClass
@SuppressWarnings("all")
public class ProcessorUtils {
    /** UTF_8 */
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    /**
     * Read service file
     *
     * @param input input
     * @return the set
     * @throws IOException io exception
     * @since 1.0.0
     */
    public static Set<String> readServiceFile(InputStream input) throws IOException {
        HashSet<String> serviceClasses = new HashSet<>();
        try (
            InputStreamReader isr = new InputStreamReader(input, UTF_8);
            BufferedReader r = new BufferedReader(isr)
        ) {
            String line;
            while ((line = r.readLine()) != null) {
                int commentStart = line.indexOf('#');
                if (commentStart >= 0) {
                    line = line.substring(0, commentStart);
                }
                line = line.trim();
                if (!line.isEmpty()) {
                    serviceClasses.add(line);
                }
            }
            return serviceClasses;
        }
    }

    /**
     * Write service file
     *
     * @param services services
     * @param output   output
     * @throws IOException io exception
     * @since 1.0.0
     */
    public static void writeServiceFile(Collection<String> services, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, UTF_8));
        for (String service : services) {
            writer.write(service);
            writer.newLine();
        }
        writer.flush();
    }

    /**
     * Gets all services *
     *
     * @param filer        filer
     * @param resourceFile resource file
     * @param logFunc      log func
     * @return the all services
     * @since 1.0.0
     */
    public static SortedSet<String> getAllServices(Filer filer, String resourceFile, Consumer<String> logFunc) {
        SortedSet<String> allServices = new TreeSet<>();
        try {
            FileObject existingFile = filer.getResource(StandardLocation.CLASS_OUTPUT, "", resourceFile);
            logFunc.accept("Looking for existing resource file at " + existingFile.toUri());
            Set<String> oldServices = ProcessorUtils.readServiceFile(existingFile.openInputStream());
            logFunc.accept("Existing service entries: " + oldServices);
            allServices.addAll(oldServices);
        } catch (IOException e) {
            logFunc.accept("Resource file did not already exist.");
        }
        return allServices;
    }

}
