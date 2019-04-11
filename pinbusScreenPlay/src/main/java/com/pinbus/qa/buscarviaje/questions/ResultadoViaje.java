  package com.pinbus.qa.buscarviaje.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import com.pinbus.qa.buscarviaje.userinterfaces.PinbusResultPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;

@Subject("validar resultado")
public class ResultadoViaje implements Question<Boolean> {

	public ResultadoViaje() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean answeredBy(Actor actor) {		
		BrowseTheWeb.as(actor).waitFor(15).second();
		return PinbusResultPage.grpResults.resolveFor(actor).waitUntilVisible().isVisible();
	}
	
	public static ResultadoViaje buscado() {
		return new ResultadoViaje();
	}
	
}
