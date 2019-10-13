package label.jogoInfo;

import java.util.Random;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelJogoInfoAngel extends LabelJogoInfo {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private Random aleatorio = new Random();

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL JOGOINFOANGEL

	public LabelJogoInfoAngel() {
		initMultiplo();
		config(ImageTools.JIANGEL);
	}

	// metodo que gera o numero multiplo
	private void initMultiplo() {
		// gera numero entre 3 e 9
		numero = aleatorio.nextInt(7) + 3;
		texto = Integer.toString(numero);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void initComponentes() {
		texto2.setText("Número múltiplo de:");
		label2.setText(texto);
	}
}
