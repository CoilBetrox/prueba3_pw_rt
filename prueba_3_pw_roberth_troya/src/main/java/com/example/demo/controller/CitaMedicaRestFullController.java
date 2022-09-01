package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.service.ICitaMedicaService;

@RestController
@RequestMapping("ApiNomina/V1/citasMedicas")
public class CitaMedicaRestFullController {

	@Autowired
	private ICitaMedicaService citaMedicaService;
	
	@PostMapping
	public String crear(@RequestBody CitaMedica citaMedica) {
		String msj = "Cita Medica insertado correctamente";
		try {
			this.citaMedicaService.crear(citaMedica);
		} catch (Exception e) {
			msj = "Error intente más tarde"+e;
		}
		return msj;
	}
	
	@PutMapping
	public String actualizar(@RequestBody CitaMedica citaMedica){
		String msj = "Cita Medica actualizado correctamente";
		try {
			this.citaMedicaService.actualizar(citaMedica);
		} catch (Exception e) {
			msj = "Error al actualizar";
		}
		return msj;
	}
	
	@PatchMapping(path = "/updateCita/{idCitaMedica}")
	public String actualizarPorNumCita(@PathVariable("idCitaMedica") Integer citaMedica , @RequestBody CitaMedica citaMedic){
		String msj = "Cita Medica actualizado correctamente";
		try {
			this.citaMedicaService.actualizarPorId(citaMedica);
		} catch (Exception e) {
			msj = "Error al actualizar";
		}
		return msj;
	}
	
	@GetMapping(path = "/{idCitaMedica}")
	public ResponseEntity<CitaMedica> buscarCitaMedica(@PathVariable("idCitaMedica") Integer id) {
		CitaMedica empl = this.citaMedicaService.buscaPorId(id);
		return ResponseEntity.ok(empl);
	}
	
	@GetMapping(path = "/cita/{numCitaMedica}")
	public ResponseEntity<CitaMedica> buscarCitaMedicaPorNumCita(@PathVariable("numCitaMedica") Integer numCita) {
		CitaMedica empl = this.citaMedicaService.buscaPorNumCita(numCita);
		return ResponseEntity.ok(empl);
	}
	
	@DeleteMapping(path = "/{idCitaMedica}")
	public String eliminar(@PathVariable("idCitaMedica") Integer id) {
		String msj = "Eliminado correctamente";
		try {
			this.citaMedicaService.eliminar(id);
		} catch (Exception e) {
			msj = "Error al eliminar";
		}
		return msj;
	}
	
}
