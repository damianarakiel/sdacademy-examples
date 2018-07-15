package pl.sdacademy.stan;

class StateContext {
	private Statelike myState;
	StateContext() {
		setState(new StateLowerCase());
	}

	void setState(final Statelike newState) {
		myState = newState;
	}

	public void writeName(final String name) {
		myState.writeName(this, name);
	}
}
