package fr.univbrest.dosi.convertisseur;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.models.FormationModel;

@Mapper(uses = { OuiNonMapper.class })
public interface FormationMapper {
	FormationMapper INSTANCE = Mappers.getMapper(FormationMapper.class);

	@Mappings({
			@Mapping(source = "estUnDoubleDiplome", target = "doubleDiplome"),
			@Mapping(source = "numeroAnnee", target = "n0Annee") })
	Formation FormationModelToFormation(FormationModel fm);

	@InheritInverseConfiguration
	FormationModel FormationToFormationModel(Formation formation);
}
