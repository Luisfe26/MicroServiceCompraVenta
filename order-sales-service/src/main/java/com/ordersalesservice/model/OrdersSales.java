package com.ordersalesservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ordersales")
public class OrdersSales {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idordensales;

    @Size(min = 8, max = 8, message = "LA FECHA DEBE DE TENER 8 CARACTERES")
    @Column(name = "fechaorden", nullable = false)
    private String fechaOrden;

    @Column(name = "idperson", nullable = false)
    private Integer idperson;

    @Column(name = "idmoneda", nullable = false)
    private Integer idmoneda;

    @Positive
    @Column(name = "montocambio", nullable = false)
    private Integer montoCambio;

    @Positive
    @Column(name = "montorecibe", nullable = false)
    private Integer montoRecibe;

	public Integer getIdordensales() {
		return idordensales;
	}

	public void setIdordensales(Integer idordensales) {
		this.idordensales = idordensales;
	}

	public String getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(String fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public Integer getIdperson() {
		return idperson;
	}

	public void setIdperson(Integer idperson) {
		this.idperson = idperson;
	}

	public Integer getIdmoneda() {
		return idmoneda;
	}

	public void setIdmoneda(Integer idmoneda) {
		this.idmoneda = idmoneda;
	}

	public Integer getMontoCambio() {
		return montoCambio;
	}

	public void setMontoCambio(Integer montoCambio) {
		this.montoCambio = montoCambio;
	}

	public Integer getMontoRecibe() {
		return montoRecibe;
	}

	public void setMontoRecibe(Integer montoRecibe) {
		this.montoRecibe = montoRecibe;
	}

	public OrdersSales() {
		super();
	}
    

}
