package il.ac.telhai.ds.trees;

public class BinaryTree<T> implements BinaryTreeI<T> {
	private T value;
	private BinaryTreeI<T> left;
	private BinaryTreeI<T> right;

	public BinaryTree(T value) {
		this.value = value;
	}

	public BinaryTree(T value, BinaryTreeI<T> left, BinaryTreeI<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeI<T> getLeft() {
		return left;
	}

	public BinaryTreeI<T> getRight() {
		return right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setLeft(BinaryTreeI<T> left) {
		this.left = left;
	}

	public void setRight(BinaryTreeI<T> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return getLeft() == null && getRight() == null;
	}

	public int height() {
		if (isLeaf())
			return 0;
		int heightLeft = 0;
		int heightRight = 0;
		if (getLeft() != null)
			heightLeft = getLeft().height();
		if (getRight() != null)
			heightRight = getRight().height();
		return 1 + Math.max(heightLeft, heightRight);
	}

	public int size() {
		int size = 1;
		if (getLeft() != null)
			size += getLeft().size();
		if (getRight() != null)
			size += getRight().size();
		return size;
	}

	public void clear() {
		setLeft(null);
		setRight(null);
	}

	public String preOrder() {
		return preOrder(" ", " ");
	}

	public String preOrder(String separationBeforeVal, String separationAfterVal) {
		StringBuilder sb = new StringBuilder();
		printValue(separationBeforeVal, separationAfterVal, sb);
		if (getLeft() != null) {
			sb.append(getLeft().preOrder(separationBeforeVal, separationAfterVal));
		}
		if (getRight() != null) {
			sb.append(getRight().preOrder(separationBeforeVal, separationAfterVal));
		}
		return sb.toString();
	}

	public String postOrder() {
		return postOrder(" ", " ");
	}

	public String postOrder(String separationBeforeVal, String separationAfterVal) {
		StringBuilder sb = new StringBuilder();
		if (getLeft() != null) {
			sb.append(getLeft().postOrder(separationBeforeVal, separationAfterVal));
		}
		if (getRight() != null) {
			sb.append(getRight().postOrder(separationBeforeVal, separationAfterVal));
		}
		printValue(separationBeforeVal, separationAfterVal, sb);
		return sb.toString();
	}

	public String inOrder() {
		return inOrder(" ", " ");
	}

	public String inOrder(String separationBeforeVal, String separationAfterVal) {
		StringBuilder sb = new StringBuilder();
		if (getLeft() != null) {
			sb.append(getLeft().inOrder(separationBeforeVal, separationAfterVal));
		}
		printValue(separationBeforeVal, separationAfterVal, sb);
		if (getRight() != null) {
			sb.append(getRight().inOrder(separationBeforeVal, separationAfterVal));
		}
		return sb.toString();
	}


	private void printValue(String separationBeforeVal, String separationAfterVal, StringBuilder sb) {
		sb.append(separationBeforeVal);
		sb.append(getValue());
		sb.append(separationAfterVal);
	}

}
