package com.clientservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpais;

    @Size(min = 3, max = 30, message = "El nombre debe tener un minimo de 3 caracteres")
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Size(min = 2, max = 2, message = "El codigo del pais es obligatorio")
    @Column(name = "codpais", nullable = false, length = 2)
    private String codpais;

	public Integer getIdpais() {
		return idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodpais() {
		return codpais;
	}

	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}

	public Country() {
		super();
	}
    
}
