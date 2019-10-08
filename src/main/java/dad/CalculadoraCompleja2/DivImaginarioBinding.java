package dad.CalculadoraCompleja2;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;

public class DivImaginarioBinding extends DoubleBinding {
	
	private DoubleExpression a,b,c,d;
	
	public DivImaginarioBinding(DoubleExpression a, DoubleExpression b, DoubleExpression c, DoubleExpression d) {
		
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		bind(a,b,c,d);
		
	}
	
	protected double computeValue() {
		return ((b.get() * c.get()) - (a.get() * d.get())) / ((c.get() * c.get()) + (d.get() * d.get()));
	}
}
