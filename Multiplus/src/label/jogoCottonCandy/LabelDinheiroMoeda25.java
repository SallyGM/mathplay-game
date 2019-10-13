package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroMoeda25 extends LabelDinheiro {

	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL MOEDA25

	public LabelDinheiroMoeda25() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.MOEDA25, this)));
		config(new Point(200, 25), 0.25);
	}
}
