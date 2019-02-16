package chains;

import java.util.Comparator;

class A implements Comparator<Object> {
	public void foo() {
		System.out.println("A.foo");
	}

	public int compare(Object o1, Object o2) {
		return 1;
	}
}


