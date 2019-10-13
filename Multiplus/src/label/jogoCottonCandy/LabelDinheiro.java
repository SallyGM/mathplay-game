package label.jogoCottonCandy;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelDinheiro extends JLabel implements MouseMotionListener {

	// //////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	public double valor;

	// //////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL DINHEIRO

	protected void config(Point localizacao, double valor) {
		setLocation(localizacao);
		setSize(getPreferredSize());

		this.valor = valor;
		addMouseMotionListener(this);
	}

	// /////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO MOUSE

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

	// //////////////////////////////////////////////////////////
	// METODOS GET E/OU SET
	
	public double getValor() {
		return valor;
	}
}
