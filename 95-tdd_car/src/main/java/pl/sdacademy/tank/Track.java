package pl.sdacademy.tank;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter

public class Track {

	@Getter
	private List<Car> cars;

	public Track() {
		cars = new ArrayList<>();
		//		cars.add(new Car(TypeCar.DIESEL));
		//		cars.add(new Car(TypeCar.ELECTRIC));
		//		cars.add(new Car(TypeCar.PETROL));
	}

	int i = 0;
	int round = 0;

	public void driveOneRound(Car car) {
		round++;
		car.setTires(car.getTires()+3);
		car.setCarDirt(car.getCarDirt()+2);
		car.setCurrentFuelLevel(car.getCurrentFuelLevel()-7);
	}

	public void driveRace(int numberOfRounds) {
		for (int j = 0; j < numberOfRounds; j++) {
			driveOneRound(cars.get(i));
		}
	}

	public void addCar(Car car) {
		cars.add(car);
	}
}