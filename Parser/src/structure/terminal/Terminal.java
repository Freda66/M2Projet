package structure.terminal;

import structure.SimpleNodeA;

public abstract class Terminal extends SimpleNodeA {
	private float[] range;

	public Terminal(float[] testRange) {
		this.range=testRange;
	}
	@Override
	public String type() {
		return "Terminal";
	}
	public float[] getRange() {
		return range;
	}
	public void setRange(float[] range) {
		this.range = range;
	}
	

}
