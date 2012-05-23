package br.com.fiap.pool;

public class TestException {

	public static void main(String[] args) {
		perform();
	}

	public static void perform() {
		Object nullObj = null;
		nullObj.toString();
	}
}