package com.amplero.interview.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WordScrambleTest  {
    /** slf4j logger */
    private static final Logger LOG = LoggerFactory.getLogger(WordScrambleTest.class);
    private final String PATH = "target/test-classes/input/";
    private final String OUTPUT_FILE = "output.txt";
    private BufferedReader reader = null;
    private StringBuilder output = null;

    @Parameters({"input", "extra"})
    @BeforeMethod(alwaysRun = true)
    public void setup(String input, @Optional String extra) throws Exception {
        Processor process = new Processor();
        String inputPath = PATH + input;
        process.createProcess(inputPath, OUTPUT_FILE);
        output = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(OUTPUT_FILE));
            String line = reader.readLine();
            output.append(line);
            
            while (line != null) {
                // Read next line for while condition
                line = reader.readLine();

                if (line != null) {
                    output.append(line);
                }
            }

            LOG.debug(output.toString());
        } catch (FileNotFoundException ex) {
            LOG.error(ex.getMessage());
        } finally {
            reader.close();
        }
    }

    @Parameters({"expected"})
    @Test(groups = {"functional","build"})
    public void runTest(String expected) {
        LOG.info("Expected: " + expected);
        assertEquals(output.toString(),expected);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        File f = new File(OUTPUT_FILE);

        // Make sure the file or directory exists and isn't write protected
        if (!f.exists()) {
            throw new IllegalArgumentException(
                    "Delete: no such file or directory: " + OUTPUT_FILE);
        }

        // Attempt to delete it
        boolean success = f.delete();

        if (!success) {
            throw new IllegalArgumentException("Delete: deletion failed");
        }

        LOG.info("Test done");
    }
}
