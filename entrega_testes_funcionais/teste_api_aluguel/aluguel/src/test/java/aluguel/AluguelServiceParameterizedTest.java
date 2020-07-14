package aluguel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import aluguel.main.AluguelService;
import aluguel.model.Aluguel;
import aluguel.model.RespostaDto;

public class AluguelServiceParameterizedTest {

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5 })
	public void testTenPercentegeDiscountGCJ(int dia) throws URISyntaxException {

		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, dia);
		RespostaDto dto = service.get(aluguel);

		assertEquals(990d, dto.getValor_calculado(), 0);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 6, 7, 8, 10 })
	public void testFivePercentegeDiscountGCJ(int dia) throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, dia);
		RespostaDto dto = service.get(aluguel);
		
		assertEquals(1045d, dto.getValor_calculado(), 0);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"11:1100", "12:1100", "13:1100", "14:1100"}, delimiter = ':')
	public void testNoDiscountGCJ(int dia, double valor) throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, dia);
		RespostaDto dto = service.get(aluguel);
		
		assertEquals(valor, dto.getValor_calculado(), 0);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/testAdditionGCJ.csv", delimiter = ',')
	public void testAdditionGCJ(int dia, double valor) throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, 16);
		RespostaDto dto = service.get(aluguel);
		
		assertEquals(1123.1d, dto.getValor_calculado(), 0);
	}
	
	
}
