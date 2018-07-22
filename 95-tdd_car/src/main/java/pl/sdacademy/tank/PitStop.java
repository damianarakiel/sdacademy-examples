package pl.sdacademy.tank;

public class PitStop {

	Station station;
	Vulcanizer vulcanizer;

	public PitStop(Station station, Vulcanizer vulcanizer) {
		this.station = station;
		this.vulcanizer = vulcanizer;
	}

	public void ifServiceNeeded(Car car) {
		station.ifWashNeeded(car);
		station.ifFuelNeeded(car);
		vulcanizer.ifNewTiresNeeded(car);
	}


}