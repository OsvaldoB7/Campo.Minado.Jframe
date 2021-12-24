package br.com.cm.visao;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import br.com.cm.modelo.Campo;
import br.com.cm.modelo.CampoEvento;
import br.com.cm.modelo.CampoObservador;

@SuppressWarnings("serial")
public class botaoCampo extends JButton 
implements CampoObservador, MouseListener{
	
	private final Color BG_PADRAO = new Color(184, 184, 184);
	private final Color BG_MARCADO = new Color(8, 179, 247);
	private final Color BG_EXPLOSAO = new Color(189, 66, 68);
	private final Color TEXT_VERDE = new Color(0, 100, 0);
	
	private Campo campo;
	
	public botaoCampo(Campo campo) {
		this.campo = campo;
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		
		
		addMouseListener(this);
		campo.registrarObservador(this);
	} 
	@Override
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
	switch(evento) {
	case ABRIR:
		aplicarEstiloAbrir();
		break;
	case MARCAR:
		aplicarEstiloMarcar();
		break;
	case EXPLODIR:
		aplicarEstiloExplodir();
		break;
		default:
			aplicarEstiloPadrao();
	}
	SwingUtilities.invokeLater(() -> {
		repaint();
		validate();
	});
		
	}
	
	private void aplicarEstiloAbrir() {
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		if(campo.isMinado()) {
			setBackground(BG_EXPLOSAO);
			return;
		}
		setBackground(BG_PADRAO);
		
		switch (campo.minasNaVizinhanca()){
		case 1: 
			setForeground(TEXT_VERDE);
			break ;
			
		    case 2:
				setForeground(Color.BLUE);
		    break;
			
			case 3:
				setForeground(Color.YELLOW);
		    break;
			
			case 4:
			case 5:
			case 6:
				setForeground(Color.RED);
		    break;
		    
			default:
				setForeground(Color.PINK);
		}
		String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhanca() + "" : "";
		setText(valor);
	}
	
	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCADO);
		setForeground(Color.WHITE);
		setText("M");
		
		
		
		
		
	}
	
	private void aplicarEstiloExplodir() {
		setBackground(BG_EXPLOSAO);
		setForeground(Color.WHITE);
		setText("X");
		
		
	}
	private void aplicarEstiloPadrao() {
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		setText("");
		
		
	}
	
	
	// Interface dos eventos do Mouse
	
	
	
	public void mouseClicked(java.awt.event.MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		if (e.getButton() == 1) {
			campo.abrir();
		} else {
			campo.alternarMarcacao();
		}
	
		
	}
	
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
