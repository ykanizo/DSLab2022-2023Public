import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public abstract class MatrixTest<T> {

	private MatrixFactory<T> matrixFactory = new MatrixFactory<T>();

	/**
	 * @return a new instance of parameter T. Two instances which are created by
	 *         this method should be different according to "equals" method. For
	 *         example for T=Object, the implementation can be "return new
	 *         Object();".
	 */
	public abstract T getParameterInstance();

	// TODO - add your implementation here.
	// For getting an instance of T, you can use getParameterInstance() method.
	// For getting an instance of Matrix<T> you must use one of the two methods in
	// MatrixFactory<T>.

}
