package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Doctor;
import com.example.demo.service.IDoctorService;

@RestController
@RequestMapping("ApiNomina/V1/doctores")
public class DoctorRestFullController {
	
	@Autowired
	private IDoctorService doctorService;
	
	@PostMapping
	public String crear(@RequestBody Doctor doctor) {
		String msj = "Doctor insertado correctamente";
		try {
			this.doctorService.crear(doctor);
		} catch (Exception e) {
			msj = "Error intente más tarde"+e;
		}
		return msj;
	}
	
	@PutMapping
	public String actualizar(@RequestBody Doctor doctor){
		String msj = "Doctor actualizado correctamente";
		try {
			this.doctorService.actualizar(doctor);
		} catch (Exception e) {
			msj = "Error al actualizar";
		}
		return msj;
	}
	
	@GetMapping(path = "/{idDoctor}")
	public ResponseEntity<Doctor> buscarDoctor(@PathVariable("idDoctor") Integer id) {
		Doctor empl = this.doctorService.buscaPorId(id);
		return ResponseEntity.ok(empl);
	}
	
	@DeleteMapping(path = "/{idDoctor}")
	public String eliminar(@PathVariable("idDoctor") Integer id) {
		String msj = "Eliminado correctamente";
		try {
			this.doctorService.eliminar(id);
		} catch (Exception e) {
			msj = "Error al eliminar";
		}
		return msj;
	}
	

}
