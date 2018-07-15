package pl.sdacademy.mediator;

public class PrzykładoweUżycieMediatora {
	public static void main(String[] args) {
		Kolega adam = new Kolega("Adam");
		Kolega piotr = new Kolega("Piotr");
		Kolega kasia = new Kolega("Kasia");

		Mediator m =new RzeczywistyMediator();
		m.zarejestrujKolege(adam);
		m.zarejestrujKolege(piotr);
		m.zarejestrujKolege(kasia);

		kasia.wyslij("Piotr", "Hello world");
		adam.wyslij("Kasia", "Witaj");
	}
}
