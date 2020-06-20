package aluguel.main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import aluguel.model.Aluguel;
import aluguel.model.RespostaDto;

public class AluguelService {
	
	public RespostaDto get(Aluguel aluguel) throws URISyntaxException {

		Gson gson = new Gson();
		String resposta = null;
		RespostaDto respostaDto = null;
		
		HttpClient httpClient = HttpClients.createDefault();
		URI uri = new URIBuilder()
		          .setScheme("https")
		          .setHost("aluguebug.herokuapp.com")
		          .setPath("/calc")
		          .addParameter("dados",  gson.toJson(aluguel))
		          .build();
		
		HttpGet httpGet = new HttpGet(uri);
		httpGet.addHeader("accept", "application/json");
		httpGet.addHeader("custom-key", gson.toJson(aluguel));

		try {
			HttpResponse response = httpClient.execute(httpGet);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();

				String json = EntityUtils.toString(entity);
							
				resposta = gson.fromJson(json, String.class);
				
				respostaDto = gson.fromJson(resposta, RespostaDto.class);
			}
			return respostaDto;

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
		}
		return respostaDto;
	}


}
