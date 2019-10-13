package label.jogoPigrabbit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelTiro extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private Thread movimento;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL TIRO

	public LabelTiro(int x, int y) {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.TIRO, this)));
		setSize(getPreferredSize());
		setLocation(x, y);
		setMovimento();
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO TIRO

	private void setMovimento() {
		movimento = new Thread() {
			
			@Override
			public void run() {
				while(getY() > 0) {
					setLocation(getX(), getY() - 10);
					
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

}
