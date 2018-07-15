package pl.sdacademy.mediator;

import java.util.HashMap;
import java.util.Map;

public class RzeczywistyMediator implements Mediator {
	private Map<String, Kolega> koledzy = new HashMap<String, Kolega>();

	public void zarejestrujKolege(Kolega k){
		k.zarejestrujMediatora(this);
		koledzy.put(k.getId(), k);
	}

	public void wyslij(String id, String wiadomosc) {
		koledzy.get(id).odbierz(wiadomosc);
	}
}
