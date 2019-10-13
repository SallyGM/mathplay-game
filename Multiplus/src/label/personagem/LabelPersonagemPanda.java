package label.personagem;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class LabelPersonagemPanda extends LabelPersonagem implements
		MouseMotionListener {

	// ///////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private JLabel lblValor;
	private int valor;
	
	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL PANDA

	public LabelPersonagemPanda(int posicao) {		
		setSprite(ImageTools.PANDA, 2);
		setSize(120, 250);

		int espacoX = 170 * posicao;
		setLocation(espacoX + (170 - getWidth()) / 2, 739 - getHeight());
		
		addMouseMotionListener(this);
	}

	// ///////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO TECLADO

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getXOnScreen() - getWidth() / 2;
		int y = e.getYOnScreen() - getHeight() / 2;

		if (e.getXOnScreen() < getWidth() / 2)
			x = 0;
		if (e.getXOnScreen() > 1020 - getWidth() / 2)
			x = 1020 - getWidth();

		if (e.getYOnScreen() < getHeight() / 2)
			y = 0;
		if (e.getYOnScreen() > 739 - getHeight() / 2)
			y = 739 - getHeight();

		setLocation(x, y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	// ///////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
		
		lblValor = new JLabel();
		Font f = new Font("impact", Font.BOLD, 50);
		
		lblValor.setFont(f);
		lblValor.setText(Integer.toString(valor));
		lblValor.setSize(lblValor.getPreferredSize());
		lblValor.setLocation((getWidth() - lblValor.getWidth()) / 2,
				getHeight() - lblValor.getHeight());
		add(lblValor);
	}
}
