package helpdesk_designer_pattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import helpdesk_designer_pattern.chain.DiaUtilHandler;
import helpdesk_designer_pattern.chain.FinanceiroHorarioHandler;
import helpdesk_designer_pattern.chain.Handler;
import helpdesk_designer_pattern.chain.MensagemTamanhoHandler;
import helpdesk_designer_pattern.chain.UrgenciaHorarioHandler;
import helpdesk_designer_pattern.model.Solicitacao;
import helpdesk_designer_pattern.observer.LogObserver;
import helpdesk_designer_pattern.observer.Notificador;
import helpdesk_designer_pattern.observer.UsuarioObserver;
import helpdesk_designer_pattern.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private Notificador notificador;

    @Autowired
    private UsuarioObserver usuarioObserver;

    @Autowired
    private LogObserver logObserver;

    @jakarta.annotation.PostConstruct
    public void initObservers() {
        notificador.adicionarObservador(usuarioObserver);
        notificador.adicionarObservador(logObserver);
    }

    public void processar(Solicitacao solicitacao) {
        Handler mensagemHandler = new MensagemTamanhoHandler();
        Handler diaUtilHandler = new DiaUtilHandler();
        Handler urgenciaHandler = new UrgenciaHorarioHandler();
        Handler financeiroHandler = new FinanceiroHorarioHandler();

        mensagemHandler.setProximo(diaUtilHandler);
        diaUtilHandler.setProximo(urgenciaHandler);
        urgenciaHandler.setProximo(financeiroHandler);

        mensagemHandler.verificar(solicitacao);

        solicitacaoRepository.save(solicitacao);
        notificador.notificar(solicitacao);
    }
}