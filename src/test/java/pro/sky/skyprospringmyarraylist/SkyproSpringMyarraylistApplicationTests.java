package pro.sky.skyprospringmyarraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SkyproSpringMyarraylistApplicationTests {

	StringList stringList;

	@BeforeEach
	public void setUp() {
		stringList = new ArrayStringList();
	}


	@Test
	public void toArrayTest(){
		stringList.add("one");
		stringList.add("three");
		String[] expected = {"one", "three"};
		String[] actual = stringList.toArray();

		assertArrayEquals(expected, actual);
	}

	@Test
	public void add1Test() {
		stringList.add("one");
		String[] actual = stringList.toArray();

		String[] expected = {"one"};

		assertArrayEquals(expected, actual);

		assertThrows(IllegalArgumentException.class, () -> stringList.add(null));

	}
    @Test
	public void add2Test() {
		stringList.add("one");
		stringList.add("three");
		stringList.add(1, "two");

		String[] expected = {"one", "two", "three"};
		String[] actual = stringList.toArray();

		assertArrayEquals(expected, actual);

		assertThrows(IllegalArgumentException.class, () -> stringList.add(1, null));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.add(3, "two"));

	}
    @Test
	public void setTest(){
		stringList.add("one");
		stringList.add("three");
		stringList.set(1, "two");

		String[] expected = {"one", "two"};
		String[] actual = stringList.toArray();

		assertArrayEquals(expected, actual);

		assertThrows(IllegalArgumentException.class, () -> stringList.add(1, null));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.add(3, "two"));
	}
    @Test
	public void remove1Test(){
		stringList.add("one");
		stringList.add("three");
		stringList.remove("three");

		String[] expected = {"one"};
		String[] actual = stringList.toArray();

		assertArrayEquals(expected, actual);

		assertThrows(NoSuchElementException.class, () -> stringList.remove("two"));
	}

	@Test
	public void remove2Test(){
		stringList.add("one");
		stringList.add("three");
		stringList.remove(1);

		String[] expected = {"one"};
		String[] actual = stringList.toArray();

		assertArrayEquals(expected, actual);

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.remove(3));
	}

	@Test
	public void containsTest(){
		stringList.add("one");
		stringList.add("three");

		boolean expected = true;
		boolean actual = stringList.contains("three");

		assertEquals(expected, actual);
	}

	@Test
	public void indexOfTest(){
		stringList.add("one");
		stringList.add("three");
		int actual1 = stringList.indexOf("two");
        int expected1 = -1;
		assertEquals(expected1, actual1);

		int actual2 = stringList.indexOf("one");
		int expected2 = 0;
		assertEquals(expected2, actual2);
	}

	@Test
	public void lastIndexOfTest(){
		stringList.add("one");
		stringList.add("three");
		int actual1 = stringList.lastIndexOf("two");
		int expected1 = -1;
		assertEquals(expected1, actual1);

		int actual2 = stringList.lastIndexOf("three");
		int expected2 = 1;
		assertEquals(expected2, actual2);
	}

	@Test
	public void getTest(){
		stringList.add("one");
		stringList.add("three");
		String actual = stringList.get(1);
		String expected = "three";
		assertEquals(expected, actual);

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList.get(3));
	}

	@Test
	public void equalsTest(){
		stringList.add("one");
		stringList.add("three");

		StringList stringList2 = new ArrayStringList();
		stringList2.add("one");
		stringList2.add("three");

		assertTrue(stringList.equals(stringList2));

		StringList stringList3 = new ArrayStringList();
		stringList3.add("one");
		stringList3.add("two");

		assertFalse(stringList.equals(stringList3));

	}

	@Test
	public void sizeTest() {
		stringList.add("one");
		stringList.add("three");
		assertEquals(2, stringList.size());
	}

	@Test
	public void isEmptyTest() {
		assertTrue(stringList.isEmpty());

		stringList.add("one");
		assertFalse(stringList.isEmpty());

	}

	@Test
	public void clearTest() {
		stringList.add("one");
		stringList.add("two");

		stringList.clear();
		String[] expected = new String[0];
		assertArrayEquals(expected, stringList.toArray());

	}

}
