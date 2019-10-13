package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaBear extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDABEAR

	public PainelAjudaBear() {
		config(ImageTools.JOGOBEAR_BACKGROUND, ImageTools.AJUDAIMAGEMBEAR,
				ImageTools.AJUDATEXTOBEAR);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-221);
		posicoesAltMensagem.add(-373);
		posicoesAltMensagem.add(-567);
		posicoesAltMensagem.add(-628);
	}
}
