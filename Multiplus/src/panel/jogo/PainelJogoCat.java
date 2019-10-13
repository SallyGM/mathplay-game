package panel.jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import label.jogoInfo.LabelJogoInfoCat;
import label.numero.LabelNumeroCat;
import label.personagem.LabelPersonagemCat;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelJogoCat extends PainelJogo {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private LabelPersonagemCat cat;
	private ArrayList<LabelNumeroCat> catNumeros;

	private int res, resPos;

	private ActionListener novaWave, verifica;
	private Timer tWave, tVerifica;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO PAINELJOGOCAT

	public PainelJogoCat() {
		config(ImageTools.JOGOCAT_BACKGROUND, 3);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		cat = new LabelPersonagemCat();
		info = new LabelJogoInfoCat();
		catNumeros = new ArrayList<LabelNumeroCat>();
		
		add(cat);
	}

	@Override
	protected void setActionsThreads() {
		novaWave = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();

				int num1 = random.nextInt(99) + 1;
				int num2 = random.nextInt(99) + 1;
				res = num1 + num2;
				resPos = random.nextInt(6) + 1;

				String t1 = Integer.toString(num1);
				String t2 = Integer.toString(num2);

				info.setString(t1 + " + " + t2);

				// //////////////////////////////////////////////////////

				LabelNumeroCat catNumRes = new LabelNumeroCat(res, resPos);

				add(catNumRes);
				catNumeros.add(catNumRes);

				for (int i = 1; i <= 6; i++) {
					if (i == resPos)
						continue;

					LabelNumeroCat catNum;
					int num;
					do {
						num = random.nextInt(200) + 1;
						catNum = new LabelNumeroCat(num, i);
					} while (num == res);

					add(catNum);
					catNumeros.add(catNum);
				}

				validate();
				repaint();

				tVerifica.restart();
			}
		};
		verifica = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (resPos == cat.getPos()) {
					info.addNumAcertos();
				} else {
					info.addNumErros();
				}

				for (int i = 0; i < 6; i++) {
					removerComponente(catNumeros.get(0));
					catNumeros.remove(0);
				}

				tVerifica.stop();
			}
		};
	}

	@Override
	protected void initTimersThreads() {
		tWave = new Timer(5000, novaWave);
		tVerifica = new Timer(4900, verifica);

		tWave.setInitialDelay(0);

		t.start();
		tWave.start();
		tVerifica.start();
	}

	@Override
	protected void initMetodos() {

	}

	@Override
	protected void stopTimers() {
		t.stop();
		tWave.stop();
		tVerifica.stop();
	}
}
