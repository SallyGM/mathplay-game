package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaAngel extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDAANGEL

	public PainelAjudaAngel() {
		config(ImageTools.JOGOANGEL_BACKGROUND, ImageTools.AJUDAIMAGEMANGEL,
				ImageTools.AJUDATEXTOANGEL);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-253);
		posicoesAltMensagem.add(-388);
		posicoesAltMensagem.add(-597);
		posicoesAltMensagem.add(-654);
	}
}
