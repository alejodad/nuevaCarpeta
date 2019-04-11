package com.pinbus.qa.buscarviaje.task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;

import com.pinbus.qa.buscarviaje.interactions.FechaAjustada;
import com.pinbus.qa.buscarviaje.interactions.FechaAjustadaRegreso;
import com.pinbus.qa.buscarviaje.models.Viaje;
import com.pinbus.qa.buscarviaje.userinterfaces.PinbusHomePage;
import com.pinbus.qa.buscarviaje.userinterfaces.PinbusResultPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.SendKeysIntoTarget;
import net.serenitybdd.screenplay.matchers.statematchers.IsVisibleMatcher;
import net.serenitybdd.screenplay.matchers.statematchers.isClickableMatcher;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;

public class BuscarViaje implements Task{
	
	private Viaje viaje;
	
	public BuscarViaje(Viaje viaje) {
		this.viaje = viaje;
		
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(viaje.getStrRutaIda()).into(PinbusHomePage.inputOrigen).thenHit(Keys.TAB),				
				Enter.theValue(viaje.getStrRutaRgreso()).into(PinbusHomePage.inputDestino).thenHit(Keys.TAB),
				Click.on(PinbusHomePage.inputFechaIda),
				FechaAjustada.ajustarCalenadrio(viaje)
				);
		if (!viaje.getStrDiaRegreso().trim().equals("")) {
			actor.attemptsTo(
					Click.on(PinbusHomePage.inputFechaRegreso),
					FechaAjustadaRegreso.ajustarCalenadrio(viaje)
					);
		}
		actor.attemptsTo(Click.on(PinbusHomePage.btnBuscar));
		
	}
	
	public static BuscarViaje enLasRutas(Viaje viaje) {
		return instrumented(BuscarViaje.class, viaje);
	}
	

}
