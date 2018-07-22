package pl.sdacademy.tank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
	@DisplayName("jakie paliwo używa nasz samochód")
	@Test
	void tankTest0() {
		//given
		Car electricCar = new Car(TypeCar.ELECTRIC);
		Car petrolCar = new Car(TypeCar.PETROL);
		Car dieselCar = new Car(TypeCar.DIESEL);
		//when

		//then
		assertThat(petrolCar).isNotNull();
		assertThat(dieselCar).isNotNull();
		assertThat(electricCar).isNotNull();
	}


}