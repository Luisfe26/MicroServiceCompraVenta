package com.clientservice.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;



@Entity
@Table(name = "persona")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona")
    private Integer idpersona;


    @Size(min = 7, max = 14, message = "La identificación debe poseer mas de 7 digito")
    @Column(name = "DNI", nullable = false, length = 20)
    private String dni;


    @Size(min = 4, max = 50, message = "El nombre debe poseer mas de 4 caracteres")
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;


    @Size(min = 3, max = 50, message = "El apellido debe poseer mas de 3 caracteres")
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;


    @Email
    @Column(name = "email", nullable = true, length = 50)
    private String email;


    @Size(min = 7, max = 14, message = "El telefono debe poseer mas de 7 caracteres")
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "idpais", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "FK_nacionalidad_cliente"))
    private Country pais;


    @Size(min = 7, max = 150, message = "La direccón debe poseer mas de 7 digito")
    @Column(name = "direccion", nullable = false, length = 150)
    private String direccion;


    @Size(min = 8, max = 14, message = "El password debe poseer mas de 8 caracteres")
    @Column(name = "contraseña", nullable = false, length = 150)
    private String contraseña;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "personarol",
            joinColumns = @JoinColumn(name = "idpersona", referencedColumnName = "idpersona"),
            inverseJoinColumns = @JoinColumn(name = "idrol", referencedColumnName = "idrol"))
    private List<Rol> roles;

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Country getPais() {
		return pais;
	}

	public void setPais(Country pais) {
		this.pais = pais;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Person() {
		super();
	}
    
    
}
