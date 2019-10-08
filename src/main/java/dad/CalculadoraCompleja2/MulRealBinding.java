package dad.CalculadoraCompleja2;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;

public class MulRealBinding extends DoubleBinding {
	
	private DoubleExpression a,b,c,d;
	
	public MulRealBinding(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d) {
		
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		bind(a,b,b,c);
		
	}
	
	protected double computeValue() {
		return (a.get() * c.get()) - (b.get() * d.get());
	}
}
