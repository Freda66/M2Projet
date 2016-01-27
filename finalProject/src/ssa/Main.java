package ssa;

import structure.PVirg;
import structure.affectation.Affectation;
import structure.operator.Plus;
import structure.terminal.Constante;
import structure.terminal.Variable;

public class Main {

	public static void main(String[] args) {

		// y = 3;
		// y = 4;
		// z = y + 3;


		Variable v = new Variable( "y", new float[]{ 2.9f, 3.1f} );

		Constante c = new Constante(new float[]{ 2.9f, 3.1f});

		Affectation a = new Affectation();
		a.setFG(v);
		a.setFD(c);


		PVirg pvTop = new PVirg();
		pvTop.setFG(a);


		PVirg pv2 = new PVirg();

		pvTop.setFD(pv2);


		v = new Variable( "y", new float[]{ 3.9f, 4.1f} );

		c = new Constante(new float[]{ 3.9f, 4.1f});

		a = new Affectation();
		a.setFG(v);
		a.setFD(c);

		pv2.setFG(a);

		PVirg pv3 = new PVirg();

		pv2.setFD(pv3);


		v = new Variable( "z", new float[]{ 6.9f, 7.1f} );

		Plus p = new Plus();

		c = new Constante(new float[]{ 2.9f, 3.1f});

		Variable v2 = new Variable( "y", new float[]{ 3.9f, 4.1f} );

		p.setFG(v2);
		p.setFD(c);


		a = new Affectation();
		a.setFG(v);
		a.setFD(p);

		pv3.setFG(a);

		//pv3.setFD(new Constante(new float[]{ 0f, 0f});
		pv3.setFD(null);




		CmdFormatter cmdf = new CmdFormatter();

		cmdf.toSSA(pvTop);

		System.out.println("pvTop: " + pvTop);

	}

}
