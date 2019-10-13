package panel.jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import panel.resultado.PainelResultado;
import label.jogoInfo.LabelJogoInfo;
import usefulTools.*;

@SuppressWarnings("serial")
public abstract class PainelJogo extends JPanel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	protected int codigo;

	protected boolean fimJogo;

	protected Image background;

	protected int largura, altura;
	protected int counter;

	protected ActionListener tempo;
	protected Timer t;

	protected Action sairJogo;
	protected boolean teclaEsc = false;

	protected LabelJogoInfo info;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL JOGO

	// configura o painel de jogo da janela
	protected void config(String diretorio, int codigo) {
		largura = 1360;
		altura = 739;

		this.codigo = codigo;

		setLayout(null);
		setBounds(0, 0, largura, altura);

		setSairJogo();
		setKeyBindings();

		background = ImageTools.ReadImage(diretorio, this);
	}

	// configura a saida do jogo pela tecla ESCAPE
	private void setSairJogo() {
		sairJogo = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				teclaEsc = true;
				setFimJogo(true);
			}
		};
	}

	// configura as entradas do teclado a serem respondidas
	private void setKeyBindings() {
		InputMap inMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actMap = this.getActionMap();

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false),
				"PressedEscape");
		actMap.put("PressedEscape", sairJogo);
	}

	// //////////////////////////////////////////////////////////////////////
	// COMECO E FIM DO JOGO

	// testes em qual situacao esta o jogo
	// (comeco ou fim, e se ESCAPE foi teclado)
	public void setFimJogo(boolean fimJogo) {
		this.fimJogo = fimJogo;

		if (!fimJogo)
			comecar();
		else {
			terminar();
			if (!teclaEsc)
				exibirResultado();
			else
				exibirTelaInicial();
		}
	}

	public boolean isFimJogo() {
		return fimJogo;
	}

	public void setTeclaEsc(boolean teclaEsc) {
		this.teclaEsc = teclaEsc;
	}

	// metodo chamado quando for comeco de jogo
	private void comecar() {
		counter = 45;

		// configura as JLabels do jogo
		configLabels();

		add(info);

		// inicializa a temporizacao do jogo
		setTemporizacao();

		// inicializa as acoes e threads a serem utilizadas
		setActionsThreads();

		// inicializa as timers e threads
		initTimersThreads();

		// metodos a mais necessarios
		initMetodos();
	}

	// metodo chamado quando for fim de jogo
	private void terminar() {
		removeAll();
		validate();
		repaint();

		stopTimers();
	}

	// ////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (ABSTRATOS)

	abstract protected void configLabels();

	abstract protected void setActionsThreads();

	abstract protected void initTimersThreads();

	abstract protected void initMetodos();

	abstract protected void stopTimers();

	// //////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	// auxiliar de inicializar()
	protected void setTemporizacao() {
		tempo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (counter == 1) {
					setFimJogo(true);
				} else {
					info.setTempo(--counter);
				}
			}
		};

		t = new Timer(1000, tempo);
	}

	// auxiliares de setFimJogo(true);
	protected void exibirResultado() {
		PainelResultado[] resultados = { FrameTools.RESULTADOANGEL,
				FrameTools.RESULTADOBAT, FrameTools.RESULTADOBEAR,
				FrameTools.RESULTADOCAT, FrameTools.RESULTADOCOTTONCANDY,
				FrameTools.RESULTADODOG, FrameTools.RESULTADOMOUSE,
				FrameTools.RESULTADOPANDA, FrameTools.RESULTADOPIG,
				FrameTools.RESULTADOPIGRABBIT };

		PainelResultado resultadoAtual = resultados[codigo];

		resultadoAtual.setResultado(info.getNumAcertos(), info.getNumErros());
		FrameTools.mudarPainel(FrameTools.JANELA, resultadoAtual);
	}

	public void exibirTelaInicial() {
		FrameTools.mudarPainel(FrameTools.JANELA, FrameTools.MENU);
	}

	// remover componente fazendo validate() e repaint()
	protected void removerComponente(JComponent c) {
		remove(c);
		validate();
		repaint();
	}

	// pinta uma imagem no painel
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, this);
	}
}
