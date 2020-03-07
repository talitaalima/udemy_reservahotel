package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservas {
	private Integer NumeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
	    	throw new DomainException("A data de CheckOut tem que ser depois da data de CheckIn.");
	   }
		this.NumeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return NumeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		NumeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public void datasAtualizadas (Date checkIn, Date checkOut ) {
		
	  Date now = new Date(); //agora
	    if (checkIn.before(now) || checkOut.before(now)) {
	    	throw new DomainException("As datas de reserva devem ser datas futuras.");		    	
	    } 
	    if (!checkOut.after(checkIn)) {
	    	throw new DomainException("A data de CheckOut tem que ser depois da data de CheckIn.");
	   }
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+NumeroQuarto
				+", check-in: "
				+sdf.format(checkIn)
				+", check-out: "
				+sdf.format(checkOut)
				+", "
				+duracao()
				+" noites.";
	}
}
