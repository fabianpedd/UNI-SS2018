import org.junit.* ;
import static org.junit.Assert.* ;

class DataType {
	public int number;
	
	@Override
	public String toString() {
		return "<"+number+">";
	}

	@Override
	public boolean equals(Object a) {
		if (a instanceof DataType)
			return ((DataType)a).number == this.number;
		return false;
	}
}

//WAS IST DIE IDEE HINTER DIESER KLASSE?

/**
 * Bogus class that triggers an exception when somebody tries 
 * to convert it to a string
 *
 *
**/
class NotImplementedDataType {
	@Override
	public String toString() {
		throw new RuntimeException("I am evil.");
	}
}

/**
 * Test-Class for Pair
 * 
 * @author AlgoDat
 *
 */
public class PairTest {

	@Test(timeout=1000)
	public void testPair() {
		DataType a = new DataType();
		DataType b = new DataType();
		a.number = 1;
		b.number = 20;

		Pair<DataType> pair = new Pair<DataType>(a, b);
		
		assertEquals("toString Fails", a + ", " + b,  pair.toString());
		
		try {
			assertEquals("Constructor or getFirst() fails", a, pair.getFirst());
		} catch (NullPointerException e) {
			assertFalse("getFirst() provokes a NullPointerException", true);
		}
		
		try {
			assertEquals("Constructor or getSecond() fails", b, pair.getSecond());
		} catch (NullPointerException e) {
			assertFalse("getSecond() provokes a NullPointerException", true);
		}
		
		DataType c = new DataType();
		DataType d = new DataType();
		c.number = 10;
		d.number = 200;
		
		pair.setFirst(d);
		pair.setSecond(c);
		
		pair.swap();
		
		try {
			assertEquals("Constructor or getFirst() fails", c, pair.getFirst());
		} catch (NullPointerException e) {
			assertFalse("getFirst() provokes a NullPointerException", true);
		}
		
		try {
			assertEquals("Constructor or getSecond() fails", d, pair.getSecond());
		} catch (NullPointerException e) {
			assertFalse("getSecond() provokes a NullPointerException", true);
		}
		
	}
	
	@Test(timeout=1000)
	public void testPairEvil() {
		NotImplementedDataType a = new NotImplementedDataType();
		NotImplementedDataType b = new NotImplementedDataType();
		
		Pair<NotImplementedDataType> pair = new Pair<>(a, b);
		
		//WAS SOLL DAS HIER???
		//assertEquals("toString Fails", a + ", " + b,  pair.toString());
		
		try {
			assertEquals("Constructor or getFirst() fails", a, pair.getFirst());
		} catch (NullPointerException e) {
			assertFalse("getFirst() provokes a NullPointerException", true);
		}
		
		try {
			assertEquals("Constructor or getSecond() fails", b, pair.getSecond());
		} catch (NullPointerException e) {
			assertFalse("getSecond() provokes a NullPointerException", true);
		}
		
		pair.swap();
		
		try {
			assertEquals("Constructor or getFirst() fails", b, pair.getFirst());
		} catch (NullPointerException e) {
			assertFalse("getFirst() provokes a NullPointerException", true);
		}
		
		try {
			assertEquals("Constructor or getSecond() fails", a, pair.getSecond());
		} catch (NullPointerException e) {
			assertFalse("getSecond() provokes a NullPointerException", true);
		}
		
		
	}
	
}




