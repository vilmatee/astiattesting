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
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;

	@Test
	public void findByNameReturnCategory() {
	    List<Category> categorys = repository.findByName("Kulhot");
	    
	    assertThat(categorys).hasSize(1);
	    assertThat(categorys.get(0).getName()).isEqualTo("Kulhot");
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Kahvikupposet");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}  

}
