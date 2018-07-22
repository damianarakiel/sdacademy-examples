package pl.sdacademy.tank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VulcanizerTest {
	@DisplayName("Chcemy mieć możliowść wymiany opon na nowe")
	@Test
	void vulcanizerTest01() {
		//given
		Car car = new Car(TypeCar.DIESEL);
		Vulcanizer vulcanizer = new Vulcanizer();
		car.setTires(50);
		//when
		vulcanizer.changeOfTires(car);
		//then
		assertThat(car.getTires()).isEqualTo(0);
	}
}