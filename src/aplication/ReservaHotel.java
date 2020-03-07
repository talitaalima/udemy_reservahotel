package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservas;
import model.exceptions.DomainException;

public class ReservaHotel {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
			System.out.print("Número do Quarto: ");
			int numero = sc.nextInt();
		    System.out.print("Data de check-In: ");
		    Date checkIn = sdf.parse(sc.next());
		    System.out.print("Data de check-Out: ");
		    Date checkOut = sdf.parse(sc.next());
		    
			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
		
			System.out.println();
			System.out.println("Escreva a datas atualizadas da reserva:");
			
			System.out.print("Data de check-In: ");
		    checkIn = sdf.parse(sc.next());
		    System.out.print("Data de check-Out: ");
		    checkOut = sdf.parse(sc.next());
		
		    reservas.datasAtualizadas(checkIn, checkOut);
		   	System.out.println("Reserva: " + reservas);
		} catch(ParseException e) {
			System.out.println("Data inválida");			
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro Inesperado!");
		}
	    
		sc.close();		
	}

}
