package com.gvime.simplerpg;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class Log {

    public static void output(String message) {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))){
            writer.write(message);
            writer.newLine();
        } catch (Exception e) {
            System.err.println("[ERROR] Failed to write to log file: " + e.getMessage());
        }
        System.out.println(message);
    }
}
