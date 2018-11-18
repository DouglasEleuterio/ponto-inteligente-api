package com.eleuterio.pontointeligente.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.eleuterio.pontointeligente.api.entities.Lancamento;


@Transactional(readOnly = true)
@NamedQueries({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", 
				query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	/**
	 * Faz uma pesquisa no banco lancamentos vinculados ao Id de funcionario.
	 * Nativamente o Spring nao consegue realizar essa busca por que ele depende de outra entidade, por este motivo devemos realizar a consulta via Query.
	 * @param funcionarioId
	 * @return Lista de Lancamentos do Funcioario
	 */
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

	/**
	 * Faz uma pesquisa no banco lancamentos vinculados ao Id de funcionario.
	 * Nativamente o Spring nao consegue realizar essa busca por que ele depende de outra entidade, por este motivo devemos realizar a consulta via Query.
	 * @param funcionarioId
	 * @return Lista de Lancamentos com Paginacao
	 */
	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
