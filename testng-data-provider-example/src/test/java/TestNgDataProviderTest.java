import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProviderTest {

    @DataProvider
    public Object[][] createTestData() {
        throw new RuntimeException("Error creating test data");
    }

    @Test(dataProvider = "createTestData")
    public void test(int number, int square) throws Exception {
        assertEquals(calculateSquare(number), square);
    }


    public static int calculateSquare(int number) {
        return number * number;
    }
}
