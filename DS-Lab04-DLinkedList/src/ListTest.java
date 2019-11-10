import org.junit.Before;

public abstract class ListTest<T> {

	private DListFactory<T> dlistFactory = new DListFactory<T>();
	private List<T> dList;

	@Before
	public void setUp() throws Exception {
		dList = dlistFactory.getDList();
	}

	
	/**
	 * @return a new instance of parameter T. 
	 * Two instances which are created by this method should be different according to "equals" method.
	 * For example for T=Object, the implementation may be "return new Object();". 
	 */
	public abstract T getParameterInstance();

}
