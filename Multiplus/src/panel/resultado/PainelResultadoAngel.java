package panel.resultado;

import java.math.BigDecimal;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelResultadoAngel extends PainelResultado {

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL RESULTADOANGEL

	public PainelResultadoAngel() {
		config(ImageTools.JOGOANGEL_BACKGROUND);
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)
	
	@Override
	public void setResultado(int acertos, int erros) {
		this.acertos = acertos;
		this.erros = erros;

		initializeLabels();

		txtResultado.setText("Sua nota na prova foi:");
		lblResultado.setText(Double.toString(calcularResultado()));
		txtInfo.setText((calcularResultado() >= 6 ? textoFeliz : textoTriste));

		configLabels();
	}

	@Override
	protected Double calcularResultado() {
		BigDecimal nota;
		int total;

		total = acertos + erros;
		nota = new BigDecimal(((double) acertos / (double) total) * 10);
		nota = nota.setScale(2, BigDecimal.ROUND_HALF_UP);

		return (nota.doubleValue());
	}
}
