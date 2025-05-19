package helpdesk_designer_pattern.chain;

import java.time.LocalTime;

import helpdesk_designer_pattern.exception.SolicitacaoInvalidaException;
import helpdesk_designer_pattern.model.Solicitacao;
import helpdesk_designer_pattern.model.TipoSolicitacao;

public class FinanceiroHorarioHandler implements Handler {
    private Handler proximo;

    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }

    public void verificar(Solicitacao solicitacao) {
        LocalTime agora = LocalTime.now();
        if (solicitacao.getTipo() == TipoSolicitacao.FINANCEIRO &&
                (agora.isBefore(LocalTime.of(8, 0)) || agora.isAfter(LocalTime.of(18, 0)))) {
            throw new SolicitacaoInvalidaException("Solicitação financeira só pode ser processada em horário comercial");
        }
        if (proximo != null) {
            proximo.verificar(solicitacao);
        }
    }
}
