package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaPanda extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDAPANDA

	public PainelAjudaPanda() {
		config(ImageTools.JOGOPANDA_BACKGROUND, ImageTools.AJUDAIMAGEMPANDA,
				ImageTools.AJUDATEXTOPANDA);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-222);
		posicoesAltMensagem.add(-376);
		posicoesAltMensagem.add(-569);
		posicoesAltMensagem.add(-630);
	}
}
