package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaBat extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDABAT

	public PainelAjudaBat() {
		config(ImageTools.JOGOBAT_BACKGROUND, ImageTools.AJUDAIMAGEMBAT,
				ImageTools.AJUDATEXTOBAT);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-243);
		posicoesAltMensagem.add(-378);
		posicoesAltMensagem.add(-574);
		posicoesAltMensagem.add(-660);
	}
}
