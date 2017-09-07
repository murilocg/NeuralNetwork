package entity.util.cost_function;

import org.jblas.DoubleMatrix;

/* This class has the responsibility of calculate the following equation: 
 * λ / 2m * L-1∑l=1 sl∑i=1 sl+1∑j=1 (Θ(l)j,i)²
 * 
 *This equation aims to regularize the cost function. If we regularize the function
 *we prevent the overfitting.
 */
public class Regularization {

	public static double reg(DoubleMatrix[] theta, double lambda, int m) {
		double sum = 0;
		int L = theta.length;
		for (int l = 0; l < L - 1; l++) {
			int sl = theta[l].rows;
			DoubleMatrix iTheta = theta[l];
			for (int i = 0; i < sl; i++) {

				for (int j = 0; j < sl + 1; j++) {
					double t = iTheta.get(j, i);
					t = Math.pow(t, 2);
					sum += t;
				}
			}
		}
		return lambda * sum / (2 * m);
	}
}
