package panel.jogo;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import label.jogoInfo.LabelJogoInfoPanda;
import label.jogoPanda.LabelGangorra;
import label.personagem.LabelPersonagem;
import label.personagem.LabelPersonagemPanda;
import label.personagem.LabelPersonagemRabbit;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelJogoPanda extends PainelJogo {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private ArrayList<LabelPersonagemPanda> pandas;
	private ArrayList<LabelPersonagemRabbit> rabbits;
	private ArrayList<LabelPersonagem> personagensEsquerda, personagensDireita;

	private LabelGangorra gangorra;
	private Area esquerda, direita;
	private boolean adicionando;

	private ActionListener tempoLimite;
	private Timer tLimite;
	private Thread verificaEquilibrio;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL JOGOPANDA

	public PainelJogoPanda() {
		config(ImageTools.JOGOPANDA_BACKGROUND, 7);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		esquerda = new Area(new Rectangle(160, 333, 153, 72));
		direita = new Area(new Rectangle(708, 333, 153, 72));

		info = new LabelJogoInfoPanda();
		gangorra = new LabelGangorra(esquerda, direita);
		pandas = new ArrayList<>();
		rabbits = new ArrayList<>();
		personagensEsquerda = new ArrayList<>();
		personagensDireita = new ArrayList<>();
	}

	@Override
	protected void setActionsThreads() {
		tempoLimite = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tLimite.stop();

				info.addNumErros();

				addNovaWave();
			}
		};

		verificaEquilibrio = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					if (!adicionando) {
						for (int i = 0; i < pandas.size(); i++) {
							LabelPersonagemPanda p = pandas.get(i);

							if (gangorra.getEsquerdaA().intersects(
									p.getBounds())
									&& !personagensEsquerda.contains(p)) {
								gangorra.somarEsquerda(p.getValor());
								personagensEsquerda.add(p);
							} else if (!gangorra.getEsquerdaA().intersects(
									p.getBounds())
									&& personagensEsquerda.contains(p)) {
								gangorra.somarEsquerda(-p.getValor());
								personagensEsquerda.remove(p);
							}

							if (gangorra.getDireitaA()
									.intersects(p.getBounds())
									&& !personagensDireita.contains(p)) {
								gangorra.somarDireita(p.getValor());
								personagensDireita.add(p);
							} else if (!gangorra.getDireitaA().intersects(
									p.getBounds())
									&& personagensDireita.contains(p)) {
								gangorra.somarDireita(-p.getValor());
								personagensDireita.remove(p);
							}

						}
						for (int i = 0; i < rabbits.size(); i++) {
							LabelPersonagemRabbit r = rabbits.get(i);

							if (gangorra.getEsquerdaA().intersects(
									r.getBounds())
									&& !personagensEsquerda.contains(r)) {
								gangorra.somarEsquerda(r.getValor());
								personagensEsquerda.add(r);
							} else if (!gangorra.getEsquerdaA().intersects(
									r.getBounds())
									&& personagensEsquerda.contains(r)) {
								gangorra.somarEsquerda(-r.getValor());
								personagensEsquerda.remove(r);
							}

							if (gangorra.getDireitaA()
									.intersects(r.getBounds())
									&& !personagensDireita.contains(r)) {
								gangorra.somarDireita(r.getValor());
								personagensDireita.add(r);
							} else if (!gangorra.getDireitaA().intersects(
									r.getBounds())
									&& personagensDireita.contains(r)) {
								gangorra.somarDireita(-r.getValor());
								personagensDireita.remove(r);
							}
						}

						if (gangorra.getSomaEsquerda() > gangorra
								.getSomaDireita()) {
							gangorra.startRodarEsquerda();
						} else if (gangorra.getSomaDireita() > gangorra
								.getSomaEsquerda()) {
							gangorra.startRodarDireita();
						} else {
							gangorra.starRodarMeio();
						}

						if (gangorra.getAngulo() == 0
								&& gangorra.getSomaDireita() == gangorra
										.getSomaEsquerda()
								&& gangorra.getSomaDireita() != 0
								&& gangorra.getSomaEsquerda() != 0) {
							info.addNumAcertos();
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
		tLimite = new Timer(20000, tempoLimite);

		t.setInitialDelay(0);

		t.start();
		tLimite.start();
		verificaEquilibrio.start();
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

	// //////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO JOGO

	private void addNovaWave() {
		adicionando = true;

		removerPersonagens();
		remove(gangorra);

		adicionarPersonagens();
		gangorra = new LabelGangorra(esquerda, direita);
		add(gangorra);

		validate();
		repaint();

		tLimite.restart();

		adicionando = false;
	}

	// //////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	private void removerPersonagens() {
		for (LabelPersonagemPanda panda : pandas) {
			remove(panda);
		}
		for (LabelPersonagemRabbit rabbit : rabbits) {
			remove(rabbit);
		}

		pandas.removeAll(pandas);
		rabbits.removeAll(rabbits);
		personagensDireita.removeAll(personagensDireita);
		personagensEsquerda.removeAll(personagensEsquerda);
	}

	private void adicionarPersonagens() {
		Random r = new Random();

		ArrayList<Integer> posicoes = new ArrayList<>();
		posicoes.add(0);
		posicoes.add(1);
		posicoes.add(2);
		posicoes.add(3);
		posicoes.add(4);
		posicoes.add(5);
		int posicaoAtual;

		int somaTotal = (r.nextInt(48) + 3) * (r.nextInt(2) + 2);
		int somaAtual = 0;
		int numFormados = 0;

		// ///////////////////////////////////////////////////////////////////////

		posicaoAtual = r.nextInt(6);
		LabelPersonagemPanda p1 = new LabelPersonagemPanda(
				posicoes.get(posicaoAtual));
		int numP1;
		do {
			numP1 = r.nextInt(somaTotal) + 1;
		} while (numP1 == somaTotal);

		somaAtual += numP1;
		p1.setValor(numP1);
		posicoes.remove(posicaoAtual);

		// //

		posicaoAtual = r.nextInt(5);
		LabelPersonagemRabbit r1 = new LabelPersonagemRabbit(
				posicoes.get(posicaoAtual));
		int numR1 = r.nextInt(somaTotal) + 1;

		if (somaAtual + numR1 >= somaTotal) {
			r1.setValor(somaTotal - p1.getValor());
			somaAtual = 0;
			numFormados++;
		} else {
			r1.setValor(numR1);
			somaAtual += numR1;
		}

		posicoes.remove(posicaoAtual);

		// //

		posicaoAtual = r.nextInt(4);
		LabelPersonagemPanda p2 = new LabelPersonagemPanda(
				posicoes.get(posicaoAtual));
		int numP2 = r.nextInt(somaTotal) + 1;

		if ((somaAtual + numP2 >= somaTotal) || (somaAtual != 0)) {
			p2.setValor(somaTotal - somaAtual);
			somaAtual = 0;
			numFormados++;
		} else {
			p2.setValor(numP2);
			somaAtual += numP2;
		}

		posicoes.remove(posicaoAtual);

		// //

		posicaoAtual = r.nextInt(3);
		LabelPersonagemRabbit r2 = new LabelPersonagemRabbit(
				posicoes.get(posicaoAtual));

		if (numFormados != 2) {
			r2.setValor(somaTotal - somaAtual);
			somaAtual = 0;
		}

		posicoes.remove(posicaoAtual);

		// ////////////////////////////////////////////////////////////

		pandas.add(p1);
		pandas.add(p2);
		rabbits.add(r1);
		rabbits.add(r2);

		add(p1);
		add(p2);
		add(r1);
		add(r2);
	}
}
