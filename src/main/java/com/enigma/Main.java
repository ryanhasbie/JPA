package com.enigma;

import com.enigma.config.Factory;
import com.enigma.model.Club;
import com.enigma.model.Major;
import com.enigma.model.Student;
import com.enigma.model.UserCredential;
import com.enigma.repository.ClubRepo;
import com.enigma.repository.MajorRepo;
import com.enigma.repository.StudentRepo;
import com.enigma.repository.UserCredentialRepo;
import com.enigma.service.MajorService;
import com.enigma.service.StudentService;
import com.enigma.util.Gender;
import com.enigma.util.GenerateDate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Main {

    static EntityManager entityManager = Factory.start();
    static StudentRepo studentRepo = new StudentRepo(entityManager);
    static MajorRepo majorRepo = new MajorRepo(entityManager);
    static ClubRepo clubRepo = new ClubRepo(entityManager);

    static MajorService majorService = new MajorService(majorRepo);
    static StudentService studentService = new StudentService(studentRepo, majorService);
    public static void main(String[] args) {


        Club footBall = new Club();
        footBall.setClubName("Voly");
        clubRepo.create(footBall);

        Major major = new Major();
        major.setMajorName("Tekink Informatika");
        majorService.insert(major);

        UserCredential userCredential = new UserCredential();
        userCredential.setEmail("ryan@gmail.com");
        userCredential.setPassword("rahasia");

        Student student = new Student();
        student.setFirstName("Ryan");
        student.setLastName("Hasbie");
        student.setGender(Gender.MALE);
        student.setBirthDate(GenerateDate.generate("2003-11-12"));
        student.setAddress("Karawang");

        Club football = clubRepo.findOne("ae727ad2-2cb1-4114-a9d1-f454e9a149d0");
        Club voly = clubRepo.findOne("b4184c55-da4f-4dd4-bc7d-d7746315a3e2");

        student.setClubs(football);
        student.setClubs(voly);

        studentService.insert(student, userCredential, "27d6a13e-f795-4246-8a09-8d1c0ef1aa0f");

        studentService.getAll(1, 10);







//        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("defaul");
//        EntityManager entityManager = managerFactory.createEntityManager();

        // EntityManager entityManager = Factory.start();

//        StudentRepo studentRepo = new StudentRepo(entityManager);

        //insert();
//
//        studentRepo.create(student);

//        studentRepo.findAll();

//        studentRepo.findByName("Ryan");


    //getAll(2, 4);
          // findOne();
          //update();
//       getById();
        //insert();

        //getAllByName("Ryan", 1, 1);

        //insert();

       //updateUserCredential();

       // insertStudentMajor();
     //   insertStudent();


        //insertStudentMajor();

//    Club futsal = new Club();
//    futsal.setClubName("Football");
//    clubRepo.create(futsal);

      //  insertStudent();















//        entityManager.getTransaction().begin();
//        entityManager.persist(student);
//        entityManager.getTransaction().commit();

//        List<Student> result = entityManager.createQuery("select s from Student s", Student.class).getResultList();
//
//        for (var data: result) {
//            System.out.println(data);
//        }

//        TypedQuery<Student> resultBy = entityManager.createQuery("select z from Student z where name=?1", Student.class);
//        resultBy.setParameter(1, "Ronaldo");
//        resultBy.getResultList().forEach(System.out::println);

        //delete();

    }

    static void insertStudentMajor() {
        Major major = new Major();
        major.setMajorName("Teknik Informatika");
        majorRepo.create(major);
//        UserCredential userCredential = new UserCredential("asepsilet@gmail.com", "bismillah123");
//        Student student = new Student();
//        student.setFirstName("Asep");
//        student.setLastName("Silet");
//        student.setAddress("Karawang");
//        student.setGender(Gender.MALE);
//        student.setBirthDate(GenerateDate.generate("2002-10-11"));
//        student.setMajor(major);
//        student.setUserCredential(userCredential);
//        studentRepo.create(student);
    }

//    static void insertStudent() {
//        Student student = new Student();
//        Major major = majorRepo.findOne("bc5449ad-ac5e-4bff-bdda-9b9f9f237b39");
//        Club club1 = clubRepo.findOne("b0d299a9-a7f0-4c24-9cbb-fbd2b3d0d208");
//        Club club2 = clubRepo.findOne("0dd9c056-6565-447d-b8ab-5f59525a6e4d");
//        UserCredential userCredential = new UserCredential("ryanhasbie@gmail.com", "rahasia");
//        student.setFirstName("Ryan");
//        student.setLastName("Hasbie");
//        student.setAddress("Karawang");
//        student.setGender(Gender.MALE);
//        student.setUserCredential(userCredential);
//        student.setMajor(major);
//        student.setBirthDate(GenerateDate.generate("2001-04-02"));
//        student.setClubs(club1);
//        student.setClubs(club2);
//
//        studentRepo.create(student);
//
//    }

    static void getAll(Integer page, Integer size) {
        List<Student> students = studentRepo.findAll(page, size);
        students.forEach(System.out::println);
    }

//    static void getAllByName(String name, Integer page, Integer size) {
//        List<Student> students = studentRepo.findByName(name, page, size);
//        students.forEach(System.out::println);
//    }

    static void update() {
        Student student = new Student();
        student.setStudentId("122tte636366261");
        // student.setName("Lisa Black pink");
        student.setAddress("Jl. Blackpink");

        studentRepo.update(student);
        System.out.println();
    }

    static void findOne() {
        Student student = studentRepo.findOne("f103821b-8da6-4467-ba71-9dc5494a2ed4");
        System.out.println(student);
    }

    static void delete() {
        studentRepo.delete("4b19da4b-71e6-4d41-904d-e582e5c36732");
    }

    static void getById() {
        Student student = studentRepo.getById("3c6cf915-c871-4488-abe9-a9ab53ef7a15");
        System.out.println(student);
    }

//    static void updateUserCredential() {
//        Student student = studentRepo.findOne("974ab2e9-881b-42a5-b8fb-3a8f928c9698");
//        student.setUserCredential(new UserCredential("ryanhasbieeeee@gmail.com", "rahasia"));
//        studentRepo.update(student);
//    }

}