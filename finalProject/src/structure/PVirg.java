package structure;

public class PVirg extends NodeA {
	
	@Override
	public SimpleNodeA clone() {
		return new PVirg();
	}
	@Override
	public String type() {
		return "PVirg";
	}
	
	@Override
	public String toString() {
		return " ; ";
	}

}
