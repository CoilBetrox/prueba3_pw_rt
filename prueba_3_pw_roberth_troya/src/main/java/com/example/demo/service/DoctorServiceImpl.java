package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IDoctorRepository;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.service.to.DoctorTo;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Override
	public void crear(Doctor doctor) {
		this.doctorRepository.crear(doctor);

	}

	@Override
	public void actualizar(Doctor doctor) {
		this.doctorRepository.actualizar(doctor);
	}

	@Override
	public Doctor buscaPorId(Integer id) {
		
		return this.doctorRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.doctorRepository.eliminar(id);

	}
	
	
	private DoctorTo convertir(Doctor doctor) {
		DoctorTo doct = new DoctorTo();
		doct.setId(doctor.getId());
		doct.setCedula(doctor.getCedula());
		doct.setNombre(doctor.getNombre());
		doct.setApellido(doctor.getApellido());
		doct.setFechaNacimiento(doctor.getFechaNacimiento());
		doct.setNumeroConsultorio(doctor.getNumeroConsultorio());
		doct.setCodigoSenescyt(doctor.getCodigoSenescyt());
		doct.setGenero(doctor.getGenero());
		
		return doct;
	}

}
