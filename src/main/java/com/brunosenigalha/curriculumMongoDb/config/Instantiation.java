package com.brunosenigalha.curriculumMongoDb.config;

import com.brunosenigalha.curriculumMongoDb.entities.AcademicExp;
import com.brunosenigalha.curriculumMongoDb.entities.AddressEntity;
import com.brunosenigalha.curriculumMongoDb.entities.Course;
import com.brunosenigalha.curriculumMongoDb.entities.CurriculumEntity;
import com.brunosenigalha.curriculumMongoDb.entities.enums.*;
import com.brunosenigalha.curriculumMongoDb.repositories.AcademicExpRepository;
import com.brunosenigalha.curriculumMongoDb.repositories.AddressRepository;
import com.brunosenigalha.curriculumMongoDb.repositories.CourseRepository;
import com.brunosenigalha.curriculumMongoDb.repositories.CurriculumRepository;
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

    @Override
    public void run(String... args) throws Exception {

        curriculumRepository.deleteAll();
        courseRepository.deleteAll();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        CurriculumEntity c1 = new CurriculumEntity(UUID.randomUUID().toString(), " ", "João Carlos", Gender.MASCULINO,
                "Desenvolvedor de Sistemas", "85555855", "joao@gmail.com", "www.linkedin.com/joao");
        CurriculumEntity c2 = new CurriculumEntity(UUID.randomUUID().toString(), " ", "Maria", Gender.FEMININO,
                "Product Manager", "87777777", "maria@gmail.com", "www.linkedin.com/maria");


        Course course1 = new Course(null, TypeCourse.CURSO, "Java", "Curso completo de Java");
        Course course2 = new Course(null, TypeCourse.CERTIFICACAO, "AWS", "Certificação de AWS");
        Course course3 = new Course(null, TypeCourse.CURSO, "MongoDB", "Curso completo de MongoDB");
        Course course4 = new Course(null, TypeCourse.CURSO, ".NET", "Curso completo de .NET");
        courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4));

        AcademicExp aExp1 = new AcademicExp(null, "Analise de Sistemas", "PUC", Degree.GRADUACAO, FormationType.SUPERIOR, FormationStatus.COMPLETO, false, LocalDate.parse("21/03/2020", fmt), LocalDate.parse("25/04/2024", fmt));
        AcademicExp aExp2 = new AcademicExp(null, "Engenharia de Alimentos", "Unesp", Degree.MESTRADO, FormationType.SUPERIOR, FormationStatus.EM_ANDAMENTO, false, LocalDate.parse("24/08/2023", fmt), LocalDate.parse("12/01/2026", fmt));
        academicExpRepository.saveAll(Arrays.asList(aExp1, aExp2));

        c1.getAcademicExpList().addAll(Arrays.asList(aExp1, aExp2));

        c1.getCourses().addAll(Arrays.asList(course1, course2, course3));
        c2.getCourses().add(course4);

        curriculumRepository.saveAll(Arrays.asList(c1, c2));

        AddressEntity addr1 = new AddressEntity(null, c1.getId(), "8566698", "São Paulo", "São Paulo", "Brasil");
        AddressEntity addr2 = new AddressEntity(null, c2.getId(), "898222", "Minas Gerais", "Montes Claros", "Brasil");
        addressRepository.saveAll(Arrays.asList(addr1, addr2));

        c1.setAddress(addr1);
        c2.setAddress(addr2);

        curriculumRepository.saveAll(Arrays.asList(c1, c2));

    }
}
