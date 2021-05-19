package com.everis.objects;

import java.util.Map;

import com.everis.interfaces.Levels;

/**
 * [FP-DUAL]:: Javier Esmerado Vela
 * 
 * Método de los objetivos.
 * 
 * @author esmer
 *
 */
public class Objectives {

	// Almacenado de la posición de nuestro objetivo.
	private Integer position;

	// Variables stática que nos definen el rango de cada nivel.
	private static final Integer EASY_RANGE = 10;
	private static final Integer MEDIUM_RANGE = 20;
	private static final Integer HARD_RANGE = 30;

	/**
	 * Generador aleatorio de objetivos según de que clase sea instancia el objeto
	 * que se introduce por parámetros.
	 * 
	 * @param li
	 * @param level
	 */
	public Objectives(Map<Integer, Integer> map, Levels level) {
		boolean var = Boolean.TRUE;
		if (level instanceof LevelEasy) {
			while (var != false) {
				int numero = (int) (Math.random() * EASY_RANGE);
				if (!map.containsKey(numero)) {
					this.position = numero;
					var = Boolean.FALSE;
				}
			}
		} else if (level instanceof LevelMedium) {
			while (var != false) {
				int numero = (int) (Math.random() * MEDIUM_RANGE);
				if (!map.containsKey(numero)) {
					this.position = numero;
					var = Boolean.FALSE;
				}
			}
		} else if (level instanceof LevelHard) {
			while (var != false) {
				int numero = (int) (Math.random() * HARD_RANGE);
				if (!map.containsKey(numero)) {
					this.position = numero;
					var = Boolean.FALSE;
				}
			}
		}
	}

	// Gettes and Setters.
	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
