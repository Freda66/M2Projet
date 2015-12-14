package structure.operator;

public class Moins extends Operator {
	
	@Override
	public String type() {
		return "Soustraction";
	}
	@Override
	public String toString() {
		return " * ";
	}
	@Override
	public float Eval(float val1,float val2) {
		return val1-val2;
	}
}
