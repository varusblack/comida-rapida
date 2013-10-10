package com.varo.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.varo.model.Proveedor;

public class ProveedorDaoImpl implements ProveedorDao {
	
	private SessionFactory sessionFactory;
	
	/**
     * Get Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
     * Set Hibernate Session Factory
     *
     * @param SessionFactory - Hibernate Session Factory
     */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Insertar Proveedor
	 * 
	 * @param Proveedor proveedor
	 */
	public void insertarProveedor(Proveedor proveedor) {
		getSessionFactory().getCurrentSession().save(proveedor);
	}

	/**
	 * Borrar Proveedor
	 * 
	 * @param Proveedor proveedor
	 */
	public void borrarProveedor(Proveedor proveedor) {
		getSessionFactory().getCurrentSession().delete(proveedor);
	}

	/**
	 * Modificar Proveedor
	 * 
	 * @param Proveedor proveedor
	 */
	public void modificarProveedor(Proveedor proveedor) {
		getSessionFactory().getCurrentSession().update(proveedor);
	}

	/**
	 * Buscar Todos Proveedor
	 * 
	 * @return List - Proveedor list
	 */
	public List<Proveedor> buscarTodosProveedores() {
		List<Proveedor> proveedores = getSessionFactory().getCurrentSession().createQuery("FROM proveedor").list();
		return proveedores;
	}

	/**
	 * Buscar Proveedor por id
	 * 
	 * @param Long - idProveedor
	 * @return Proveedor
	 */
	public Proveedor buscarProveedorPorId(Long idProveedor) {
		List<Proveedor> proveedor = getSessionFactory().getCurrentSession().createQuery("FROM proveedor WHERE id_proveedor = ?").setParameter(0, idProveedor).list();
		return proveedor.get(0);
	}

	/**
	 * Buscar Proveedor por nombre
	 * 
	 * @param String - nombre
	 * @return List - Proveedor list
	 */
	public List<Proveedor> buscarProveedoresPorNombre(String nombre) {
		List<Proveedor> proveedores = getSessionFactory().getCurrentSession().createQuery("FROM proveedor WHERE nombre LIKE '%?%'").setParameter(0, nombre).list();
		return proveedores;
	}

}
