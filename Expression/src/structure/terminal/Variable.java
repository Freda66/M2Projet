package structure.terminal;

public class Variable<T> extends Terminal{
	private String name;
	private T min;
	private T max;
	
	public Variable(String name,T min,T max) {
		super();
		this.name = name;
		this.min=min;
		this.max=max;
	}
	
	public T getMin() {
		return min;
	}
	public void setMin(T min) {
		this.min = min;
	}
	public T getMax() {
		return max;
	}
	public void setMax(T max) {
		this.max = max;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String type() {
		return "Variable";
	}
	@Override
	public String toString() {
		return this.name;
	}
}
