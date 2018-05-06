import org.junit.* ;
import static org.junit.Assert.* ;

public class CuboidUnitTest {
    private double delta = 1e-5;

    @Test(timeout=1000)
    public void testEmptyConstructor(){
        Cuboid c = new Cuboid();
    }

    @Test(timeout=1000)
    public void testNormalConstructor(){
        Cuboid c = new Cuboid(3, 5, 7);
        assertEquals("The return value is not equals the input to the constructor", 3, c.getHeight(), delta);
        assertEquals("The return value is not equals the input to the constructor", 5, c.getLength(), delta);
        assertEquals("The return value is not equals the input to the constructor", 7, c.getWidth(), delta);
    }

    @Test(timeout=1000)
    public void testHierarchy1(){
        Cuboid c = new Cuboid(3, 3, 3);
        assertTrue("Cuboid does not inherit from Body", c instanceof Body);
    }
    
    @Test(timeout=1000)
    public void testSetters(){
        Cuboid c = new Cuboid(-3, -4, -5);
        
        c.setHeight(1);
        c.setWidth(2);
        c.setLength(3);
        assertEquals("calculateVolume returns the wrong value", 6, c.calculateVolume(), delta);
        
        c.setHeight(-1);
        c.setWidth(-2);
        c.setLength(-3);
        assertEquals("calculateVolume returns the wrong value", 1, c.calculateVolume(), delta);
    }

    @Test(timeout=1000)
    public void testCalculateVolume(){
        Cuboid c = new Cuboid(3, 3, 3);
        assertEquals("calculateVolume returns the wrong value", 27, c.calculateVolume(), delta);
        
        Cuboid c1 = new Cuboid(-12, -122, 3);
        assertEquals("calculateVolume returns the wrong value", 3, c1.calculateVolume(), delta);
    }
    

    @Test(timeout=1000)
    public void testCalculateSurface(){
        Cuboid c = new Cuboid(3, 3, 3);
        assertEquals("calculateSurface returns the wrong value", 54, c.calculateSurface(), delta);
        
        Cuboid c1 = new Cuboid(10, -1342, -112);
        assertEquals("calculateVolume returns the wrong value", 42, c1.calculateSurface(), delta);
    }
}
