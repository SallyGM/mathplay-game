package label.personagem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelPersonagemAngel extends LabelPersonagem {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	// tempo para executar cada ActionListener
	private final int TEMPO = 3;

	private Timer timeEsq, timeDir;
	private ActionListener movEsq, movDir;
	private Action inEsq, inDir;
	private Action outEsq, outDir;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL ANGEL

	public LabelPersonagemAngel() {
		// colocando imagem
		setSprite(ImageTools.ANGEL, 2);
		setLocation((1020 - getWidth()) / 2, 739 - getHeight());

		speed = 1;
		maxX = 1020;

		setActions();
		setTimers();
		setKeyBindings();
	}

	// ////////////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO TECLADO

	private void setKeyBindings() {
		// InputMap: relaciona tecla com um nome da acao

		// WHEN_IN_FOCUSED_WINDOW: quando algum componente da tela tiver foco,
		// nao importa qual
		InputMap inMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

		// ActionMap: relaciona nome da acao com a acao em si
		ActionMap actMap = this.getActionMap();

		// movimentacao do personagem
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false),
				"PressedRight");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true),
				"ReleasedRight");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false),
				"PressedLeft");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true),
				"ReleasedLeft");

		actMap.put("PressedRight", inDir);
		actMap.put("ReleasedRight", outDir);
		actMap.put("PressedLeft", inEsq);
		actMap.put("ReleasedLeft", outEsq);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	// acoes do teclado
	private void setActions() {
		inEsq = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setEsq(true);
			}
		};
		inDir = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDir(true);
			}
		};

		outEsq = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setEsq(false);
			}
		};
		outDir = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDir(false);
			}
		};

		movEsq = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = (getX() - speed < 0 ? 0 : getX() - speed);
				setLocation(x, getY());
			}
		};
		movDir = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = (getX() + speed > maxX - icone.getIconWidth() ? maxX
						- icone.getIconWidth() : getX() + speed);
				setLocation(x, getY());
			}
		};
	}

	private void setTimers() {
		// cada Timer executa sua respectiva ação a cada TEMPO ms
		timeEsq = new Timer(TEMPO, movEsq);
		timeDir = new Timer(TEMPO, movDir);

		timeEsq.setInitialDelay(0);
		timeDir.setInitialDelay(0);
	}

	// metodos responsaveis por controlar a movimentacao horizontals
	public void setEsq(boolean esq) {
		if (esq)
			timeEsq.start();
		else
			timeEsq.stop();
	}

	public void setDir(boolean dir) {
		if (dir)
			timeDir.start();
		else
			timeDir.stop();
	}
}
