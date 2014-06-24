package org.um.feri.ears.problems.unconstrained.cec2010;


import java.util.Arrays;
import java.util.Random;

import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.RandomMatrices;
import org.um.feri.ears.problems.Problem;
import org.um.feri.ears.problems.unconstrained.cec2010.base.EllipticRotated;
import org.um.feri.ears.problems.unconstrained.cec2010.base.EllipticShifted;

/**
 * Problem function!
 * 
 * @author Niki Vecek
 * @version 1
 * 
 **/

public class F9 extends Problem {
	
	int[] P;
	int m;
	public double[][] rot_matrix;
	EllipticShifted elliptic_shifted;
	EllipticRotated elliptic_rotated;
	
	// F9 CEC 2010
	// D/2m-group Shifted and m-rotated Elliptic Function
	public F9(int d) {
		dim = d;
		elliptic_shifted = new EllipticShifted(dim);
		elliptic_rotated= new EllipticRotated(dim);
		interval = new double[d];
		intervalL = new double[d];
		Arrays.fill(interval, 200);
		Arrays.fill(intervalL, -100);
		name = "F09 D/2m-group Shifted and m-rotated Elliptic Function";
		
		P = new int[dim];
		Random rand = new Random();
		int rand_place = 0;
		for (int i=dim-1; i>0; i--){
			rand_place = rand.nextInt(dim);
			P[i] = rand_place;			
		}
		
		m = 2;
		
		rot_matrix = new double[m][m];
		
		Random rand1 = new Random();
		DenseMatrix64F A = RandomMatrices.createOrthogonal(m, m, rand1);
		
		for (int i=0; i<m; i++){
			for (int j=0; j<m; j++){
				rot_matrix[i][j] = A.get(i, j);
			}
		}
	}
	
	public double eval(double x[]) {
		double F = 0;
		for (int k=0; k<dim/(2*m); k++){
			F = F + elliptic_rotated.eval(x,P,k*m+1,(k+1)*m, rot_matrix);
		}
		F = F + elliptic_shifted.eval(x,P,dim/2,dim);
		return F;
	}

	public double getOptimumEval() {
		return 0;
	}

	@Override
	public boolean isFirstBetter(double[] x, double eval_x, double[] y,
			double eval_y) {
		return eval_x < eval_y;
	}

}