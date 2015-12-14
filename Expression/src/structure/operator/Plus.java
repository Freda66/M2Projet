package structure.operator;

public class Plus extends Operator {

	@Override
	public String type() {
		return "Addition";
	}
	@Override
	public String toString() {
		return " + ";
	}
	@Override
	public float Eval(float val1,float val2) {
		return val1+val2;
	}
	
}
