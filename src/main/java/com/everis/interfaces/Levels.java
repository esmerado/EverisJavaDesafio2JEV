package com.everis.interfaces;

import java.util.Map;

/**
 * [FP-DUAL]:: Javier Esmerado Vela
 * 
 * Interfaz para la creación de las dificultades.
 * 
 * @author esmer
 *
 */
public interface Levels {

	// Método encargado de 'disparar' al objetivo.
	public void shoot(Map<Integer, Integer> map);

	// Método que muestra un número cercano a uno de los objeticos.
	// Max 2 usos.
	public void help(Map<Integer, Integer> map);

	// Método sorpresa, si se acierta la pregunta se suma un disparo.
	// Max 1 uso.
	public void extraShoot();

	// Método para saber cuántos objetivos quedan.
	public void remaining(Map<Integer, Integer> map);

	// Método que muestra las reglas del juego.
	public void rules();

}
