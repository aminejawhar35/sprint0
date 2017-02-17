package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.univbrest.dosi.beans.Candidat;

@Repository
public interface CandidatRepository extends CrudRepository<Candidat, Long> {

	List<Candidat> findByNom(String nom);

	List<Candidat> findByUniversiteOrigine(String universiteOrigine);

}
