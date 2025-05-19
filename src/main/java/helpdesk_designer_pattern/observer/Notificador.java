package helpdesk_designer_pattern.observer;

import java.util.ArrayList;
import java.util.List;

import helpdesk_designer_pattern.model.Solicitacao;
import org.springframework.stereotype.Component;

@Component
public class Notificador {
    private List<Observer> observadores = new ArrayList<>();

    public void adicionarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void notificar(Solicitacao solicitacao) {
        for (Observer observador : observadores) {
            observador.notificar(solicitacao);
        }
    }
}
