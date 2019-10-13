package label.jogoPigrabbit;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelBonus extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private Random r;
	private int codigo;

	private String[] bonuses = { ImageTools.BONUSPONTO, ImageTools.BONUSTEMPO };

	private Thread movimento;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL BONUS

	public LabelBonus() {
		r = new Random();

		setBonus();
		setSize(getPreferredSize());

		int x;
		do {
			x = r.nextInt(920);
		} while (x > 920 - getWidth());
		setLocation(x, 150);

		setMovimento();
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO BONUS

	private void setBonus() {
		codigo = r.nextInt(2);
		setIcon(new ImageIcon(ImageTools.ReadImage(bonuses[codigo], this)));
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
