package control.nn;

import org.jblas.DoubleMatrix;

import entity.util.activation_function.Sigmoid;

class FowardPropagation {

	public static DoubleMatrix[] propagate(DoubleMatrix x, DoubleMatrix[] theta) {
		int layers = theta.length;
		DoubleMatrix[] A = new DoubleMatrix[layers];
		A[0] = x;
		return propagate(A, theta, theta.length, 1);
	}

	private static DoubleMatrix[] propagate(DoubleMatrix[] A, DoubleMatrix[] theta, int layers, int l) {
		if (l == layers)
			return A;
		DoubleMatrix iTheta = theta[l - 1];
		DoubleMatrix z = A[l - 1].mmul(iTheta);
		A[l] = Sigmoid.sigmoid(z);
		return propagate(A, theta, layers, l + 1);
	}
}
