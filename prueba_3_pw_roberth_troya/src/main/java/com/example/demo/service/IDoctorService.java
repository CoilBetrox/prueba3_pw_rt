package com.example.demo.service;

import com.example.demo.repository.modelo.Doctor;

public interface IDoctorService {
	
	public void crear(Doctor doctor);
	public void actualizar(Doctor doctor);
	public Doctor buscaPorId(Integer id);
	public void eliminar(Integer id);
}
