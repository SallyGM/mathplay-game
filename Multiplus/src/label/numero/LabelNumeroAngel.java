package label.numero;

import java.awt.Font;
import java.util.Random;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelNumeroAngel extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private Random random;

	private int speed;
	private int valor;

	private Thread movimento;

	private Font f;
	private String text;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL NUMEROANGEL

	public LabelNumeroAngel() {
		initVar();
		configLabel();
		setMovimento();
	}

	// inicializa as variaveis a serem utilizadas
	private void initVar() {
		// randomiza o numero
		random = new Random();
		f = new Font("impact", Font.BOLD, 40);

		valor = random.nextInt(200) + 1;
		text = Integer.toString(valor);

		// inicializa outras variaveis
		speed = 2;
	}

	// metodo que configura a JLabel
	private void configLabel() {
		setFont(f);
		setText(text);

		setSize(this.getPreferredSize());

		// inicializa as posicoes x e y
		int x;
		do {
			x = random.nextInt(1020);
		} while (x > 1020 - getWidth());
		setLocation(x, 0);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO LABEL
	
	private void setMovimento() {
		movimento = new Thread() {

			@Override
			public void run() {
				while (getY() < 739 - getHeight()) {
					setLocation(getX(), getY() + speed);

					try {
						Thread.sleep(17);
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

	// getter para o valor do numero
	public int getValor() {
		return valor;
	}
}
