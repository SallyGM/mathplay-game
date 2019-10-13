package label.numero;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelNumeroDog extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private int valor;
	private int[] posicaoX = { 326, 302, 311 };
	private int[] espacosX = { 0, 353, 682 };

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL NUMERODOG

	public LabelNumeroDog(int valor) {
		this.valor = valor;

		Font f = new Font("impact", Font.BOLD, 100);
		setFont(f);
		setText(Integer.toString(valor));
		setSize(getPreferredSize());
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS GET E/OU SET
	
	// setter para a posicao do numero
	public void setPosicao(int x, int y) {
		int xAnt, yAnt;

		xAnt = espacosX[x];
		yAnt = 184 * y + 92;

		setLocation(xAnt + (posicaoX[x] - getWidth()) / 2, yAnt - getHeight()
				/ 2);
	}

	public int getValor() {
		return valor;
	}
}
