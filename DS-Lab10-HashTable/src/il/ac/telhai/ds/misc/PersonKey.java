package il.ac.telhai.ds.misc;
public class PersonKey {
	private String id;
	private String lastName;

	public PersonKey(String id, String lastName) {
		super();
		this.id = id;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "PersonKey [id=" + id + ", lastName=" + lastName + "]";
	}

}