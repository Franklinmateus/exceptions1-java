package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainExcepition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(number, checkIn, checkOut);
			System.out.println("Reservation: " + reserva);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.println("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
		
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainExcepition e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
			
		sc.close();
	}

}
