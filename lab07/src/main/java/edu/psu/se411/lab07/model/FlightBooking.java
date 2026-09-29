package edu.psu.se411.lab07.model;

import java.time.LocalDate;

import edu.psu.se411.lab07.config.BookingConfig;
import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;

public class FlightBooking extends Booking {

	private final double basePrice;
	private Double luggageWeight; // entered later by the customer

	public FlightBooking(String bookingId, String customerName, LocalDate travelDate, String destinationCity,
			double basePrice) {
		super(bookingId, customerName, travelDate, destinationCity);
		this.basePrice = basePrice;
	}

	public void setLuggageWeight(double luggageWeight) throws InvalidArgumentException {
		if (luggageWeight < BookingConfig.MIN_LUGGAGE_WEIGHT || luggageWeight > BookingConfig.MAX_LUGGAGE_WEIGHT) {
			throw new InvalidArgumentException(
					"Luggage weight must be between " + BookingConfig.MIN_LUGGAGE_WEIGHT + " and "
							+ BookingConfig.MAX_LUGGAGE_WEIGHT + " kg, got: " + luggageWeight);
		}
		this.luggageWeight = luggageWeight;
	}

	@Override
	public double computeTotalPrice() throws MissingInformationException {
		if (luggageWeight == null) {
			throw new MissingInformationException("Luggage weight was not provided for booking " + getBookingId());
		}
		return basePrice + (luggageWeight * BookingConfig.EXTRA_LUGGAGE_RATE);
	}
}
