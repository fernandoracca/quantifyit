package render.quantifyit.statistics.descriptive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import render.quantifyit.model.Decimal;
import render.quantifyit.model.operations.Operation;
import render.quantifyit.util.DecimalUtils;

/**
 * In statistics, the mode is the value that occurs the most frequently in a data 
 * set or a probability distribution.

 * @see "http://en.wikipedia.org/wiki/Mode_(statistics)"
 */
public class Mode<X extends Decimal> implements Operation<X> {


	@SuppressWarnings("unchecked")
	public X[] eval(final X... elements) {
		DecimalUtils.notNullOrEmpty(elements);
		if (elements.length == 1) {
			return (X[]) new Decimal[] {elements[0]};
		}
		Arrays.sort(elements);
		
		final Set<Decimal> modes = findModes(elements);
		
		return (X[]) modes.toArray(new Decimal[] {});
	}
	
	private Set<Decimal> findModes(final Decimal... elements) {
		final Set<Decimal> modes = new HashSet<Decimal>(); 
		Decimal last = elements[0];
		Decimal current = null;
		int counter = 1;
		int maxCount = 1;
		for (int i = 1; i < elements.length; i++) {
			current = elements[i];
			if (last.same(current)) {
				counter++;
			} else {
				if (counter > maxCount) {
					maxCount = counter;
					modes.clear();
					modes.add(last);
				} else if (counter == maxCount) {
					modes.add(last);
				}
				last = current;
				counter = 1;
			}
		}
		if (counter == maxCount) {
			modes.add(last);
		}
		return modes;
	}
}
