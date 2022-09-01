package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPacienteRepository;
import com.example.demo.repository.modelo.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepository pacienteRepository;
	
	@Override
	public void crear(Paciente paciente) {
		this.pacienteRepository.crear(paciente);

	}

	@Override
	public void actualizar(Paciente paciente) {
		this.pacienteRepository.actualizar(paciente);

	}

	@Override
	public Paciente buscaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.pacienteRepository.eliminar(id);

	}

	@Override
	public Paciente buscaPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return pacienteRepository.buscarPorCedula(cedula);
	}

}
