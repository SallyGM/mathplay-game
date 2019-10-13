package label.personagem;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelPersonagemBear extends LabelPersonagem {

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL BEAR
	public LabelPersonagemBear() {
		setSprite(ImageTools.BEAR, 2);
		setLocation((1020 - getWidth()) / 2, 739 - getHeight());
	}
}
