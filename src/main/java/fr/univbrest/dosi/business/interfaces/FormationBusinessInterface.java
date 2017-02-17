package fr.univbrest.dosi.business.interfaces;

import java.util.List;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.models.FormationModel;

public interface FormationBusinessInterface {

	public abstract void creerFormation(FormationModel formation);

	public abstract void supprimerFormation(String codeFormation);

	public abstract List<FormationModel> getToutesLesFormations();

	public abstract FormationModel getFormationParCodeFormation(String codeFormation);

	public abstract FormationModel getFormationParNomFormation(String nomFormation);
	
	public abstract long getNombreDeFormation();
	
	public abstract void miseAjourFormation(FormationModel formation);
}