package helpdesk_designer_pattern.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import helpdesk_designer_pattern.model.Notificacao;
import helpdesk_designer_pattern.model.Solicitacao;
import helpdesk_designer_pattern.model.TipoNotificacao;
import helpdesk_designer_pattern.repository.NotificacaoRepository;

@Component
public class LogObserver implements Observer {
    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public void notificar(Solicitacao solicitacao) {
        Notificacao notificacao = new Notificacao(TipoNotificacao.LOG, "Solicitação registrada: " + solicitacao.getMensagem());
        notificacaoRepository.save(notificacao);
    }
}