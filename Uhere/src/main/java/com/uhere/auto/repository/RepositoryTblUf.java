package com.uhere.auto.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import com.uhere.auto.entity.TblUf;

public interface RepositoryTblUf extends JpaRepository<TblUf, String>{
	
	@Cacheable
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Override
	public List<TblUf> findAll() ;
	
	@Cacheable
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Override
	public TblUf findOne(String chave) ;
	
}
