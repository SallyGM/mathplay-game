package panel.jogo;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import label.jogoCottonCandy.*;
import label.jogoInfo.LabelJogoInfoCottonCandy;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelJogoCottonCandy extends PainelJogo {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private DecimalFormat df;
	private double troco, somaValores, somaUsuario;

	private ArrayList<LabelDinheiro> dinheiros;
	private JLabel valor;
	private Rectangle cliente;

	private Font f;

	private ActionListener tempoLimite;
	private Timer tLimite;

	private Action verificaResposta;

	private Thread colisaoCliente;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL JOGOCOTTONCANDY

	public PainelJogoCottonCandy() {
		config(ImageTools.JOGOCOTTONCANDY_BACKGROUND, 4);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		info = new LabelJogoInfoCottonCandy();
		dinheiros = new ArrayList<LabelDinheiro>();
		valor = new JLabel();
		cliente = new Rectangle(425, 176, 422, 446);
		
		df = new DecimalFormat("#0.00");
		
		f = new Font("impact", Font.BOLD, 48);

		valor.setFont(f);
		valor.setLocation(180, 364);
		valor.setSize(210, 48);
	}

	@Override
	protected void setActionsThreads() {
		tempoLimite = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tLimite.stop();

				info.addNumErros();

				addNovaWave();
			}
		};

		verificaResposta = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(df.format(somaUsuario).equalsIgnoreCase(df.format(troco))) {
					info.addNumAcertos();
				} else {
					info.addNumErros();
				}
								
				addNovaWave();
			}
		};

		colisaoCliente = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					double soma = 0;
					
					for (int i = 0; i < dinheiros.size(); i++) {
						Rectangle dinheiro = dinheiros.get(i).getBounds();

						if (dinheiro.intersects(cliente))
							soma += dinheiros.get(i).getValor();
					}
					
					somaUsuario = soma;
								
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

	@Override
	protected void initTimersThreads() {
		tLimite = new Timer(30000, tempoLimite);

		t.setInitialDelay(0);
		
		t.start();
		tLimite.start();
		colisaoCliente.start();
	}

	@Override
	protected void initMetodos() {
		counter = 100;
		
		addNovaWave();
		setKeyBindings();
	}

	@Override
	protected void stopTimers() {
		t.stop();
		tLimite.stop();
	}

	// ///////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO TECLADO

	private void setKeyBindings() {
		InputMap inMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actMap = getActionMap();

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
				"pressedEnter");
		actMap.put("pressedEnter", verificaResposta);
	}

	// //////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO JOGO

	private void addNovaWave() {
		removeDinheiros();
		remove(valor);

		addDinheiros();

		calcularNovoValor();
		calcularNovoValorDado();

		validate();
		repaint();

		tLimite.restart();
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	private void removeDinheiros() {
		for (int i = 0; i < dinheiros.size(); i++) {
			remove(dinheiros.get(i));
		}

		dinheiros.removeAll(dinheiros);
	}

	private void addDinheiros() {
		LabelDinheiroMoeda5 moeda5 = new LabelDinheiroMoeda5();
		LabelDinheiroMoeda10 moeda10 = new LabelDinheiroMoeda10();
		LabelDinheiroMoeda25 moeda25 = new LabelDinheiroMoeda25();
		LabelDinheiroMoeda50 moeda50 = new LabelDinheiroMoeda50();
		LabelDinheiroMoeda100 moeda100 = new LabelDinheiroMoeda100();
		LabelDinheiroCedula2 cedula2 = new LabelDinheiroCedula2();
		LabelDinheiroCedula5 cedula5 = new LabelDinheiroCedula5();
		LabelDinheiroCedula10 cedula10 = new LabelDinheiroCedula10();
		LabelDinheiroCedula20 cedula20 = new LabelDinheiroCedula20();
		LabelDinheiroCedula50 cedula50 = new LabelDinheiroCedula50();
		LabelDinheiroCedula100 cedula100 = new LabelDinheiroCedula100();

		dinheiros.add(moeda5);
		dinheiros.add(moeda10);
		dinheiros.add(moeda25);
		dinheiros.add(moeda50);
		dinheiros.add(moeda100);
		dinheiros.add(cedula2);
		dinheiros.add(cedula5);
		dinheiros.add(cedula10);
		dinheiros.add(cedula20);
		dinheiros.add(cedula50);
		dinheiros.add(cedula100);

		add(moeda5);
		add(moeda10);
		add(moeda25);
		add(moeda50);
		add(moeda100);
		add(cedula2);
		add(cedula5);
		add(cedula10);
		add(cedula20);
		add(cedula50);
		add(cedula100);
	}

	private void calcularNovoValor() {
		Random r = new Random();
		boolean moeda5, moeda10, moeda25, moeda50, moeda100;
		boolean cedula2, cedula5, cedula10, cedula20, cedula50, cedula100;
		double soma = 0;

		moeda5 = r.nextBoolean();
		moeda10 = r.nextBoolean();
		moeda25 = r.nextBoolean();
		moeda50 = r.nextBoolean();
		moeda100 = r.nextBoolean();
		cedula2 = r.nextBoolean();
		cedula5 = r.nextBoolean();
		cedula10 = r.nextBoolean();
		cedula20 = r.nextBoolean();
		cedula50 = r.nextBoolean();
		cedula100 = r.nextBoolean();

		if (moeda5)
			soma += 0.05f;
		if (moeda10)
			soma += 0.1f;
		if (moeda25)
			soma += 0.25f;
		if (moeda50)
			soma += 0.5f;
		if (moeda100)
			soma += 1f;
		if (cedula2)
			soma += 2f;
		if (cedula5)
			soma += 5f;
		if (cedula10)
			soma += 10f;
		if (cedula20)
			soma += 20f;
		if (cedula50)
			soma += 50f;
		if (cedula100)
			soma += 100f;

		valor.setText("R$" + df.format(soma));

		somaValores = soma;
	}

	private void calcularNovoValorDado() {
		Random r = new Random();
		boolean moeda5, moeda10, moeda25, moeda50, moeda100;
		boolean cedula2, cedula5, cedula10, cedula20, cedula50, cedula100;
		double soma = 0;

		moeda5 = r.nextBoolean();
		moeda10 = r.nextBoolean();
		moeda25 = r.nextBoolean();
		moeda50 = r.nextBoolean();
		moeda100 = r.nextBoolean();
		cedula2 = r.nextBoolean();
		cedula5 = r.nextBoolean();
		cedula10 = r.nextBoolean();
		cedula20 = r.nextBoolean();
		cedula50 = r.nextBoolean();
		cedula100 = r.nextBoolean();

		if (moeda5)
			soma += 0.05f;
		if (moeda10)
			soma += 0.1f;
		if (moeda25)
			soma += 0.25f;
		if (moeda50)
			soma += 0.5f;
		if (moeda100)
			soma += 1f;
		if (cedula2)
			soma += 2f;
		if (cedula5)
			soma += 5f;
		if (cedula10)
			soma += 10f;
		if (cedula20)
			soma += 20f;
		if (cedula50)
			soma += 50f;
		if (cedula100)
			soma += 100f;

		somaValores += soma;
		info.setString(df.format(somaValores));

		troco = soma;

		add(valor);
	}
}
