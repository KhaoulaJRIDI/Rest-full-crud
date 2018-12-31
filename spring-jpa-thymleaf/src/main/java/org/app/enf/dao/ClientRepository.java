package org.app.enf.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.app.enf.entities.Client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository
     extends JpaRepository<Client,Long> {
	
	
	public Optional<Client> findById(Long id);
	public List<Client> findByNom(String n);
	
	public Page<Client> findByNom(String n, Pageable pageable);
	
	@Query("select c from Client c where c.nom like :x")
	public Page<Client> chercherClient(@Param("x") String mc,Pageable pageable);

	
	@Query("select c from Client c where c.dateNaissance > :x and c.dateNaissance < :y")
	public List<Client> chercherClient(@Param("x")Date d1,@Param("y") Date d2);
	
	
}
