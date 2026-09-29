package edu.psu.se411.lab07.model;

import java.time.LocalDate;

import edu.psu.se411.lab07.config.BookingConfig;
import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;

public class TrainBooking extends Booking {

	public enum SeatClass {
		STANDARD, FIRST_CLASS
	}

	private final SeatClass seatClass;
	private Double distanceKm; // entered later by the system

	public TrainBooking(String bookingId, String customerName, LocalDate travelDate, String destinationCity,
			SeatClass seatClass) {
		super(bookingId, customerName, travelDate, destinationCity);
		this.seatClass = seatClass;
	}

	public void setDistanceKm(double distanceKm) throws InvalidArgumentException {
		if (distanceKm < BookingConfig.MIN_TRAIN_DISTANCE || distanceKm > BookingConfig.MAX_TRAIN_DISTANCE) {
			throw new InvalidArgumentException(
					"Distance must be between " + BookingConfig.MIN_TRAIN_DISTANCE + " and "
							+ BookingConfig.MAX_TRAIN_DISTANCE + " km, got: " + distanceKm);
		}
		this.distanceKm = distanceKm;
	}

	@Override
	public double computeTotalPrice() throws MissingInformationException {
		if (distanceKm == null) {
			throw new MissingInformationException("Distance was not provided for booking " + getBookingId());
		}
		double rate = seatClass == SeatClass.FIRST_CLASS
				? BookingConfig.TRAIN_FIRST_CLASS_RATE
				: BookingConfig.TRAIN_STANDARD_RATE;
		return distanceKm * rate;
	}
}
