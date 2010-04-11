package render.quantifyit.model.operations;

import render.quantifyit.model.Decimal;

public class Operations<T extends Decimal> {

	public final ArithmeticOperation<T, T> addition; 
	public final ArithmeticOperation<T, T> subtraction; 
	public final ArithmeticOperation<T, T> multiplication; 
	public final Division<T, T> division; 
	public final Power<T> power;
	public final SquareRoot<T> squareRoot;
	
	Operations(final ArithmeticOperation<T, T> addition,  
			   final ArithmeticOperation<T, T> subtraction,
			   final ArithmeticOperation<T, T> multiplication,
			   final Division<T, T> division,
			   final Power<T> power,
			   final SquareRoot<T> squareRoot){
		this.addition = addition;
		this.subtraction = subtraction;
		this.multiplication = multiplication;
		this.division = division;
		this.power = power;
		this.squareRoot = squareRoot;
	}
}
