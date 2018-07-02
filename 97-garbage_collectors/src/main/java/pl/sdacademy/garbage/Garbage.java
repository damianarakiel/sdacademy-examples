package pl.sdacademy.garbage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Garbage {

	final static BigDecimal VAT = BigDecimal.valueOf(0.23);


	public static void main(String[] args) throws InterruptedException {
		List<BigDecimal> kwotaNetto = new ArrayList<>();
		List<BigDecimal> kwotaBrutto = new ArrayList<>();

		for (int i =1;i>0;i++) {
			BigDecimal netto = BigDecimal.valueOf(i);
			BigDecimal vat = netto.multiply(VAT).setScale(2, RoundingMode.HALF_UP);
			Thread.sleep(0);
			kwotaNetto.add(netto);
			kwotaBrutto.add(vat);
		}
		System.out.println(kwotaNetto);
		System.out.println(kwotaBrutto);
	}
}