package com.everis.operators;

import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.everis.interfaces.Levels;
import com.everis.objects.LevelEasy;
import com.everis.objects.LevelHard;
import com.everis.objects.LevelMedium;
import com.everis.objects.Objectives;

/**
 * [FP-DUAL]:: Javier Esmerado Vela
 * 
 * Clase global para unir todos los métodos.
 * 
 * @author esmer
 *
 */
public class Pinball {

	// Objeto encargada de concatenar varios strings.
	public StringBuilder sb = new StringBuilder();

	// Objeto scanner para la obtención de elementos por consola.
	private static Scanner sc = new Scanner(System.in);

	// Instancia de los objetos de cada nivel.
	static LevelEasy le = new LevelEasy();
	static LevelMedium lm = new LevelMedium();
	static LevelHard lh = new LevelHard();

	// Instancia del objeto LOGGER para comprobaciones
	private static Logger LOGGER = LoggerFactory.getLogger(Pinball.class);

	/**
	 * Generador de objetivos según el tipo de objeto introducido por parámetros.
	 * 
	 * @param le
	 */
	public static void generateObjetives(Levels le, Map<Integer, Integer> map) {
		LOGGER.info("Accede al metodo generateObjetives.");
		int cont = 0;
		if (le instanceof LevelEasy) {
			while (cont != 5) {
				Objectives ob = new Objectives(map, le);
				map.put(ob.getPosition(), ob.getPosition());
				cont++;
			}
		} else if (le instanceof LevelMedium) {
			while (cont != 9) {
				Objectives ob = new Objectives(map, le);
				map.put(ob.getPosition(), ob.getPosition());
				cont++;
			}
		} else if (le instanceof LevelHard) {
			while (cont != 13) {
				Objectives ob = new Objectives(map, le);
				map.put(ob.getPosition(), ob.getPosition());
				cont++;
			}
		}
	}

	/**
	 * Salir del juego.
	 */
	public static void exit() {
		System.out.println("¡¡HASTA PRONTO!!");
		System.exit(0);
	}

	/**
	 * Generador del menú del juego.
	 */
	public void levelsMenu(Levels le, Map<Integer, Integer> map) {
		LOGGER.info("Accede al metodo LevelsMenu.");
		try {
			while (true) {

				// Generador del menú.
				sb.append("¿Qué accion deseas realizar?\n").append("1.- Shoot.\n").append("2.- Help.\n")
						.append("3.- ExtraShoot. \n").append("4.- Remaining.\n").append("5.- Rules.\n")
						.append("6.- Exit.\n");
				System.out.println(sb.toString());
				sb.setLength(0);
				int num = sc.nextInt();

				// Switch para las opciones.
				switch (num) {
				case 1:
					le.shoot(map);
					break;
				case 2:
					le.help(map);
					break;
				case 3:
					le.extraShoot();
					break;
				case 4:
					le.remaining(map);
					break;
				case 5:
					le.rules();
					break;
				default:
					exit();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("[ERROR]:: Alguno de los valores introducidos son erroneos.");
		}
	}

	/**
	 * Menú principal.
	 */
	public void game(Map<Integer, Integer> map) {
		LOGGER.info("Accede al método game.");
		try {

			// Generador del menú.
			sb.append("----------BIENVENIDO---------- \n").append("¿QUÉ DIFICULTAD QUIERES ELEGIR?\n")
					.append("1.- Level Easy \n").append("2.- Level Medium \n").append("3.- Level Hard \n")
					.append("4.- Exit \n");
			System.out.println(sb.toString());
			int num = sc.nextInt();
			sb.setLength(0);

			// Switch para las opciones.
			switch (num) {
			case 1:
				generateObjetives(le, map);
				levelsMenu(le, map);
				break;

			case 2:
				generateObjetives(lm, map);
				levelsMenu(lm, map);
				break;

			case 3:
				generateObjetives(lh, map);
				levelsMenu(lh, map);
				break;

			default:
				exit();
				break;
			}
		} catch (Exception e) {
			System.err.println("[ERROR]:: Alguno de los valores introducidos son erroneos.");
		}

	}

}
