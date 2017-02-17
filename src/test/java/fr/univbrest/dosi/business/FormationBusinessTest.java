package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.beans.Formation;
import fr.univbrest.dosi.business.implementation.FormationBusinessImpl;
import fr.univbrest.dosi.business.interfaces.FormationBusinessInterface;
import fr.univbrest.dosi.business.stubs.FormationRepositoryStub;
import fr.univbrest.dosi.exceptions.FormationDuplicationCode;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class FormationBusinessTest {

	private FormationBusinessInterface formationBusiness;

	@Before
	public void init() {
		FormationRepositoryStub entrepot = new FormationRepositoryStub();
		formationBusiness = new FormationBusinessImpl(entrepot);
	}

	@Test
	public void doitCreerUneFormation() {
		Formation formation = new Formation();
		formation.setCodeFormation("AB");
		formation.setDiplome("L");
		formation.setN0Annee(new BigDecimal(1));
		formation.setNomFormation("Formation par alternance");
		formation.setDoubleDiplome("O");
		formation.setDebutAccreditation(new Date());
		formation.setFinAccreditation(new Date());
		//assertThat(formationBusiness.creerFormation(formation)).isEqualTo(true);
	}

	@Test(expected = FormationDuplicationCode.class)
	public void doitRetournerExceptionDeDuplicationClePrimaire() {
		Formation formation1 = new Formation();
		formation1.setCodeFormation("ABC");
		formation1.setDiplome("L");
		formation1.setN0Annee(new BigDecimal(1));
		formation1.setNomFormation("Formation par alternance");
		formation1.setDoubleDiplome("O");
		formation1.setDebutAccreditation(new Date());
		formation1.setFinAccreditation(new Date());
		//formationBusiness.creerFormation(formation1);
		// deuxieme formation
		Formation formation2 = new Formation();
		formation2.setCodeFormation("ABC");
		formation2.setDiplome("L");
		formation2.setN0Annee(new BigDecimal(1));
		formation2.setNomFormation("Formation par alternance");
		formation2.setDoubleDiplome("O");
		formation2.setDebutAccreditation(new Date());
		formation2.setFinAccreditation(new Date());
		//formationBusiness.creerFormation(formation2);
		// doit lever une exception car cet id existe deja
	}

}