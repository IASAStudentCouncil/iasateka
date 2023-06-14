package ua.iasasc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class EmailServiceApplicationTest
        extends TestCase {

    public EmailServiceApplicationTest(String testName) {
        super(testName);
    }


    public static Test suite() {
        return new TestSuite(EmailServiceApplicationTest.class);
    }

    public void testApp() {
        assertTrue(true);
    }
}
