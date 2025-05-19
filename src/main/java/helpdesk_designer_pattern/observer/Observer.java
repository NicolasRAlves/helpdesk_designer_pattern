package helpdesk_designer_pattern.observer;

import helpdesk_designer_pattern.model.Solicitacao;

public interface Observer {
    void notificar(Solicitacao solicitacao);
}
