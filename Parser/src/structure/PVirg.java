package structure;

public class PVirg extends NodeA {
	
	@Override
	public SimpleNodeA clone() {
		// TODO Auto-generated method stub
		return new PVirg();
	}
	@Override
	public String type() {
		// TODO Auto-generated method stub
		return ";";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + fg + ";" + fd;
	}

}
