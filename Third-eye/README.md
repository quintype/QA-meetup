# API Test Suite:

## Prerequisite: 

1. On local system should have installed jdk 7 or 8.
For MAC users:
=> export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)

2. On local system should have installed Maven.

## Command to run the project: 
=> mvn --quiet clean test -DsuiteXmlFile=testng.xml
