package helpdesk_designer_pattern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk_designer_pattern.model.Notificacao;
import helpdesk_designer_pattern.model.TipoNotificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    List<Notificacao> findByTipo(TipoNotificacao tipo);
        
}
