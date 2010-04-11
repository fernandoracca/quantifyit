package render.quantifyit.model.operations;

import render.quantifyit.model.Decimal;

public abstract class DecimalOperationsFactory {

	private static ArithmeticOperation<Decimal, Decimal> addition = new Addition<Decimal, Decimal>();
	private static ArithmeticOperation<Decimal, Decimal> subtraction = new Subtraction<Decimal, Decimal>();
	private static ArithmeticOperation<Decimal, Decimal> multiplication = new Multiplication<Decimal, Decimal>();
	private static Division<Decimal, Decimal> division = new Division<Decimal, Decimal>();
	private static Power<Decimal> power = new Power<Decimal>();
	private static SquareRoot<Decimal> squareRoot = new SquareRoot<Decimal>();
	
	private static final Operations<Decimal> operations =
		new Operations<Decimal>(addition , subtraction, multiplication, division, power, squareRoot);
	
	public static Operations<Decimal> getInstance(){
		return operations;
	}
	
}
