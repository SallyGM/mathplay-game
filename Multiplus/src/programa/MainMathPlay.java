package programa;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import frame.FrameJanela;
import usefulTools.FrameTools;

public class MainMathPlay {

	// /////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS
	static FrameJanela janela;

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO JOGO

	public static void main(String[] args) {
		janela = new FrameJanela();

		loading();

		FrameTools.mudarPainel(FrameTools.JANELA, FrameTools.MENU);
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	private static void loading() {
		JLabel texto = new JLabel("Loading...");
		Font f = new Font("impact", Font.BOLD, 50);

		texto.setFont(f);
		texto.setSize(texto.getPreferredSize());
		texto.setLocation(680 - texto.getWidth() / 2,
				370 - texto.getHeight() / 2);

		janela.getContentPane().setBackground(Color.WHITE);
		janela.getContentPane().add(texto);
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS GET E/OU SET

	public static FrameJanela getJanela() {
		return janela;
	}
}
