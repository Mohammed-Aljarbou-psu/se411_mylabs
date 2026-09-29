package edu.psu.se411.lab07.config;

// Global configuration constants shared by all booking types.
public final class BookingConfig {

	private BookingConfig() {
	}

	public static final double EXTRA_LUGGAGE_RATE = 15.0; // per kg
	public static final double TRAIN_STANDARD_RATE = 0.15; // per km
	public static final double TRAIN_FIRST_CLASS_RATE = 0.35; // per km

	public static final double MIN_LUGGAGE_WEIGHT = 0;
	public static final double MAX_LUGGAGE_WEIGHT = 40;

	public static final double MIN_TRAIN_DISTANCE = 1;
	public static final double MAX_TRAIN_DISTANCE = 2000;

	public static final int MIN_RENTAL_DAYS = 1;
	public static final int MAX_RENTAL_DAYS = 30;
}
