package edu.psu.se411.lab07.model;

import java.time.LocalDate;

import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;

// Common data and contract shared by every transportation booking type.
public abstract class Booking {

	private final String bookingId;
	private final String customerName;
	private final LocalDate travelDate;
	private final String destinationCity;

	protected Booking(String bookingId, String customerName, LocalDate travelDate, String destinationCity) {
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.travelDate = travelDate;
		this.destinationCity = destinationCity;
	}

	// Each booking type computes its own total price, hence the polymorphism.
	public abstract double computeTotalPrice() throws MissingInformationException, InvalidArgumentException;

	public String getBookingId() {
		return bookingId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	@Override
	public String toString() {
		return String.format("%s[id=%s, customer=%s, date=%s, destination=%s]",
				getClass().getSimpleName(), bookingId, customerName, travelDate, destinationCity);
	}
}
