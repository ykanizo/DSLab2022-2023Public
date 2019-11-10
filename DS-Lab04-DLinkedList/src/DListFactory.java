public class DListFactory<T> {

	private Class<T> TType;

	public List<T> getDList() {
		return new DLinkedList<T>();
	}

}
