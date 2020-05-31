package SmallTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import program.Calculator;

public class CalculatorTest {

    Calculator calc;
    int a = 5;
    int b = 5;

    @BeforeTest
    public void initiateTest(){
        calc = new Calculator();
    }

//    @Test
//    public void testAssertTrue(){
//        int result =  calc.add(a ,b);
//        Assert.assertTrue(result == 11);
//    }
//
//    @Test
//    public void testAssertFalse(){
//        int result =  calc.add(a ,b);
//        Assert.assertFalse(result == 11);
//    }
//
//    @Test
//    public void testAssertEquals(){
//        int result =  calc.add(a ,b);
//        Assert.assertEquals(result, 10);
//    }


}
