package ar.edu.unju.fi.tp3.controller;

import java.time.LocalDate;
import java.time.Period;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.tp3.model.Cliente;
import ar.edu.unju.fi.tp3.service.IClienteService;


@Controller
public class ClienteController {
	private static final Log BELLA = LogFactory.getLog(ClienteController.class);

	@Autowired
	IClienteService clienteService;

	@GetMapping("/cliente/mostrar")
	public String cargarCliente(Model model) {
		model.addAttribute("unCliente", clienteService.crearCliente());
		model.addAttribute("clientes", clienteService.obtenerTodosClientes());
		return("cliente");
	}

	@PostMapping("/cliente/guardar")
	public String guardarNuevoProducto(@ModelAttribute("unCliente") Cliente nuevoCliente, Model model) {
		BELLA.info("METHOD: ingresando el metodo Guardar");
		clienteService.guardarCliente(nuevoCliente);		
		BELLA.info("Tamaño del Listado: "+ clienteService.obtenerTodosClientes().size());
		trabajarConFechas();
		return "redirect:/cliente/mostrar";
	}
	
	public void trabajarConFechas() {
		//algunas cosas con fecha;
		//obtengo tres fechas
		LocalDate fecha1 = clienteService.obtenerTodosClientes().get(0).getFechaNacimiento();
		LocalDate fecha2 = LocalDate.now();
		@SuppressWarnings("unused")
		LocalDate fecha3 = LocalDate.of(2021, 4, 22);
		
		//calculo el período entre dos de ellas
		Period periodo = Period.between(fecha1,fecha2);
		int dias = periodo.getDays();		
		System.out.println("dias: "+dias);
	}
}