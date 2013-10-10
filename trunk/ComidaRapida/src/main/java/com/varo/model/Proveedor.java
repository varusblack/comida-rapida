package com.varo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

	private Long id;
	private String nombre;
	private String web;
	private String email;
	private String telefono;
	private String direccion;

	/**
	 * Get id Proveedor
	 * 
	 * @return Long - id Proveedor
	 */
	@Id
	@Column(name = "id_proveedor", nullable = false)
	public Long getId() {
		return id;
	}

	/**
	 * Set id Proveedor
	 * 
	 * @param Long - id Proveedor
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get Proveedor nombre
	 * 
	 * @return String - Proveedor nombre
	 */
	@Column(name = "nombre", unique = true, nullable = false)
	public String getNombre() {
		return nombre;
	}

	/**
	 * Set Proveedor nombre
	 * 
	 * @param String - Proveedor nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Get Proveedor web
	 * 
	 * @return String - Proveedor web
	 */
	@Column(name = "web")
	public String getWeb() {
		return web;
	}

	/**
	 * Set Proveedor web
	 * 
	 * @param String - Proveedor web
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	
	/**
	 * Get Proveedor email
	 * 
	 * @return String - Proveedor email
	 */
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	/**
	 * Set Proveedor email
	 * 
	 * @param String - Proveedor email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Get Proveedor telefono
	 * 
	 * @return String - Proveedor telefono
	 */
	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Set Proveedor telefono
	 * 
	 * @param String - Proveedor telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Get Proveedor direccion
	 * 
	 * @return String - Proveedor direccion
	 */
	@Column(name = "direccion")
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Set Proveedor direccion
	 * 
	 * @param String - Proveedor direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
