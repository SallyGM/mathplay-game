package label.jogoDog;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelOssoDog extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VETORES (POSICAO X)

	private int[] posicaoX = { 326, 302, 311 };
	private int[] espacosX = { 0, 353, 682 };

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL OSSO

	public LabelOssoDog() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.OSSO, this)));
		setSize(getPreferredSize());
	}

	// ////////////////////////////////////////////////////////////////////

	// metodo responsavel por configurar a posicao correta x e y do JLabel
	public void setPosicao(int x, int y) {
		int xAnt, yAnt;

		xAnt = espacosX[x];
		yAnt = 184 * y + 92;

		setLocation(xAnt + (posicaoX[x] - getWidth()) / 2, yAnt - getHeight()
				/ 2);
	}
}
