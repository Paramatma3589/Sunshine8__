package com.sunshine.satyananda.sunshine.test;

/**
 * Created by Satyananda on 29.11.2014.
 */
import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;

public class fullTestSuite {
    public static Test suite() {
        return new TestSuiteBuilder(fullTestSuite.class)
                .includeAllPackagesUnderHere().build();
    }

    public fullTestSuite() {
        super();
    }
}