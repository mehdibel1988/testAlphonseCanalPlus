package com.alphonse.canalplus;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.client.RestTemplate;

import com.alphonse.canalplus.entities.Abonne;
import com.alphonse.canalplus.entities.Adresse;
import com.alphonse.canalplus.entities.Mouvement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModificationAdresse {

	private final WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());
	private static final String APPLICATION_JSON = "application/json";
	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	private Abonne abonne = null;
	private Adresse adresse = null;
	private ObjectMapper objectMapper = new ObjectMapper();

	@Given("^un abonné avec une adresse principale active en France$")
	public void getAbonneEnFrance() {

		abonne = new RestTemplate().getForObject("http://localhost:8080/abonnes/1", Abonne.class);
	}

	@When("^le conseiller connecté à <canal> modifie l'adresse de l'abonné sans date d'effet$")
	public void modifierAdresse() throws Throwable {
		adresse = abonne.getAdresse();
		adresse.setRue("rue des archevilliers");
		adresse.setCodePostal(28000);
		adresse.setVille("Chartres");
	}

	@Then("l'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné")
	public void enregistrerMdificationsAdresse() throws Throwable {
		wireMockServer.start();
		configureFor("localhost", wireMockServer.port());

		stubFor(put(urlEqualTo("/adresses")).withHeader("content-type", equalTo(APPLICATION_JSON))
				.withRequestBody(containing(objectMapper.writeValueAsString(adresse)))
				.willReturn(aResponse().withStatus(200)));

		HttpPut request = new HttpPut("http://localhost:" + wireMockServer.port() + "/adresses");
		StringEntity entity = new StringEntity(objectMapper.writeValueAsString(adresse));
		request.addHeader("content-type", APPLICATION_JSON);
		request.setEntity(entity);
		HttpResponse response = httpClient.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
		wireMockServer.stop();

	}

	@Then("^un mouvement de modification d'adresse est créé")
	public void enregistrerMouvement() throws Throwable {
		wireMockServer.start();
		configureFor("localhost", wireMockServer.port());
		Mouvement mouvement = new Mouvement("Modification d'adresse: ",
				"l'adresse des contrats de l abonne " + abonne.getNumAbonnement() + "  est modifée");

		stubFor(post(urlEqualTo("/mouvements")).withHeader("content-type", equalTo(APPLICATION_JSON))
				.withRequestBody(containing(objectMapper.writeValueAsString(mouvement)))
				.willReturn(aResponse().withStatus(200)));

		HttpPost request = new HttpPost("http://localhost:" + wireMockServer.port() + "//mouvements");
		StringEntity entity = new StringEntity(objectMapper.writeValueAsString(mouvement));
		request.addHeader("content-type", APPLICATION_JSON);
		request.setEntity(entity);
		HttpResponse response = httpClient.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
		wireMockServer.stop();

	}

	@Then("^Et la nouvelle adresse peut être recherchée")
	public void rechercherAdresse() throws Throwable {
		wireMockServer.start();
		configureFor("localhost", wireMockServer.port());
		stubFor(get(urlEqualTo("/adresses" + adresse.getId())).withHeader("accept", equalTo(APPLICATION_JSON))
				.withHeader("content-type", equalTo(APPLICATION_JSON)).willReturn(aResponse().withStatus(200)));

		HttpGet request = new HttpGet("http://localhost:" + wireMockServer.port() + "/adresses/" + adresse.getId());
		request.addHeader("accept", APPLICATION_JSON);
		HttpResponse response = httpClient.execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
		wireMockServer.stop();
	}

}
