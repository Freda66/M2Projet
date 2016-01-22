import structure.PVirg;
import structure.Function;
import structure.terminal.Variable;
import structure.affectation.Affectation;
import structure.terminal.Constante;
import java.util.ArrayList;


public class TestTreeQuentin{

	public static void main ( String args [ ] ) {

		System.out.println("Hello world !");
		PVirg Code = new PVirg();
		Function fct1 = new Function();
		
		Code.setFD(null);
		Code.setFG(fct1);

		fct1.setName("main");
		ArrayList<Variable> fct1Params = new ArrayList<Variable>();
		float[] range = new float[2];
		range[0] = -1;
		range[1] = -1;
		
		Variable fct1Param = new Variable("x",range,"float");	
		fct1Params.add(fct1Param);
		Variable fct1RV = new Variable("y",range,"int");	
		fct1.setReturnedValue(fct1RV);
		PVirg fct1Content = new PVirg();
		fct1.setContent(fct1Content);

		Variable var = new Variable("y",range,"int");
		fct1Content.setFG(var);
		PVirg toto = new PVirg();
		fct1Content.setFD(toto);

		Affectation aff = new Affectation();
		toto.setFD(null);
		toto.setFG(aff);

		aff.setFG(new Variable("y",range,"int"));
		float[] range2 = new float[2];
		range[0] = 2;
		range[1] = 2;
		aff.setFD(new Constante(range2));

		

	}

}
