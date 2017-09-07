package control.cost_function;

import org.jblas.DoubleMatrix;

import entity.util.cost_function.PartialDerivation;
import entity.util.cost_function.Regularization;

/*
 * This class has the responsibility of calculate the following equation: 
 * J(Θ)=−1/m * m∑i=1 K∑k=1 [y(i)k log( (hΘ( x(i) ))k ) + (1 − y(i)k ) log(1 − (
 * hΘ( x(i) ))k )] + λ / 2m * L-1∑l=1 sl∑i=1 sl+1∑j=1 (Θ(l)j,i)^2
 * 
 * This equation aims to measure the accuracy of the neural network. Verifying if
 * the neural network is converging to a minimal.
 */
public class CostFunction {

	public static double cost(DoubleMatrix X, DoubleMatrix Y, DoubleMatrix[] theta, double lambda) {
		int m = Y.length;
		int classes = theta[theta.length - 1].rows - 1;
		double partialDerivation = PartialDerivation.derive(X, Y, classes, m);
		double reg = Regularization.reg(theta, lambda, m);
		return partialDerivation + reg;
	}
}
