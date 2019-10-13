package panel.jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.Timer;

import usefulTools.ImageTools;
import label.jogoInfo.LabelJogoInfoMouse;
import label.numero.LabelNumeroMouse;
import label.personagem.LabelPersonagemMouse;

@SuppressWarnings("serial")
public class PainelJogoMouse extends PainelJogo implements MouseListener {

	// //////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private LabelPersonagemMouse mouse;
	private Font f;
	private JLabel lblExpressao;
	private ArrayList<LabelNumeroMouse> mouseNumeros;
	private int posResposta;

	private JLabel transicao;
	private Rectangle porta1, porta2, porta3;

	private ActionListener tempoLimite;
	private Timer tLimite;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO PAINELJOGOMOUSE

	public PainelJogoMouse() {
		config(ImageTools.JOGOMOUSE_BACKGROUND, 6);
		addMouseListener(this);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		mouse = new LabelPersonagemMouse();
		info = new LabelJogoInfoMouse();
		
		f = new Font("impact", Font.BOLD, 100);
		lblExpressao = new JLabel();
		lblExpressao.setFont(f);

		transicao = new JLabel();
		transicao.setSize(1020, altura);
		transicao.setLocation(0, 0);
		transicao.setForeground(Color.BLACK);

		porta1 = new Rectangle(23, 228, 226, 269);
		porta2 = new Rectangle(373, 228, 226, 269);
		porta3 = new Rectangle(709, 228, 226, 269);

		mouseNumeros = new ArrayList<LabelNumeroMouse>();
		posResposta = 0;
		
		add(mouse);
	}

	@Override
	protected void setActionsThreads() {
		tempoLimite = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tLimite.stop();

				info.addNumErros();

				addNovaWave();
			}
		};
	}

	@Override
	protected void initTimersThreads() {
		tLimite = new Timer(7000, tempoLimite);

		t.start();
		tLimite.start();
	}
	
	@Override
	protected void initMetodos() {
		addNovaWave();
	}
	
	@Override
	protected void stopTimers() {
		t.stop();
		tLimite.stop();
	}
	
	// ///////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO MOUSE

	@Override
	public void mouseClicked(MouseEvent e) {
		if (porta1.contains(e.getPoint())) {
			mouse.moverEsquerda();
			confereResposta(0);
		}
		if (porta2.contains(e.getPoint())) {
			mouse.moverCentro();
			confereResposta(1);
		}
		if (porta3.contains(e.getPoint())) {
			mouse.moverDireita();
			confereResposta(2);
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

	// //////////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO JOGO

	private void addNovaWave() {
		Random random = new Random();
		LabelNumeroMouse mouseNumRes, mouseNum1, mouseNum2;
		int resultado = gerarExpressao(random);
		int num1, num2;
		int pos1, pos2, pos3;

		removerWave();

		// adicionando o resultado
		pos1 = random.nextInt(3);
		mouseNumRes = new LabelNumeroMouse(resultado, pos1);
		mouseNumeros.add(mouseNumRes);
		posResposta = pos1;

		// adicionando numeros aleatorios
		do {
			num1 = random.nextInt(10) + resultado;
			num2 = -random.nextInt(10) + resultado;
		} while (num1 == resultado || num2 == resultado);
		do {
			pos2 = random.nextInt(3);
		} while (pos2 == pos1);
		do {
			pos3 = random.nextInt(3);
		} while (pos3 == pos1 || pos3 == pos2);

		mouseNum1 = new LabelNumeroMouse(num1, pos2);
		mouseNum2 = new LabelNumeroMouse(num2, pos3);

		mouseNumeros.add(mouseNum1);
		mouseNumeros.add(mouseNum2);

		adicionarWave();

		tLimite.restart();
	}

	private void removerWave() {
		remove(lblExpressao);
		for (int i = 0; i < mouseNumeros.size(); i++) {
			remove(mouseNumeros.get(i));
		}
		mouseNumeros.removeAll(mouseNumeros);

		validate();
		repaint();
	}

	private void adicionarWave() {
		add(lblExpressao);
		for (int i = 0; i < mouseNumeros.size(); i++) {
			add(mouseNumeros.get(i));
		}

		validate();
		repaint();
	}

	private int gerarExpressao(Random r) {
		String[] operacoes = { " + ", " - ", " * " };
		StringBuilder expressao = new StringBuilder();

		boolean p1, p2;
		int n1, n2, n3;
		int op1, op2;

		int res = 0;

		// determinando quais parenteses aparecerao
		// se p1 for verdadeiro, p2 eh falso; se nao, entao randomiza p2
		p2 = ((p1 = r.nextBoolean()) ? false : r.nextBoolean());

		// determinando quais os 3 numeros
		n1 = r.nextInt(10) + 1;
		n2 = r.nextInt(10) + 1;
		n3 = r.nextInt(10) + 1;

		// determinando as operacoes
		if (!p1 && !p2) {
			op1 = r.nextInt(3);
			op2 = r.nextInt(3);
		} else {
			op1 = (p2 ? 2 : r.nextInt(2));
			op2 = (p1 ? 2 : r.nextInt(2));
		}
		// montando a expressao
		// se tiver parenteses no primeiro
		if (p1) {
			switch (op1) {
			case 0:
				res = n1 + n2;
				break;
			case 1:
				res = n1 - n2;
				break;
			}

			res *= n3;
		}
		// se tiver parenteses no segundo
		if (p2) {
			switch (op2) {
			case 0:
				res = n2 + n3;
				break;
			case 1:
				res = n2 - n3;
				break;
			}

			res *= n1;
		}
		// se nao tiver parenteses
		if (!p1 && !p2) {
			int prioridadeOpcao = 0;

			if (op1 == 2 && op2 == 2) {
				res = n1 * n2 * n3;
			} else {
				if (op1 == 2) {
					prioridadeOpcao = 1;
					res = n1 * n2;
				}
				if (op2 == 2) {
					prioridadeOpcao = 2;
					res = n2 * n3;
				}

				// se tiver multiplicacao
				if (prioridadeOpcao != 0) {
					if (prioridadeOpcao == 1) {
						switch (op2) {
						case 0:
							res += n3;
							break;
						case 1:
							res -= n3;
							break;
						}
					} else {
						switch (op1) {
						case 0:
							res += n1;
							break;
						case 1:
							res = n1 - res;
							break;
						}
					}
				} else {
					switch (op1) {
					case 0:
						res = n1 + n2;
						break;
					case 1:
						res = n1 - n2;
						break;
					}

					switch (op2) {
					case 0:
						res += n3;
						break;
					case 1:
						res -= n3;
						break;
					}
				}
			}
		}

		// desenhando expressao na tela
		if (p1) {
			expressao.append("( ");
			expressao.append(n1);
			expressao.append(operacoes[op1]);
			expressao.append(n2);
			expressao.append(" )");
			expressao.append(operacoes[op2]);
			expressao.append(n3);
		}
		if (p2) {
			expressao.append(n1);
			expressao.append(operacoes[op1]);
			expressao.append("( ");
			expressao.append(n2);
			expressao.append(operacoes[op2]);
			expressao.append(n3);
			expressao.append(" )");
		}
		if (!p1 && !p2) {
			expressao.append(n1);
			expressao.append(operacoes[op1]);
			expressao.append(n2);
			expressao.append(operacoes[op2]);
			expressao.append(n3);
		}
		lblExpressao.setText(expressao.toString());
		lblExpressao.setSize(lblExpressao.getPreferredSize());
		lblExpressao.setLocation((largura - 345 - lblExpressao.getWidth()) / 2,
				0);

		return res;
	}

	private void confereResposta(int pos) {
		if (pos == posResposta)
			info.addNumAcertos();
		else
			info.addNumErros();

		addNovaWave();
	}
}
