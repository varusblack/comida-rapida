package com.varo.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import com.varo.model.Proveedor;
import com.varo.service.ProveedorService;

@ManagedBean(name = "ProveedorMB")
@RequestScoped
public class ProveedorManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ProveedorService}")
	private ProveedorService proveedorService;
	
	private List<Proveedor> proveedores;
	private List<Proveedor> proveedoresFiltrados; 
	private Proveedor proveedorSeleccionado;
	
	private String nombreABuscar;
	
	/**
	 * @return the proveedorService
	 */
	public ProveedorService getProveedorService() {
		return proveedorService;
	}

	/**
	 * @param proveedorService the proveedorService to set
	 */
	public void setProveedorService(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}

	/**
	 * @return the proveedores
	 */
	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	/**
	 * @param proveedores the proveedores to set
	 */
	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	/**
	 * @return the proveedoresFiltrados
	 */
	public List<Proveedor> getProveedoresFiltrados() {
		return proveedoresFiltrados;
	}
	
	/**
	 * @param proveedoresFiltrados the proveedoresFiltrados to set
	 */
	public void setProveedoresFiltrados(List<Proveedor> proveedoresFiltrados) {
		this.proveedoresFiltrados = proveedoresFiltrados;
	}
	
	/**
	 * @return the nombreABuscar
	 */
	public String getNombreABuscar() {
		return nombreABuscar;
	}

	/**
	 * @param nombreABuscar the nombreABuscar to set
	 */
	public void setNombreABuscar(String nombreABuscar) {
		this.nombreABuscar = nombreABuscar;
	}
	
	/**
	 * @return the proveedorSeleccionado
	 */
	public Proveedor getProveedorSeleccionado() {
		return proveedorSeleccionado;
	}
	
	/**
	 * @param proveedorSeleccionado the proveedorSeleccionado to set
	 */
	public void setProveedorSeleccionado(Proveedor proveedorSeleccionado) {
		this.proveedorSeleccionado = proveedorSeleccionado;
	}
	
	public void buscarProveedorPorNombre () {
		List<Proveedor> proveedoresEncontrados = new ArrayList<Proveedor>();
		proveedoresEncontrados.addAll(getProveedorService().buscarProveedoresPorNombre(nombreABuscar));
		setProveedores(proveedoresEncontrados);
	}


	
	
	
}
