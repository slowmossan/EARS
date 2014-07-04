package org.um.feri.ears.problems.unconstrained.cec2009;

import java.util.ArrayList;

import org.um.feri.ears.problems.moo.MOIndividual;
import org.um.feri.ears.problems.moo.MOProblem;
import org.um.feri.ears.problems.moo.functions.UP1_F2_1;
import org.um.feri.ears.problems.moo.functions.UP1_F2_2;


public class UnconstrainedProblem1 extends MOProblem {
    

	public UnconstrainedProblem1() {
		this(30); // 30 variables by default
	} // CEC2009_UF1
	 
	  public UnconstrainedProblem1(Integer numberOfVariables) {
		dim  = numberOfVariables;
		numberOfObjectives =  2;
		numberOfConstraints =  0;

		file_name = "UF1";
		name = "CEC2009 Unconstrained Problem 01";
		
		interval = new double[numberOfVariables];
		intervalL = new double[numberOfVariables];

		intervalL[0] = 0.0 ;
		interval[0] = 1.0 ;
	     for (int var = 1; var < numberOfVariables; var++){
	    	 intervalL[var] = -1.0;
	    	 interval[var] = 1.0;
	     }

	     this.addProblem(new UP1_F2_1(dim));
	     this.addProblem(new UP1_F2_2(dim));
	  }
	    
	  /** 
	   * Evaluates a solution.
	   * @param solution The solution to evaluate.
	   * @throws JMException 
	   */
	  public void evaluate(MOIndividual solution) {
	    double[] decisionVariables  = solution.getX();
	    
	    double [] x = new double[dim];
	    for (int i = 0; i < dim; i++)
	      x[i] = decisionVariables[i];

	    double obj[] =new double [functions.size()];
        for (int i=0; i<obj.length; i++) {
        	obj[i] = functions.get(i).eval(x);
        }
        solution.setEval(obj);
	  }

	@Override
	public double eval(double[] ds) {
		// TODO Auto-generated method stub
		return 0;
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
}