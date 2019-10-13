package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroMoeda10 extends LabelDinheiro {
	
	// //////////////////////////////////////
	// INICIALIZACAO DO LABEL MOEDA10

	public LabelDinheiroMoeda10() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.MOEDA10, this)));
		config(new Point(120, 25), 0.1);
	}
}
