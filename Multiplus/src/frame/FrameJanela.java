package frame;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import panel.PainelMenu;
import panel.PainelSelecao;
import panel.jogo.PainelJogoAngel;
import panel.resultado.PainelResultadoAngel;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class FrameJanela extends JFrame {

	// //////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS
	
	private int x = 1366, y = 768;

	private ImageIcon icone;

	public PainelMenu menu;
	public PainelJogoAngel jogoAngel;
	public PainelResultadoAngel resultado;
	public PainelSelecao selecao;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DA JANELA DE JOGO
	
	public FrameJanela() {
		config();
		setVisible(true);
	}

	private void config() {
		setTitle("Multiplus (BETA)");
		setPreferredSize(new Dimension(x, y));

		// "comprime" a janela
		pack();

		// centraliza o jogo na tela
		setLocationRelativeTo(null);

		setFocusable(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		icone = ImageTools.ReadIcon(ImageTools.ICONE, this);
		setIconImage(icone.getImage());
	}
}