package all;

import java.awt.Color;

public class Function_Theme {

	GUI gui;
	Color neonGreen = new Color(57 ,255, 20);
	Color brokenTube = new Color(6 ,3, 16);
	Color royalBlue = new Color(65 ,105, 225);
	
	public Function_Theme(GUI gui) {
		this.gui = gui;
	}
	
	public void setTheme(String theme) {
		
		switch(theme) {
		case "Light": 
			gui.window.getContentPane().setBackground(Color.WHITE);
			gui.textArea.setBackground(Color.WHITE);
			gui.textArea.setForeground(Color.BLACK);
			break;
		case "Dark":
			gui.window.getContentPane().setBackground(Color.BLACK);
			gui.textArea.setBackground(Color.BLACK);
			gui.textArea.setForeground(Color.WHITE);
			break;
		case "High Contrast":
			gui.window.getContentPane().setBackground(Color.BLACK);
			gui.textArea.setBackground(Color.BLACK);
			gui.textArea.setForeground(neonGreen);
			break;
		case "Abyss":
			gui.window.getContentPane().setBackground(brokenTube);
			gui.textArea.setBackground(brokenTube);
			gui.textArea.setForeground(royalBlue);
			break;
		}
	}
		
		
	
}
