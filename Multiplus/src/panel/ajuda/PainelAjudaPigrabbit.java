package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaPigrabbit extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDAPIGRABBIT

	public PainelAjudaPigrabbit() {
		config(ImageTools.JOGOPIGRABBIT_BACKGROUND, ImageTools.AJUDAIMAGEMPIGRABBIT,
				ImageTools.AJUDATEXTOPIGRABBIT);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-223);
		posicoesAltMensagem.add(-375);
		posicoesAltMensagem.add(-568);
		posicoesAltMensagem.add(-633);
	}
}
