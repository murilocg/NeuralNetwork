package entity.util;

import org.jblas.DoubleMatrix;

public class Delta {

	public static DoubleMatrix[] getInstance(DoubleMatrix[] theta, int sizeTrainingSet) {
		int layers = theta.length;
		DoubleMatrix[] delta = new DoubleMatrix[layers];
		for (int l = 0; l < layers; l++) {
			delta[l] = DoubleMatrix.zeros(sizeTrainingSet, theta[l].rows);
		}
		return delta;
	}

	public static DoubleMatrix[] update(DoubleMatrix[] delta, DoubleMatrix[] a, DoubleMatrix error) {
		for (int l = 0; l < a.length; l++) {
			DoubleMatrix d = delta[l];
			DoubleMatrix mmul = error.getRow(l + 1).mmul(a[l].transpose());
			d.addi(mmul);
			delta[l] = d;
		}
		return delta;
	}
}
