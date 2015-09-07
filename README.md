# Overview
For this interview question, I have created a series of integration tests to validate a Word Scramble program.
The Word Scramble program scores the difficulty of any particular scrambling of a word.  The scores can be not, poor, fair or hard, 
depending on whether or not the scramble is not scrambled, easy to solve, a reasonable difficulty to solve or hard to solve.
The Word Scramble program uses a set of heuristics including if the word looks real or if the scramble has letters in the correct place.

## Test Approach
I am using TestNG and the maven-failsafe-plugin to drive the integration tests.  TestNG is a test framework simular to JUnit but with
better support for other frameworks like Spring and the ability to run tests in different threads.  The maven-failsafe-plugin is designed specifically
to run integration tests where the maven-surefire-plugin is for unit tests.  Both can be found the POM. For this program, there are no unit tests which 
can be helpful in creating integration tests.  Unit tests can give insight into what needs to be tested. My test approach is designed to follow the test 
principles of 'Keep Tests Independent', and 'Test Concerns Separately ' and 'Verify One Condition per Test'. The input files and testNG configuration
file separate the tests to provide easier maintenance, better defect localization, and minimize debugging.
These test principles come from Gerard Meszaros book xUnit Test Patterns.  
The website is http://xunitpatterns.com/index.html.

## Running and adding tests
The tests can be executed with mvn verify command after cloning the project to your workspace with git clone 
https://github.com/mmiller82/WordScramble.git (or unpacking the zip file).
The results are displayed in the target/surefire-reports/index.html file. Maven integrates easily
with continuous integration tools like Jenkins. Jenkins will display the results in the surefire-reports directory in it's UI.
Tests can be added by adding a test file to the src/resources/input directory and adding a test case to the word-scramble.xml file.

## Choice of solution
I chose to automate the second solution. It allowed more flexibility in the testing aspect since it used a file as input.  This allowed the tester to add or change a test 
fairly easily as described above. 
The first solution does not have the same flexibility. You would have to modify the code to add or update test cases although you could probably follow the
aforementioned test principles.

The second solution is also a better design.  The code is more modular.  The code for the different score levels is separated into different classes.
The score level classes are derived from a abstract class that implements an interface.  This type of design allows for easier extension like
adding another score level.

## Test Cases
I created a total of ten cases. The test cases include coverage of all the cases outlined in the interview document.
In some cases like Fair Scramble and Letter Combination tests, I grouped scenarios for a specific feature. 
The test cases included test for each of the scores, a test case with lowercase letters and several test cases with bad input.
Three of the test cases failed.  The Not Scramble,Hard Scramble and Parameter tests failed. The Parameter test failed because of
a misspelling.
