import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class ArrayCheckTest {
	// NOTTODO DIESE ZEILE BITTE NICHT VERAENDERN!!
	// TODO Fuehrt eure Tests auf diesem ArrayCheck-Objekt aus!
	// Ansonsten werden unsere Tests fehlschlagen
	public ArrayCheck arrayCheckTestObject = new ArrayCheck();

	@Test(timeout = 1000)
	public void testAllDivisibleBy() {
		// TODO Schreibt verschiedene Testfaelle, die unterschiedliche Arrays
		// anlegen und an arrayCheck.testAllDivisibleBy uebergeben.
		// Benutzt nur diese Methode.
		// Testet auch randfaelle wie z.B. leere arrays.
		// Bsp: assertTrue("mein test 1", arrayCheckTestObject.allDivisibleBy(testArray, 7));
		
		ArrayList <Integer> testArray = null;
		
		assertFalse("Does not return false when passed invalid Array", arrayCheckTestObject.allDivisibleBy(testArray, 5));
		
		testArray = new ArrayList<>();
		
		assertFalse("Does not return false when passed empty Array", arrayCheckTestObject.allDivisibleBy(testArray, 7));
		
		testArray.add(12);
		testArray.add(6);
		testArray.add(66);
		testArray.add(36);
		
		assertTrue("Does not return true when passed valid Array", arrayCheckTestObject.allDivisibleBy(testArray, 3));
		
		assertTrue("Does not return true when passed valid Array", arrayCheckTestObject.allDivisibleBy(testArray, 6));
		
		assertTrue("Does not return true when passed valid Array", arrayCheckTestObject.allDivisibleBy(testArray, 1));
		
		assertFalse("Does not return false when passed zero as divisor", arrayCheckTestObject.allDivisibleBy(testArray, 0));
		
		testArray.clear();
		
		assertFalse("Does not return false when passed empty Array", arrayCheckTestObject.allDivisibleBy(testArray, 12345));
		
		testArray.add(0);
		testArray.add(7);
		testArray.add(21);
		testArray.add(-21);
		testArray.add(700);
		testArray.add(-7);
		testArray.add(0);
		
		assertTrue("Does not return true when passed valid Array", arrayCheckTestObject.allDivisibleBy(testArray, 1));
		
		assertTrue("Does not return true when passed valid Array", arrayCheckTestObject.allDivisibleBy(testArray, 7));
		
		testArray.add(6);
		
		assertFalse("Does not return false when passed Array with invalid number", arrayCheckTestObject.allDivisibleBy(testArray, 7));
		
		testArray.clear();
		
		testArray.add(0);
		testArray.add(0);
		testArray.add(0);
		testArray.add(0);
		testArray.add(0);
		
		assertTrue("Does not return true when passed valid Array", arrayCheckTestObject.allDivisibleBy(testArray, 1));
		assertTrue("Does not return true when passed valid Array", arrayCheckTestObject.allDivisibleBy(testArray, 2));
		assertTrue("Does not return true when passed valid Array", arrayCheckTestObject.allDivisibleBy(testArray, 3));
		
		testArray = null;			//zum Glück gibt es den Garbage Collector 
		
		assertFalse("Does not return false when passed invaild Array", arrayCheckTestObject.allDivisibleBy(testArray, 2));
		
	}

	@Test(timeout = 1000)
	public void testIsAnagram() {
		// TODO Schreibt verschiedene Testfaelle fuer isAnagram in diese Methode
		// Bsp: assertTrue("mein test 2", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		ArrayList <Character> testArray1 = null;
		ArrayList <Character> testArray2 = null;
		
		assertFalse("Does not return false when passed 2 null Arrays", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		
		
		testArray1 = new ArrayList<>();
		
		assertFalse("Does not return false when passed 1 empty / 1 null Array", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1 = null;
		testArray2 = new ArrayList<>();
		
		assertFalse("Does not return true when passed 1 empty / 1 null Array", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1 = new ArrayList<>();
		testArray2 = new ArrayList<>();
		
		
		
		assertFalse("Does not return false when passed 2 empty Array", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1.add('!');
		testArray1.add('#');
		
		assertFalse("Does not return false when passed 1 empty Array", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1.clear();
		testArray2.add('*');
		testArray2.add('+');
		
		assertFalse("Does not return false when passed 1 empty Array", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray2.clear();
		testArray2.add('~');
		testArray2.add('"');
		
		testArray1.add('?');
		testArray1.add('&');
		
		assertTrue("Does not return true when passed 2 Arrays with only \"special characters\" ", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		
		
		
		testArray1.add('a');
		testArray1.add('b');
		testArray1.add('c');
		
		testArray2.add('c');
		testArray2.add('b');
		testArray2.add('a');
		
		assertTrue("Does not return true when passed ana. Arrays", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1.clear();
		testArray2.clear();
		
		testArray1.add('A');
		testArray1.add('l');
		testArray1.add('g');
		testArray1.add('o');
		testArray1.add('D');
		testArray1.add('a');
		testArray1.add('t');
		
		testArray2.add('G');
		testArray2.add('a');
		testArray2.add('l');
		testArray2.add('a');
		testArray2.add(' ');
		testArray2.add('T');
		testArray2.add('o');
		testArray2.add('d');
		testArray2.add('!');
		
		assertTrue("Does not return true when passed ana. Arrays", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1.clear();
		testArray2.clear();
		
		testArray1.add('E');
		testArray1.add('c');
		testArray1.add('l');
		testArray1.add('i');
		testArray1.add('?');
		testArray1.add('p');
		testArray1.add('s');
		testArray1.add('e');
		
		testArray2.add('P');
		testArray2.add('C');
		testArray2.add(' ');
		testArray2.add('L');
		testArray2.add('e');
		testArray2.add('i');
		testArray2.add('s');
		testArray2.add('e');
		testArray2.add('+');
		
		assertTrue("Does not return true when passed ana. Arrays", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1.clear();
		testArray2.clear();
		
		
		
		
		testArray1.add('a');
		testArray1.add('a');
		testArray1.add('a');
		
		testArray2.add('a');
		testArray2.add('a');
		
		assertFalse("Does not return false when passed not ana. Arrays", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1.clear();
		testArray2.clear();
		
		testArray1.add('a');
		testArray1.add('a');
		testArray1.add('b');
		
		testArray2.add('b');
		testArray2.add('a');
		
		assertFalse("Does not return false when passed not ana. Arrays", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1.clear();
		testArray2.clear();
		
		testArray1.add('a');
		testArray1.add('p');
		testArray1.add('f');
		testArray1.add('e');
		testArray1.add('l');
		
		testArray2.add('b');
		testArray2.add('a');
		testArray2.add('u');
		testArray2.add('m');
		testArray2.add('e');
		
		assertFalse("Does not return false when passed not ana. Arrays", arrayCheckTestObject.isAnagram(testArray1, testArray2));
		
		testArray1.clear();
		testArray2.clear();
		
		
		/*
			([abc],[cba]) ([AlgoDat],[Gala Tod!]) ([Eclipse], [PC, Leise])
			die Methode gibt für folgende Paare false zurück:
			([aaa],[aa]) ([aab],[ba])
		*/
	}


}

