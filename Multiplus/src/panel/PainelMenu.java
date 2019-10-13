package panel;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import usefulTools.FrameTools;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelMenu extends JPanel implements MouseListener {

	// //////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private Image background, logo, jogar, sair;
	private JLabel jLblBackground, jLblLogo, jLblJogar, jLblSair;
	private Rectangle jogarRect, sairRect;

	private int altura, largura;

	// //////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINELMENU

	public PainelMenu() {
		initVar();
		config();
	}

	// //////////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO MOUSE

	@Override
	public void mouseClicked(MouseEvent e) {
		if (jogarRect.contains(e.getPoint())) {
			FrameTools.mudarPainel(FrameTools.JANELA, FrameTools.SELECAO);
		}
		if (sairRect.contains(e.getPoint())) {
			System.exit(1);
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

	// /////////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	// auxiliares de PainelMenu();
	private void initVar() {
		logo = ImageTools.ReadImage(ImageTools.LOGO, this);
		background = ImageTools.ReadImage(ImageTools.MENU_BACKGROUND, this);
		jogar = ImageTools.ReadImage(ImageTools.JOGAR, this);
		sair = ImageTools.ReadImage(ImageTools.SAIR, this);
		
		jLblBackground = new JLabel(new ImageIcon(background));
		jLblLogo = new JLabel(new ImageIcon(logo));
		jLblJogar = new JLabel(new ImageIcon(jogar));
		jLblSair = new JLabel(new ImageIcon(sair));
		
		largura = 1360;
		altura = 739;
	}

	private void config() {
		setLayout(null);
		setBounds(0, 0, largura, altura);
		configLabels();

		addMouseListener(this);
	}

	// auxiliar de config();
	private void configLabels() {
		jLblBackground.setSize(jLblBackground.getPreferredSize());
		jLblLogo.setSize(jLblLogo.getPreferredSize());
		jLblJogar.setSize(jLblJogar.getPreferredSize());
		jLblSair.setSize(jLblSair.getPreferredSize());
		
		jLblBackground.setLocation(0, 0);
		jLblLogo.setLocation(380, 20);
		jLblJogar.setLocation(405, 300);
		jLblSair.setLocation(705, 300);
		
		jogarRect = new Rectangle(jLblJogar.getBounds());
		sairRect = new Rectangle(jLblSair.getBounds());
		
		add(jLblLogo);
		add(jLblJogar);
		add(jLblSair);
		add(jLblBackground);
	}

}
