package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteDaoImpl implements IClienteDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Integer idcli) {
		// TODO Auto-generated method stub
		return em.find(Cliente.class, idcli);
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		if(cliente.getIdcli() != null && cliente.getIdcli() >0) {
			em.merge(cliente);
		}else {
			em.persist(cliente);
		}
	}

	@Override
	@Transactional
	public void delete(Integer idcli) {
		// TODO Auto-generated method stub
		em.remove(findOne(idcli));
		
	}

}
