package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Paciente;

import net.bytebuddy.asm.Advice.This;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);

	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		this.entityManager.merge(citaMedica);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));

	}

	@Override
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public CitaMedica buscarPorNumCita(Integer numeroCita) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT e FROM CitaMedica e WHERE e.numeroCita =:numCitaDato", CitaMedica.class);
		myQuery.setParameter("numCitaDato", numeroCita);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizarPorId(Integer citaMedica) {
		this.entityManager.merge(this.buscarPorNumCita(citaMedica));
		
	}

	@Override
	public List<CitaMedica> buscarCitasPendientes(Integer idDoctor) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT e FROM CitaMedica e INNER JOIN doctor d ON e.doct_id = d.doct_id WHERE e.diagnostico =:null", CitaMedica.class);
		myQuery.setParameter("null", idDoctor);
		return myQuery.getResultList();
	}
	
	

}
