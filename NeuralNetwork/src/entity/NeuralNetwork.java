package entity;

import org.jblas.DoubleMatrix;

import entity.util.Sigmoid;
import entity.util.Theta;

public class NeuralNetwork {

	private Theta theta;

	public NeuralNetwork(Theta theta) {
		this.theta = theta;
	}

	public double[] predict(DoubleMatrix X) {
		X = DoubleMatrix.concatHorizontally(DoubleMatrix.ones(X.rows, 1), X);
		DoubleMatrix p = foward(X.transpose(), 0);
		return p.data;
	}

	private DoubleMatrix foward(DoubleMatrix x, int i) {
		if (i == theta.size())
			return x;
		DoubleMatrix iTheta = null;
		DoubleMatrix a = x;
		if (i - 1 > 0) {
			iTheta = theta.get(i - 1);
			DoubleMatrix z = x.mmul(iTheta);
			a = Sigmoid.sigmoid(z);
		}
		return foward(a, i + 1);
	}
}
