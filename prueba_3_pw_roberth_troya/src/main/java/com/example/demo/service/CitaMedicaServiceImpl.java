package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICitaMedicaRepository;
import com.example.demo.repository.modelo.CitaMedica;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;
	
	@Override
	public void crear(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.crear(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.actualizar(citaMedica);
	}

	@Override
	public CitaMedica buscaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.eliminar(id);
	}

	@Override
	public CitaMedica buscaPorNumCita(Integer numCita) {
		// TODO Auto-generated method stub
		return citaMedicaRepository.buscarPorNumCita(numCita);
	}

	@Override
	public void actualizarPorId(Integer citaMedica) {
		// TODO Auto-generated method stub
		this.citaMedicaRepository.actualizarPorId(citaMedica);
	}

}
