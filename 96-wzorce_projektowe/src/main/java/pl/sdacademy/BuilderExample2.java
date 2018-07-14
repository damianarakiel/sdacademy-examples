package pl.sdacademy;

class BuilderExample2 {
	public static void main(String[] args) {
		Pizza2 pizza = Pizza2.newBuilder()
			.withDough("cross")
			.withSauce("mild")
			.withTopping("ham")
			.build();

		System.out.println(pizza);}
}
