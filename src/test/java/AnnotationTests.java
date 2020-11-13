import org.testng.annotations.*;

public class AnnotationTests {

    // metoda uruchomi się raz przed wszystkimi testami w klasie
    @BeforeClass
    public void executeOnceOnStart() {
        System.out.println("startuje raz na poczatku");
    }

    // metoda uruchomi się raz po wszystkich testach w klasie
    @AfterClass
    public void executeOnceOnFinish() {
        System.out.println("startuje raz na koncu");
    }

    // metoda uruchomi się przed każdym testem w klasie
    @BeforeMethod
    public void executeBeforeEveryTestMethod() {
        System.out.println("uruchomie sie zawsze przed");
    }

    // metoda uruchomi po każdym teście w klasie
    @AfterMethod
    public void executeAfterEveryTestMethod() {
        System.out.println("uruchomie sie zawsze po");
    }

    @Test
    public void myFirstSuperTest1() {
        System.out.println("to jest 1 test");
    }

    @Test
    public void myFirstSuperTest2() {
        System.out.println("to jest 2 test");
    }

    @Test
    public void myFirstSuperTest3() {
        System.out.println("to jest 3 test");
    }


}
