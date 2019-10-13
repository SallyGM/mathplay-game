package label.personagem;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public abstract class LabelPersonagem extends JLabel {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	protected ImageIcon icone;
	protected int maxX, maxY;
	protected int speed;

	// ///////////////////////////////////////////////////////////////
	// METODOS SET

	public void setSprite(String diretorio, int razao) {
		Image aux = ImageTools.ReadImage(diretorio, this);
		icone = ImageTools.resizeImgIcon(new ImageIcon(aux),
				aux.getWidth(null) / razao, aux.getHeight(null) / razao);

		setIcon(icone);

		setSize(this.getPreferredSize());
	}
}
