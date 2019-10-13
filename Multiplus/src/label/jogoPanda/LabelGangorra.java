package label.jogoPanda;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

import javax.swing.JLabel;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelGangorra extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVIES

	private Image sprite;
	private int angulo = 0;

	private Area esquerdaOriginal, direitaOriginal, esquerdaA, direitaA;

	private int somaEsquerda = 0;
	private int somaDireita = 0;

	private Thread rodarEsquerda, rodarDireita, rodarMeio;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL GANGORRA

	public LabelGangorra(Area esq, Area dir) {
		sprite = ImageTools.ReadImage(ImageTools.GANGORRA, this);
		setSize(700, 400);
		setLocation((1020 - getWidth()) / 2, (739 - getHeight()) / 2);

		esquerdaOriginal = esq;
		direitaOriginal = dir;
		esquerdaA = esquerdaOriginal;
		direitaA = direitaOriginal;
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	public void startRodarEsquerda() {
		rodarEsquerda = new Thread() {

			@Override
			public void run() {
				for (int i = 1; i <= 20; i++) {
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (angulo > -20) {
						angulo--;
					}
					validate();
					repaint();
				}
			}
		};

		rodarEsquerda.start();
	}

	public void startRodarDireita() {
		rodarDireita = new Thread() {

			@Override
			public void run() {
				for (int i = 1; i <= 20; i++) {
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (angulo < 20) {
						angulo++;
					}
					validate();
					repaint();

				}
			}
		};

		rodarDireita.start();
	}

	public void starRodarMeio() {
		rodarMeio = new Thread() {

			@Override
			public void run() {
				while (angulo != 0) {
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (angulo <= 20 && angulo > 0) {
						angulo--;
					}
					if (angulo >= -20 && angulo < 0) {
						angulo++;
					}

					validate();
					repaint();
				}
			}
		};

		rodarMeio.start();
	}

	public Area getEsquerdaA() {
		return esquerdaA;
	}

	public Area getDireitaA() {
		return direitaA;
	}

	public void somarEsquerda(int num) {
		somaEsquerda += num;
	}

	public void somarDireita(int num) {
		somaDireita += num;
	}

	public int getSomaEsquerda() {
		return somaEsquerda;
	}

	public int getSomaDireita() {
		return somaDireita;
	}

	public int getAngulo() {
		return angulo;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		AffineTransform at = new AffineTransform();
		at.rotate(Math.toRadians(angulo), getWidth() / 2, getHeight() / 2 + 53);

		g2d.transform(at);
		g2d.drawImage(sprite, 0, getHeight() / 2, this);

		esquerdaA = esquerdaOriginal.createTransformedArea(at);
		direitaA = direitaOriginal.createTransformedArea(at);

		g2d.dispose();
	}
}
