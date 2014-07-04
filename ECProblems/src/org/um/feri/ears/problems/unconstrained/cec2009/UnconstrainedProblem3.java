package org.um.feri.ears.problems.unconstrained.cec2009;

import org.um.feri.ears.problems.moo.MOIndividual;
import org.um.feri.ears.problems.moo.MOProblem;
import org.um.feri.ears.problems.moo.functions.UP1_F2_1;
import org.um.feri.ears.problems.moo.functions.UP1_F2_2;
import org.um.feri.ears.problems.moo.functions.UP2_F5_1;
import org.um.feri.ears.problems.moo.functions.UP2_F5_2;
import org.um.feri.ears.problems.moo.functions.UP3_1;
import org.um.feri.ears.problems.moo.functions.UP3_2;




public class UnconstrainedProblem3 extends MOProblem {

	 /**
	  * Constructor.
	  * Creates a default instance of problem CEC2009_UF2 (30 decision variables)
	  * @param solutionType The solution type must "Real" or "BinaryReal".
	  */
	  public UnconstrainedProblem3() {
	    this(30); // 30 variables by default
	  } // CEC2009_UF2

	 /**
	  * Creates a new instance of problem CEC2009_UF2.
	  * @param numberOfVariables Number of variables.
	  * @param solutionType The solution type must "Real" or "BinaryReal".
	  */
	  public UnconstrainedProblem3(Integer numberOfVariables) {
	    dim  = numberOfVariables;
	    numberOfObjectives =  2;
	    numberOfConstraints=  0;
	    
	    name = "CEC2009 Unconstrained Problem 03";
	    file_name = "UF3";
	    
		interval = new double[numberOfVariables];
		intervalL = new double[numberOfVariables];

		for (int var = 0; var < numberOfVariables; var++) {
			intervalL[var] = 0.0;
			interval[var] = 1.0;
		}

		this.addProblem(new UP3_1(dim));
		this.addProblem(new UP3_2(dim));

	  }

	  /**
	   * Evaluates a solution.
	   * @param solution The solution to evaluate.
	   * @throws JMException
	   */
	public void evaluate(MOIndividual solution) {
		double[] decisionVariables = solution.getX();

		double[] x = new double[dim];
		for (int i = 0; i < dim; i++)
			x[i] = decisionVariables[i];
		
		double obj[] =new double [functions.size()];
        for (int i=0; i<obj.length; i++) {
        	obj[i] = functions.get(i).eval(x);
        }
        solution.setEval(obj);

	}

	@Override
	public double[] evaluate(double[] ds) {
		
		double[] x = new double[dim];
		for (int i = 0; i < dim; i++)
			x[i] = ds[i];

		double obj[] =new double [functions.size()];
        for (int i=0; i<obj.length; i++) {
        	obj[i] = functions.get(i).eval(x);
        }
        return obj;
	}

	@Override
	public double eval(double[] ds) {
		// TODO Auto-generated method stub
		return 0;
	}
}
