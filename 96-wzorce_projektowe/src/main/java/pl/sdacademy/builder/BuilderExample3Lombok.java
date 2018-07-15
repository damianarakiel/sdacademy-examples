package pl.sdacademy.builder;

class BuilderExample3Lombok {
	public static void main(String[] args) {
		Pizza3Lombok pizza = Pizza3Lombok.newBuilder()
			.dough("cross")
			.sauce("mild")
			.topping("ham")
			.build();

		System.out.println(pizza);}
}
