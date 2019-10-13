package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroCedula100 extends LabelDinheiro {

	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL CEDULA100

	public LabelDinheiroCedula100() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.CEDULA100, this)));
		config(new Point(840, 3), 100);
	}
}
