package label.jogoInfo;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelJogoInfoCat extends LabelJogoInfo {

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL JOGOINFOCAT

	public LabelJogoInfoCat() {
		config(ImageTools.JICAT);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void initComponentes() {
		texto2.setText("Soma:");
		label2.setBounds(40, 240, 345, 130);
	}
}
