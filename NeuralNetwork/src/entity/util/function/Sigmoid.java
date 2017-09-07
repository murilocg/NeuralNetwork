package entity.util.function;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

public class Sigmoid {

	public static DoubleMatrix sigmoid(DoubleMatrix X) {
		DoubleMatrix matrix_z = X.dup().mmuli(-1);
		DoubleMatrix ones = DoubleMatrix.ones(matrix_z.rows, matrix_z.columns);
		ones.mmuli(Math.E);
		ones = MatrixFunctions.powi(ones, matrix_z);
		ones.addi(1);
		return  MatrixFunctions.powi(ones, -1);
	}
}
