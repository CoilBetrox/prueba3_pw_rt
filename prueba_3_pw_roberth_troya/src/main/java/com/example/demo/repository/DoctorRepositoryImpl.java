package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Doctor doctor) {
		this.entityManager.persist(doctor);
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.entityManager.merge(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Doctor buscar(Integer id) {
		return this.entityManager.find(Doctor.class, id);
	}

}
