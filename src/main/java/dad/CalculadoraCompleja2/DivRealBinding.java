package dad.CalculadoraCompleja2;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;

public class DivRealBinding extends DoubleBinding {
	
	private DoubleExpression a,b,c,d;
	
	public DivRealBinding(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d) {
		
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		bind(a,b,c,d);
		
	}
	
	protected double computeValue() {
		return ((a.get() * c.get()) + (b.get() * d.get())) / ((c.get() * c.get()) + (d.get() * d.get()));
	}
}
