package com.mphasis.service;
import java.util.List;

import com.mphasis.pojo.Person;
import com.mphasis.util.InvalidPersonException;

public interface PersonService {
	boolean addNewPerson(Person p) throws InvalidPersonException;
	Person findPersonByName(String name) throws InvalidPersonException;
	List<Person> getAllPersons();
}
