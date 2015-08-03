package persistence.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import persistence.Persistence;
import persistence.PersistenceImpl;

import static org.junit.Assert.*;

public class PersistenceImplTest {

    private Persistence classToTest;

    @Before
    public void setUp() throws Exception {
        classToTest = new PersistenceImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAccidentalReboot() throws Exception {
        boolean test = classToTest.accidentalReboot();

        assertEquals(true, test);
    }

    @Test
    public void testSaveState() throws Exception {

    }

    @Test
    public void testLoadState() throws Exception {

    }
}