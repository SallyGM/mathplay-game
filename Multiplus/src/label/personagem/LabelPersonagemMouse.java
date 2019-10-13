package label.personagem;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelPersonagemMouse extends LabelPersonagem {

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL MOUSE
	
	public LabelPersonagemMouse() {
		setSprite(ImageTools.MOUSE, 2);
		setLocation((1020 - getWidth()) / 2, 739 - getHeight());
	}

	public void moverEsquerda() {

	}

	public void moverCentro() {

	}

	public void moverDireita() {

	}
}
