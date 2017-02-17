package fr.univbrest.dosi.controllers;

import fr.univbrest.dosi.business.implementation.FormationBusinessImpl;
import fr.univbrest.dosi.models.FormationModel;
import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "formation")
@RestController
@RequestMapping("formation")
public class FormationController {

	private final FormationBusinessImpl formationBusiness;

	@Autowired
	public FormationController(FormationBusinessImpl formationBusiness) {
		this.formationBusiness = formationBusiness;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<FormationModel> getToutesLesFormations() {
		return formationBusiness.getToutesLesFormations();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/nombredeformations")
	public long getNombreDeFormations() {
		return formationBusiness.getNombreDeFormation();
	}

	@RequestMapping(value = "/{codeFormation}", method = RequestMethod.GET)
	public FormationModel getFormationParCode(
			@PathVariable("codeFormation") String codeFormation) {
		return formationBusiness.getFormationParCodeFormation(codeFormation);
	}

	@RequestMapping(value = "/{codeFormation}", method = RequestMethod.DELETE)
	public void supprimerFormation(
			@PathVariable("codeFormation") String codeFormation) {
		formationBusiness.supprimerFormation(codeFormation);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void ajouterFormation(@RequestBody FormationModel formation) {
		formationBusiness.creerFormation(formation);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void miseAjourFormation(@RequestBody FormationModel formation){
		formationBusiness.miseAjourFormation(formation);
	}
}
