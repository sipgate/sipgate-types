package com.sipgate.type.carrier;

public enum Carrier {
	NQ("D146", "nmsd"),
	UMBRA("D248", "umbrad"),
	PURPUR("D218", "purpurd"),
	UNKNOWN("", "");

	private String id;
	private String system;

	private Carrier(String id, String system) {
		this.id = id;
		this.system = system;
	}

	public String getId() {
		return id;
	}

	public String getSystem() {
		return system;
	}

	public static Carrier parseSystem(String carrier) {
		for (final Carrier currentCarrier : values()) {
			if (currentCarrier.getSystem().equalsIgnoreCase(carrier)) {
				return currentCarrier;
			}
		}

		return UNKNOWN;
	}

	public static Carrier parseCarrierId(String carrier) {
		for (final Carrier currentCarrier : values()) {
			if (currentCarrier.getId().equalsIgnoreCase(carrier)) {
				return currentCarrier;
			}
		}

		return UNKNOWN;
	}
}
