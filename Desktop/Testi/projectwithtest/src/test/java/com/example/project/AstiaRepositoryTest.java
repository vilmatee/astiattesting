package com.example.project;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.project.domain.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AstiaRepositoryTest {
	
	@Autowired
	private AstiaRepository repository;

	@Test
	public void findByKuosiShouldReturnAstia() {
	    List<Astia> astiat = repository.findByKuosi("Kestit");
	    
	    assertThat(astiat).hasSize(1);
	    assertThat(astiat.get(0).getKuosi()).isEqualTo("Kestit");
	}

	@Test
	public void createNewAstia() {
		Astia astia = new Astia("Siirtolapuutarha", "Mustavalkoinen", "4 dl", 24, 2, new Category("Muki"));
		repository.save(astia);
		assertThat(astia.getId()).isNotNull();
	}  

}