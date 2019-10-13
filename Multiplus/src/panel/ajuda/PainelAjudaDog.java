package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaDog extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDADOG

	public PainelAjudaDog() {
		config(ImageTools.JOGODOG_BACKGROUND, ImageTools.AJUDAIMAGEMDOG,
				ImageTools.AJUDATEXTODOG);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-247);
		posicoesAltMensagem.add(-381);
		posicoesAltMensagem.add(-577);
		posicoesAltMensagem.add(-649);
	}
}
