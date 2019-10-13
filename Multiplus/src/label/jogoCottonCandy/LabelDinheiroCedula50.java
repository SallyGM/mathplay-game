package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroCedula50 extends LabelDinheiro {

	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL CEDULA50

	public LabelDinheiroCedula50() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.CEDULA50, this)));
		config(new Point(760, 3), 50);
	}
}
