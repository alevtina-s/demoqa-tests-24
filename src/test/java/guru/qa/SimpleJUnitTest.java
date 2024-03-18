package guru.qa;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("### @BeforeEach");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("### @BeforeAll\n");
    }

    @AfterEach
    void afterEach() {
        System.out.println("### @AfterEach");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("### @AfterAll\n");
    }
    @Test
    void firstTest() {
        System.out.println("### @Test firstTest");
        Assertions.assertTrue(2*2 == 4);
    }

    @Test
    void secondTest() {
        System.out.println("### @Test secondTest");
        Assertions.assertTrue(2+2 == 4);
    }

}
