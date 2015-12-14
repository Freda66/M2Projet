package structure.operator;

public class Multiplication extends Operator {

	@Override
	public String type() {
		return "Multiplication";
	}
	@Override
	public String toString() {
		return " * ";
	}
	@Override
	public float Eval(float val1,float val2) {
		return val1*val2;
	}
}
