package fr.univbrest.dosi.exceptions;

public class FormationDuplicationCode extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormationDuplicationCode(){
		super("Une formation avec le meme id existe");
	}
}
