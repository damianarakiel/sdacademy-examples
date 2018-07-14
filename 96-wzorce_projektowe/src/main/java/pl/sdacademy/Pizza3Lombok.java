package pl.sdacademy;

import lombok.Builder;
import lombok.ToString;

@Builder(builderMethodName = "newBuilder")
@ToString
public class Pizza3Lombok {
	String dough = "";
	private String sauce = "";
	private String topping = "";
}