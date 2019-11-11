import java.util.ArrayList;

public class DListFactory<T> {

	public List<T> getDList(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> c = Class.forName(className);
		List<T> dlist = (List<T>) c.newInstance();
		return dlist;
	}

	public static Iterable<String> getClassNames() {
		ArrayList<String> result = new ArrayList<String>();
		result.add("DLinkedList");
		return result;
	}

}
