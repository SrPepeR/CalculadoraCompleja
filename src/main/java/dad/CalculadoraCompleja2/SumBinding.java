package dad.CalculadoraCompleja2;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;

public class SumBinding extends DoubleBinding {
	
	private DoubleExpression a,b;
	
	public SumBinding(DoubleExpression a, DoubleExpression b) {
		
		super();
		this.a = a;
		this.b = b;
		bind(a,b);
		
	}
	
	protected double computeValue() {
		return a.get() + b.get();
	}
}
