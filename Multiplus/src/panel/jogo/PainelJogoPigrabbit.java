package panel.jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import label.jogoInfo.LabelJogoInfoPigrabbit;
import label.jogoPigrabbit.LabelBonus;
import label.jogoPigrabbit.LabelNave;
import label.jogoPigrabbit.LabelTiro;
import label.personagem.LabelPersonagemPigrabbit;
import usefulTools.ImageTools;

@SuppressWarnings("serial")
public class PainelJogoPigrabbit extends PainelJogo {

	// ///////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	private LabelPersonagemPigrabbit pigrabbit;
	private ArrayList<LabelNave> naves;
	private ArrayList<LabelTiro> tiros;
	private ArrayList<LabelBonus> bonuses;
	private JLabel expressao;

	private int codigoResultado;

	private ActionListener tempoLimite, tempoAdd, tempoTiro;
	private Action inTiro, outTiro;
	private Timer tLimite, tAdd, tTiro;
	private Thread colisaoTiro, colisaoLimites, colisaoNave;

	// ///////////////////////////////////////////////////////////////
	// INICIALIZACAO DO PAINEL JOGOPIGRABBIT

	public PainelJogoPigrabbit() {
		config(ImageTools.JOGOPIGRABBIT_BACKGROUND, 9);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (CONCRETOS)

	@Override
	protected void configLabels() {
		info = new LabelJogoInfoPigrabbit();
		pigrabbit = new LabelPersonagemPigrabbit();
		tiros = new ArrayList<>();
		naves = new ArrayList<>();
		bonuses = new ArrayList<>();
		expressao = new JLabel();

		Font f = new Font("impact", Font.BOLD, 100);
		expressao.setFont(f);
		expressao.setForeground(Color.WHITE);

		add(pigrabbit);
		add(expressao);
	}

	@Override
	protected void setActionsThreads() {
		tempoLimite = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setNovaExpressao();
			}
		};
		tempoAdd = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				int categoria = r.nextInt(5);

				if (categoria != 0) {
					LabelNave n = new LabelNave();
					naves.add(n);
					add(n);
				} else {
					LabelBonus b = new LabelBonus();
					bonuses.add(b);
					add(b);
				}
			}
		};
		tempoTiro = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				LabelTiro t = new LabelTiro(pigrabbit.getX() + 25,
						pigrabbit.getY());
				tiros.add(t);
				add(t);
			}
		};

		inTiro = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setTiro(true);
			}
		};
		outTiro = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setTiro(false);
			}
		};

		colisaoTiro = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					for (int i = 0; i < tiros.size(); i++) {
						LabelTiro t = tiros.get(i);
						Rectangle tRectangle = t.getBounds();

						for (int j = 0; j < naves.size(); j++) {
							LabelNave n = naves.get(j);
							Rectangle nRectangle = n.getBounds();

							if (tRectangle.intersects(nRectangle)) {
								if (codigoResultado == n.getCodigo())
									info.addNumErros();
								else
									info.addNumAcertos();

								removerComponente(n);
								removerComponente(t);
								naves.remove(n);
								tiros.remove(t);
							}
						}
						for (int j = 0; j < bonuses.size(); j++) {
							LabelBonus b = bonuses.get(j);
							Rectangle bRectangle = b.getBounds();

							if (tRectangle.intersects(bRectangle)) {								
								removerComponente(b);
								removerComponente(t);
								bonuses.remove(b);
								tiros.remove(t);
							}
						}
					}

					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		colisaoLimites = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					for (int i = 0; i < tiros.size(); i++) {
						LabelTiro t = tiros.get(i);

						if (t.getY() <= 150) {
							removerComponente(t);
							tiros.remove(t);
						}
					}

					for (int i = 0; i < naves.size(); i++) {
						LabelNave n = naves.get(i);

						if (n.getY() >= 739 - n.getHeight()) {
							if (codigoResultado == n.getCodigo())
								info.addNumAcertos();
							else
								info.addNumErros();

							removerComponente(n);
							naves.remove(n);
						}
					}
					for (int i = 0; i < bonuses.size(); i++) {
						LabelBonus b = bonuses.get(i);

						if (b.getY() >= 739 - b.getHeight()) {		
							removerComponente(b);
							bonuses.remove(b);
						}
					}

					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		colisaoNave = new Thread() {

			@Override
			public void run() {
				while (!fimJogo) {
					Rectangle prRectangle = pigrabbit.getBounds();

					for (int i = 0; i < naves.size(); i++) {
						LabelNave n = naves.get(i);
						Rectangle nRectangle = n.getBounds();

						if (prRectangle.intersects(nRectangle)) {
							if (codigoResultado == n.getCodigo())
								info.addNumAcertos();
							else
								info.addNumErros();

							removerComponente(n);
							naves.remove(n);
						}
					}
					for (int i = 0; i < bonuses.size(); i++) {
						LabelBonus b = bonuses.get(i);
						Rectangle bRectangle = b.getBounds();

						if (prRectangle.intersects(bRectangle)) {	
							if (b.getCodigo() == 0)
								info.addNumAcertos();
							else
								counter += 5;
							
							removerComponente(b);
							bonuses.remove(b);
						}
					}

					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

	@Override
	protected void initTimersThreads() {
		tAdd = new Timer(1000, tempoAdd);
		tLimite = new Timer(10000, tempoLimite);
		tTiro = new Timer(300, tempoTiro);

		tAdd.setInitialDelay(0);
		tTiro.setInitialDelay(0);

		t.start();
		tAdd.start();
		tLimite.start();
		colisaoLimites.start();
		colisaoTiro.start();
		colisaoNave.start();
	}

	@Override
	protected void initMetodos() {
		setNovaExpressao();
		setKeyBindings();
	}

	@Override
	protected void stopTimers() {
		t.stop();
		tAdd.stop();
	}

	// ///////////////////////////////////////////////////////////////
	// CONFIGURANDO ENTRADAS DO TECLADO

	private void setKeyBindings() {
		InputMap inMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actMap = this.getActionMap();

		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false),
				"PressedSpace");
		inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true),
				"ReleasedSpace");

		actMap.put("PressedSpace", inTiro);
		actMap.put("ReleasedSpace", outTiro);
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS PROPRIOS DO JOGO

	private void setNovaExpressao() {
		gerarExpressao();

		validate();
		repaint();
	}

	// ///////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	private void gerarExpressao() {
		Random r = new Random();

		int codigo = r.nextInt(4);

		int num1 = 0;
		int num2 = 0;
		int resultado = 0;

		// ////////////////////////////////////////

		switch (codigo) {
		case 0:
			num1 = r.nextInt(10) + 1;
			num2 = r.nextInt(10) + 1;
			resultado = num1 + num2;
			break;
		case 1:
			num1 = r.nextInt(10) + 1;
			num2 = r.nextInt(10) + 1;
			resultado = num1 - num2;
			break;
		case 2:
			num1 = r.nextInt(10) + 1;
			num2 = r.nextInt(10) + 1;
			resultado = num1 * num2;
			break;
		case 3:
			num2 = r.nextInt(10) + 1;
			num1 = num2 * (r.nextInt(5) + 1);
			resultado = num1 / num2;
			break;
		}

		expressao.setText(num1 + " ? " + num2 + " = " + resultado);
		expressao.setSize(expressao.getPreferredSize());
		expressao.setLocation((1020 - expressao.getWidth()) / 2, 0);

		codigoResultado = codigo;
	}

	private void setTiro(boolean tiro) {
		if (tiro)
			tTiro.start();
		else
			tTiro.stop();
	}

}
