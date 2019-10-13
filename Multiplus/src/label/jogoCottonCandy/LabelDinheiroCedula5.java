package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroCedula5 extends LabelDinheiro {

	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL CEDULA5

	public LabelDinheiroCedula5() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.CEDULA5, this)));
		config(new Point(520, 3), 5);
	}
}
