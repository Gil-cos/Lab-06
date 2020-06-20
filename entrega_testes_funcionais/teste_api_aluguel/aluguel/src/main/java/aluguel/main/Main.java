package aluguel.main;

import java.net.URISyntaxException;
import java.util.Scanner;

import aluguel.model.Aluguel;
import aluguel.model.RespostaDto;

public class Main {

	public static void main(String[] args) throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Gilberto Costa Junior");
		System.out.println("\nEsta aplicação esta consumindo a API Web disponibilizada em https://aluguebug.herokuapp.com");

	    System.out.println("\nDigite o valor do aluguel: ");
	    Double valor_nominal = scanner.nextDouble();

	    System.out.println("\nDigite o numero de dias: ");
	    Integer dia = scanner.nextInt();
	    
	    Aluguel aluguel = new Aluguel(valor_nominal, dia);
	    
	    RespostaDto respostaDto = service.get(aluguel);

	    System.out.println("Resultado: R$" + respostaDto.getValor_calculado());

	}

}
