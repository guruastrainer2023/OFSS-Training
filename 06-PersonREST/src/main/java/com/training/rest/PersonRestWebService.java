package com.training.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.process.internal.RequestScoped;

import com.training.bean.Person;
import com.training.service.PersonManagement;

@Path("/personapi")
public class PersonRestWebService {

	private PersonManagement personManagement = new PersonManagement();

	@POST
	@Produces(value =MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public List<Person> addPerson( Person person) {
		return this.personManagement.addPerson(person);
	}

	@PUT
	@Produces(value =MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public List<Person> updatePerson(Person person) {
		return this.personManagement.updatePerson(person);
	}

	@DELETE
	@Produces(value =MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	public List<Person> deletePerson(Person person) {
		return this.personManagement.deletePerson(person);
	}

	@GET
	@Produces(value =MediaType.APPLICATION_JSON)
	@Path("/get/{id}")
	public Person fetchPersonById(@PathParam("id") int id) {
		return this.personManagement.getPersonById(id);
	}

	@GET
	@Path("/getAll")
	@Produces(value =MediaType.APPLICATION_JSON)
	public List<Person> findAllPersons() {
		return this.personManagement.getAllPersons();
	}

}
