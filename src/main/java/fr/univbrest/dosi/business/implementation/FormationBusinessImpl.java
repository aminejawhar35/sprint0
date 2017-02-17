package fr.univbrest.dosi.business.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.interfaces.FormationBusinessInterface;
import fr.univbrest.dosi.convertisseur.FormationMapper;
import fr.univbrest.dosi.exceptions.FormationDuplicationCode;
import fr.univbrest.dosi.exceptions.FormationNonTrouvee;
import fr.univbrest.dosi.models.FormationModel;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component
public class FormationBusinessImpl implements FormationBusinessInterface {

	private FormationRepository formationRepository;
	private FormationMapper formationMapper;

	@Autowired
	public FormationBusinessImpl(FormationRepository formationRepository) {
		super();
		this.formationRepository = formationRepository;
		this.formationMapper = FormationMapper.INSTANCE;
	}

	@Override
	public void creerFormation(FormationModel formation) {
		Formation _formation = this.formationMapper
				.FormationModelToFormation(formation);

		if (formationRepository.findOne(formation.getCodeFormation()) != null) {
			throw new FormationDuplicationCode();
		}
		formationRepository.save(_formation);
	}

	@Override
	public void supprimerFormation(String codeFormation) {
		Formation formationASupprimer = formationRepository
				.findOne(codeFormation);
		if (formationASupprimer == null) {
			throw new FormationNonTrouvee();
		}
		formationRepository.delete(codeFormation);
	}

	@Override
	public List<FormationModel> getToutesLesFormations() {
		List<Formation> formations = Lists.newArrayList(formationRepository
				.findAll());
		return formations.stream()
				.map(this.formationMapper::FormationToFormationModel)
				.collect(Collectors.toList());
	}

	@Override
	public FormationModel getFormationParCodeFormation(String codeFormation) {
		Formation formationRecherchee = formationRepository
				.findOne(codeFormation);
		if (formationRecherchee == null) {
			throw new FormationNonTrouvee();
		}

		FormationModel _formation = this.formationMapper
				.FormationToFormationModel(formationRecherchee);
		return _formation;
	}

	@Override
	public FormationModel getFormationParNomFormation(String nomFormation) {
		Formation formationRecherchee = formationRepository
				.findByNomFormation(nomFormation);
		if (formationRecherchee == null) {
			throw new FormationNonTrouvee();
		}
		FormationModel _formation = this.formationMapper
				.FormationToFormationModel(formationRecherchee);
		return _formation;
	}

	@Override
	public long getNombreDeFormation() {
		return formationRepository.count();
	}

	//TODO il faut faut si la formation existe avant de faire la MAJ
	@Override
	public void miseAjourFormation(FormationModel formation) {
		Formation _formation = this.formationMapper.FormationModelToFormation(formation);
		formationRepository.save(_formation);

	}
}
