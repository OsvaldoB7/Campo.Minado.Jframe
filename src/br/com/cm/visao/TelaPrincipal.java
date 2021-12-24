package br.com.cm.visao;

import javax.swing.JFrame;

import br.com.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame{
	
	public TelaPrincipal() {
	Tabuleiro tabuleiro = new Tabuleiro(10, 9, 5);
	
	add(new PainelTabuleiro(tabuleiro));
		
	setTitle("Campo Minado");
	setSize(490, 438);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
		
	}

}
