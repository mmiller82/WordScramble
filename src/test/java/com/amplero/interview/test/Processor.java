/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amplero.interview.test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Maury Miller
 */
public class Processor {
    private final Reader reader;

    public Processor(Reader r) {
        this.reader = r;
    }
    
    public void createProcess(String file, String outputFile) {
        String classpath = "target/classes";
        String className = "com.amplero.interview.WordScrambleApp";
        ProcessBuilder builder = new ProcessBuilder("java", "-cp", classpath, className, file);

        File log = new File(outputFile);
        builder.redirectErrorStream(true);
        builder.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        
        try {
            Process process = builder.start();
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
