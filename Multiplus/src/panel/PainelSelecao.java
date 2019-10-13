package panel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import panel.ajuda.PainelAjuda;
import panel.jogo.PainelJogo;
import label.selecao.*;
import usefulTools.FrameTools;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelSelecao extends JPanel implements MouseListener {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private int largura;
	private int altura;

	private ArrayList<LabelSelecao> selecoes = new ArrayList<LabelSelecao>();
	private LabelSelecao selecaoAtual;
	private int indexSelecao;

	private Rectangle setaDirRect, setaEsqRect, btnJogarRect, btnAjudaRect;

	private Image background;
	private JLabel setaDireita, setaEsquerda;
	private JLabel btnJogar, btnAjuda;

	// ////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL SELECAO

	public PainelSelecao() {
		initVar();
		initComponents();
		config();
	}

	// /////////////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO MOUSE

	@Override
	public void mouseClicked(MouseEvent e) {
		// as condicoes a seguir checam se o mouse foi solto dentro de certos
		// botoes da tela

		// seta da direita
		if (setaDirRect.contains(e.getPoint())) {
			remove(selecaoAtual);
			indexSelecao++;

			// se for o ultimo elemento, volta para o comeco
			if (indexSelecao >= selecoes.size())
				indexSelecao = 0;

			selecaoAtual = selecoes.get(indexSelecao);
			add(selecaoAtual);

			validate();
			repaint();
		}

		// seta da esquerda
		if (setaEsqRect.contains(e.getPoint())) {
			remove(selecaoAtual);
			indexSelecao--;

			// se for o primeiro elemento, vai para o ultimo
			if (indexSelecao <= -1)
				indexSelecao = selecoes.size() - 1;

			selecaoAtual = selecoes.get(indexSelecao);
			add(selecaoAtual);

			validate();
			repaint();
		}

		// botao de jogar
		if (btnJogarRect.contains(e.getPoint())) {
			PainelJogo[] jogos = { FrameTools.JOGOANGEL, FrameTools.JOGOBAT,
					FrameTools.JOGOBEAR, FrameTools.JOGOCAT,
					FrameTools.JOGOCOTTONCANDY, FrameTools.JOGODOG,
					FrameTools.JOGOMOUSE, FrameTools.JOGOPANDA,
					FrameTools.JOGOPIG, FrameTools.JOGOPIGRABBIT };

			PainelJogo jogoAtual = jogos[selecaoAtual.getCodigo()];

			jogoAtual.setFimJogo(false);
			jogoAtual.setTeclaEsc(false);
			FrameTools.mudarPainel(FrameTools.JANELA, jogoAtual);
		}

		// botao de ajuda
		if (btnAjudaRect.contains(e.getPoint())) {
			PainelAjuda[] ajudas = { FrameTools.AJUDAANGEL,
					FrameTools.AJUDABAT, FrameTools.AJUDABEAR,
					FrameTools.AJUDACAT, FrameTools.AJUDACOTTONCANDY,
					FrameTools.AJUDADOG, FrameTools.AJUDAMOUSE,
					FrameTools.AJUDAPANDA, FrameTools.AJUDAPIG,
					FrameTools.AJUDAPIGRABBIT };

			PainelAjuda ajudaAtual = ajudas[selecaoAtual.getCodigo()];

			ajudaAtual.setFimChat(false);
			FrameTools.mudarPainel(FrameTools.JANELA, ajudaAtual);
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

	// auxiliares de PainelSelecao();
	public void initVar() {
		indexSelecao = 0;

		largura = 1360;
		altura = 739;
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, largura, altura);

		background = ImageTools.ReadImage(ImageTools.MENU_BACKGROUND, this);

		setaDireita = new JLabel();
		setaEsquerda = new JLabel();
		btnJogar = new JLabel();
		btnAjuda = new JLabel();

		addMouseListener(this);
	}

	public void config() {
		Font f;
		JLabel texto = new JLabel();

		// edita o cabecalho da tela de selecao
		f = new Font("impact", Font.BOLD, 50);

		texto.setFont(f);
		texto.setText("ESCOLHA O MODO DE JOGO");
		texto.setSize(texto.getPreferredSize());
		texto.setLocation(largura / 2 - texto.getWidth() / 2, 0);

		// adiciona todas as selecoes (jogos) atualmente disponiveis
		selecoes.add(new LabelSelecaoAngel());
		selecoes.add(new LabelSelecaoBat());
		selecoes.add(new LabelSelecaoBear());
		selecoes.add(new LabelSelecaoCat());
		selecoes.add(new LabelSelecaoCottonCandy());
		selecoes.add(new LabelSelecaoDog());
		selecoes.add(new LabelSelecaoMouse());
		selecoes.add(new LabelSelecaoPanda());
		selecoes.add(new LabelSelecaoPig());
		selecoes.add(new LabelSelecaoPigRabbit());

		selecaoAtual = selecoes.get(indexSelecao);

		// //////////////////////////////////////////////////////////////////

		Image aux;

		aux = ImageTools.ReadImage(ImageTools.SETADIREITA, this);
		setaDireita.setIcon(new ImageIcon(aux));
		setaDireita.setSize(setaDireita.getPreferredSize());
		setaDireita.setLocation(largura - setaDireita.getWidth(), altura / 2
				- setaDireita.getHeight() / 2);

		aux = ImageTools.ReadImage(ImageTools.SETAESQUERDA, this);
		setaEsquerda.setIcon(new ImageIcon(aux));
		setaEsquerda.setSize(setaEsquerda.getPreferredSize());
		setaEsquerda.setLocation(0, altura / 2 - setaEsquerda.getHeight() / 2);

		aux = ImageTools.ReadImage(ImageTools.JOGAR, this);
		btnJogar.setIcon(new ImageIcon(aux));
		btnJogar.setSize(btnJogar.getPreferredSize());
		btnJogar.setLocation(250 + (430 - btnJogar.getWidth()) / 2, 550);

		aux = ImageTools.ReadImage(ImageTools.AJUDA, this);
		btnAjuda.setIcon(new ImageIcon(aux));
		btnAjuda.setSize(btnAjuda.getPreferredSize());
		btnAjuda.setLocation(680 + (430 - btnAjuda.getWidth()) / 2, 550);

		// /////////////////////////////////////////////////////////////////

		add(texto);
		add(setaDireita);
		add(setaEsquerda);
		add(btnJogar);
		add(btnAjuda);
		add(selecaoAtual);

		// ////////////////////////////////////////////////////////////////

		setaDirRect = setaDireita.getBounds();
		setaEsqRect = setaEsquerda.getBounds();
		btnJogarRect = btnJogar.getBounds();
		btnAjudaRect = btnAjuda.getBounds();
	}

	// responsavel por pintar imagens na tela
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, this);
	}
}
