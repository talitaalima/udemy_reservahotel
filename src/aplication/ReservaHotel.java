package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservas;

public class ReservaHotel {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do Quarto: ");
		int numero = sc.nextInt();
	    System.out.print("Data de check-In: ");
	    Date checkIn = sdf.parse(sc.next());
	    System.out.print("Data de check-Out: ");
	    Date checkOut = sdf.parse(sc.next());
	    
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na data de Reserva. A data de CheckOut tem que ser depois da data de CheckIn");
		} else {
			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
		
			System.out.println();
			System.out.println("Escreva a datas atualizadas da reserva:");
			
			System.out.print("Data de check-In: ");
		    checkIn = sdf.parse(sc.next());
		    System.out.print("Data de check-Out: ");
		    checkOut = sdf.parse(sc.next());
		
		    String error = reservas.datasAtualizadas(checkIn, checkOut);
		    if (error != null) {
		    	System.out.println("Erro na resrva: " + error);
		    } else {
		    	System.out.println("Reserva: " + reservas);
		    }
		}
	    
	    
		sc.close();		
	}

}
