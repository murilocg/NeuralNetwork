package entity.util.cost_function;

import org.jblas.DoubleMatrix;

import entity.util.Sigmoid;

/*
 * This class has the responsibility of calculate the following equation: 
 * p1 = m∑i=1 K∑k=1 [y(i)k log( (hΘ( x(i) ))k )
 * 
 * +
 * 
 * p2 = (1 − y(i)k ) log(1 − ( hΘ( x(i) ))k )]
 * 
 * -(p1 + p2) / m
 * 
 * This equation is the base to the cost function.
 */
public class PartialDerivation {

	public static double derive(DoubleMatrix X, DoubleMatrix Y, int K, int m) {
		double sum = 0;
		for (int i = 0; i < m; i++) {
			DoubleMatrix y = Y.getRow(i);
			DoubleMatrix x = X.getRow(i);
			DoubleMatrix sigmoid_x = Sigmoid.sigmoid(x);
			for (int k = 0; k < K; k++) {
				/*
				 * p1 = y(i)k log( (hΘ( x(i) ))k )
				 */
				double p1 = y.get(k) * Math.log(sigmoid_x.get(k) / Math.log(2));
				/*
				 * p2 = (1 − y(i)k ) log(1 − ( hΘ( x(i) ))k )
				 */
				double p2 = (1 - y.get(k)) * Math.log(1 - sigmoid_x.get(k)) / Math.log(2);

				sum += (p1 + p2);
			}
		}

		return -sum / m;
	}
}
