package helpdesk_designer_pattern.chain;

import helpdesk_designer_pattern.model.Solicitacao;

public interface Handler {
    void setProximo(Handler proximo);
    void verificar(Solicitacao solicitacao);
}
