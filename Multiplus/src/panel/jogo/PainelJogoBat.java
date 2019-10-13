package panel.jogo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import label.jogoInfo.LabelJogoInfoBat;
import label.numero.LabelNumeroBat;
import label.personagem.LabelPersonagemBat;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelJogoBat extends PainelJogo {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private LabelPersonagemBat bat;
	private LabelNumeroBat batNum;
	private JLabel setaEsq, setaDir;

	private ActionListener tempoLimite;
	private Timer tLimite;

	private Action goEsq, goDir;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL JOGOBAT

	public PainelJogoBat() {
		config(ImageTools.JOGOBAT_BACKGROUND, 1);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		bat = new LabelPersonagemBat();
		info = new LabelJogoInfoBat();
		batNum = new LabelNumeroBat();

		// ////////////////////////////////////////////////////////////////

		Image aux;

		aux = ImageTools.ReadImage(ImageTools.SETAIMPAR, this);
		setaEsq = new JLabel(new ImageIcon(aux));
		setaEsq.setSize(setaEsq.getPreferredSize());
		setaEsq.setLocation(360 - setaEsq.getWidth(), batNum.getY() - 19);

		aux = ImageTools.ReadImage(ImageTools.SETAPAR, this);
		setaDir = new JLabel(new ImageIcon(aux));
		setaDir.setSize(setaDir.getPreferredSize());
		setaDir.setLocation(660, batNum.getY() - 19);

		// ///////////////////////////////////////////////////////////////

		add(bat);
		add(setaEsq);
		add(setaDir);
	}

	@Override
	protected void setActionsThreads() {
		tempoLimite = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tLimite.stop();

				info.addNumErros();
				removerComponente(batNum);
				addBatNum();
			}
		};

		goEsq = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (batNum.getValor() % 2 != 0) {
					info.addNumAcertos();
					batNum.moverEsquerda();
				} else {
					info.addNumErros();
					removerComponente(batNum);
				}
				tLimite.stop();

				validate();
				repaint();

				addBatNum();
			}
		};
		goDir = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (batNum.getValor() % 2 == 0) {
					info.addNumAcertos();
					batNum.moverDireita();
				} else {
					info.addNumErros();
					removerComponente(batNum);
				}
				tLimite.stop();

				validate();
				repaint();

				addBatNum();
			}
		};
	}

	@Override
	protected void initTimersThreads() {
		t.start();

		tLimite = new Timer(5000, tempoLimite);
		tLimite.start();
	}

	@Override
	protected void initMetodos() {
		add(batNum);
		setKeyBindings();
	}

	@Override
	protected void stopTimers() {
		t.stop();
		tLimite.stop();
	}

	// //////////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO TECLADO

	// configurando acoes de acordo com as teclas
	private void setKeyBindings() {
		InputMap inMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actMap = getActionMap();

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false),
				"pressedLeft");
		actMap.put("pressedLeft", goEsq);

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false),
				"pressedRight");
		actMap.put("pressedRight", goDir);
	}
	
	// //////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO JOGO

	public void addBatNum() {
		batNum = new LabelNumeroBat();
		add(batNum);

		validate();
		repaint();

		tLimite.restart();
	}
}
