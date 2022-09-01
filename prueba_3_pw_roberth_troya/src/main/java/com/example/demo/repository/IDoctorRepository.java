package com.example.demo.repository;

import com.example.demo.repository.modelo.Doctor;

public interface IDoctorRepository {
	
	public void crear(Doctor doctor);
	public void actualizar(Doctor doctor);
	public void eliminar(Integer id);
	public Doctor buscar(Integer id);

}
