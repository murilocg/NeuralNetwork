package entity.util;

import org.jblas.DoubleMatrix;
import org.junit.Assert;

public class Theta {

	private DoubleMatrix[] theta;
	private int[] unitsInLayer;
	private int totalNumberLayer;

	public Theta(int totalNumberLayer, int[] unitsInLayer) {

		Assert.assertTrue(totalNumberLayer == unitsInLayer.length);

		this.unitsInLayer = unitsInLayer;
		this.totalNumberLayer = totalNumberLayer;
		theta = defaultTheta(this.totalNumberLayer, this.unitsInLayer);
	}

	private DoubleMatrix[] defaultTheta(int totalNumberLayer, int[] unitsInLayer) {
		DoubleMatrix[] theta = new DoubleMatrix[totalNumberLayer];
		int n = 0;
		int m = 0;
		DoubleMatrix iTheta = null;
		for (int i = 0; i < totalNumberLayer - 1; i++) {
			m = unitsInLayer[i] + 1;
			n = unitsInLayer[i + 1] + 1;
			iTheta = DoubleMatrix.zeros(m, n);
			theta[i] = iTheta;
		}
		return theta;
	}

	public DoubleMatrix get(int i) {
		Assert.assertTrue(i < theta.length);
		return theta[i];
	}

	public int size() {
		return theta.length;
	}

	public int[] getUnitsInLayer() {
		return unitsInLayer;
	}

	public int getTotalNumberLayer() {
		return this.totalNumberLayer;
	}

	public int getTotalNumberClasses() {
		return unitsInLayer[unitsInLayer.length - 1];
	}

	public DoubleMatrix[] asArray() {
		return theta;
	}
}
