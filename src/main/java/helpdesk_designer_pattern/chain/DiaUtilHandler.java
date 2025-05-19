package helpdesk_designer_pattern.chain;

import java.time.DayOfWeek;
import java.time.LocalDate;

import helpdesk_designer_pattern.exception.SolicitacaoInvalidaException;
import helpdesk_designer_pattern.model.Solicitacao;

public class DiaUtilHandler implements Handler {
    private Handler proximo;

    public void setProximo(Handler proximo) {
        this.proximo = proximo;
    }

    public void verificar(Solicitacao solicitacao) {
        DayOfWeek hoje = LocalDate.now().getDayOfWeek();
        if (hoje == DayOfWeek.SATURDAY || hoje == DayOfWeek.SUNDAY) {
            throw new SolicitacaoInvalidaException("Solicitação não pode ser processada em fins de semana");
        }
        if (proximo != null) {
            proximo.verificar(solicitacao);
        }
    }
}
