package render.quantifyit.model.operations;

import render.quantifyit.model.Decimal;

public interface MultipleElements<X extends Decimal, Y extends Decimal> {
	
	X eval(X x, Y... elements);
}