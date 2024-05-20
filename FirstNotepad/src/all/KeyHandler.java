package all;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	GUI gui;
	
	public KeyHandler(GUI gui) {
		
		this.gui = gui;
		
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) { // KEYBOARD SHORTCUT FOR SAVE: CRTL + S
			gui.file.saveAs();
		} else if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) { // KEYBOARD SHORTCUT FOR SAVE AS: SHIFT + CRTL + S
			gui.file.save();
		} else if (e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z) { // KEYBOARD SHORTCUT FOR UNDO: CRTL + Z
			gui.edit.redo();
		} else if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z) { // KEYBOARD SHORTCUT FOR UNDO: CRTL + Y
			gui.edit.undo();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
