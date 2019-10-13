package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaPig extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDAPIG

	public PainelAjudaPig() {
		config(ImageTools.JOGOPIG_BACKGROUND, ImageTools.AJUDAIMAGEMPIG,
				ImageTools.AJUDATEXTOPIG);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-222);
		posicoesAltMensagem.add(-374);
		posicoesAltMensagem.add(-570);
		posicoesAltMensagem.add(-636);
	}
}
