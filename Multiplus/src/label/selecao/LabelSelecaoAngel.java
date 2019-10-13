package label.selecao;

import java.awt.Image;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelSelecaoAngel extends LabelSelecao {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DA LABEL SELECAOANGEL

	public LabelSelecaoAngel() {
		config();
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)
	@Override
	protected void setInfoIndividual() {
		Image aux = ImageTools.ReadImage(ImageTools.ANGEL, this);
		jLblPersonagemImage.setIcon(new ImageIcon(aux));
		jLblPersonagemNome.setText("PERSONAGEM: Angel");
		jLblCategoriaJogo.setText("CATEGORIA: Múltiplos");
		jLblDificuldade.setText("DIFICULDADE: Médio");

		codigo = 0;
	}
}
