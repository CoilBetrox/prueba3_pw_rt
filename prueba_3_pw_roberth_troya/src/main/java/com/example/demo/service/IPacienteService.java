package com.example.demo.service;

import com.example.demo.repository.modelo.Paciente;

public interface IPacienteService {

	public void crear(Paciente paciente);
	public void actualizar(Paciente paciente);
	public Paciente buscaPorId(Integer id);
	public void eliminar(Integer id);
	public Paciente buscaPorCedula(String cedula);
}
