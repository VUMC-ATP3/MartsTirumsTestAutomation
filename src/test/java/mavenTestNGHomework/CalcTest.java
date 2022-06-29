package mavenTestNGHomework;

import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalcTest {

    private Calculator kalk;

        @Test
        public void sumParbaude(){
            Assert.assertEquals(kalk.sum(10, 10), 20);
        }
        @Test
        public void subParbaude(){
            Assert.assertEquals(kalk.atnemsana(10,5), 5);
        }
        @Test
        public void multParbaude(){
            Assert.assertEquals(kalk.reizinasana(5,5), 25);
        }
        @Test
        public void divParbaude(){
            Assert.assertEquals(kalk.dalisana(25,5), 5);
        }

        @BeforeClass
    public void beforeClass() {
        this.kalk = new Calculator();
    }
        @BeforeMethod
    public void pirmsKatrasMetodes(){
            System.out.println("Tests ir sācies!");
        }





}
