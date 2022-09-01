package com.example.demo.service;

import com.example.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaService {

	public void crear(CitaMedica citaMedica);
	public void actualizar(CitaMedica citaMedica);
	public CitaMedica buscaPorId(Integer id);
	public void eliminar(Integer id);
	public CitaMedica buscaPorNumCita(Integer numCita);
	public void actualizarPorId(Integer citaMedica);
	
}
