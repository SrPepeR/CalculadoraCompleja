package dad.CalculadoraCompleja2;

import javafx.beans.binding.DoubleExpression;

public class MathBinding {
	public static SumBinding sumBinding(DoubleExpression a, DoubleExpression b) {
		return new SumBinding(a, b);
	}
	public static ResBinding resBinding(DoubleExpression a, DoubleExpression b) {
		return new ResBinding(a, b);
	}
	public static MulRealBinding mulRealBinding(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d) {
		return new MulRealBinding(a, b, c, d);
	}
	public static MulImaginarioBinding mulImaginarioBinding(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d) {
		return new MulImaginarioBinding(a, b, c, d);
	}
	public static DivRealBinding divRealBinding(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d) {
		return new DivRealBinding(a, b, c, d);
	}
	public static DivImaginarioBinding divImaginarioBinding(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d) {
		return new DivImaginarioBinding(a, b, c, d);
	}
}
