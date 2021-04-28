package ar.edu.unju.fi.tp3.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp3.model.Cliente;
import ar.edu.unju.fi.tp3.service.IClienteService;
import ar.edu.unju.fi.tp3.util.ListadoClientes;

@Service
public class ClienteServiceImp implements IClienteService {
	
	private List<Cliente> listadoClientes = ListadoClientes.clientes;
	
	@Autowired
	Cliente unCliente;

	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		listadoClientes.add(unCliente);		
	}
	
	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return listadoClientes;
	}

}