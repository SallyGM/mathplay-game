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
public class LabelPersonagemDog extends LabelPersonagem {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private final int TEMPO = 3;

	private int pos;
	private int[] posicaoX = { 326, 302, 311 };
	private int[] espacosX = { 0, 353, 682 };

	private Timer tCima, tBaixo;
	private ActionListener movCima, movBaixo;
	private Action movEsq, movDir;
	private Action inCima, inBaixo, outCima, outBaixo;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL DOG

	public LabelPersonagemDog() {
		setSprite(ImageTools.DOG, 2);
		setLocation((326 - getWidth()) / 2, 739 - getHeight());

		pos = 0;
		speed = 2;

		setActions();
		setTimers();
		setKeyBindings();
	}

	// ////////////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO TECLADO

	private void setKeyBindings() {
		InputMap inMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actMap = this.getActionMap();

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "PressedUp");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "ReleasedUp");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false),
				"PressedDown");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true),
				"ReleasedDown");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false),
				"PressedLeft");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false),
				"PressedRight");

		actMap.put("PressedUp", inCima);
		actMap.put("ReleasedUp", outCima);
		actMap.put("PressedDown", inBaixo);
		actMap.put("ReleasedDown", outBaixo);
		actMap.put("PressedLeft", movEsq);
		actMap.put("PressedRight", movDir);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	// acoes do teclado
	private void setActions() {
		inCima = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCima(true);
			}
		};
		inBaixo = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setBaixo(true);
			}
		};
		outCima = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setCima(false);
			}
		};
		outBaixo = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setBaixo(false);
			}
		};

		movEsq = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pos > 0)
					pos--;
				int x = espacosX[pos] + (posicaoX[pos] - getWidth()) / 2;

				setLocation(x, getY());
			}
		};
		movDir = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pos < 2)
					pos++;
				int x = espacosX[pos] + (posicaoX[pos] - getWidth()) / 2;

				setLocation(x, getY());
			}
		};
		movCima = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int y = (getY() - speed < 0 ? 0 : getY() - speed);

				setLocation(getX(), y);
			}
		};
		movBaixo = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int y = (getY() + speed > 589 ? 589 : getY() + speed);

				setLocation(getX(), y);
			}
		};
	}

	private void setTimers() {
		tCima = new Timer(TEMPO, movCima);
		tBaixo = new Timer(TEMPO, movBaixo);

		tCima.setInitialDelay(0);
		tBaixo.setInitialDelay(0);
	}

	// metodos responsaveis por controlar a movimentacao vertical
	public void setCima(boolean cima) {
		if (cima)
			tCima.start();
		else
			tCima.stop();
	}

	public void setBaixo(boolean baixo) {
		if (baixo)
			tBaixo.start();
		else
			tBaixo.stop();
	}
}
