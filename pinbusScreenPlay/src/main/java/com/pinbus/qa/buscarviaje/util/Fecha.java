package com.pinbus.qa.buscarviaje.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import com.pinbus.qa.buscarviaje.models.Viaje;
import com.pinbus.qa.buscarviaje.userinterfaces.PinbusHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

public class Fecha {
	
	/**
	 * 
	 * @return
	 * Este vento obtiene la fecha que se necesita para poder interactuar con el input
	 */
	public static String strObtenerFechaFormateada() {
		Date hoy = new Date();
		String formatoFecha = "MMMM yyyy";
		SimpleDateFormat simpleDateFormatmesAno = new SimpleDateFormat(formatoFecha);
		String mesAno=simpleDateFormatmesAno.format(hoy).substring(0,1).toUpperCase()+simpleDateFormatmesAno.format(hoy).substring(1,3);
		
		return mesAno;
	}
	
	/**
	 * 
	 * @param itemComparar
	 * @param itemInicial
	 * @param itemFinal
	 * @return
	 * Este evento recibe una fecha a comparar y verifica que este entre los rangos de las 
	 * otras fechas que tiene como pararmetros
	 */
	
	public static boolean BlnRangoAnosEstaEntre(int itemComparar, int itemInicial, int itemFinal) {
		if(itemComparar >= itemInicial && itemComparar <= itemFinal || itemComparar==itemInicial || itemComparar==itemFinal) {
			return true;
		}else
		return false;
		}
	
	
	/**
	 * 
	 * @param actor
	 * @param viaje
	 * Este evento interactua entre los rangos de fechas  buscando que el a�o
	 * para la fecha de ida 
	 */
	public static void buscarRangoDeAnos(Actor actor,Viaje viaje) {
		String yearRange[] = PinbusHomePage.divAnosIda.resolveFor(actor).getText().split("-");
		while (!BlnRangoAnosEstaEntre(Integer.parseInt(viaje.getSrtAnoIda()),Integer.parseInt(yearRange[0].trim()),Integer.parseInt(yearRange[1].trim()))) {
			
			
			if(Integer.parseInt(viaje.getSrtAnoIda())>Integer.parseInt(yearRange[1].trim())) {
				PinbusHomePage.btnSiguienteCalendarioIda.resolveFor(actor).click();
			}
			
		 String yearRange1[] = PinbusHomePage.divAnosIda.resolveFor(actor).getText().split("-");
		 yearRange[0]=yearRange1[0];
		 yearRange[1]=yearRange1[1];
			
		}
	}
	
	/**
	 * 
	 * @param actor
	 * @param viaje
	 * Este evento interactua entre los rangos de fechas  buscando que el a�o
	 * para la fecha de regreso 
	 */
	
	public static void buscarRangoDeAnosRegreso(Actor actor,Viaje viaje) {	
		String yearRange[] = PinbusHomePage.divAnosRegreso.resolveFor(actor).getText().split("-");
		while (!BlnRangoAnosEstaEntre(Integer.parseInt(viaje.getStrAnoRegrso()),Integer.parseInt(yearRange[0].trim()),Integer.parseInt(yearRange[1].trim()))) {
			
			
			if(Integer.parseInt(viaje.getStrAnoRegrso())>Integer.parseInt(yearRange[1].trim())) {
				PinbusHomePage.btnSiguienteCalendariRegreso.resolveFor(actor).click();
			}
			
		 String yearRange1[] = PinbusHomePage.divAnosRegreso.resolveFor(actor).getText().split("-");
		 yearRange[0]=yearRange1[0];
		 yearRange[1]=yearRange1[1];
			
		}
	}
	

}
