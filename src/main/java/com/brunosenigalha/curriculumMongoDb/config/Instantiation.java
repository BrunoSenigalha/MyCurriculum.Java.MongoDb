package com.brunosenigalha.curriculumMongoDb.config;

import com.brunosenigalha.curriculumMongoDb.entities.*;
import com.brunosenigalha.curriculumMongoDb.entities.enums.*;
import com.brunosenigalha.curriculumMongoDb.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.UUID;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AcademicExpRepository academicExpRepository;

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public void run(String... args) throws Exception {

        curriculumRepository.deleteAll();
        courseRepository.deleteAll();
        academicExpRepository.deleteAll();
        addressRepository.deleteAll();
        languageRepository.deleteAll();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        CurriculumEntity c1 = new CurriculumEntity(UUID.randomUUID().toString(), " ", "João Carlos", Gender.MASCULINO,
                "Desenvolvedor de Sistemas", "85555855", "joao@gmail.com", "www.linkedin.com/joao");
        CurriculumEntity c2 = new CurriculumEntity(UUID.randomUUID().toString(), " ", "Maria", Gender.FEMININO,
                "Product Manager", "87777777", "maria@gmail.com", "www.linkedin.com/maria");

        CourseEntity course1 = new CourseEntity(UUID.randomUUID().toString(),c1.getId() ,TypeCourse.CURSO, "Java", "Curso completo de Java");
        CourseEntity course2 = new CourseEntity(UUID.randomUUID().toString(),c1.getId() ,TypeCourse.CERTIFICACAO, "AWS", "Certificação de AWS");
        CourseEntity course3 = new CourseEntity(UUID.randomUUID().toString(),c1.getId() ,TypeCourse.CURSO, "MongoDB", "Curso completo de MongoDB");
        CourseEntity course4 = new CourseEntity(UUID.randomUUID().toString(),c2.getId() ,TypeCourse.CURSO, ".NET", "Curso completo de .NET");
        courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4));

        AcademicExpEntity aExp1 = new AcademicExpEntity(UUID.randomUUID().toString(), c1.getId(), "Analise de Sistemas", "PUC", Degree.GRADUACAO, FormationType.SUPERIOR, FormationStatus.COMPLETO, false, LocalDate.parse("21/03/2020", fmt), LocalDate.parse("25/04/2024", fmt));
        AcademicExpEntity aExp2 = new AcademicExpEntity(UUID.randomUUID().toString(), c1.getId(), "Engenharia de Alimentos", "Unesp", Degree.MESTRADO, FormationType.SUPERIOR, FormationStatus.EM_ANDAMENTO, false, LocalDate.parse("24/08/2023", fmt), LocalDate.parse("12/01/2026", fmt));
        academicExpRepository.saveAll(Arrays.asList(aExp1, aExp2));

        LanguageEntity l1 = new LanguageEntity(UUID.randomUUID().toString(), c2.getId(), "Inglês", ProficiencyLevel.AVANCADO, ProficiencyLevel.MEDIO, ProficiencyLevel.AVANCADO);
        LanguageEntity l2 = new LanguageEntity(UUID.randomUUID().toString(), c2.getId(), "Espanhol", ProficiencyLevel.BASICO, ProficiencyLevel.MEDIO, ProficiencyLevel.BASICO);
        LanguageEntity l3 = new LanguageEntity(UUID.randomUUID().toString(), c2.getId(), "Inglês", ProficiencyLevel.MEDIO, ProficiencyLevel.AVANCADO, ProficiencyLevel.MEDIO);
        languageRepository.saveAll(Arrays.asList(l1, l2, l3));

        c1.getAcademicExpList().addAll(Arrays.asList(aExp1, aExp2));
        c1.getCourses().addAll(Arrays.asList(course1, course2, course3));
        c1.getLanguages().add(l1);
        c2.getCourses().add(course4);
        c2.getLanguages().addAll(Arrays.asList(l2, l3));


        curriculumRepository.saveAll(Arrays.asList(c1, c2));

        AddressEntity addr1 = new AddressEntity(UUID.randomUUID().toString(), c1.getId(), "8566698", "São Paulo", "São Paulo", "Brasil");
        AddressEntity addr2 = new AddressEntity(UUID.randomUUID().toString(), c2.getId(), "898222", "Minas Gerais", "Montes Claros", "Brasil");
        addressRepository.saveAll(Arrays.asList(addr1, addr2));

        c1.setAddress(addr1);
        c2.setAddress(addr2);

        curriculumRepository.saveAll(Arrays.asList(c1, c2));

    }
}
