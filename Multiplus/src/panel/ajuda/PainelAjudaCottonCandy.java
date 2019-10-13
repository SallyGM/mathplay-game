package panel.ajuda;

import java.util.ArrayList;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelAjudaCottonCandy extends PainelAjuda {

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDACOTTONCANDY

	public PainelAjudaCottonCandy() {
		config(ImageTools.JOGOCOTTONCANDY_BACKGROUND, ImageTools.AJUDAIMAGEMCOTTONCANDY,
				ImageTools.AJUDATEXTOCOTTONCANDY);

		// posicoes das mensagens
		posicoesAltMensagem = new ArrayList<Integer>();

		posicoesAltMensagem.add(-232);
		posicoesAltMensagem.add(-372);
		posicoesAltMensagem.add(-566);
		posicoesAltMensagem.add(-631);
	}
}
