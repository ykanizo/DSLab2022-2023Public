package il.ac.telhai.ds.misc;
public class PersonKey implements Comparable<PersonKey> {
	private String id;
	private String lastName;

	public PersonKey(String id, String lastName) {
		super();
		this.id = id;
		this.lastName = lastName;
	}

	@Override
	public int compareTo(PersonKey other) {
		int ret = lastName.compareTo(other.lastName);
		return ret != 0 ? ret : id.compareTo(other.id);
	}


	@Override
	public String toString() {
		return "PersonKey [id=" + id + ", lastName=" + lastName + "]";
	}

}