package label.selecao;

import java.awt.Image;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelSelecaoPig extends LabelSelecao {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DA LABEL SELECAOPIG

	public LabelSelecaoPig() {
		config();
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void setInfoIndividual() {
		Image aux = ImageTools.ReadImage(ImageTools.PIG, this);
		jLblPersonagemImage.setIcon(new ImageIcon(aux));
		jLblPersonagemNome.setText("PERSONAGEM: Pig");
		jLblCategoriaJogo.setText("CATEGORIA: Somat�ria");
		jLblDificuldade.setText("DIFICULDADE: Muito dif�cil");

		codigo = 8;
	}
}
