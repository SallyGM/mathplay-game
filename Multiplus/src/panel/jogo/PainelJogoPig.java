package panel.jogo;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import label.jogoInfo.LabelJogoInfoPig;
import label.jogoPig.LabelMaca;
import label.personagem.LabelPersonagemPig;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelJogoPig extends PainelJogo {

	// ///////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private LabelPersonagemPig pig;
	private ArrayList<LabelMaca> macas;

	private boolean adicionando;

	private ActionListener tempoLimite;
	private Timer tLimite;
	private Thread colisao;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL JOGOPIG

	public PainelJogoPig() {
		config(ImageTools.JOGOPIG_BACKGROUND, 8);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		pig = new LabelPersonagemPig();
		info = new LabelJogoInfoPig();
		macas = new ArrayList<>();

		add(pig);
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

		colisao = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					Rectangle pigRectangle = pig.getBounds();

					if (!adicionando) {
						for (int i = 0; i < macas.size(); i++) {
							LabelMaca m = macas.get(i);
							Rectangle mRectangle = m.getBounds();

							if (pigRectangle.intersects(mRectangle)) {
								pig.addMaca(m.getValor());

								removerComponente(m);
								macas.remove(m);
							}
						}

						if (pig.getTotalCesta() == info.getNumero()) {
							info.addNumAcertos();
							addNovaWave();
						} else if (pig.getTotalCesta() > info.getNumero()
								|| macas.isEmpty()) {
							info.addNumErros();
							addNovaWave();
						}
					}

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
		tLimite = new Timer(25000, tempoLimite);

		t.setInitialDelay(0);
		
		t.start();
		tLimite.start();
		colisao.start();
	}

	@Override
	protected void initMetodos() {
		counter = 100;
		adicionando = false;

		addNovaWave();
	}

	@Override
	protected void stopTimers() {
		t.stop();
		tLimite.stop();
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO JOGO

	private void addNovaWave() {
		adicionando = true;

		removerMacas();
		remove(pig);

		pig = new LabelPersonagemPig();
		add(pig);
		adicionarMacas();

		validate();
		repaint();

		tLimite.restart();

		adicionando = false;
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	private void removerMacas() {
		for (LabelMaca m : macas) {
			remove(m);
		}

		macas.removeAll(macas);
	}

	private void adicionarMacas() {
		Random r = new Random();

		ArrayList<Integer> posicoes = new ArrayList<>();
		posicoes.add(0);
		posicoes.add(1);
		posicoes.add(2);
		posicoes.add(3);
		posicoes.add(4);
		posicoes.add(5);
		int posicaoAtual;

		int somaTotal = (r.nextInt(91) + 10) * (r.nextInt(2) + 2);
		int somaAtual = 0;
		int nMacas = r.nextInt(3) + 3;
		boolean positivo;

		// ///////////////////////////////////////////////////////////////////////

		info.setNumero(somaTotal);

		for (int i = 0; i < nMacas; i++) {
			posicaoAtual = r.nextInt(6 - i);
			LabelMaca m = new LabelMaca(posicoes.get(posicaoAtual));
			int numMaca;

			if (i != nMacas - 1) {
				do {
					positivo = r.nextBoolean();
					numMaca = (positivo ? r.nextInt(50) + 1
							: -(r.nextInt(50) + 1));
				} while (somaAtual + numMaca >= somaTotal);

				somaAtual += numMaca;
			} else {
				numMaca = somaTotal - somaAtual;
			}

			m.setValor(numMaca);
			posicoes.remove(posicaoAtual);

			macas.add(m);
		}
		for (int i = 0; i < 6 - nMacas; i++) {
			posicaoAtual = r.nextInt(6 - nMacas - i);
			LabelMaca m = new LabelMaca(posicoes.get(posicaoAtual));
			int numMaca;

			positivo = r.nextBoolean();
			numMaca = (positivo ? r.nextInt(50) + 1 : -(r.nextInt(50) + 1));

			m.setValor(numMaca);
			posicoes.remove(posicaoAtual);
			macas.add(m);
		}

		// ////////////////////////////////////////////////////////////

		for (LabelMaca m : macas) {
			add(m);
		}
	}
}
