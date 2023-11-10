package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcli;
    private String nombre;
    
    public Integer getIdcli() {
		return idcli;
	}

	public void setIdcli(Integer idcli) {
		this.idcli = idcli;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
    
    
}
