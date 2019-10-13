package label.selecao;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public abstract class LabelSelecao extends JLabel {

	// ////////////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	protected JLabel jLblPersonagemImage;
	protected JLabel jLblPersonagemNome;
	protected JLabel jLblCategoriaJogo;
	protected JLabel jLblDificuldade;
	protected int codigo;

	// /////////////////////////////////////////////////////////////////////
	// INICIALIZACAO DE UMA LABEL SELECAO

	protected void config() {
		initializeLabels();
		setInfoIndividual();
		setLabelFonts();
		setLabelSizes();
		setLabelLocations();
		addLabels();
	}

	// /////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (ABSTRATOS)

	abstract protected void setInfoIndividual();

	// ////////////////////////////////////////////////////////////////////
	// METODOS AUXILIARES

	// metodo responsavel por inicializar as JLabels
	protected void initializeLabels() {
		setSize(870, 300);
		setLocation(250, 220);

		jLblPersonagemImage = new JLabel();
		jLblPersonagemNome = new JLabel();
		jLblCategoriaJogo = new JLabel();
		jLblDificuldade = new JLabel();
	}

	// metodo responsavel por colocar a fonte nas JLabels
	protected void setLabelFonts() {
		Font f = new Font("impact", Font.BOLD, 35);

		jLblPersonagemImage.setFont(f);
		jLblPersonagemNome.setFont(f);
		jLblCategoriaJogo.setFont(f);
		jLblDificuldade.setFont(f);
	}

	// metodo responsavel por
	protected void setLabelSizes() {
		jLblPersonagemImage.setSize(jLblPersonagemImage.getPreferredSize());
		jLblPersonagemNome.setSize(jLblPersonagemNome.getPreferredSize());
		jLblCategoriaJogo.setSize(jLblCategoriaJogo.getPreferredSize());
		jLblDificuldade.setSize(jLblDificuldade.getPreferredSize());
	}

	protected void setLabelLocations() {
		jLblPersonagemImage.setLocation(
				(430 - jLblPersonagemImage.getWidth()) / 2,
				(300 - jLblPersonagemImage.getHeight()) / 2);
		jLblPersonagemNome.setLocation(430, 30);
		jLblCategoriaJogo.setLocation(430, 130);
		jLblDificuldade.setLocation(430, 230);
	}

	protected void addLabels() {
		add(jLblPersonagemImage);
		add(jLblPersonagemNome);
		add(jLblCategoriaJogo);
		add(jLblDificuldade);
	}

	public int getCodigo() {
		return (codigo);
	}
}
