package structure.terminal;

import structure.SimpleNode;

public abstract class Terminal extends SimpleNode {
	
	@Override
	public String type() {
		return "Terminal";
	}

}
