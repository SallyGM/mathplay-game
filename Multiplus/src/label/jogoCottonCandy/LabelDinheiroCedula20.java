package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroCedula20 extends LabelDinheiro {

	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL CEDULA20

	public LabelDinheiroCedula20() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.CEDULA20, this)));
		config(new Point(680, 3), 20);
	}
}
