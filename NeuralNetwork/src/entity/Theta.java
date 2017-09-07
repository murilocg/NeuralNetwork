package entity;

import org.jblas.DoubleMatrix;
import org.junit.Assert;

public class Theta {

	public static DoubleMatrix[] theta(int numberOfLayers, int[] unitsPerLayer) {
		Assert.assertTrue(numberOfLayers == unitsPerLayer.length);

		DoubleMatrix[] theta = new DoubleMatrix[numberOfLayers];
		int columns = 0;
		int rows = 0;
		DoubleMatrix iTheta = null;
		for (int i = 0; i < numberOfLayers - 1; i++) {
			rows = unitsPerLayer[i] + 1;
			columns = unitsPerLayer[i + 1] + 1;
			iTheta = DoubleMatrix.zeros(rows, columns);
			theta[i] = iTheta;
		}
		return theta;
	}

	public static DoubleMatrix[] update(DoubleMatrix[] theta, DoubleMatrix[] correction) {
		for (int l = 0; l < correction.length; l++) {
			DoubleMatrix subi = theta[l].subi(correction[l]);
			theta[l] = subi;
		}
		return theta;
	}
}
