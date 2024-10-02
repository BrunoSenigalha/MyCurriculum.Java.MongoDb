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

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ToolRepository toolRepository;

    @Override
    public void run(String... args) throws Exception {

        curriculumRepository.deleteAll();
        courseRepository.deleteAll();
        academicExpRepository.deleteAll();
        addressRepository.deleteAll();
        languageRepository.deleteAll();
        linkRepository.deleteAll();
        projectRepository.deleteAll();
        toolRepository.deleteAll();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        CurriculumEntity c1 = new CurriculumEntity(UUID.randomUUID().toString(), " ", "João Carlos", Gender.MASCULINO,
                "Desenvolvedor de Sistemas", "85555855", "joao@gmail.com", "www.linkedin.com/joao");
        CurriculumEntity c2 = new CurriculumEntity(UUID.randomUUID().toString(), " ", "Maria", Gender.FEMININO,
                "Product Manager", "87777777", "maria@gmail.com", "www.linkedin.com/maria");

        CourseEntity course1 = new CourseEntity(UUID.randomUUID().toString(), c1.getId(), TypeCourse.CURSO, "Java", "Curso completo de Java");
        CourseEntity course2 = new CourseEntity(UUID.randomUUID().toString(), c1.getId(), TypeCourse.CERTIFICACAO, "AWS", "Certificação de AWS");
        CourseEntity course3 = new CourseEntity(UUID.randomUUID().toString(), c1.getId(), TypeCourse.CURSO, "MongoDB", "Curso completo de MongoDB");
        CourseEntity course4 = new CourseEntity(UUID.randomUUID().toString(), c2.getId(), TypeCourse.CURSO, ".NET", "Curso completo de .NET");
        courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4));

        AcademicExpEntity aExp1 = new AcademicExpEntity(UUID.randomUUID().toString(), c1.getId(), "Analise de Sistemas", "PUC", Degree.GRADUACAO, FormationType.SUPERIOR, FormationStatus.COMPLETO, false, LocalDate.parse("21/03/2020", fmt), LocalDate.parse("25/04/2024", fmt));
        AcademicExpEntity aExp2 = new AcademicExpEntity(UUID.randomUUID().toString(), c1.getId(), "Engenharia de Alimentos", "Unesp", Degree.MESTRADO, FormationType.SUPERIOR, FormationStatus.EM_ANDAMENTO, false, LocalDate.parse("24/08/2023", fmt), LocalDate.parse("12/01/2026", fmt));
        academicExpRepository.saveAll(Arrays.asList(aExp1, aExp2));

        LanguageEntity l1 = new LanguageEntity(UUID.randomUUID().toString(), c2.getId(), "Inglês", ProficiencyLevel.AVANCADO, ProficiencyLevel.MEDIO, ProficiencyLevel.AVANCADO);
        LanguageEntity l2 = new LanguageEntity(UUID.randomUUID().toString(), c2.getId(), "Espanhol", ProficiencyLevel.BASICO, ProficiencyLevel.MEDIO, ProficiencyLevel.BASICO);
        LanguageEntity l3 = new LanguageEntity(UUID.randomUUID().toString(), c2.getId(), "Inglês", ProficiencyLevel.MEDIO, ProficiencyLevel.AVANCADO, ProficiencyLevel.MEDIO);
        languageRepository.saveAll(Arrays.asList(l1, l2, l3));

        LinkEntity link1 = new LinkEntity(UUID.randomUUID().toString(), c1.getId(), "www.aprender.com.br");
        LinkEntity link2 = new LinkEntity(UUID.randomUUID().toString(), c1.getId(), "www.github.com.br");
        LinkEntity link3 = new LinkEntity(UUID.randomUUID().toString(), c2.getId(), "www.portifolionline.com.br");
        LinkEntity link4 = new LinkEntity(UUID.randomUUID().toString(), c2.getId(), "www.marketplace.com");
        LinkEntity link5 = new LinkEntity(UUID.randomUUID().toString(), c2.getId(), "www.links.com.br");
        linkRepository.saveAll(Arrays.asList(link1, link2, link3, link4, link5));

        ToolEntity tool1 = new ToolEntity(UUID.randomUUID().toString(),  "Java");
        ToolEntity tool2 = new ToolEntity(UUID.randomUUID().toString(), "MongoDB");
        ToolEntity tool3 = new ToolEntity(UUID.randomUUID().toString(), "Entity Framework");
        ToolEntity tool4 = new ToolEntity(UUID.randomUUID().toString(), "RabbitMQ");
        ToolEntity tool5 = new ToolEntity(UUID.randomUUID().toString(), ".NET");
        toolRepository.saveAll(Arrays.asList(tool1, tool2, tool3, tool4, tool5));

        ProjectEntity proj1 = new ProjectEntity(UUID.randomUUID().toString(), c1.getId(), "E-Commerce", "www.github.com", "Projeto para e-commerce online");
        ProjectEntity proj2 = new ProjectEntity(UUID.randomUUID().toString(), c1.getId(), "Banco Online", "www.github.com", "Projeto para criar banco online");
        ProjectEntity proj3 = new ProjectEntity(UUID.randomUUID().toString(), c2.getId(), "Curriculum Online", "www.github.com", "Cadastro de currículo independente de plataforma");
        ProjectEntity proj4 = new ProjectEntity(UUID.randomUUID().toString(), c2.getId(), "Posto de Gasolina", "www.github.com", "Gerenciamento de posto de gasolina.");
        proj1.getTools().addAll(Arrays.asList(tool1, tool2));
        proj2.getTools().addAll(Arrays.asList(tool1, tool3, tool4));
        proj3.getTools().addAll(Arrays.asList(tool2, tool5));
        proj4.getTools().addAll(Arrays.asList(tool1, tool2, tool3));
        projectRepository.saveAll(Arrays.asList(proj1, proj2, proj3, proj4));

        c1.getAcademicExpList().addAll(Arrays.asList(aExp1, aExp2));
        c1.getCourses().addAll(Arrays.asList(course1, course2, course3));
        c1.getLanguages().add(l1);
        c1.getLinks().addAll(Arrays.asList(link1, link2));
        c1.getProjects().addAll(Arrays.asList(proj1, proj2));
        c1.getTools().addAll(Arrays.asList(tool1, tool2, tool3, tool4));

        c2.getCourses().add(course4);
        c2.getLanguages().addAll(Arrays.asList(l2, l3));
        c2.getLinks().addAll(Arrays.asList(link3, link4, link5));
        c2.getProjects().addAll(Arrays.asList(proj3, proj4));
        c2.getTools().addAll(Arrays.asList(tool2, tool5, tool1, tool3));

        curriculumRepository.saveAll(Arrays.asList(c1, c2));

        AddressEntity addr1 = new AddressEntity(UUID.randomUUID().toString(), c1.getId(), "8566698", "São Paulo", "São Paulo", "Brasil");
        AddressEntity addr2 = new AddressEntity(UUID.randomUUID().toString(), c2.getId(), "898222", "Minas Gerais", "Montes Claros", "Brasil");
        addressRepository.saveAll(Arrays.asList(addr1, addr2));

        c1.setAddress(addr1);
        c2.setAddress(addr2);

        curriculumRepository.saveAll(Arrays.asList(c1, c2));

    }
}
