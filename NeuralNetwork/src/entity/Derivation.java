package entity;

import org.jblas.DoubleMatrix;

public class Derivation {

	public static DoubleMatrix[] derivate(DoubleMatrix[] data, DoubleMatrix[] theta, double alpha, int m) {
		DoubleMatrix[] D = new DoubleMatrix[data.length];
		D[0] = data[0].divi(m);
		for (int l = 1; l < data.length; l++) {
			DoubleMatrix divi = data[l].divi(m);
			DoubleMatrix mmuli = theta[l].mmuli(alpha);
			D[l] = divi.addi(mmuli);
		}
		return D;
	}
}
