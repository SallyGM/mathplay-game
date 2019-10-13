package label.selecao;

import java.awt.Image;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelSelecaoCat extends LabelSelecao {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DA LABEL SELECAOCAT

	public LabelSelecaoCat() {
		config();
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void setInfoIndividual() {
		Image aux = ImageTools.ReadImage(ImageTools.CAT, this);
		jLblPersonagemImage.setIcon(new ImageIcon(aux));
		jLblPersonagemNome.setText("PERSONAGEM: Cat");
		jLblCategoriaJogo.setText("CATEGORIA: Soma");
		jLblDificuldade.setText("DIFICULDADE: Médio");

		codigo = 3;
	}
}
