package label.selecao;

import java.awt.Image;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelSelecaoPanda extends LabelSelecao {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DA LABEL SELECAOPANDA
	
	public LabelSelecaoPanda() {
		config();
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void setInfoIndividual() {
		Image aux = ImageTools.ReadImage(ImageTools.PANDA, this);
		jLblPersonagemImage.setIcon(new ImageIcon(aux));
		jLblPersonagemNome.setText("PERSONAGEM: Panda");
		jLblCategoriaJogo.setText("CATEGORIA: Equilíbrio");
		jLblDificuldade.setText("DIFICULDADE: Difícil");

		codigo = 7;
	}
}
