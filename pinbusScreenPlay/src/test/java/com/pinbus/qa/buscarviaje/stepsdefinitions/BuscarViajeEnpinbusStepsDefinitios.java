package com.pinbus.qa.buscarviaje.stepsdefinitions;

import java.util.List;

import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.WebDriver;

import com.pinbus.qa.buscarviaje.task.BuscarViaje;
import com.pinbus.qa.buscarviaje.userinterfaces.PinbusHomePage;
import com.pinbus.qa.buscarviaje.userinterfaces.PinbusResultPage;
import com.pinbus.qa.buscarviaje.util.VerificarConexion;

import static org.hamcrest.CoreMatchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.core.Is.is;

import com.pinbus.qa.buscarviaje.exceptions.ViajeNoEncontrado;
import com.pinbus.qa.buscarviaje.models.Viaje;
import com.pinbus.qa.buscarviaje.questions.ResultadoViaje;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;



public class BuscarViajeEnpinbusStepsDefinitios {
	public static final int INDICE_VIAJE = 0;
	PinbusHomePage pinbusHomePage;
	
	@Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor alejandro = Actor.named("Don Alejo");
    
	@Before
	 public void actorCanBrowseTheWeb() {
		alejandro.can(BrowseTheWeb.with(hisBrowser));
		
	   }
	
	@Given("^El esta en la pagina principal de Pinbus$")
	public void elEstaEnLaPaginaPrincipalDePinbus() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		alejandro.wasAbleTo(Open.browserOn().the(pinbusHomePage)); 
	}

	@When("^El busca el viaje con los parametros dados$")
	public void elBuscaElViajeConLosParametrosDados(List<Viaje> viajes) throws Exception {
		alejandro.attemptsTo(BuscarViaje.enLasRutas(viajes.get(INDICE_VIAJE)));
	    
	}

	@Then("^El verifica el resultado$")
	public void elVerificaElResultado() {		
		alejandro.should(seeThat(ResultadoViaje.buscado(), is(true)));
		}

}
