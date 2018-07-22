package pl.sdacademy.tank;

public class Vulcanizer {

	public void changeOfTires(Car car){
		car.setTires(0);
	}

	public void ifNewTiresNeeded(Car car) {
		if (car.getTires() >= 85) {
			changeOfTires(car);
		}

	}
}