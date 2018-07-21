package pl.sdacademy.tank;

import java.util.HashMap;
import java.util.Map;

public class Station {

	Map<TypeCar, Integer> cennik = new HashMap<>();

	public Station() {
		cennik.put(TypeCar.PETROL, 5);
		cennik.put(TypeCar.DIESEL, 4);
		cennik.put(TypeCar.ELECTRIC, 2);
	}

	public Map<TypeCar, Integer> getCennik() {
		return cennik;
	}

	int fullTank(Car car) {
		int amount = car.getMaxLevel() - car.getCurrentLevel();
		car.setCurrentLevel(car.getMaxLevel());
		return amount;

	}

	public int price(Car car, int amount) {
		return amount * cennik.get(car.getTypeCar());
	}
}