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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.IPacienteService;

@RestController
@RequestMapping("ApiNomina/V1/pacientes")
public class PacienteRestFullController {
	
	@Autowired
	private IPacienteService pacienteService;
	
	@PostMapping
	public String crear(@RequestBody Paciente paciente) {
		String msj = "Paciente insertado correctamente";
		try {
			this.pacienteService.crear(paciente);
		} catch (Exception e) {
			msj = "Error intente más tarde"+e;
		}
		return msj;
	}
	
	@PutMapping
	public String actualizar(@RequestBody Paciente paciente){
		String msj = "Paciente actualizado correctamente";
		try {
			this.pacienteService.actualizar(paciente);
		} catch (Exception e) {
			msj = "Error al actualizar";
		}
		return msj;
	}
	
	@GetMapping(path = "/{idPaciente}")
	public ResponseEntity<Paciente> buscarPaciente(@PathVariable("idPaciente") Integer id) {
		Paciente empl = this.pacienteService.buscaPorId(id);
		return ResponseEntity.ok(empl);
	}
	
	@GetMapping(path = "/cedula/{idCedulaPaci}")
	public ResponseEntity<Paciente> buscarPacientePorCedula(@PathVariable("idCedulaPaci") String cedula) {
		Paciente empl = this.pacienteService.buscaPorCedula(cedula);
		return ResponseEntity.ok(empl);
	}
	
	@DeleteMapping(path = "/{idPaciente}")
	public String eliminar(@PathVariable("idPaciente") Integer id) {
		String msj = "Eliminado correctamente";
		try {
			this.pacienteService.eliminar(id);
		} catch (Exception e) {
			msj = "Error al eliminar";
		}
		return msj;
	}
	
}
