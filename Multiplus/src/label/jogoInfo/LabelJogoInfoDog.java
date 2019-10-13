package label.jogoInfo;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelJogoInfoDog extends LabelJogoInfo {

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL JOGOINFODOG

	public LabelJogoInfoDog() {
		config(ImageTools.JIDOG);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void initComponentes() {	
		texto2.setText("Divisor de:");
	}
}
