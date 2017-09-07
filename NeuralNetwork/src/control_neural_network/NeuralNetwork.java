package control_neural_network;

import org.jblas.DoubleMatrix;
import org.junit.Assert;

import entity.Delta;
import entity.Derivation;
import entity.Theta;

public class NeuralNetwork {

	private DoubleMatrix[] theta;
	private int iterations;

	public NeuralNetwork(int numberOfLayers, int[] unitsPerLayer, int iterations) {
		this.theta = Theta.theta(numberOfLayers, unitsPerLayer);
		this.iterations = iterations;
	}

	public void train(DoubleMatrix X, DoubleMatrix Y) {
		Assert.assertTrue(X.rows == Y.rows);
		for (int i = 0; i < iterations; i++) {
			DoubleMatrix[] delta = calculateDelta(X, Y);
			DoubleMatrix[] D = Derivation.derivate(delta, theta, 0.0, Y.length);
			theta = Theta.update(theta, D);
		}
	}

	private DoubleMatrix[] calculateDelta(DoubleMatrix X, DoubleMatrix Y) {
		DoubleMatrix[] delta = Delta.getInstance(theta, Y.length);
		for (int j = 0; j < Y.length; j++) {
			DoubleMatrix[] A = FowardPropagation.propagate(X.getRow(j), theta);
			DoubleMatrix error = BackPropagation.propagate(A, Y.getRow(j), theta);
			delta = Delta.update(delta, A, error);
		}
		return delta;
	}

	public double[] predict(DoubleMatrix X) {
		DoubleMatrix[] propagate = FowardPropagation.propagate(X, theta);
		DoubleMatrix p = propagate[propagate.length - 1];
		return p.data;
	}
}
