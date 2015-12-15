package structure.terminal;

import structure.SimpleNode;

public abstract class Terminal extends SimpleNode {
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
