package com.perscholas.model;


import java.util.List;
import java.util.stream.Stream;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import com.perscholas.model.Person;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit test for simple App.
 */
public class AppTest
{

    private static SessionFactory factory;

    @BeforeAll
    public static void setUp() {
        factory = new Configuration().configure().buildSessionFactory();
        // Initialize database with test data if necessary
    }

    @AfterAll
    public static void tearDown() {
        if (factory != null) {
            factory.close();
        }
    }

    @ParameterizedTest
    @MethodSource("provideNames")
    public void testPersonLookupByName(String name, String expectedName) {
        Person person = Person.personLookupByName(name);
        if (expectedName == null) {
            assertNull(person, "Expected no person to be found with name: " + name);
        } else {
            assertNotNull(person, "Expected a person to be found with name: " + name);
            assertEquals(expectedName, person.getName(), "Person name should match the expected name");
        }
    }

    private static Stream<Arguments> provideNames() {
        return Stream.of(
                Arguments.of("Bill Board", "Bill Board"),
                Arguments.of("Bonnie Ann Clyde", "Bonnie Ann Clyde"),
                Arguments.of("Non Existent", null)
        );
    }
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Session session = factory.openSession();
//
//        Transaction t = session.beginTransaction();
        //========================
        // GOAL:   Test that a Person Object exists in the database
        // with name="Bill Board"
        //=========================

        //===========================================
        /*String sql = "SELECT name FROM Person WHERE name ='Bill Board'";
        Query query = session.createNativeQuery(sql);
        List<Object[]> person = query.getResultList();
        if(person.isEmpty()){
            assertEquals("no", "rows found");
        }
        Object tmp = person.get(0);
        Person testPerson = new Person();
        testPerson.setName("Bill Board");
        assertEquals(tmp.toString(), testPerson.getName()); */

//        session.close();
//        System.out.println("Session Closed");


    @ParameterizedTest
    @MethodSource("provideCities")
    public void testAddressLookup(String city, String expectedCity) {
        Address address = Address.addressLookupByCity(city);
        if (expectedCity == null) {
            assertNull(address, "Expected no address to be found with city: " + city);
        } else {
            assertNotNull(address, "Expected an address to be found with city: " + city);
            assertEquals(expectedCity, address.getCity(), "Address city should match the expected city");
        }
    }

    private static Stream<Arguments> provideCities() {
        return Stream.of(
                Arguments.of("nyc", "nyc"),
                Arguments.of("Queens", "Queens"),
                Arguments.of("Non Existent City", null)
        );
    }

        //========================
        // GOAL:   Test that a Address Object exists in the database
        // with city="nyc"
        //=========================
////        SessionFactory factory = new Configuration().configure().buildSessionFactory();
////        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Session session = AppTest.factory.openSession();
//        Transaction t = session.beginTransaction();
//        String sql = "SELECT city FROM Address WHERE city ='nyc'";
//        TypedQuery<Object[]> query = session.createQuery(sql,
//                Object[].class);
//        List<Object[]> results = query.getResultList();
//        if(results.isEmpty()){
//            System.out.println("We do not have that city in the db");
//        }
//
//        for (Object[] a : results) {
//            //System.out.printf("%s. %s%n", a[0], a[1]);
//            Address newyork = new Address();
//            newyork.setCity("nyc");
//            assertEquals(a[0].toString(), newyork.getCity());
//        }
//        session.close();
//        System.out.println("Session Closed");
}


