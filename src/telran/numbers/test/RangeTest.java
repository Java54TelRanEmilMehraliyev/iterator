package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import telran.numbers.Range;

class RangeTest {
	Range range = Range.getRange(5, 10);
	@Test
	void IterableIteratortest() {
		Integer[] expected = {5, 6, 7, 8, 9, 10};
		
		Integer[] actual = new Integer[expected.length];
		assertArrayEquals(expected, toArrayFromIterable(actual, range));
		
	}
	@Test
	void iteratorIncorrectUsageTest() {
		Range range1 = Range.getRange(3, 4);
		Iterator<Integer> it = range1.iterator();
		it.next();
		it.next();
		
		assertThrowsExactly(NoSuchElementException.class, () -> it.next());
	}
	public <T> T[] toArrayFromIterable(T[] array, Iterable<T> iterable) {
		int index = 0;
		for(T obj: iterable) {
			array[index++] = obj;
		}
		return array;
	}

}