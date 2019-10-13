package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaMouse extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDAMOUSE

	public PainelAjudaMouse() {
		config(ImageTools.JOGOMOUSE_BACKGROUND, ImageTools.AJUDAIMAGEMMOUSE,
				ImageTools.AJUDATEXTOMOUSE);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-244);
		posicoesAltMensagem.add(-355);
		posicoesAltMensagem.add(-556);
		posicoesAltMensagem.add(-634);
	}
}
