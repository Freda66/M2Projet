package structure.terminal;

public class Constante<T> extends Terminal {
	
	private T value;

	public Constante(T value) {
		super();
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String type() {
		return "Constante";
	}
	@Override
	public String toString() {
		return this.value.toString();
	}

	
}
