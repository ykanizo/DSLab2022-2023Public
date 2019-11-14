import org.junit.Before;

public abstract class ListTest<T> {

	private DListFactory<T> dListFactory = new DListFactory<T>();
	private List<T> dList;

	
	/**
	 * @return a new instance of parameter T. Two instances which are created by
	 *         this method should be different according to "equals" method. For
	 *         example for T=Object, the implementation can be "return new
	 *         Object();".
	 */
	public abstract T getParameterInstance();

	@Before
	public void setUp() throws Exception {
		dList = dListFactory.getDList();
		// TODO You can add your code here
	}
	
	// TODO You should add @Test methods here
	
}
