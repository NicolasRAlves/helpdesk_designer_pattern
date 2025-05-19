package helpdesk_designer_pattern.chain;

import java.time.LocalTime;

import helpdesk_designer_pattern.exception.SolicitacaoInvalidaException;
import helpdesk_designer_pattern.model.Solicitacao;
import helpdesk_designer_pattern.model.Urgencia;

public class UrgenciaHorarioHandler implements Handler {
    private Handler proximo;

    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }

    public void verificar(Solicitacao solicitacao) {
        LocalTime agora = LocalTime.now();
        if (solicitacao.getUrgencia() == Urgencia.ALTA &&
                (agora.isBefore(LocalTime.of(8, 0)) || agora.isAfter(LocalTime.of(22, 0)))) {
            throw new SolicitacaoInvalidaException("Solicitação de urgência alta não pode ser processada fora do horário");
        }
        if (proximo != null) {
            proximo.verificar(solicitacao);
        }
    }
}
