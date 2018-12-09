package com.mphasis.service;

import java.util.List;

import com.mphasis.dao.PersonDao;
import com.mphasis.dao.PersonDaoImpl;
import com.mphasis.pojo.Person;
import com.mphasis.util.InvalidPersonException;

public class PersonServiceImpl implements PersonService {
	private PersonDao dao;
	
	public PersonServiceImpl() {
		dao = new PersonDaoImpl();
	}
	@Override
	public boolean addNewPerson(Person p) throws InvalidPersonException {
		if(p.getAge() >= 18 && p.getAge() <= 60)
			return dao.addPerson(p);
		throw new InvalidPersonException("Too yount or too old person");

	}

	@Override
	public Person findPersonByName(String name) throws InvalidPersonException {
		Person p = dao.findPerson(name);
		if(p != null)
			return p;
		else
			throw new InvalidPersonException("No such person exist: " + name);
	}

	@Override
	public List<Person> getAllPersons() {
		return dao.getAll();
	}

}
