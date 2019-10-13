package panel.ajuda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import usefulTools.FrameTools;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public abstract class PainelAjuda extends JPanel implements MouseListener {

	// /////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private int largura;
	private int altura;

	private Image background;

	protected JLabel helpImage;
	protected JLabel helpText;

	protected Rectangle botao;
	protected int counterMensagem;
	protected ArrayList<Integer> posicoesAltMensagem;

	// /////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL AJUDA

	protected void config(String dirBackground, String dirHelpImage,
			String dirHelpText) {
		largura = 1360;
		altura = 739;

		setLayout(null);
		setBounds(0, 0, largura, altura);

		botao = new Rectangle(806, 676, 54, 51);
		background = ImageTools.ReadImage(dirBackground, this);
		helpImage = new JLabel(new ImageIcon(ImageTools.ReadImage(dirHelpImage,
				this)));
		helpText = new JLabel(new ImageIcon(ImageTools.ReadImage(dirHelpText,
				this)));

		helpImage.setSize(helpImage.getPreferredSize());
		helpText.setSize(helpText.getPreferredSize());

		helpImage.setLocation(445, 0);

		add(helpImage);
		add(helpText);
		addMouseListener(this);
	}

	// /////////////////////////////////////////////////////////////
	// COMECO E FIM DO CHAT

	// metodo que testa em qual situacao esta o chat (inicio ou fim)
	public void setFimChat(boolean fimChat) {
		if (fimChat) {
			terminar();
		} else {
			comecar();
		}
	}

	// metodo responsavel por comecar o chat
	private void comecar() {
		counterMensagem = 0;
		helpText.setLocation(445, posicoesAltMensagem.get(counterMensagem));
	}

	// metodo responsavel por terminar o chat
	private void terminar() {
		FrameTools.mudarPainel(FrameTools.JANELA, FrameTools.SELECAO);
	}

	// /////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO MOUSE

	@Override
	public void mouseClicked(MouseEvent e) {
		if (botao.contains(e.getPoint())) {
			if (counterMensagem < 3) {
				helpText.setLocation(445,
						posicoesAltMensagem.get(++counterMensagem));
			} else {
				setFimChat(true);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	// /////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	// pinta uma imagem no painel
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(255, 255, 255, 127));
		g.drawImage(background, 0, 0, this);
		g.fillRect(0, 0, 1360, 739);
	}
}
