#!/usr/bin/env bash

emulator -avd Pixel_3a_API_28 & appium & mvn --quiet clean test -DsuiteXmlFile=testng.xml
