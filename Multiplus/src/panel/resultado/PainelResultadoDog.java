package panel.resultado;

import java.math.BigDecimal;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelResultadoDog extends PainelResultado {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL RESULTADODOG
	
	public PainelResultadoDog() {
		config(ImageTools.JOGODOG_BACKGROUND);
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)
	
	@Override
	public void setResultado(int acertos, int erros) {
		this.acertos = acertos;
		this.erros = erros;

		initializeLabels();

		txtResultado.setText("Sua posição na natação foi:");
		lblResultado.setText(calcularResultado().intValue() + "º lugar");
		txtInfo.setText((calcularResultado() >= 1 && calcularResultado() <= 3 ? textoFeliz
				: textoTriste));

		configLabels();
	}

	@Override
	protected Double calcularResultado() {
		BigDecimal posicao;
		int total;

		total = acertos + erros;
		posicao = new BigDecimal(
				11 - (((double) acertos / (double) total) * 10));
		posicao = posicao.setScale(1, BigDecimal.ROUND_HALF_UP);

		return (posicao.doubleValue());
	}
}
