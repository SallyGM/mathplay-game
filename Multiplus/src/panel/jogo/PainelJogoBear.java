package panel.jogo;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import label.jogoInfo.LabelJogoInfoBear;
import label.personagem.LabelPersonagemBear;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelJogoBear extends PainelJogo {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private LabelPersonagemBear bear;
	private JLabel poteMel;

	private JLabel expressao;
	private JLabel numeroPoteMel;
	private int resultado;
	private int passoCount;

	private Action countUpStart, countDownStart, countUpStop, countDownStop,
			confirm;
	private ActionListener tempoLimite, tempoCountUp, tempoCountDown;
	private Timer tCountUp, tCountDown, tLimite;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL JOGOBEAR

	public PainelJogoBear() {
		config(ImageTools.JOGOBEAR_BACKGROUND, 2);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		bear = new LabelPersonagemBear();
		info = new LabelJogoInfoBear();
		expressao = new JLabel();
		numeroPoteMel = new JLabel();
		poteMel = new JLabel();

		Font f = new Font("impact", Font.BOLD, 100);

		expressao.setFont(f);
		numeroPoteMel.setFont(f);

		// //////////////////////////////////////////////////////////

		Image aux;

		aux = ImageTools.ReadImage(ImageTools.POTEMEL, this);
		poteMel.setIcon(new ImageIcon(aux));
		poteMel.setSize(poteMel.getPreferredSize());
		poteMel.setLocation((1020 - poteMel.getWidth()) / 2,
				739 - poteMel.getHeight());

		add(bear);
		add(expressao);
		add(numeroPoteMel);
		add(poteMel);
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
		tempoCountUp = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(numeroPoteMel.getText().replace("%",
						""));

				if (passoCount != 0 && num < passoCount * 10)
					numeroPoteMel.setText(Integer.toString(num += passoCount));
				else if (passoCount == 0 && num < 100)
					numeroPoteMel.setText(Integer.toString(num += 10) + "%");

				numeroPoteMel.setSize(numeroPoteMel.getPreferredSize());
				numeroPoteMel.setLocation(
						(1020 - numeroPoteMel.getWidth()) / 2,
						450 - numeroPoteMel.getHeight() / 2);

				validate();
				repaint();
			}
		};
		tempoCountDown = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(numeroPoteMel.getText().replace("%",
						""));

				if (passoCount != 0 && num > 0)
					numeroPoteMel.setText(Integer.toString(num -= passoCount));
				else if (passoCount == 0 && num > 0)
					numeroPoteMel.setText(Integer.toString(num -= 10) + "%");

				numeroPoteMel.setSize(numeroPoteMel.getPreferredSize());
				numeroPoteMel.setLocation(
						(1020 - numeroPoteMel.getWidth()) / 2,
						450 - numeroPoteMel.getHeight() / 2);

				validate();
				repaint();
			}
		};

		countUpStart = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCountUp(true);
			}
		};
		countDownStart = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCountDown(true);
			}
		};
		countUpStop = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCountUp(false);
			}
		};
		countDownStop = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCountDown(false);
			}
		};
		confirm = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(numeroPoteMel.getText().replace("%",
						""));

				if (num == resultado)
					info.addNumAcertos();
				else
					info.addNumErros();

				addNovaWave();
			}
		};
	}

	@Override
	protected void initTimersThreads() {
		tLimite = new Timer(10000, tempoLimite);
		tCountUp = new Timer(100, tempoCountUp);
		tCountDown = new Timer(100, tempoCountDown);

		tCountUp.setInitialDelay(0);
		tCountDown.setInitialDelay(0);

		t.start();
		tLimite.start();
	}

	@Override
	protected void initMetodos() {
		setKeyBindings();
		addNovaWave();
	}

	@Override
	protected void stopTimers() {
		t.stop();
		tLimite.stop();
		tCountUp.stop();
		tCountDown.stop();
	}

	// ///////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO TECLADO

	private void setKeyBindings() {
		InputMap inMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actMap = getActionMap();

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "pressedUp");
		actMap.put("pressedUp", countUpStart);
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "releasedUp");
		actMap.put("releasedUp", countUpStop);

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false),
				"pressedDown");
		actMap.put("pressedDown", countDownStart);
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true),
				"releasedDown");
		actMap.put("releasedDown", countDownStop);

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
				"pressedConfirm");
		actMap.put("pressedConfirm", confirm);
	}

	// /////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO JOGO

	private void addNovaWave() {
		novaExpressao();

		validate();
		repaint();

		tLimite.restart();
	}

	// /////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO JOGO

	private void novaExpressao() {
		Random r = new Random();

		if (r.nextInt(2) == 0)
			novaExpressaoPorcentagem(r);
		else
			novaExpressaoValor(r);
	}

	private void novaExpressaoPorcentagem(Random random) {
		int porcentagem;
		int valor;
		Double resultado;

		porcentagem = (random.nextInt(10) + 1) * 10;
		valor = (random.nextInt(100) + 1) * 10;
		resultado = porcentagem / 100.0 * valor;

		this.resultado = resultado.intValue();

		expressao.setText(porcentagem + "% de " + valor);
		numeroPoteMel.setText("0");

		expressao.setSize(expressao.getPreferredSize());
		expressao.setLocation((1020 - expressao.getWidth()) / 2, 0);

		numeroPoteMel.setSize(numeroPoteMel.getPreferredSize());
		numeroPoteMel.setLocation((1020 - numeroPoteMel.getWidth()) / 2,
				450 - numeroPoteMel.getHeight() / 2);

		passoCount = valor / 10;
	}

	private void novaExpressaoValor(Random random) {
		int valor;
		Integer valorTotal;
		Double resultado;

		valorTotal = (random.nextInt(100) + 1) * 10;
		valor = valorTotal / 10 * (random.nextInt(10) + 1);
		resultado = valor / valorTotal.doubleValue() * 100.0;

		this.resultado = resultado.intValue();

		expressao.setText(valor + " de " + valorTotal);
		numeroPoteMel.setText("0%");

		expressao.setSize(expressao.getPreferredSize());
		expressao.setLocation((1020 - expressao.getWidth()) / 2, 0);

		numeroPoteMel.setSize(numeroPoteMel.getPreferredSize());
		numeroPoteMel.setLocation((1020 - numeroPoteMel.getWidth()) / 2,
				450 - numeroPoteMel.getHeight() / 2);

		passoCount = 0;
	}

	private void setCountUp(boolean countUp) {
		if (countUp)
			tCountUp.start();
		else
			tCountUp.stop();
	}

	private void setCountDown(boolean countDown) {
		if (countDown)
			tCountDown.start();
		else
			tCountDown.stop();
	}
}
