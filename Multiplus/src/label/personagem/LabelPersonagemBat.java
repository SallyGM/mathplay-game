package label.personagem;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelPersonagemBat extends LabelPersonagem {

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL BAT
	public LabelPersonagemBat() {
		setSprite(ImageTools.BAT, 1);
		setLocation((1020 - getWidth()) / 2, 10);
	}
}
