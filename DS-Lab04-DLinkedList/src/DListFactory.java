public class DListFactory<T> {

	public List<T> getDList()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> c = Class.forName("DLinkedList");
		@SuppressWarnings("unchecked")
		List<T> dlist = (List<T>) c.newInstance();
		return dlist;
	}

}
