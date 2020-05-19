package com.company;

import java.io.*;
import java.util.Properties;

public final class IOHandler {

    private static final String RESOURCES_FILE_NAME = "configs.properties";

    public static String getInput() {
        String input = null;
        try (BufferedReader in = new BufferedReader(new FileReader(new File(getPropsValue("input"))))) {
            int b;
            StringBuilder content = new StringBuilder();
            while ((b = in.read()) != -1)
                content.append((char) b);
            input = content.toString();
        } catch (IOException e) {
            System.out.println("Got problems reading input file");
        }
        return input;
    }

    public static void setOutput(String output) {
        try (BufferedOutputStream out =
                     new BufferedOutputStream(new FileOutputStream(new File(getPropsValue("output"))))) {
            out.write(output.getBytes());
            out.flush();
        } catch (IOException e) {
            System.out.println("Got problems reading output file");
        }
    }

    private static String getPropsValue(String propName) {

        Properties props = new Properties();
        InputStream in = IOHandler.class.getClassLoader().getResourceAsStream(RESOURCES_FILE_NAME);
        try {
            if (in != null)
                props.load(in);
            else throw new IOException();
        } catch (IOException e) {
            System.out.println("Got troubles reading resource file");
        }

        return props.getProperty(propName);
    }

}
