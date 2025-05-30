package com.a8.runner;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("login.feature")
@SelectClasspathResource("logout.feature")
@ConfigurationParameter(key = "cucumber.glue", value = "com.a8.stepDefinitions")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
public class RunCucumberTest {}
