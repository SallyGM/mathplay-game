package label.selecao;

import java.awt.Image;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelSelecaoBear extends LabelSelecao {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DA LABEL SELECAOBEAR

	public LabelSelecaoBear() {
		config();
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void setInfoIndividual() {
		Image aux = ImageTools.ReadImage(ImageTools.BEAR, this);
		jLblPersonagemImage.setIcon(new ImageIcon(aux));
		jLblPersonagemNome.setText("PERSONAGEM: Bear");
		jLblCategoriaJogo.setText("CATEGORIA: Porcentagem");
		jLblDificuldade.setText("DIFICULDADE: Médio");

		codigo = 2;
	}
}
