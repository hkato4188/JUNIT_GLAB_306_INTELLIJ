package com.perscholas.model;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;



@Entity
@Table
public class Person {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int PersonId;
    private String name;
    private String email;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private Address adress;
    public Person(int personId, String name, String email, int age) {
        super();
        PersonId = personId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Person()
    {
    }
    public Address getAdress() {
        return adress;
    }
    public void setAdress(Address adress) {
        this.adress = adress;
    }
    public int getPersonId() {
        return PersonId;
    }
    public void setPersonId(int personId) {
        PersonId = personId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public static Person personLookupByName(String name){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Person WHERE name = :name";
        TypedQuery<Person> query = session.createQuery(hql, Person.class);
        query.setParameter("name", name);
        List<Person> results = query.getResultList();
        Person foundPerson = results.isEmpty() ? null : results.get(0);

        session.close();
        return foundPerson;
    }


}


