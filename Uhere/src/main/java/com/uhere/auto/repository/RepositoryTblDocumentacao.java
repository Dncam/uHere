package com.uhere.auto.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import com.uhere.auto.entity.TblDocumentacao;

public interface RepositoryTblDocumentacao extends JpaRepository<TblDocumentacao, Long>{
	
	@Cacheable
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Override
	public List<TblDocumentacao> findAll() ;
	
	@Cacheable
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	@Override
	public TblDocumentacao findOne(Long chave) ;
	
}
