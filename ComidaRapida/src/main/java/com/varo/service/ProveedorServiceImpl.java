package com.varo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.varo.dao.ProveedorDao;
import com.varo.model.Proveedor;

@Transactional(readOnly = true)
public class ProveedorServiceImpl implements ProveedorService {

	private ProveedorDao proveedorDao;
	
	/**
	 * Get Proveedor dao
	 * 
	 * @return ProveedorDao
	 */
	public ProveedorDao getProveedorDao() {
		return proveedorDao;
	}

	/**
	 * Set Proveedor dao
	 * 
	 * @param ProveedorDao - proveedorDao
	 */
	public void setProveedorDao(ProveedorDao proveedorDao) {
		this.proveedorDao = proveedorDao;
	}

	/**
	 * Insertar Proveedor
	 * 
	 * @param Proveedor proveedor
	 */
	@Transactional(readOnly = false)
	public void insertarProveedor(Proveedor proveedor) {
		getProveedorDao().insertarProveedor(proveedor);
	}

	/**
	 * Borrar Proveedor
	 * 
	 * @param Proveedor proveedor
	 */
	@Transactional(readOnly = false)
	public void borrarProveedor(Proveedor proveedor) {
		getProveedorDao().borrarProveedor(proveedor);
	}

	/**
	 * Modificar Proveedor
	 * 
	 * @param Proveedor proveedor
	 */
	@Transactional(readOnly = false)
	public void modificarProveedor(Proveedor proveedor) {
		getProveedorDao().modificarProveedor(proveedor);
	}

	/**
	 * Buscar Todos Proveedor
	 * 
	 * @return List - Proveedor list
	 */
	public List<Proveedor> buscarTodosProveedores() {
		return getProveedorDao().buscarTodosProveedores();
	}

	/**
	 * Buscar Proveedor por id
	 * 
	 * @param Long - idProveedor
	 * @return Proveedor
	 */
	public Proveedor buscarProveedorPorId(Long idProveedor) {
		return getProveedorDao().buscarProveedorPorId(idProveedor);
	}
	
	/**
	 * Buscar Proveedor por nombre
	 * 
	 * @param String - nombre
	 * @return List - Proveedor list
	 */
	public List<Proveedor> buscarProveedoresPorNombre(String nombre) {
		return getProveedorDao().buscarProveedoresPorNombre(nombre);
	}

}
