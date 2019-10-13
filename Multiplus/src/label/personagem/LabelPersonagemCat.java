package label.personagem;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelPersonagemCat extends LabelPersonagem {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private int x;
	private int pos;
	private int[] desvio = { 168, 172, 171, 170, 171, 171 };

	private Action movEsq, movDir;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL NUMEROCAT

	public LabelPersonagemCat() {
		setSprite(ImageTools.CAT, 2);
		setLocation(23, 621 - getHeight());

		pos = 1;
		speed = desvio[pos - 1];

		setActions();
		setKeyBindings();
	}

	// ////////////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO TECLADO

	private void setKeyBindings() {
		InputMap inMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actMap = getActionMap();

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false),
				"PressedLeft");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false),
				"PressedRight");

		actMap.put("PressedLeft", movEsq);
		actMap.put("PressedRight", movDir);
	}

	private void setActions() {
		movEsq = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				x = getX() - speed;

				if (x < 23) {
					x = 23;
					pos = 1;
				} else {
					pos--;
				}

				setLocation(x, getY());
				speed = desvio[pos - 1];
			}
		};
		movDir = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				x = getX() + speed;

				if (x > 875) {
					x = 875;
					pos = 6;
				} else {
					pos++;
				}

				setLocation(x, getY());
				speed = desvio[pos - 1];

			}
		};
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS GET E/OU SET
	
	public int getPos() {
		return pos;
	}
}
