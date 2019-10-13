package label.jogoPigrabbit;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelNave extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private Random r;
	private int codigo;

	private String[] naves = { ImageTools.NAVESOMA, ImageTools.NAVESUBTRACAO,
			ImageTools.NAVEMULTIPLICACAO, ImageTools.NAVEDIVISAO };

	private Thread movimento;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL NAVE

	public LabelNave() {
		r = new Random();

		setNave();
		setSize(getPreferredSize());

		int x;
		do {
			x = r.nextInt(920);
		} while (x > 920 - getWidth());
		setLocation(x, 150);

		setMovimento();
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DA NAVE

	private void setNave() {
		codigo = r.nextInt(4);
		setIcon(new ImageIcon(ImageTools.ReadImage(naves[codigo], this)));
	}

	private void setMovimento() {
		movimento = new Thread() {

			@Override
			public void run() {
				while (getY() < 739 - getHeight()) {
					setLocation(getX(), getY() + 2);

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
	// METODOS GET

	public int getCodigo() {
		return codigo;
	}
}
