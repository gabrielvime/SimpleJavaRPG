package com.gvime.simplerpg;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * SIMPLE LOGGER CLASS
 * WRITE MESSAGES TO A FILE AND CONSOLE
 */
public class Logger {

    private static final String LOG_FILE_PATH = "simple_rpg.log";

    public static void output(String message) {

        try (FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(message);
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        System.out.println(message);
    }
}