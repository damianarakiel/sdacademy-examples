package pl.sdacademy.builder;

class BuilderExample {
	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		PizzaBuilder hawaiian_pizzaBuilder = new HawaiianPizzaBuilder();
		PizzaBuilder spicy_pizzaBuilder = new SpicyPizzaBuilder();

		waiter.setPizzaBuilder(hawaiian_pizzaBuilder);
		waiter.constructPizza();

		Pizza pizza = waiter.getPizza();
	}
}
