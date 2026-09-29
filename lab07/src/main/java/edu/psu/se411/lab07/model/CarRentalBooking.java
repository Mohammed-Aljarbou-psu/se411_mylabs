package edu.psu.se411.lab07.model;

import java.time.LocalDate;

import edu.psu.se411.lab07.config.BookingConfig;
import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;

public class CarRentalBooking extends Booking {

	private final double dailyRate;
	private Integer rentalDays; // entered later by the customer

	public CarRentalBooking(String bookingId, String customerName, LocalDate travelDate, String destinationCity,
			double dailyRate) {
		super(bookingId, customerName, travelDate, destinationCity);
		this.dailyRate = dailyRate;
	}

	public void setRentalDays(int rentalDays) throws InvalidArgumentException {
		if (rentalDays < BookingConfig.MIN_RENTAL_DAYS || rentalDays > BookingConfig.MAX_RENTAL_DAYS) {
			throw new InvalidArgumentException(
					"Number of days must be between " + BookingConfig.MIN_RENTAL_DAYS + " and "
							+ BookingConfig.MAX_RENTAL_DAYS + ", got: " + rentalDays);
		}
		this.rentalDays = rentalDays;
	}

	@Override
	public double computeTotalPrice() throws MissingInformationException {
		if (rentalDays == null) {
			throw new MissingInformationException("Number of rental days was not provided for booking "
					+ getBookingId());
		}
		return dailyRate * rentalDays;
	}
}
