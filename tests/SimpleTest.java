public class SimpleTest {
    public static void main(String[] args){
        successTest();
        failTest();
    }

    public static void successTest() {
        assert "Test"=="Test";
    }

    public static void failTest() {
        assert "Test"!="Test";
    }
}