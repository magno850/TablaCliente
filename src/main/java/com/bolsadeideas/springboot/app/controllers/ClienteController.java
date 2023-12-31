package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String lista(Model model) {
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		Cliente  cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "form";
	}
	
	@RequestMapping(value="/form/{idcli}")
	public String editar(@PathVariable(value="idcli") Integer idcli, Map<String, Object> model) {
		
		Cliente cliente = null;
		
		if(idcli>0) {
			cliente = clienteDao.findOne(idcli);
		}else {
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Cliente cliente) {
		clienteDao.save(cliente);
		return "redirect:listar";
	}
	
	@RequestMapping(value="/eliminar/{idcli}")
	public String eliminar(@PathVariable(value="idcli") Integer idcli) {
		if(idcli>0) {
			clienteDao.delete(idcli);
		}
		return "redirect:/listar";
	}
}
