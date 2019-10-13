package label.numero;

import java.awt.Font;
import java.util.Random;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelNumeroBat extends JLabel {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private Random random;

	private int valor;

	private Font f;
	private String text;

	private int velocidade;

	private Thread moverEsquerda, moverDireita;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL NUMEROBAT

	public LabelNumeroBat() {
		initVar();
		configLabel();
	}

	private void initVar() {
		// randomiza o numero
		random = new Random();
		f = new Font("impact", Font.BOLD, 200);

		valor = random.nextInt(500) + 1;
		text = Integer.toString(valor);

		// inicializa outras variaveis
		velocidade = 10;
	}

	private void configLabel() {
		setFont(f);
		setText(text);

		setSize(getPreferredSize());
		setLocation((1020 - getWidth()) / 2, (739 - getHeight()) / 2);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO LABEL

	public void moverDireita() {
		int alturaAnt = getHeight();
		int alturaNovo;
		Font novoF = new Font("impact", Font.BOLD, 50);

		setFont(novoF);
		setSize(getPreferredSize());

		alturaNovo = getY() + (alturaAnt - getHeight()) / 2;

		setLocation(835, alturaNovo);

		moverDireita = new Thread() {

			@Override
			public void run() {
				while (getX() < 1020) {
					setLocation(getX() + velocidade, alturaNovo);

					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		moverDireita.start();
	}

	public void moverEsquerda() {
		int alturaAnt = getHeight();
		int alturaNovo;
		Font novoF = new Font("impact", Font.BOLD, 50);

		setFont(novoF);
		setSize(getPreferredSize());

		alturaNovo = getY() + (alturaAnt - getHeight()) / 2;

		setLocation(105, alturaNovo);

		moverEsquerda = new Thread() {

			@Override
			public void run() {
				while (getX() + getWidth() > 0) {
					setLocation(getX() - velocidade, alturaNovo);

					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		moverEsquerda.start();
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS GET E/OU SET
	
	public int getValor() {
		return valor;
	}
}
