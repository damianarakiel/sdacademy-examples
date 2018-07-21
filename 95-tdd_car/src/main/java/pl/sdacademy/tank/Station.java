package pl.sdacademy.tank;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Station {

	Map<TypeCar, Integer> pricing = new HashMap<>();

	public Station() {
		pricing.put(TypeCar.PETROL, 5);
		pricing.put(TypeCar.DIESEL, 4);
		pricing.put(TypeCar.ELECTRIC, 2);
	}

//	public Map<TypeCar, Integer> getPricing() {
//		return pricing;
//	}

	int fullTank(Car car) {
		int amount = car.getMaxLevel() - car.getCurrentLevel();
		car.setCurrentLevel(car.getMaxLevel());
		return amount;

	}

	public int price(Car car, int amount) {
		return amount * pricing.get(car.getTypeCar());
	}
}