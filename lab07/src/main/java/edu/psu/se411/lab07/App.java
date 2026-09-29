package edu.psu.se411.lab07;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;
import edu.psu.se411.lab07.model.Booking;
import edu.psu.se411.lab07.model.CarRentalBooking;
import edu.psu.se411.lab07.model.FlightBooking;
import edu.psu.se411.lab07.model.TrainBooking;
import edu.psu.se411.lab07.model.TrainBooking.SeatClass;

public class App {

	static Logger logger = LoggerFactory.getLogger(App.class);

	// Works for any booking type thanks to polymorphism.
	public static double computeTotalPrice(Booking booking) throws MissingInformationException,
			InvalidArgumentException {
		return booking.computeTotalPrice();
	}

	public static void main(String[] args) {
		logger.info("Application is starting...");

		FlightBooking flight = new FlightBooking("FL-1", "Ali Hassan", LocalDate.now().plusDays(10), "Dubai", 500);
		TrainBooking train = new TrainBooking("TR-1", "Sara Omar", LocalDate.now().plusDays(5), "Riyadh",
				SeatClass.FIRST_CLASS);
		CarRentalBooking car = new CarRentalBooking("CR-1", "Omar Fahad", LocalDate.now().plusDays(2), "Jeddah", 120);

		Booking[] bookings = { flight, train, car };

		try {
			flight.setLuggageWeight(15);
			train.setDistanceKm(450);
			car.setRentalDays(4);
		} catch (InvalidArgumentException e) {
			logger.error("Invalid booking argument", e);
		}

		for (Booking booking : bookings) {
			try {
				double price = computeTotalPrice(booking);
				System.out.printf("%s -> total price: %.2f%n", booking, price);
			} catch (MissingInformationException | InvalidArgumentException e) {
				logger.error("Failed to compute price for " + booking, e);
				System.out.println("Exception caught: " + e.getMessage());
			}
		}

		// Demonstrate the exception paths explicitly.
		FlightBooking incompleteFlight = new FlightBooking("FL-2", "Lina Nasser", LocalDate.now(), "Cairo", 300);
		try {
			computeTotalPrice(incompleteFlight);
		} catch (MissingInformationException | InvalidArgumentException e) {
			logger.error("Failed to compute price for " + incompleteFlight, e);
			System.out.println("Exception caught: " + e.getMessage());
		}

		try {
			flight.setLuggageWeight(100);
		} catch (InvalidArgumentException e) {
			logger.error("Invalid luggage weight", e);
			System.out.println("Exception caught: " + e.getMessage());
		}

		logger.info("Application is ending...");
	}
}
