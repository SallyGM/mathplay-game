package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroCedula10 extends LabelDinheiro {

	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL CEDULA10

	public LabelDinheiroCedula10() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.CEDULA10, this)));
		config(new Point(600, 3), 10);
	}
}
