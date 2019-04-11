package com.pinbus.qa.buscarviaje.interactions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.pinbus.qa.buscarviaje.models.Viaje;
import com.pinbus.qa.buscarviaje.userinterfaces.PinbusHomePage;
import com.pinbus.qa.buscarviaje.util.Fecha;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class FechaAjustada implements Interaction{

	private Viaje viaje;
	public FechaAjustada(Viaje viaje) {
		this.viaje = viaje;
	}
	
	@Override
	@Step("{0} ajusta el calendario")
	public <T extends Actor> void performAs(T actor) {
		PinbusHomePage.calendarioMesesIda.resolveFor(actor).click();
		PinbusHomePage.calendarioAnosIda.resolveFor(actor).click();
		PinbusHomePage.divAnosIda.resolveFor(actor).click();
		Fecha.buscarRangoDeAnos(actor,viaje);
		PinbusHomePage.lblAnoIda(viaje).resolveFor(actor).click();
		PinbusHomePage.lblMesIda(viaje).resolveFor(actor).click();
		PinbusHomePage.lblDiaIda(viaje).resolveFor(actor).click();
		
	}
	
	public static FechaAjustada ajustarCalenadrio(Viaje viaje) {
		return instrumented(FechaAjustada.class, viaje);
	}

}
