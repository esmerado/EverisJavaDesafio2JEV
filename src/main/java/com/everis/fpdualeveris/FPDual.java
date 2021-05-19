package com.everis.fpdualeveris;

import java.util.HashMap;
import java.util.Map;

import com.everis.operators.Pinball;

/**
 * [FP-DUAL]:: Javier Esmerado Vela.
 * 
 * Clase con método main.
 * 
 * @author esmer
 *
 */
public class FPDual {

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Instancia de la clase Pinball.
		Pinball p = new Pinball();

		// Map generado para el almacenamiento de los objetivos.
		Map<Integer, Integer> map = new HashMap<>();

		// Instancia del método principal del programa de la clase Pinball.
		p.game(map);

	}
}
