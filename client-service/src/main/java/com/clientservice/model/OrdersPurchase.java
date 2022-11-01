package com.clientservice.model;

public class OrdersPurchase {
	
	private String fechaOrden;
	private Integer idperson;
	private Integer idmoneda;
	private Integer montoCambio;
	private Integer montoRecibe;


	public OrdersPurchase(String fechaOrden, Integer idperson, Integer idmoneda, Integer montoCambio,
			Integer montoRecibe) {
		super();
		this.fechaOrden = fechaOrden;
		this.idperson = idperson;
		this.idmoneda = idmoneda;
		this.montoCambio = montoCambio;
		this.montoRecibe = montoRecibe;
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

}
