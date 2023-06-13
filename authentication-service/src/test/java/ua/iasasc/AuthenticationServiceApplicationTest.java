package ua.iasasc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AuthenticationServiceApplicationTest
        extends TestCase {

    public AuthenticationServiceApplicationTest(String testName) {
        super(testName);
    }


    public static Test suite() {
        return new TestSuite(AuthenticationServiceApplicationTest.class);
    }

    public void testApp() {
        assertTrue(true);
    }
}
