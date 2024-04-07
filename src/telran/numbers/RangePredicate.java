package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class RangePredicate extends Range {
	private Predicate<Integer> predicate;

	protected RangePredicate(int min, int max) {
		super(min, max);

	}

	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}

	public static RangePredicate getRange(int min, int max) {
		checkMinMax(min, max);
		return new RangePredicate(min, max);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new RangePredicateIterator();
	}

	private class RangePredicateIterator implements Iterator<Integer> {
	    private int current;

	    public RangePredicateIterator() {
	        current = min -1;
	        prepareNext();
	    }

	    @Override
	    public boolean hasNext() {
	        return current <= max;
	    }

	    @Override
	    public Integer next() {
	        if (!hasNext()) {
	            throw new NoSuchElementException();
	        }
	        int result = current;
	        prepareNext();
	        return result;
	    }

	    private void prepareNext() {
	        current++;
	        while (current <= max && predicate != null && !predicate.test(current)) {
	            current++;
	        }
	    }
	}
}