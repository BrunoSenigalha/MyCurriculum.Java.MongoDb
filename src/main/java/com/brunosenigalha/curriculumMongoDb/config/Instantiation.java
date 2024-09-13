package com.brunosenigalha.curriculumMongoDb.config;

import com.brunosenigalha.curriculumMongoDb.dto.AddressDTO;
import com.brunosenigalha.curriculumMongoDb.entities.Curriculum;
import com.brunosenigalha.curriculumMongoDb.entities.enums.Gender;
import com.brunosenigalha.curriculumMongoDb.repositories.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Override
    public void run(String... args) throws Exception {

        curriculumRepository.deleteAll();

        Curriculum c1 = new Curriculum(null, " ", "João Carlos",  Gender.MASCULINO,
                "Desenvolvedor de Sistemas", "85555855", "joao@gmail.com", "www.linkedin.com/joao");
        Curriculum c2 = new Curriculum(null, " ", "Maria", Gender.FEMININO,
                "Product Manager", "87777777", "maria@gmail.com", "www.linkedin.com/maria");

        AddressDTO addr1 = new AddressDTO("0254559", "São Paulo", "São Paulo", "Brasil");
        AddressDTO addr2 = new AddressDTO("5856666", "Minas Gerais", "Montes Claros", "Brasil");

        c1.setAddressDTO(addr1);
        c2.setAddressDTO(addr2);
        curriculumRepository.saveAll(Arrays.asList(c1, c2));
    }
}
