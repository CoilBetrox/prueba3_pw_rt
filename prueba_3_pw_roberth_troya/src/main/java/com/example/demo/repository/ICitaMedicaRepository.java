package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaRepository {
	
	public void crear(CitaMedica citaMedica);
	public void actualizar(CitaMedica citaMedica);
	public void actualizarPorId(Integer citaMedica);
	
	public void eliminar(Integer id);
	public CitaMedica buscar(Integer id);
	public CitaMedica buscarPorNumCita(Integer numeroCita);
	public List<CitaMedica> buscarCitasPendientes(Integer idDoctor);
	
	

}
