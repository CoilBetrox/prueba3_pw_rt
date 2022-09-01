package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Paciente paciente) {
		this.entityManager.persist(paciente);

	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);

	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));

	}

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT e FROM Paciente e WHERE e.cedula =:cedulaDato", Paciente.class);
		myQuery.setParameter("cedulaDato", cedula);
		return myQuery.getSingleResult();
	}

}
