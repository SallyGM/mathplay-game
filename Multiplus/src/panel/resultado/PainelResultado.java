package panel.resultado;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import usefulTools.FrameTools;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public abstract class PainelResultado extends JPanel implements MouseListener {

	// /////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	protected int altura, largura;
	protected Image background;

	protected int acertos, erros;
	protected Font f;
	protected String textoFeliz, textoTriste;
	protected JLabel txtAcertos, txtErros, txtResultado, txtInfo, txtTerminar;
	protected JLabel lblAcertos, lblErros, lblResultado;

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DE UM PAINEL RESULTADO

	protected void config(String diretorio) {
		largura = 1360;
		altura = 739;

		setLayout(null);
		setBounds(0, 0, largura, altura);

		addMouseListener(this);

		background = ImageTools.ReadImage(diretorio, this);
	}

	// /////////////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO MOUSE

	@Override
	public void mouseClicked(MouseEvent e) {
		removeAll();
		FrameTools.mudarPainel(FrameTools.JANELA, FrameTools.MENU);
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

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (ABSTRATOS)
	
	abstract public void setResultado(int acertos, int erros);

	abstract protected Double calcularResultado();

	// /////////////////////////////////////////////////////////////////////
	// METODOS AUXILIARES
	
	protected void initializeLabels() {
		txtAcertos = new JLabel("Acertos: ");
		txtErros = new JLabel("Erros: ");
		lblAcertos = new JLabel(Integer.toString(acertos));
		lblErros = new JLabel(Integer.toString(erros));

		txtResultado = new JLabel();
		lblResultado = new JLabel();
		txtInfo = new JLabel();

		txtTerminar = new JLabel("Clique para voltar ao menu...");

		textoFeliz = "Parabéns!";
		textoTriste = "Talvez da próxima vez...";
	}

	protected void configLabels() {
		f = new Font("impact", 0, 45);
		txtAcertos.setFont(f);
		txtAcertos.setSize(txtAcertos.getPreferredSize());

		txtErros.setFont(f);
		txtErros.setSize(txtErros.getPreferredSize());

		lblAcertos.setFont(f);
		lblAcertos.setSize(lblAcertos.getPreferredSize());

		lblErros.setFont(f);
		lblErros.setSize(lblErros.getPreferredSize());

		txtAcertos.setLocation(
				largura / 2 - txtAcertos.getWidth() - lblAcertos.getWidth()
						- 20, 75);
		txtErros.setLocation(largura / 2 + 20, 75);
		lblAcertos.setLocation(largura / 2 - lblAcertos.getWidth() - 20, 75);
		lblErros.setLocation(largura / 2 + 20 + txtErros.getWidth(), 75);

		f = new Font("impact", Font.BOLD, 50);

		txtResultado.setFont(f);
		txtResultado.setSize(txtResultado.getPreferredSize());
		txtResultado
				.setLocation(largura / 2 - txtResultado.getWidth() / 2, 200);

		lblResultado.setFont(f);
		lblResultado.setSize(lblResultado.getPreferredSize());
		lblResultado
				.setLocation(largura / 2 - lblResultado.getWidth() / 2, 300);

		f = new Font("impact", Font.BOLD, 80);

		txtInfo.setFont(f);
		txtInfo.setSize(txtInfo.getPreferredSize());
		txtInfo.setLocation(largura / 2 - txtInfo.getWidth() / 2, 400);

		f = new Font("impact", 0, 30);

		txtTerminar.setFont(f);
		txtTerminar.setSize(txtTerminar.getPreferredSize());
		txtTerminar.setLocation(largura / 2 - txtTerminar.getWidth() / 2, 600);

		add(txtAcertos);
		add(txtErros);
		add(lblAcertos);
		add(lblErros);
		add(txtResultado);
		add(lblResultado);
		add(txtInfo);
		add(txtTerminar);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(255, 255, 255, 127));
		g.drawImage(background, 0, 0, this);
		g.fillRect(0, 0, 1360, 739);
	}
}
