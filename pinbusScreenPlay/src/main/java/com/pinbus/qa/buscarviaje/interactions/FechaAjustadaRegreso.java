package com.pinbus.qa.buscarviaje.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pinbus.qa.buscarviaje.models.Viaje;
import com.pinbus.qa.buscarviaje.userinterfaces.PinbusHomePage;
import com.pinbus.qa.buscarviaje.util.Fecha;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class FechaAjustadaRegreso implements Interaction{

	private Viaje viaje;
	public FechaAjustadaRegreso(Viaje viaje) {
		this.viaje = viaje;
	}
	
	@Override
	@Step("{0} ajusta el calendario")
	public <T extends Actor> void performAs(T actor) {
		PinbusHomePage.calendarioMesesRegreso.resolveFor(actor).click();
		PinbusHomePage.calendarioAnosRegreso.resolveFor(actor).click();
		PinbusHomePage.divAnosRegreso.resolveFor(actor).click();
		Fecha.buscarRangoDeAnosRegreso(actor, viaje);
		PinbusHomePage.lblAnoRegreso(viaje).resolveFor(actor).click();
		PinbusHomePage.lblMesRegreso(viaje).resolveFor(actor).click();
		PinbusHomePage.lblDiaRegreso(viaje).resolveFor(actor).click();
		
	}
	
	public static FechaAjustadaRegreso ajustarCalenadrio(Viaje viaje) {
		return instrumented(FechaAjustadaRegreso.class, viaje);
	}

}
