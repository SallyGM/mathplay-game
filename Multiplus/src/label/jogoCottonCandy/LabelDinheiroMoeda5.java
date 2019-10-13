package label.jogoCottonCandy;

import java.awt.Point;

import javax.swing.ImageIcon;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelDinheiroMoeda5 extends LabelDinheiro {

	////////////////////////////////////////
	// INICIALIZACAO DO LABEL MOEDA5
	
	public LabelDinheiroMoeda5() {
		setIcon(new ImageIcon(ImageTools.ReadImage(ImageTools.MOEDA5, this)));
		config(new Point(40, 25), 0.05);
	}
}
