package com.varo.service;

import java.util.List;

import com.varo.model.Proveedor;

public interface ProveedorService {
	
	/**
	 * Insertar Proveedor
	 * 
	 * @param Proveedor proveedor
	 */
	public void insertarProveedor(Proveedor proveedor);

	/**
	 * Borrar Proveedor
	 * 
	 * @param Proveedor proveedor
	 */
	public void borrarProveedor(Proveedor proveedor);

	/**
	 * Modificar Proveedor
	 * 
	 * @param Proveedor proveedor
	 */
	public void modificarProveedor(Proveedor proveedor);

	/**
	 * Buscar Todos Proveedor
	 * 
	 * @return List - Proveedor list
	 */
	public List<Proveedor> buscarTodosProveedores();
	
	/**
	 * Buscar Proveedor por id
	 * 
	 * @param Long - idProveedor
	 * @return Proveedor
	 */
	public Proveedor buscarProveedorPorId(Long idProveedor);
	
	/**
	 * Buscar Proveedor por nombre
	 * 
	 * @param String - nombre
	 * @return List - Proveedor list
	 */
	public List<Proveedor> buscarProveedoresPorNombre(String nombre);

}
