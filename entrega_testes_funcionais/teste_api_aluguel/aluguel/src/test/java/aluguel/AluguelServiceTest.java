package aluguel;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Test;

import aluguel.main.AluguelService;
import aluguel.model.Aluguel;
import aluguel.model.RespostaDto;

public class AluguelServiceTest {
	
	@Test
	public void testTenPercentegeDiscountGCJ() throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, 1);
		RespostaDto dto = service.get(aluguel);
		
		assertEquals(990d, dto.getValor_calculado(), 0);
	}
	
	@Test
	public void testFivePercentegeDiscountGCJ() throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, 6);
		RespostaDto dto = service.get(aluguel);
		
		assertEquals(1045d, dto.getValor_calculado(), 0);
	}
	
	@Test
	public void testNoDiscountGCJ() throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, 11);
		RespostaDto dto = service.get(aluguel);
		
		assertEquals(1100d, dto.getValor_calculado(), 0);
	}
	
	@Test
	public void testMinAdditionGCJ() throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, 16);
		RespostaDto dto = service.get(aluguel);
		
		assertEquals(1123.1d, dto.getValor_calculado(), 0);
	}
	
	@Test
	public void testMaxAdditionGCJ() throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, 30);
		RespostaDto dto = service.get(aluguel);
		
		assertEquals(1138.5d, dto.getValor_calculado(), 0);
	}
	
	@Test
	public void testInvalidValueGCJ() throws URISyntaxException {
		
		AluguelService service = new AluguelService();
		Aluguel aluguel = new Aluguel(1100d, 31);
		RespostaDto dto = service.get(aluguel);
		
		assertEquals(-1d, dto.getValor_calculado(), 0);
	}


}
