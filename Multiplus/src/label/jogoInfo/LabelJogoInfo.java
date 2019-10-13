package label.jogoInfo;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import usefulTools.ImageTools;

@SuppressWarnings("serial")
public abstract class LabelJogoInfo extends JLabel {

	// /////////////////////////////////////////////////////////////
	// DECLARACAO DE VARIAVEIS

	protected int numAcertos, numErros;

	protected Image background;

	protected Font f;
	protected JLabel texto1, texto2, texto3, texto4;
	protected JLabel label1, label2, label3, label4;

	protected String texto;

	protected String string;
	protected int numero;

	// ////////////////////////////////////////////////////////////
	// INICIALIZACAO DO LABEL JOGOINFO

	protected void config(String diretorio) {
		setSize(340, 739);
		setLocation(1020, 0);

		background = ImageTools.ReadImage(diretorio, this);
		setIcon(new ImageIcon(background));
		numAcertos = 0;
		numErros = 0;

		configLabels();
		initComponentes();
	}

	// configura todas as JLabels (informacoes) do JOGOINFO
	protected void configLabels() {
		texto1 = new JLabel();
		label1 = new JLabel();
		texto2 = new JLabel();
		label2 = new JLabel();
		texto3 = new JLabel();
		label3 = new JLabel();
		texto4 = new JLabel();
		label4 = new JLabel();
		
		texto1.setText("Tempo:");
		label1.setText("45");
		
		texto3.setText("Número de acertos:");
		label3.setText("0");
		
		texto4.setText("Número de erros:");
		label4.setText("0");

		// //////////////////////////////////////////////////////////////

		f = new Font("impact", 0, 30);

		texto1.setFont(f);
		texto1.setBounds(40, 50, 345, 30);

		texto2.setFont(f);
		texto2.setBounds(40, 210, 345, 30);

		texto3.setFont(f);
		texto3.setBounds(40, 370, 345, 30);

		texto4.setFont(f);
		texto4.setBounds(40, 530, 345, 30);

		// ///////////////////////////////////////////////////////////////

		f = new Font("impact", Font.BOLD, 80);

		label1.setFont(f);
		label1.setBounds(122, 80, 345, 130);

		label2.setFont(f);
		label2.setBounds(122, 240, 345, 130);

		label3.setFont(f);
		label3.setBounds(122, 400, 345, 130);

		label4.setFont(f);
		label4.setBounds(122, 560, 345, 130);

		// ////////////////////////////////////////////////////////////////

		add(texto1);
		add(texto2);
		add(texto3);
		add(texto4);
		add(label1);
		add(label2);
		add(label3);
		add(label4);
	}

	// //////////////////////////////////////////////////////////////////////
	// METODOS POLIMORFICOS (ABSTRATOS)

	abstract protected void initComponentes();

	// /////////////////////////////////////////////////////////////////////
	// METODOS GET E/OU SET (PARA AS INFORMACOES)

	// setter para a informacao de label1 (tempo do jogo)
	public void setTempo(int num) {
		texto = Integer.toString(num);
		label1.setText(texto);
	}

	// setter e getter para a informacao de label2 (uma String)
	public void setString(String string) {
		this.string = string;

		label2.setText(string);
	}

	public String getLabel2String() {
		return string;
	}

	// setter e getter para a informacao de label2 (um int)
	public void setNumero(int numero) {
		this.numero = numero;

		texto = Integer.toString(numero);
		label2.setText(texto);
	}

	public int getNumero() {
		return numero;
	}

	// setter e getter para a informacao de label3 (numero de acertos)
	public int getNumAcertos() {
		return numAcertos;
	}

	public void addNumAcertos() {
		numAcertos++;

		texto = Integer.toString(this.numAcertos);
		label3.setText(texto);
	}

	// setter e getter para a informacao de label4 (numero de erros)
	public int getNumErros() {
		return numErros;
	}

	public void addNumErros() {
		numErros++;

		texto = Integer.toString(this.numErros);
		label4.setText(texto);
	}
}
