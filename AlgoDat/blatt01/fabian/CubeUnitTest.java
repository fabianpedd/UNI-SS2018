import org.junit.* ;
import static org.junit.Assert.* ;

public class CubeUnitTest {
    private double delta = 1e-5;

    @Test(timeout=1000)
    public void testEmptyConstructor(){
        Cube c = new Cube();
    }

    @Test(timeout=1000)
    public void testNormalConstructor(){
        Cube c = new Cube(3);
        assertEquals("The return value is not equals the input to the constructor", 3, c.getLength(), delta);
    }

    @Test(timeout=1000)
    public void testHierarchy1(){
        Cube c = new Cube(3);
        assertTrue("Cube does not inherit from Cuboid", c instanceof Cuboid);
    }

    @Test(timeout=1000)
    public void testHierarchy2(){
        Cube c = new Cube(3);
        assertTrue("Cube does not inherit from Body", c instanceof Body);
    }
    
    @Test(timeout=1000)
    public void testSetter(){
        Cube c = new Cube(3);
        
        assertEquals("calculateVolume returns the wrong value", 27, c.calculateVolume(), delta);
        
        c.setLength(5);
        assertEquals("calculateVolume returns the wrong value", 125, c.calculateVolume(), delta);
        
        c.setLength(-1);
        assertEquals("calculateVolume returns the wrong value", 1, c.calculateVolume(), delta);
    }
    
    @Test(timeout=1000)
    public void testCalculateVolume(){
        Cube c = new Cube(3);
        assertEquals("calculateVolume returns the wrong value", 27, c.calculateVolume(), delta);
        
        Cube c1 = new Cube(0);
        assertEquals("calculateVolume returns the wrong value", 0, c1.calculateVolume(), delta);
        
        Cube c2 = new Cube(-100);
        assertEquals("calculateVolume returns the wrong value", 1, c2.calculateVolume(), delta);
    }

    @Test(timeout=1000)
    public void testCalculateSurface(){
        Cube c = new Cube(3);
        assertEquals("calculateSurface returns the wrong value", 54, c.calculateSurface(), delta);
        
        Cube c1 = new Cube(-100);
        assertEquals("calculateSurface returns the wrong value", 6, c1.calculateSurface(), delta);
        
        Cube c2 = new Cube(0);
        assertEquals("calculateSurface returns the wrong value", 0, c2.calculateSurface(), delta);
    }
}
