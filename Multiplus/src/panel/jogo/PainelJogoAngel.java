package panel.jogo;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import label.jogoInfo.LabelJogoInfoAngel;
import label.numero.LabelNumeroAngel;
import label.personagem.LabelPersonagemAngel;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelJogoAngel extends PainelJogo {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private final int TEMPOADD = 1000;

	private LabelPersonagemAngel angel;
	private ArrayList<LabelNumeroAngel> angelNumeros;

	private ActionListener addNum;
	private Timer tNum;
	private Thread colisao, colisaoFundo;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL JOGOANGEL

	public PainelJogoAngel() {
		config(ImageTools.JOGOANGEL_BACKGROUND, 0);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		angel = new LabelPersonagemAngel();
		info = new LabelJogoInfoAngel();
		angelNumeros = new ArrayList<LabelNumeroAngel>();

		add(angel);
	}

	@Override
	protected void setActionsThreads() {
		addNum = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LabelNumeroAngel num = new LabelNumeroAngel();
				angelNumeros.add(num);
				add(num);
			}
		};

		colisao = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					Rectangle player = angel.getBounds();

					for (int i = 0; i < angelNumeros.size(); i++) {
						// cria um retângulo com tamanho de atual (LabelNumero)
						LabelNumeroAngel atual = angelNumeros.get(i);
						Rectangle numero = atual.getBounds();

						// colisões são detectadas pelo conceito de intersecção
						// de retângulos
						if (player.intersects(numero)) {
							if (atual.getValor() % info.getNumero() == 0)
								info.addNumAcertos();
							else
								info.addNumErros();

							removerComponente(atual);
							angelNumeros.remove(atual);
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
		colisaoFundo = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					for (int i = 0; i < angelNumeros.size(); i++) {
						// cria um retângulo com tamanho de atual (LabelNumero)
						LabelNumeroAngel atual = angelNumeros.get(i);

						// penalização de pontos quando um LabelNumero chega ao
						// fim da tela no eixo x
						if (atual.getY() >= altura - atual.getHeight()) {
							if (atual.getValor() % info.getNumero() == 0)
								info.addNumErros();

							removerComponente(atual);
							angelNumeros.remove(atual);
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
		tNum = new Timer(TEMPOADD, addNum);

		tNum.setInitialDelay(0);

		t.start();
		tNum.start();
		colisao.start();
		colisaoFundo.start();
	}

	@Override
	protected void initMetodos() {

	}

	@Override
	protected void stopTimers() {
		t.stop();
		tNum.stop();
		angel.setEsq(false);
		angel.setDir(false);
	}
}
