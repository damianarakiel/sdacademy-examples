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

//	public boolean ifServiceRealNeeded(Car car) {
//		return
// 			station.ifWashRealNeeded(car) ||
//			station.ifFuelRealNeeded(car) ||
//			vulcanizer.ifNewTiresRealNeeded(car);
//		}
//
//	public void pervormNeededServices(Car car) {
//		if( station.ifWashRealNeeded(car)) {
//			station.washCar(car);
// 		}
//		if( station.ifFuelRealNeeded(car)) {
//			station.fullTank(car);
//		}
//		if( vulcanizer.ifNewTiresRealNeeded(car)) {
//			vulcanizer.changeOfTires(car);
//		}
}