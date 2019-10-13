package label.jogoInfo;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelJogoInfoPig extends LabelJogoInfo {

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL JOGOINFOPIG

	public LabelJogoInfoPig() {
		config(ImageTools.JIPIG);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void initComponentes() {
		texto2.setText("Soma total:");
	}
}
