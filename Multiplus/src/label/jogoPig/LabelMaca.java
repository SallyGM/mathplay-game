package label.jogoPig;

import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelMaca extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private JLabel lblValor;
	private int valor;

	private Point[] posicoes = { new Point(26, 219), new Point(291, 194),
								new Point(542, 242), new Point(48, 610),
								new Point(891, 620), new Point(695, 629)};

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL MACA

	public LabelMaca(int posicao) {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.MACA, this)));
		setSize(getPreferredSize());
		setLocation(posicoes[posicao]);
	}

	// ////////////////////////////////////////////////////////////////////

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;

		Font f = new Font("impact", Font.BOLD, 45);
		lblValor = new JLabel();

		lblValor.setFont(f);
		lblValor.setText(Integer.toString(valor));
		lblValor.setSize(lblValor.getPreferredSize());
		lblValor.setLocation((getWidth() - lblValor.getWidth()) / 2,
				getHeight() - lblValor.getHeight());
		
		add(lblValor);
	}
}
