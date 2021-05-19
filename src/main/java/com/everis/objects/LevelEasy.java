package com.everis.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.everis.interfaces.Levels;

/**
 * [FP-DUAL]:: Javier Esmerado Vela
 * 
 * Clase de la dificultad fácil.
 * 
 * @author esmer
 *
 */
public class LevelEasy implements Levels {

	// Objeto encargada de concatenar varios strings.
	private StringBuilder sb = new StringBuilder();

	// Objeto scanner para la obtención de elementos por consola.
	private static Scanner sc = new Scanner(System.in);

	// Variable que contiene el número de disparos.
	private int numShoots = 5;

	// Listas para el alamacenamiento de preguntas y respuestas.
	private static List<String> questions = new ArrayList<>();
	private static List<String> answers = new ArrayList<>();

	// Variables encargadas de acumular el número de iteraciones.
	private static int cont = 0;
	private static int cont2 = 0;

	// Getters and Setters.
	public int getNumShoots() {
		return numShoots;
	}

	public void setNumShoots(int numShoots) {
		this.numShoots = numShoots;
	}

	@Override
	public void shoot(Map<Integer, Integer> map) {
		try {
			System.out.println("Introduce el numero al que quiere disparar");
			int shoot = sc.nextInt();

			// Condición para saber si tenemos tiros disponibles.
			if (cont != numShoots) {

				// Comprobación para saber si el número introducido está dentro de los márgenes.
				if (shoot <= 10) {

					// Comprobación de objetivo para saber si el disparo es un objetivo o no.
					if (map.containsKey(shoot)) {
						System.out.println("¡¡BOOM, BLANCO ELIMINADO!!");
						map.remove(shoot);
						cont++;
						if (map.size() == 0) {
							System.out.println("¡¡FELICIDADES, HAS GANADO!!");
							exit();
						}
					} else {
						System.out.println("¡¡FALLASTE!! VUELVE A INTENTARLO.");
						cont++;
					}

				} else {
					System.err.println("[ERROR]:: El valor esta fuera de los limites.");

				}
			} else {
				System.out.println("Te has quedado sin disparos :(.");
				System.out.println("VUELVE A INTENTARLO!!");
				exit();
			}

		} catch (Exception e) {
			System.err.println("[ERROR]:: El valor introducido no esta permitido.");
		}

	}

	@Override
	public void help(Map<Integer, Integer> map) {
		int cont = 0;

		// Comprobación de usos restantes.
		if (cont < 2) {
			int num = map.get(map.keySet().toArray()[0]);
			int random = (int) (Math.random() * 3 + 1);
			num += random;
			sb.append("[Pista]:: El numero que busca se encuentra cerca del ").append(num);
			System.out.println(sb.toString());
			sb.setLength(0);
			cont++;
		} else {
			System.out.println("Lo sentimos ha agotado el numero de usos.");
		}

	}

	@Override
	public void extraShoot() {
		questions();
		answers();
		
		// Comprobación de usos restantes.
		if (cont2 < 1) {
			int random = (int) (Math.random() * 6);
			System.out.println(questions.get(random));
			String an = sc.next();
			if (answers.contains(an)) {
				System.out.println("¡¡ENHORABUENA HAS ACERTADO LA PREGUNTA, AHORA TIENES UN TIRO MAS!!");
				cont2++;
				numShoots++;
			} else {
				System.out.println("Lo sentimos no has acertado la pregunta.");
				cont2++;
			}
		} else {
			System.out.println("Lo sentimos ha agotado el número de usos.");
		}

	}

	@Override
	public void remaining(Map<Integer, Integer> map) {

		sb.append("Queda ").append(map.size()).append(" objetivos restantes!!!");
		System.out.println(sb.toString());
		sb.setLength(0);
		System.out.println("¡¡A POR TODAAASS!!");

	}

	@Override
	public void rules() {

		sb.append("-------------------REGLAS------------------- \n")
				.append("El objetivo del juego es eliminar todos los \n objetivos enemigos, \n")
				.append("Segun la dificultad elegida tendra mas o menos \n objetivos y tiros. \n")
				.append("A parte de todo tienes dos tipos de ayudas, \n")
				.append("'Help', esta opción te muestra un número cercano \n a uno de los objetivos, \n")
				.append("la segunda es 'extraShoot', con esta ayuda podremos \n obtener un tiro extra si acertamos la pregunta. \n")
				.append("Easy -> 0 - 10 \n").append("Medium -> 0 - 20 \n").append("Hard -> 0 - 30 \n")
				.append("¡¡A DISFRUTAR!! \n").append("--------------------------------------------");
		System.out.println(sb.toString());
		sb.setLength(0);

	}

	/**
	 * Método para salir de la aplicación.
	 */
	public void exit() {
		System.out.println("¡¡HASTA PRONTO!!");
		System.exit(0);
	}

	/**
	 * Método para instanciar las preguntas.
	 */
	public static void questions() {
		questions.add("¿En que año descubrio colon america?");
		questions.add("¿Que vengador usa un martillo?");
		questions.add("¿En que año se piso la luna por primera vez?");
		questions.add("¿Cuánto duro la guerra de los 100 años?");
		questions.add("¿Qué número tiene Lebron James?");
		questions.add("¿Cual es el resultado de 333 entre 3?");
	}

	/**
	 * Método para instanciar las respuestas.
	 */
	public static void answers() {
		answers.add("1492");
		answers.add("Thor");
		answers.add("1969");
		answers.add("116");
		answers.add("23");
		answers.add("111");
	}

}
