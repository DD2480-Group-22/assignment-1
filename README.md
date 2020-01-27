[![Build Status](https://travis-ci.com/DD2480-Group-22/assignment-1.svg?branch=master)](https://travis-ci.com/DD2480-Group-22/assignment-1)
[![codecov](https://codecov.io/gh/DD2480-Group-22/assignment-1/branch/master/graph/badge.svg)](https://codecov.io/gh/DD2480-Group-22/assignment-1)

# Assignment 1: Decide
This repository contains the code and documentation for assignment 1 _Decide_, written by group 22. The assignment is part of the course DD2480 Software Engineering Fundamentals.

Group members:
* Erik Svensson
* Felipe Ignacio Vicencio Neumann
* ~~Mikel Zhobro~~
* Nils Streijffert
* Pablo Javier Aravena Núñez

## Running the program
### Requirements
* Java JDK 8
* Apache Maven 3.6.3

### How to run the program
1. Compile the project: `mvn compile`
2. Run the program: `mvn exec:java -Dexec.mainClass=Main `

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
`ePts`, `fPts`, `gPts`. After the parameters there is fifteen rows of fifteen space separated Strings with either of 
the values `ANND`, `NOTUSED` or `ORR`, these rows form the _Logical Connector Matrix_. The final fifteen rows of the
file are boolean values either `true` or `false`, these values form the _Preliminary Unlocking Vector_.