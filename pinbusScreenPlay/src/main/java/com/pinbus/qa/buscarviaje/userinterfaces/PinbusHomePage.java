package com.pinbus.qa.buscarviaje.userinterfaces;

import org.openqa.selenium.By;

import com.pinbus.qa.buscarviaje.models.Viaje;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://pinbus.com/")
public class PinbusHomePage extends PageObject {
	public static final Target inputOrigen = Target.the("el textbox del origen")
			.locatedBy("//input[@placeholder='Ingresa tu Origen']");

	public static final Target lsbAutocompletar = Target.the("lista autocompletar")
			.locatedBy("//div[contains(@class,'v-autocomplete-list)]");

	public static final Target inputDestino = Target.the("el textbox del destino")
			.locatedBy("//input[@placeholder='Destino']");

	public static final Target inputFechaIda = Target.the("el textbox de la fecha de ida")
			.locatedBy("//input[contains(@placeholder,'Salida')]");

	public static final Target inputFechaRegreso = Target.the("el textbox de la fecha de regreso")
			.locatedBy("//input[contains(@placeholder,'Regreso (opcional)')]");

	public static final Target btnBuscar = Target.the("El boton de buscar").locatedBy("//button[@id='btn_buscar']");

	public static final Target inputCalendarioIda = Target.the("el calenadrio de fechas")
			.locatedBy("//input[contains(@placeholder,'Salida')]");

	public static final Target calendarioMesesIda = Target.the("el calendario de meses")
			.locatedBy("//div[3]//div[1]//div[2]//header[1]//span[2]");

	public static final Target calendarioAnosIda = Target.the("el calendario de a�os")
			.locatedBy("//div[3]//div[1]//div[3]//header[1]//span[2]");

	public static final Target divAnosIda = Target.the("el rango de a�os")
			.locatedBy("//div[3]//div[1]//div[4]//header[1]//span[2]");

	public static final Target inputCalendarioRegreso = Target.the("el calenadrio de fechas")
			.locatedBy("//input[contains(@placeholder,'Salida')]");

	public static final Target calendarioMesesRegreso = Target.the("el calendario de meses")
			.locatedBy("//div[4]//div[1]//div[2]//header[1]//span[2]");

	public static final Target calendarioAnosRegreso = Target.the("el calendario de a�os")
			.locatedBy("//div[4]//div[1]//div[3]//header[1]//span[2]");

	public static final Target divAnosRegreso = Target.the("el rango de a�os")
			.locatedBy("//div[4]//div[1]//div[4]//header[1]//span[2]");
	
	public static final Target btnSiguienteCalendarioIda= Target.the("el boton siguiente del calendario de ida")
			.locatedBy("//div[3]//div[1]//div[4]//header[1]//span[3]");

	public static final Target btnSiguienteCalendariRegreso= Target.the("el boton siguiente del calendario de regreso")
			.locatedBy("//div[4]//div[1]//div[4]//header[1]//span[3]");
	
	public static  Target lblAnoIda(Viaje viaje) {
		return Target.the("el a�o esperado")
				.locatedBy("//div[3]//div[1]//div[4]//span[contains(@class,'cell year')][contains(text(),'"+viaje.getSrtAnoIda()+"')]");
	}
	
	public static Target lblMesIda(Viaje viaje) {
		return Target.the("el mes esperado")
				.locatedBy("//div[3]//div[1]//div[3]//span[contains(@class,'cell month')][contains(text(),'"+viaje.getStrMesIda().substring(0,1).toUpperCase()+viaje.getStrMesIda().substring(1)+"')]");
	
	}
	
	public static Target lblDiaIda(Viaje viaje) {
		return Target.the("el mes esperado")
				.locatedBy("//div[3]//div[1]//div[2]//div[1]//span[contains(@class,'cell day')][contains(text(),'"+viaje.getStrDiaIdA()+"')]");
	
	}
	
	public static  Target lblAnoRegreso(Viaje viaje) {
		return Target.the("el a�o esperado")
				.locatedBy("//div[4]//div[1]//div[4]//span[contains(@class,'cell year')][contains(text(),'"+viaje.getStrAnoRegrso()+"')]");
	}
	
	public static Target lblMesRegreso(Viaje viaje) {
		return Target.the("el mes esperado")
				.locatedBy("//div[4]//div[1]//div[3]//span[contains(@class,'cell month')][contains(text(),'"+viaje.getStrMesRegreso().substring(0,1).toUpperCase()+viaje.getStrMesRegreso().substring(1)+"')]");
	
	}
	
	public static Target lblDiaRegreso(Viaje viaje) {
		return Target.the("el dia esperado")
				.locatedBy("//div[4]//div[1]//div[2]//div[1]//span[contains(@class,'cell day')][contains(text(),'"+viaje.getStrDiaRegreso()+"')]");
	
	}
}
