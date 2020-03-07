package udemy_excessoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
	
	public static void main(String[] args) {
		
		metodo1();
		
		System.out.println("Fim do Programa");
	}
	
	public static void metodo1() {
		System.out.println("**Metodo1 Start");
		metodo2();
		System.out.println("**Metodo1 Fim");
	}
	
	public static void metodo2() {
		System.out.println("**Metodo2 - Start**");
		Scanner sc = new Scanner(System.in);
		
		try {
			String[] vetor = sc.nextLine().split(" ");
			int posicao = sc.nextInt();
			System.out.println(vetor[posicao]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Posicao invalida");
			e.printStackTrace();
			sc.next();
		} catch (InputMismatchException e) {
			System.out.println("Erro na entrada");
		}
		
		sc.close();
		System.out.println("**Metod2 - Fim**");
	}

}
