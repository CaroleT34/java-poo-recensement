package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exception.RecensementException;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws RecensementException {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;
		
		//l’utilisateur saisit une lettre au lieu de chiffres pour le min
		if(!NumberUtils.isDigits(saisieMin)){
			throw new RecensementException("Min doit être un nombre positif ou nul");
		}
		//l’utilisateur saisit une lettre au lieu de chiffres pour le max
		if(!NumberUtils.isDigits(saisieMax)) {
			throw new RecensementException("Max doit être un nombre positif ou nul");
		}
		//si l’utilisateur saisit un min <0 ou un max <0 ou un min > max
		if (min<0 || max<0 || min > max) {
			throw new RecensementException("T'écris de la merde, essaye encore");
		}
		
		
		List<Ville> villes = rec.getVilles();
		
		boolean departemenTrouve = false;
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				departemenTrouve = true;
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
		
		if(!departemenTrouve) {
			throw new RecensementException("Le code départemental " + choix +" n'existe pas");
		}
	}

}
