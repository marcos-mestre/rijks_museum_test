package com.mmestre.rijksmuseum;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("com.mmestre.rijksmuseum")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.mmestre.rijksmuseum.steps")
public class RunCucumberIT {
}
