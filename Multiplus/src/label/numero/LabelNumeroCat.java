package label.numero;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelNumeroCat extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private final int SPEED = 2;

	private Thread movimento;
	private int valor;

	private int idPos, pos;
	private int[] posicaoX = { 144, 147, 147, 147, 146, 145 };
	private int[] espacosX = { 24, 192, 364, 534, 705, 876 };

	private Font f;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL NUMEROCAT

	public LabelNumeroCat(int valor, int idPos) {
		this.valor = valor;
		this.idPos = idPos;

		initVar();
		configLabel();
	}

	private void initVar() {
		f = new Font("impact", Font.BOLD, 90);
		setMovimento();
	}

	private void configLabel() {
		setFont(f);
		setText(Integer.toString(valor));
		setSize(getPreferredSize());

		int posXAnt = espacosX[idPos - 1];
		pos = posXAnt + (posicaoX[idPos - 1] - getWidth()) / 2;
		setLocation(pos, 0);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO LABEL

	private void setMovimento() {
		movimento = new Thread() {

			@Override
			public void run() {
				while (getY() < 471) {
					setLocation(pos, getY() + SPEED);

					try {
						Thread.sleep(24);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		movimento.start();
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS GET E/OU SET
	
	public int getIdPos() {
		return idPos;
	}
}
