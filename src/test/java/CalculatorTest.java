import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;
import org.w3c.dom.ls.LSOutput;

public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void testSum(){
        int actualResult = calculator.sum(5, 3);
        int expectedResult = 8;
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(calculator.sum(-5,3),-2 );
        Assert.assertEquals(calculator.sum(-5,-3),-8 );
        Assert.assertEquals(calculator.sum(0,-3),-3 );
        Assert.assertEquals(calculator.sum(2,0),2 );
        System.out.println("This is my first test ever");
    }

    @Test
    public void dalisanasTests(){
        Assert.assertEquals(calculator.dalisana(8.2,2.0),4.1);
    }

    @Test
    public void izteiksmesTests(){
    }

    @BeforeClass
    public void beforeClass(){
        this.calculator = new Calculator();
    }

    @BeforeMethod
    public void izpildasPirms(){
        System.out.println("Izpildas pirms katra testa");
    }



}
