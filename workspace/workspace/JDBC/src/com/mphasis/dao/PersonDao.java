package com.mphasis.dao;

import java.util.List;

import com.mphasis.pojo.Person;

public interface PersonDao {
	boolean addPerson(Person p);
	Person findPerson(String name);
	List<Person> getAll();
}
