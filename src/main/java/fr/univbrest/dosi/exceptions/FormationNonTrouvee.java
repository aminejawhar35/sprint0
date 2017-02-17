package fr.univbrest.dosi.exceptions;

public class FormationNonTrouvee extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormationNonTrouvee() {
		super("Formation Non trouvée");
	}
}
