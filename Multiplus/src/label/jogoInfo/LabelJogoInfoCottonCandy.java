package label.jogoInfo;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelJogoInfoCottonCandy extends LabelJogoInfo {

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL JOGOINFOCOTTONCANDY

	public LabelJogoInfoCottonCandy() {
		config(ImageTools.JICOTTONCANDY);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void initComponentes() {
		texto2.setText("Valor dado (R$):");
		label2.setBounds(40, 240, 345, 130);
	}
}
