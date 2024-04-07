package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
	protected static final String ERROR_MESSAGE = "max less or equal min";
	protected int min;
	protected int max;
	protected Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	@Override
	public Iterator<Integer> iterator() {
		
		return new RangeIterator();
	}
	public static Range getRange(int min, int max) {
		checkMinMax(min, max);
		return new Range(min, max);
	}
	protected static void checkMinMax(int min, int max) {
		if (max <= min) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}
	private class RangeIterator implements Iterator<Integer> {
		int current = min;
		@Override
		public boolean hasNext() {
			
			return current <= max;
		}

		@Override
		public Integer next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return current++;
		}
		
	}

}
