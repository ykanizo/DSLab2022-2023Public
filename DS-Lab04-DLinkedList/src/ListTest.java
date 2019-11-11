import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public abstract class ListTest<T> {

	@Parameter
	public String listClassName;
	private DListFactory<T> dListFactory = new DListFactory<T>();
	private List<T> dList;

	@Parameterized.Parameters
	public static Iterable<String> classNames() {
		return DListFactory.getClassNames();
	}
	
	/**
	 * @return a new instance of parameter T. Two instances which are created by
	 *         this method should be different according to "equals" method. For
	 *         example for T=Object, the implementation can be "return new
	 *         Object();".
	 */
	public abstract T getParameterInstance();

	@Before
	public void setUp() throws Exception {
		dList = dListFactory.getDList(listClassName);
		// TODO You can add your code here
	}
	
	// TODO You should add @Test methods here
	
}
