

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version java-maven-junit5-example version(1.0)</br>
 * @date 09/03/18 11:12</br>
 * @since JDK 1.8</br>
 *
 * https://github.com/bluetata/java-maven-junit5-example/blob/master/src/main/java/com/example/junit5/test/basic/HelloWorld.java
 *
 */
class HelloWorldTest {

    private HelloWorld helloWorld;
    @BeforeAll
    public static void  mybeforeAll() {
        System.out.println("beforeAll/beforeClass Finished ");
    }
    @BeforeEach
    @DisplayName("Before run test case to init resource")
    void init() {
        helloWorld = new HelloWorld();
    }

    @Test
    @DisplayName("Something more descriptive")
    void sayHelloWorld() {
        assertEquals("Hello World", helloWorld.sayHelloWorld());
    }

    @AfterEach
    @DisplayName("Finish Test to destroy resource")
    void tearDown() {
        helloWorld = null;
    }

}