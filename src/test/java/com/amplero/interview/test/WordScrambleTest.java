package com.amplero.interview.test;

import java.io.InputStreamReader;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WordScrambleTest  {
    /** slf4j logger */
    private static final Logger LOG = LoggerFactory.getLogger(WordScrambleTest.class);

    
    @Parameters({"file"})
    @BeforeMethod(alwaysRun = true)
    public void setup(String path) throws Exception {
        Processor process = new Processor(new InputStreamReader(System.in));
        process.createProcess("");

    }
    
    @Parameters({"output"})
    @Test(groups = {"functional","build"})
    public void runTest() {

    }
    

}
