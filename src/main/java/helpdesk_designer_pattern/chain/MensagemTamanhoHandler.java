package helpdesk_designer_pattern.chain;

import helpdesk_designer_pattern.exception.SolicitacaoInvalidaException;
import helpdesk_designer_pattern.model.Solicitacao;

public class MensagemTamanhoHandler implements Handler {
    private Handler proximo;

    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }

    public void verificar(Solicitacao solicitacao) {
        if (solicitacao.getMensagem() == null || solicitacao.getMensagem().length() < 10) {
            throw new SolicitacaoInvalidaException("Mensagem deve ter no mínimo 10 caracteres");
        }
        if (proximo != null) {
            proximo.verificar(solicitacao);
        }
    }
}
