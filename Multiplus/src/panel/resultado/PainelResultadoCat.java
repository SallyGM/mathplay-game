package panel.resultado;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelResultadoCat extends PainelResultado {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL RESULTADO CAT
	
	public PainelResultadoCat() {
		config(ImageTools.JOGOCAT_BACKGROUND);
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)
	
	@Override
	public void setResultado(int acertos, int erros) {
		this.acertos = acertos;
		this.erros = erros;

		initializeLabels();

		txtResultado.setText("Sua posição na corrida foi:");
		lblResultado.setText(calcularResultado().intValue() + "º lugar");
		txtInfo.setText((calcularResultado() >= 1 && calcularResultado() <= 3 ? textoFeliz
				: textoTriste));

		configLabels();
	}

	@Override
	protected Double calcularResultado() {
		return (10.0 - acertos);
	}
}
