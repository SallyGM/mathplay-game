package label.numero;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelNumeroMouse extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private int valor;
	private int pos;
	private int[] espacosX = { 55, 403, 739 };

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL NUMEROMOUSE

	public LabelNumeroMouse(int valor, int pos) {
		this.valor = valor;
		this.pos = pos;

		Font f = new Font("impact", Font.BOLD, 50);
		setFont(f);
		setText(Integer.toString(valor));
		setSize(getPreferredSize());
		setLocation(espacosX[pos] + (163 - getWidth()) / 2, 164);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS GET E/OU SET

	public int getValor() {
		return valor;
	}

	public int getPos() {
		return pos;
	}
}
