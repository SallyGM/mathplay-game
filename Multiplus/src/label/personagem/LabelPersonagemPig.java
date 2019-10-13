package label.personagem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelPersonagemPig extends LabelPersonagem {

	// ///////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private final int TEMPO = 3;

	private Timer timeEsq, timeDir;
	private ActionListener movEsq, movDir;
	private Action inEsq, inDir;
	private Action outEsq, outDir;
	private Action jump;

	private ArrayList<ImageIcon> sprite;
	private JLabel lblTotalCesta;
	private int indexSprite;
	private int totalCesta;
	private boolean isJumping;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL PIG

	public LabelPersonagemPig() {
		setImagens();
		setLocation((1020 - getWidth()) / 2, 678 - getHeight());

		speed = 2;
		maxX = 1020;
		totalCesta = 0;
		indexSprite = 0;

		setActions();
		setTimers();
		setKeyBindings();
	}

	// ////////////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO TECLADO

	private void setKeyBindings() {
		InputMap inMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

		ActionMap actMap = this.getActionMap();

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false),
				"PressedRight");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true),
				"ReleasedRight");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false),
				"PressedLeft");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true),
				"ReleasedLeft");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false),
				"PressedSpace");

		actMap.put("PressedRight", inDir);
		actMap.put("ReleasedRight", outDir);
		actMap.put("PressedLeft", inEsq);
		actMap.put("ReleasedLeft", outEsq);
		actMap.put("PressedSpace", jump);
	}

	// ////////////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	public void addMaca(int numMaca) {
		totalCesta += numMaca;
		setIcon(sprite.get(indexSprite++));
		
		lblTotalCesta.setText(Integer.toString(totalCesta));
		lblTotalCesta.setSize(lblTotalCesta.getPreferredSize());
		lblTotalCesta.setLocation(43 + (107 - lblTotalCesta.getWidth()) / 2,
				getHeight() - lblTotalCesta.getHeight());
	}

	public int getTotalCesta() {
		return totalCesta;
	}

	// le todas as imagens do sprite
	private void setImagens() {
		sprite = new ArrayList<>();

		sprite.add(new ImageIcon(ImageTools.ReadImage(ImageTools.PIGCESTA1,
				this)));
		sprite.add(new ImageIcon(ImageTools.ReadImage(ImageTools.PIGCESTA2,
				this)));
		sprite.add(new ImageIcon(ImageTools.ReadImage(ImageTools.PIGCESTA3,
				this)));
		sprite.add(new ImageIcon(ImageTools.ReadImage(ImageTools.PIGCESTA4,
				this)));
		sprite.add(new ImageIcon(ImageTools.ReadImage(ImageTools.PIGCESTA5,
				this)));
		sprite.add(new ImageIcon(ImageTools.ReadImage(ImageTools.PIGCESTA6,
				this)));

		setSprite(ImageTools.PIGCESTA0, 1);

		Font f = new Font("impact", Font.BOLD, 45);
		lblTotalCesta = new JLabel();
		lblTotalCesta.setFont(f);
		lblTotalCesta.setText("0");
		lblTotalCesta.setSize(lblTotalCesta.getPreferredSize());
		lblTotalCesta.setLocation(43 + (107 - lblTotalCesta.getWidth()) / 2,
				getHeight() - lblTotalCesta.getHeight());
		
		add(lblTotalCesta);
	}

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
		jump = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				startJump();
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
				int x = (getX() + speed > maxX - getWidth() ? maxX - getWidth()
						: getX() + speed);
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

	private void startJump() {
		Thread jump = new Thread() {

			@Override
			public void run() {
				if (!isJumping) {
					isJumping = true;

					int valorPulo = 25;

					int auxPulo = valorPulo;
					while (auxPulo > 0) {
						int y = getY() - auxPulo;
						setLocation(getX(), y);

						auxPulo -= 1;

						try {
							Thread.sleep(17);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					auxPulo = 1;
					while (auxPulo != 26) {
						int y = getY() + auxPulo;
						setLocation(getX(), y);

						auxPulo += 1;

						try {
							Thread.sleep(17);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					isJumping = false;
				}
			}
		};

		jump.start();
	}
}
