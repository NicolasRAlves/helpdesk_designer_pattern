package helpdesk_designer_pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk_designer_pattern.model.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    
}
