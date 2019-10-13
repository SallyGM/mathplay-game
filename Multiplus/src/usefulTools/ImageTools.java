package usefulTools;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Essa classe e responsavel por juntar todos os metodos uteis que mexem de
 * alguma forma com imagens
 * 
 * @author JS_Company
 *
 */
public class ImageTools {

	// //////////////////////////////////////////////////////////////////////
	// DECLARACAO DE TODAS AS IMAGENS DO JOGO (EM DIRETORIO)

	// imagens principais
	public final static String MENU_BACKGROUND = "/images/backgrounds/MenuBackground.png";
	public final static String JOGOANGEL_BACKGROUND = "/images/backgrounds/JogoAngelBackground.png";
	public final static String JOGOBAT_BACKGROUND = "/images/backgrounds/JogoBatBackground.png";
	public final static String JOGOBEAR_BACKGROUND = "/images/backgrounds/JogoBearBackground.png";
	public final static String JOGOCAT_BACKGROUND = "/images/backgrounds/JogoCatBackground.png";
	public final static String JOGOCOTTONCANDY_BACKGROUND = "/images/backgrounds/JogoCottonCandyBackground.png";
	public final static String JOGODOG_BACKGROUND = "/images/backgrounds/JogoDogBackground.png";
	public final static String JOGOMOUSE_BACKGROUND = "/images/backgrounds/JogoMouseBackground.png";
	public final static String JOGOPANDA_BACKGROUND = "/images/backgrounds/JogoPandaBackground.png";
	public final static String JOGOPIG_BACKGROUND = "/images/backgrounds/JogoPigBackground.png";
	public final static String JOGOPIGRABBIT_BACKGROUND = "/images/backgrounds/JogoPigRabbitBackground.png";

	public final static String ICONE = "/images/auxiliares/menu/JanelaIcone.png";
	public final static String LOGO = "/images/auxiliares/menu/MenuLogo.png";
	public final static String JOGAR = "/images/auxiliares/menu/MenuJogar.png";
	public final static String AJUDA = "/images/auxiliares/menu/MenuAjuda.png";
	public final static String SAIR = "/images/auxiliares/menu/MenuSair.png";
	public final static String SETAESQUERDA = "/images/auxiliares/menu/SetaEsquerda.png";
	public final static String SETADIREITA = "/images/auxiliares/menu/SetaDireita.png";

	public final static String JIANGEL = "/images/jogoInfos/JogoInfoAngel.png";
	public final static String JIBAT = "/images/jogoInfos/JogoInfoBat.png";
	public final static String JIBEAR = "/images/jogoInfos/JogoInfoBear.png";
	public final static String JICAT = "/images/jogoInfos/JogoInfoCat.png";
	public final static String JICOTTONCANDY = "/images/jogoInfos/JogoInfoCottonCandy.png";
	public final static String JIDOG = "/images/jogoInfos/JogoInfoDog.png";
	public final static String JIMOUSE = "/images/jogoInfos/JogoInfoMouse.png";
	public final static String JIPANDA = "/images/jogoInfos/JogoInfoPanda.png";
	public final static String JIPIG = "/images/jogoInfos/JogoInfoPig.png";
	public final static String JIPIGRABBIT = "/images/jogoInfos/JogoInfoPigRabbit.png";

	public final static String AJUDAIMAGEMANGEL = "/images/ajudas/AjudaImagemAngel.png";
	public final static String AJUDAIMAGEMBAT = "/images/ajudas/AjudaImagemBat.png";
	public final static String AJUDAIMAGEMBEAR = "/images/ajudas/AjudaImagemBear.png";
	public final static String AJUDAIMAGEMCAT = "/images/ajudas/AjudaImagemCat.png";
	public final static String AJUDAIMAGEMCOTTONCANDY = "/images/ajudas/AjudaImagemCottonCandy.png";
	public final static String AJUDAIMAGEMDOG = "/images/ajudas/AjudaImagemDog.png";
	public final static String AJUDAIMAGEMMOUSE = "/images/ajudas/AjudaImagemMouse.png";
	public final static String AJUDAIMAGEMPANDA = "/images/ajudas/AjudaImagemPanda.png";
	public final static String AJUDAIMAGEMPIG = "/images/ajudas/AjudaImagemPig.png";
	public final static String AJUDAIMAGEMPIGRABBIT = "/images/ajudas/AjudaImagemPigRabbit.png";

	public final static String AJUDATEXTOANGEL = "/images/ajudas/AjudaTextoAngel.png";
	public final static String AJUDATEXTOBAT = "/images/ajudas/AjudaTextoBat.png";
	public final static String AJUDATEXTOBEAR = "/images/ajudas/AjudaTextoBear.png";
	public final static String AJUDATEXTOCAT = "/images/ajudas/AjudaTextoCat.png";
	public final static String AJUDATEXTOCOTTONCANDY = "/images/ajudas/AjudaTextoCottonCandy.png";
	public final static String AJUDATEXTODOG = "/images/ajudas/AjudaTextoDog.png";
	public final static String AJUDATEXTOMOUSE = "/images/ajudas/AjudaTextoMouse.png";
	public final static String AJUDATEXTOPANDA = "/images/ajudas/AjudaTextoPanda.png";
	public final static String AJUDATEXTOPIG = "/images/ajudas/AjudaTextoPig.png";
	public final static String AJUDATEXTOPIGRABBIT = "/images/ajudas/AjudaTextoPigRabbit.png";

	public final static String ANGEL = "/images/personagens/PersonagemAngel.png";
	public final static String BAT = "/images/personagens/PersonagemBat.png";
	public final static String BEAR = "/images/personagens/PersonagemBear.png";
	public final static String CAT = "/images/personagens/PersonagemCat.png";
	public final static String COTTONCANDY = "/images/personagens/PersonagemCottonCandy.png";
	public final static String DOG = "/images/personagens/PersonagemDog.png";
	public final static String MOUSE = "/images/personagens/PersonagemMouse.png";
	public final static String PANDA = "/images/personagens/PersonagemPanda.png";
	public final static String PIG = "/images/personagens/PersonagemPig.png";
	public final static String PIGRABBIT = "/images/personagens/PersonagemPigRabbit.png";
	public final static String RABBIT = "/images/personagens/PersonagemRabbit.png";

	// imagens secundarias (jogos especificos)
	public final static String SETAIMPAR = "/images/auxiliares/jogoBat/BatSetaImpar.png";
	public final static String SETAPAR = "/images/auxiliares/jogoBat/BatSetaPar.png";

	public final static String POTEMEL = "/images/auxiliares/jogoBear/BearMel.png";

	public final static String OSSO = "/images/auxiliares/jogoDog/DogOsso.png";

	public final static String MOEDA5 = "/images/auxiliares/jogoCottonCandy/CottonCandyMoeda5.png";
	public final static String MOEDA10 = "/images/auxiliares/jogoCottonCandy/CottonCandyMoeda10.png";
	public final static String MOEDA25 = "/images/auxiliares/jogoCottonCandy/CottonCandyMoeda25.png";
	public final static String MOEDA50 = "/images/auxiliares/jogoCottonCandy/CottonCandyMoeda50.png";
	public final static String MOEDA100 = "/images/auxiliares/jogoCottonCandy/CottonCandyMoeda100.png";
	public final static String CEDULA2 = "/images/auxiliares/jogoCottonCandy/CottonCandyCedula2.png";
	public final static String CEDULA5 = "/images/auxiliares/jogoCottonCandy/CottonCandyCedula5.png";
	public final static String CEDULA10 = "/images/auxiliares/jogoCottonCandy/CottonCandyCedula10.png";
	public final static String CEDULA20 = "/images/auxiliares/jogoCottonCandy/CottonCandyCedula20.png";
	public final static String CEDULA50 = "/images/auxiliares/jogoCottonCandy/CottonCandyCedula50.png";
	public final static String CEDULA100 = "/images/auxiliares/jogoCottonCandy/CottonCandyCedula100.png";

	public final static String GANGORRA = "/images/auxiliares/jogoPanda/PandaGangorra.png";
	
	public final static String MACA = "/images/auxiliares/jogoPig/PigMaca.png";
	public final static String PIGCESTA0 = "/images/auxiliares/jogoPig/PersonagemPigCesta0.png";
	public final static String PIGCESTA1 = "/images/auxiliares/jogoPig/PersonagemPigCesta1.png";
	public final static String PIGCESTA2 = "/images/auxiliares/jogoPig/PersonagemPigCesta2.png";
	public final static String PIGCESTA3 = "/images/auxiliares/jogoPig/PersonagemPigCesta3.png";
	public final static String PIGCESTA4 = "/images/auxiliares/jogoPig/PersonagemPigCesta4.png";
	public final static String PIGCESTA5 = "/images/auxiliares/jogoPig/PersonagemPigCesta5.png";
	public final static String PIGCESTA6 = "/images/auxiliares/jogoPig/PersonagemPigCesta6.png";

	public final static String NAVE = "/images/auxiliares/jogoPigrabbit/PigrabbitNave.png";
	public final static String TIRO = "/images/auxiliares/jogoPigrabbit/PigrabbitTiro.png";
	public final static String NAVEDIVISAO = "/images/auxiliares/jogoPigrabbit/PigrabbitDivisao.png";
	public final static String NAVEMULTIPLICACAO = "/images/auxiliares/jogoPigrabbit/PigrabbitMultiplicacao.png";
	public final static String NAVESOMA = "/images/auxiliares/jogoPigrabbit/PigrabbitSoma.png";
	public final static String NAVESUBTRACAO = "/images/auxiliares/jogoPigrabbit/PigrabbitSubtracao.png";
	public final static String BONUSPONTO = "/images/auxiliares/jogoPigrabbit/PigrabbitBonusPonto.png";
	public final static String BONUSTEMPO = "/images/auxiliares/jogoPigrabbit/PigrabbitBonusTempo.png";

	// //////////////////////////////////////////////////////////////////////
	// METODOS RESPONSAVEIS PELA MANIPULACAO DE IMAGENS
	/**
	 * Este metodo e responsavel por redimensionar uma imagem do tipo ImageIcon
	 * 
	 * @param img
	 *            = a ImageIcon a ser redimensionada
	 * @param largura
	 *            = a largura da nova dimensao
	 * @param altura
	 *            = a altura da nova dimensao
	 * @return A ImageIcon redimensionada
	 */
	public static ImageIcon resizeImgIcon(ImageIcon img, int largura, int altura) {
		Image newImg = img.getImage().getScaledInstance(largura, altura,
				Image.SCALE_SMOOTH);
		return new ImageIcon(newImg);
	}

	/**
	 * Este metodo e responsavel por ler uma imagem considerada icone do jogo
	 * (Apenas para JFrames)
	 * 
	 * @param dir
	 *            = o diretorio do icone
	 * @param janela
	 *            = o JFrame que será usado para obter a imagem
	 * @return Uma ImageIcon que possui o icone
	 */
	public static ImageIcon ReadIcon(String dir, JFrame janela) {
		URL diretorio;
		Image img = null;

		try {
			diretorio = janela.getClass().getResource(dir);
			img = ImageIO.read(diretorio);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		return new ImageIcon(img);
	}

	/**
	 * Este metodo e responsavel por ler uma imagem do jogo
	 * 
	 * @param dir
	 *            = o diretorio da imagem
	 * @param comp
	 *            = o JComponent que será usado para obter a imagem
	 * @return Uma Image que possui a imagem
	 */
	public static Image ReadImage(String dir, JComponent comp) {
		URL diretorio;
		Image img = null;

		try {
			diretorio = comp.getClass().getResource(dir);
			img = ImageIO.read(diretorio);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		return img;
	}

	/**
	 * Este metodo e responsavel por ler uma sprite do jogo
	 * 
	 * @param dir
	 *            = o diretorio da imagem
	 * @param cenas
	 *            = o numero de cenas do sprite
	 * @param comp
	 *            = o JComponent que será usado para obter a imagem
	 * @return Um ArrayList<ImageIcon> que possui as cenas do sprite
	 */
	public static ArrayList<ImageIcon> ReadSprite(String dir, int cenas,
			JComponent comp) {
		URL diretorio;
		Image img = null;
		BufferedImage bImg;

		ArrayList<ImageIcon> sprite = new ArrayList<>();
		int largura, altura;

		try {
			diretorio = comp.getClass().getResource(dir);
			img = ImageIO.read(diretorio);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		bImg = (BufferedImage) img;
		largura = bImg.getWidth() / cenas;
		altura = bImg.getHeight();

		for (int i = 0; i < cenas; i++) {
			sprite.add(new ImageIcon(bImg.getSubimage(i * largura, 0, largura,
					altura)));
		}

		return sprite;
	}
}
