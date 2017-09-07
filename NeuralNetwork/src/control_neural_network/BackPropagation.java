package control_neural_network;

import org.jblas.DoubleMatrix;

class BackPropagation {

	public static DoubleMatrix propagate(DoubleMatrix[] A, DoubleMatrix y, DoubleMatrix[] theta) {
		int layers = A.length;
		DoubleMatrix error = DoubleMatrix.zeros(layers, 1);
		error.putRow(layers - 1, A[layers - 1].dup().subi(y));
		return propagate(A, theta, error, layers, layers - 2);
	}

	private static DoubleMatrix propagate(DoubleMatrix[] A, DoubleMatrix[] theta, DoubleMatrix error, int layers,
			int l) {
		if (l == 0)
			return error;
		DoubleMatrix i_theta = theta[l].transpose();
		DoubleMatrix i_error = error.getRow(l + 1);
		DoubleMatrix ia = A[l];
		DoubleMatrix mmul = i_theta.mmul(i_error);
		mmul.mmuli(ia);
		DoubleMatrix ones = DoubleMatrix.ones(ia.rows, ia.columns);
		ones.subi(ia);
		error.putRow(l, mmul.mmuli(ones));
		return propagate(A, theta, error, layers, l - 1);
	}
}
