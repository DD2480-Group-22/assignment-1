[![Build Status](https://travis-ci.com/DD2480-Group-22/assignment-1.svg?branch=master)](https://travis-ci.com/DD2480-Group-22/assignment-1)
[![codecov](https://codecov.io/gh/DD2480-Group-22/assignment-1/branch/master/graph/badge.svg)](https://codecov.io/gh/DD2480-Group-22/assignment-1)

# Assignment 1: Decide
This repository contains the code and documentation for assignment 1 _Decide_, written by group 22. The assignment is part of the course DD2480 Software Engineering Fundamentals.

## Program description
The Decide program is a part of a hypothetical anti-ballistic missile system, and determines whether an interceptor should be launched based upon the inputed radar tracking information. The program only allows a launch if all the requirments set in the configuration files are meet. 

## Group members:
* Erik Svensson
* Felipe Ignacio Vicencio Neumann
* Nils Streijffert
* Pablo Javier Aravena Núñez

### Statement of contributions
##### Erik Svensson
* Converted the original code skeleton from C to Java
* Wrote the third test case for the Decide program
* Implemented _Launch Interceptor Conditions_ 0, 1, 3 and 14

##### Felipe Ignacio Vicencio Neumann
* Implemented _Launch Interceptor Conditions_ 2, 5, 8, 9, 11 and 13

##### Nils Streijffert
* Implemented _Launch Interceptor Conditions_ 6 and 7
* Wrote the `IOHandler`, `Parameters` and `Connectors` classes
* Implemented the `DecideProgram` class
* Setup the Maven project
* Setup Travis
* Setup CodeCov
* Setup JavaDoc
* Setup JUnit
* Wrote documentation

#### Pablo Javier Aravena Núñez
* Implemented _Launch Interceptor Conditions_ 4, 10 and 12
* Added the Travis bot to Slack

## Running the program
### Requirements
* Java JDK 8
* Apache Maven 3.6.3

### How to run the program
1. Compile the project: `mvn compile`
2. Run the program: `mvn exec:java -Dexec.mainClass=Main`

You can suppress the Maven output by running the the program with the `-q` flag. The command then becomes:

`mvn exec:java -Dexec.mainClass=Main -q`

#### Specify test file
If you want to run a specific test from the resources folder you can specify it by passing an application argument
using the `-Dexec.args` flag. Valid arguments are the numbers of the test file (program_test_#), you can specify more 
than one file at a time.

**Example run test file 1 and 3:**

`mvn exec:java -Dexec.mainClass=Main -Dexec.args="1 3" `

### How to test the program
1. Compile the project: `mvn compile`
2. Run tests: `mvn test`

## How to generate documentation for the source code
1. Compile the project: `mvn compile`
2. Generate documentation: `mvn javadoc:javadoc`
3. To view the documentation open the file `target/site/apidocs/index.html` in a web browser.

## Decide program configuration file
The Decide program configuration file lets the user easily configure the input parameters to the program.

### File structure 
The first line is a integer `N` (`3 <= N <= 100`) and defines the number of data points. Then there is `N` rows of
coordinates which are pairs of doubles. After the coordinates there are eight rows of doubles which represent the 
following parameters: `epsilon`,  `length1`,  `length2`, `radius1`, `radius2`, `area1`, `area2`, `dist`. Then there is 
eleven rows of integers which represent the parameters: `qPts`, `quads`,`nPts`, `kPts`, `aPts`, `bPts`, `cPts`, `dPts`, 
`ePts`, `fPts`, `gPts`. After the parameters there is fifteen rows of fifteen space separated Strings (only one space between each String) with either of the values `ANND`, `NOTUSED` or `ORR`, these rows form the _Logical Connector Matrix_. The final fifteen rows of the file are boolean values either `true` or `false`, these values form the _Preliminary Unlocking Vector_.

**Example:** [Config file](src/main/resources/program_test_1.in)
