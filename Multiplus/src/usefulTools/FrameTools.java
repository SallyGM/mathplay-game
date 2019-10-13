package usefulTools;

import javax.swing.JFrame;
import javax.swing.JPanel;

import frame.FrameJanela;
import panel.*;
import panel.ajuda.*;
import panel.jogo.*;
import panel.resultado.*;
import programa.MainMathPlay;

/**
 * Esta classe e responsavel por agrupar metodos que dizem respeito a
 * manipulacao de JFrames
 * 
 * @author JS_Company
 *
 */
public class FrameTools {

	// //////////////////////////////////////////////////////////////////////
	// DECLARACAO DE TODOS OS PAINEIS DO JOGO
	public final static FrameJanela JANELA = MainMathPlay.getJanela();

	public final static PainelMenu MENU = new PainelMenu();
	public final static PainelSelecao SELECAO = new PainelSelecao();

	public final static PainelAjudaAngel AJUDAANGEL = new PainelAjudaAngel();
	public final static PainelAjudaBat AJUDABAT = new PainelAjudaBat();
	public final static PainelAjudaBear AJUDABEAR = new PainelAjudaBear();
	public final static PainelAjudaCat AJUDACAT = new PainelAjudaCat();
	public final static PainelAjudaCottonCandy AJUDACOTTONCANDY = new PainelAjudaCottonCandy();
	public final static PainelAjudaDog AJUDADOG = new PainelAjudaDog();
	public final static PainelAjudaMouse AJUDAMOUSE = new PainelAjudaMouse();
	public final static PainelAjudaPanda AJUDAPANDA = new PainelAjudaPanda();
	public final static PainelAjudaPig AJUDAPIG = new PainelAjudaPig();
	public final static PainelAjudaPigrabbit AJUDAPIGRABBIT = new PainelAjudaPigrabbit();

	public final static PainelJogoAngel JOGOANGEL = new PainelJogoAngel();
	public final static PainelJogoBat JOGOBAT = new PainelJogoBat();
	public final static PainelJogoBear JOGOBEAR = new PainelJogoBear();
	public final static PainelJogoCat JOGOCAT = new PainelJogoCat();
	public final static PainelJogoCottonCandy JOGOCOTTONCANDY = new PainelJogoCottonCandy();
	public final static PainelJogoDog JOGODOG = new PainelJogoDog();
	public final static PainelJogoMouse JOGOMOUSE = new PainelJogoMouse();
	public final static PainelJogoPanda JOGOPANDA = new PainelJogoPanda();
	public final static PainelJogoPig JOGOPIG = new PainelJogoPig();
	public final static PainelJogoPigrabbit JOGOPIGRABBIT = new PainelJogoPigrabbit();

	public final static PainelResultadoAngel RESULTADOANGEL = new PainelResultadoAngel();
	public final static PainelResultadoBat RESULTADOBAT = new PainelResultadoBat();
	public final static PainelResultadoBear RESULTADOBEAR = new PainelResultadoBear();
	public final static PainelResultadoCat RESULTADOCAT = new PainelResultadoCat();
	public final static PainelResultadoCottonCandy RESULTADOCOTTONCANDY = new PainelResultadoCottonCandy();
	public final static PainelResultadoDog RESULTADODOG = new PainelResultadoDog();
	public final static PainelResultadoMouse RESULTADOMOUSE = new PainelResultadoMouse();
	public final static PainelResultadoPanda RESULTADOPANDA = new PainelResultadoPanda();
	public final static PainelResultadoPig RESULTADOPIG = new PainelResultadoPig();
	public final static PainelResultadoPigrabbit RESULTADOPIGRABBIT = new PainelResultadoPigrabbit();

	// //////////////////////////////////////////////////////////////////////

	/**
	 * Este metodo eh responsavel por trocar o painel da janela JFrame
	 * 
	 * @param janela
	 *            = o JFrame que trocara o painel
	 * @param painel
	 *            = o novo painel a ser colocado no JFrame
	 */
	public static void mudarPainel(JFrame janela, JPanel painel) {
		janela.setContentPane(painel);
	}
}
