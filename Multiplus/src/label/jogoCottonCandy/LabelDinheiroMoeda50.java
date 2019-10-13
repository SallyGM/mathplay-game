package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroMoeda50 extends LabelDinheiro {
	
	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL MOEDA50

	public LabelDinheiroMoeda50() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.MOEDA50, this)));
		config(new Point(280, 25), 0.5);
	}
}
