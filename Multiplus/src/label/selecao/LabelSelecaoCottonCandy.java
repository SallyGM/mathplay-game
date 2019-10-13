package label.selecao;

import java.awt.Image;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelSelecaoCottonCandy extends LabelSelecao {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DA LABEL SELECAOCOTTONCANDY

	public LabelSelecaoCottonCandy() {
		config();
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void setInfoIndividual() {
		Image aux = ImageTools.ReadImage(ImageTools.COTTONCANDY, this);
		jLblPersonagemImage.setIcon(new ImageIcon(aux));
		jLblPersonagemNome.setText("PERSONAGEM: Cotton Candy");
		jLblCategoriaJogo.setText("CATEGORIA: Troco");
		jLblDificuldade.setText("DIFICULDADE: Muito Difícil");

		codigo = 4;
	}
}
