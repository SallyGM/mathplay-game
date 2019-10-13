package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaCat extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDACAT

	public PainelAjudaCat() {
		config(ImageTools.JOGOCAT_BACKGROUND, ImageTools.AJUDAIMAGEMCAT,
				ImageTools.AJUDATEXTOCAT);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-245);
		posicoesAltMensagem.add(-379);
		posicoesAltMensagem.add(-576);
		posicoesAltMensagem.add(-660);
	}
}
