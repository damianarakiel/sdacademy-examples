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
		int amount = car.getMAX_FUEL_LEVEL() - car.getCurrentFuelLevel();
		car.setCurrentFuelLevel(car.getMAX_FUEL_LEVEL());
		return amount;

	}

	public int price(Car car, int amount) {
		return amount * pricing.get(car.getTypeCar());
	}

	public void washCar(Car car) {
		car.setCarDirt(0);
	}

	public void ifWashNeeded(Car car) {
		if (car.getCarDirt() >= 70) {
			washCar(car);
		}

	}

	public void ifFuelNeeded(Car car) {
		if (car.getCurrentFuelLevel() <= 12) {
			fullTank(car);
		}
	}
}