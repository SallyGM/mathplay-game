package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroCedula2 extends LabelDinheiro {

	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL CEDULA2

	public LabelDinheiroCedula2() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.CEDULA2, this)));
		config(new Point(440, 3), 2);
	}
}
