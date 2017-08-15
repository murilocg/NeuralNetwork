package entity.util;

import org.jblas.DoubleMatrix;
import org.junit.Assert;

public class Theta {

	private DoubleMatrix[] theta;

	public Theta(int numberOfLayers, int[] unitsPerLayer) {

		Assert.assertTrue(numberOfLayers == unitsPerLayer.length);

		theta = new DoubleMatrix[numberOfLayers];
		int n = 0;
		int m = 0;
		DoubleMatrix iTheta = null;
		for (int i = 0; i < numberOfLayers - 1; i++) {
			m = unitsPerLayer[i] + 1;
			n = unitsPerLayer[i + 1] + 1;
			iTheta = DoubleMatrix.zeros(m, n);
			theta[i] = iTheta;
		}
	}

	public DoubleMatrix get(int i) {
		Assert.assertTrue(i < theta.length);
		return theta[i];
	}

	public int size() {
		return theta.length;
	}
}
