/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amplero.interview.test;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Maury Miller
 */
public class Processor {
    ProcessBuilder builder = null;
    private final String PATH = "target/test-classes/input/";
    
    /**
     * Method creates a process using the ProcessBuilder class.
     * @param file
     * @param outputFile 
     */
    public void createProcess(String file, String outputFile) {
        String classpath = "target/classes";
        String className = "com.amplero.interview.WordScrambleApp";
        String path = PATH + file;
        
        if (file == null || file.length() == 0) {
            builder = new ProcessBuilder("java", "-cp", classpath, className);
        } else {
            builder = new ProcessBuilder("java", "-cp", classpath, className, path);
            
        }

        File log = new File(outputFile);
        builder.redirectErrorStream(true);
        builder.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        
        try {
            Process process = builder.start();
            System.out.println(builder.command());
            Thread.sleep(1000);
            System.out.println("Process has been started.");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException: " + ex.getMessage());
        }
        
        System.out.println("Program terminated!");
    }
}
