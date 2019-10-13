package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroMoeda100 extends LabelDinheiro {

	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL MOEDA100

	public LabelDinheiroMoeda100() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.MOEDA100, this)));
		config(new Point(360, 25), 1);
	}
}
