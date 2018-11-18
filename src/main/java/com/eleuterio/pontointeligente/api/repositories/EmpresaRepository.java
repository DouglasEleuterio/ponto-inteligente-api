package com.eleuterio.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.eleuterio.pontointeligente.api.entities.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	//Devido a realizar apenas uma consulta no banco, ele nao necessita bloquear a transacao, dessa forma com a anotacao ganhamos performance
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);

}
