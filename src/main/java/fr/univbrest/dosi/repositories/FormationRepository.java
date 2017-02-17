package fr.univbrest.dosi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.univbrest.dosi.beans.Formation;


@Repository
public interface FormationRepository extends CrudRepository<Formation, String> {
	public Formation findByNomFormation(String nomFormation);
}
