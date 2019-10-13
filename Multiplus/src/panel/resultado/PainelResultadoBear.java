package panel.resultado;

import java.math.BigDecimal;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelResultadoBear extends PainelResultado {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL RESULTADOBEAR

	public PainelResultadoBear() {
		config(ImageTools.JOGOBEAR_BACKGROUND);
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	public void setResultado(int acertos, int erros) {
		this.acertos = acertos;
		this.erros = erros;

		initializeLabels();

		txtResultado.setText("A porcentagem de potes certos foi de:");
		lblResultado.setText(Double.toString(calcularResultado()) + "%");
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
