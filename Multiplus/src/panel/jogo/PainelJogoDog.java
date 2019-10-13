package panel.jogo;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import usefulTools.ImageTools;
import label.jogoDog.LabelOssoDog;
import label.jogoInfo.LabelJogoInfoDog;
import label.numero.LabelNumeroDog;
import label.personagem.LabelPersonagemDog;

@SuppressWarnings("serial")
public class PainelJogoDog extends PainelJogo {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private LabelPersonagemDog dog;
	private ArrayList<LabelNumeroDog> dogNumeros;
	private ArrayList<LabelOssoDog> dogBonuses;

	private ActionListener tempoLimite;
	private Timer tLimite;
	private Thread colisaoNumero, colisaoBonus;

	private boolean adicionando = false;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO PAINELJOGODOG

	public PainelJogoDog() {
		config(ImageTools.JOGODOG_BACKGROUND, 5);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		dog = new LabelPersonagemDog();
		info = new LabelJogoInfoDog();
		dogNumeros = new ArrayList<LabelNumeroDog>();
		dogBonuses = new ArrayList<LabelOssoDog>();

		add(dog);
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

		colisaoNumero = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					Rectangle player = dog.getBounds();

					for (int i = 0; i < dogNumeros.size(); i++) {
						LabelNumeroDog atual = dogNumeros.get(i);
						Rectangle numero = atual.getBounds();

						if (player.intersects(numero) && !adicionando) {
							if (info.getNumero() % atual.getValor() == 0) {
								info.addNumAcertos();
								addNovaWave();
							} else
								info.addNumErros();

							removerComponente(atual);
							dogNumeros.remove(atual);
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
		colisaoBonus = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					Rectangle player = dog.getBounds();

					for (int i = 0; i < dogBonuses.size(); i++) {
						LabelOssoDog atual = dogBonuses.get(i);
						Rectangle bonus = atual.getBounds();

						if (player.intersects(bonus) && !adicionando) {
							info.addNumAcertos();

							removerComponente(atual);
							dogBonuses.remove(atual);
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
		tLimite = new Timer(5000, tempoLimite);

		t.start();
		tLimite.start();
		colisaoNumero.start();
		colisaoBonus.start();
	}

	@Override
	protected void initMetodos() {
		addNovaWave();
	}

	@Override
	protected void stopTimers() {
		t.stop();
		tLimite.stop();
		dog.setCima(false);
		dog.setBaixo(false);
	}

	// //////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO JOGO

	private void addNovaWave() {
		Random random = new Random();
		LabelNumeroDog lblDivisor;
		ArrayList<Integer> divisores = new ArrayList<Integer>();
		int[][] posicoes = new int[4][3];
		int novoNum;

		adicionando = true;

		removerWave();

		// colocando novo numero
		do {
			novoNum = random.nextInt(91) + 10;

			divisores.removeAll(divisores);
			for (int i = 2; i <= novoNum; i++) {
				if (novoNum % i == 0)
					divisores.add(i);
			}
		} while (divisores.size() <= 2);
		info.setNumero(novoNum);

		// adicionando os elementos da tela
		addBonuses(posicoes, random);
		lblDivisor = addResposta(posicoes, divisores, random);
		addNumeros(posicoes, novoNum, lblDivisor.getValor(), random);

		adicionarWave(lblDivisor);

		adicionando = false;
		tLimite.restart();
	}

	private void removerWave() {
		// zerando a tela
		for (int i = 0; i < dogNumeros.size(); i++) {
			remove(dogNumeros.get(i));
		}
		for (int i = 0; i < dogBonuses.size(); i++) {
			remove(dogBonuses.get(i));
		}
		dogNumeros.removeAll(dogNumeros);
		dogBonuses.removeAll(dogBonuses);

		validate();
		repaint();
	}

	private void adicionarWave(LabelNumeroDog dogResposta) {
		// adicionando os numeros e os bonus
		for (int i = 0; i < dogNumeros.size(); i++) {
			add(dogNumeros.get(i));
		}
		for (int i = 0; i < dogBonuses.size(); i++) {
			add(dogBonuses.get(i));
		}

		validate();
		repaint();
	}

	private void addBonuses(int[][] matriz, Random r) {
		// configurando os bonus
		Rectangle player = dog.getBounds();
		int numBonus;
		int x, y;

		numBonus = r.nextInt(4);
		for (int i = 0; i < numBonus; i++) {
			LabelOssoDog dogBonus = new LabelOssoDog();
			Rectangle bonus;

			do {
				x = r.nextInt(4);
				y = r.nextInt(3);
				dogBonus.setPosicao(y, x);
				bonus = dogBonus.getBounds();
			} while (matriz[x][y] != 0 || bonus.intersects(player));

			matriz[x][y] = 1;
			dogBonuses.add(dogBonus);
		}
	}

	private LabelNumeroDog addResposta(int[][] matriz, ArrayList<Integer> div,
			Random r) {
		// configurando a resposta
		Rectangle player = dog.getBounds();
		int divisor;
		int x, y;

		divisor = div.get(r.nextInt(div.size() - 2) + 1);

		LabelNumeroDog dogRes = new LabelNumeroDog(divisor);
		Rectangle resposta;

		do {
			x = r.nextInt(4);
			y = r.nextInt(3);
			dogRes.setPosicao(y, x);
			resposta = dogRes.getBounds();
		} while (matriz[x][y] != 0 || resposta.intersects(player));

		matriz[x][y] = 1;
		dogNumeros.add(dogRes);

		return dogRes;
	}

	private void addNumeros(int[][] matriz, int numMax, int resposta, Random r) {
		// configurando outros numeros
		Rectangle player = dog.getBounds();
		int x, y;
		int numNumeros;

		numNumeros = r.nextInt(3) + 1;

		for (int i = 0; i < numNumeros; i++) {
			LabelNumeroDog dogNum;
			Rectangle numero;
			int num;

			boolean flag = false;
			do {
				num = r.nextInt(numMax - 5) + 5;
			} while (num == resposta || flag);

			dogNum = new LabelNumeroDog(num);

			do {
				x = r.nextInt(4);
				y = r.nextInt(3);
				dogNum.setPosicao(y, x);
				numero = dogNum.getBounds();
			} while (matriz[x][y] != 0 || numero.intersects(player));

			matriz[x][y] = 1;
			dogNumeros.add(dogNum);
		}
	}
}
