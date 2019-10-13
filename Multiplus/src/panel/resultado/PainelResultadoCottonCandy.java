package panel.resultado;

import java.math.BigDecimal;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelResultadoCottonCandy extends PainelResultado {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL RESULTADOANGEL

	public PainelResultadoCottonCandy() {
		config(ImageTools.JOGOCOTTONCANDY_BACKGROUND);
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	public void setResultado(int acertos, int erros) {
		this.acertos = acertos;
		this.erros = erros;

		initializeLabels();

		txtResultado.setText("Seu resultado no mercado foi:");
		lblResultado.setText(Double.toString(calcularResultado()) + "%");
		txtInfo.setText((calcularResultado() >= 60 ? textoFeliz : textoTriste));

		configLabels();
	}

	@Override
	protected Double calcularResultado() {
		BigDecimal porcent;
		int total;

		total = acertos + erros;
		porcent = new BigDecimal(((double) acertos / (double) total) * 100);
		porcent = porcent.setScale(2, BigDecimal.ROUND_HALF_UP);

		return (porcent.doubleValue());
	}
}
