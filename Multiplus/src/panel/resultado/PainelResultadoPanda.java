package panel.resultado;

import java.math.BigDecimal;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelResultadoPanda extends PainelResultado {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL RESULTADOPANDA

	public PainelResultadoPanda() {
		config(ImageTools.JOGOPANDA_BACKGROUND);
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	public void setResultado(int acertos, int erros) {
		this.acertos = acertos;
		this.erros = erros;

		initializeLabels();

		txtResultado.setText("Sua perfeição no equilíbrio é de:");
		lblResultado.setText(calcularResultado().intValue() + "%");
		txtInfo.setText((calcularResultado() >= 70 ? textoFeliz : textoTriste));

		configLabels();
	}

	@Override
	protected Double calcularResultado() {
		BigDecimal porcent;
		int total;

		total = acertos + erros;
		porcent = new BigDecimal(((double) acertos / (double) total) * 100);
		porcent = porcent.setScale(1, BigDecimal.ROUND_HALF_UP);

		return (porcent.doubleValue());
	}
}
