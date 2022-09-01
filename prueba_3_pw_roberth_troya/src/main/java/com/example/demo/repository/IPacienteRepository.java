package com.example.demo.repository;

import com.example.demo.repository.modelo.Paciente;

public interface IPacienteRepository {
	
	public void crear(Paciente paciente);
	public void actualizar(Paciente paciente);
	public void eliminar(Integer id);
	public Paciente buscar(Integer id);
	public Paciente buscarPorCedula(String cedula);
	
}
