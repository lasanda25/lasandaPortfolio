package all;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener{

	JFrame window;
	
	// TEXT AREA
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	
	// MENU BAR
	JMenuBar menuBar;
	JMenu fileMenu, editMenu, formatMenu, themeMenu;
	
	// FILE MENU
	JMenuItem newMenuItem, openMenuItem, saveMenuItem, saveAsMenuItem, exitMenuItem;
	
	// EDIT MENU
	JMenuItem undoMenuItem, redoMenuItem;
	
	// FORMAT MENU
	JMenuItem wordWrapMenuItem, arialFont, comicSansMSFont, timesNewRomanFont, fontSize8, fontSize12, fontSize16, fontSize20, fontSize24, fontSize28;
	JMenu fontMenu, fontSizeMenu;
	
	// THEME MENU
	JMenuItem lightTheme, darkTheme, highContrastTheme, abyssTheme;
	
	Function_File file = new Function_File(this);
	Function_Format format = new Function_Format(this);
	Function_Theme theme = new Function_Theme(this);
	Function_Edit edit = new Function_Edit(this);
	
	UndoManager um = new UndoManager();
	
	KeyHandler kh = new KeyHandler(this);

	
	public static void main(String[] args) {
		new GUI();
		

	}
	
	public GUI() {
		
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createThemeMenu();
		format.setFont("Arial");
		format.setFontSize(16);
		format.wordWrap();
		theme.setTheme("Light");
		window.setVisible(true);
		
	}
	
	public void createWindow() {
		
		window = new JFrame("Notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void createTextArea() {
		
		textArea = new JTextArea();
		textArea.addKeyListener(kh);
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				}
			);
		
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		window.add(scrollPane);
	}
	
	public void createMenuBar() {
		
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		formatMenu = new JMenu("Format");
		themeMenu = new JMenu("Theme");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(formatMenu);
		menuBar.add(themeMenu);
	}
	
	public void createFileMenu() {
		
		newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(this);
		newMenuItem.setActionCommand("New");
		fileMenu.add(newMenuItem);
		
		openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener(this);
		openMenuItem.setActionCommand("Open");
		fileMenu.add(openMenuItem);

		
		saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(this);
		saveMenuItem.setActionCommand("Save");
		fileMenu.add(saveMenuItem);

		saveAsMenuItem = new JMenuItem("Save As");
		saveAsMenuItem.addActionListener(this);
		saveAsMenuItem.setActionCommand("SaveAs");
		fileMenu.add(saveAsMenuItem);

		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(this);
		exitMenuItem.setActionCommand("Exit");
		fileMenu.add(exitMenuItem);

	}
	
	public void createEditMenu() {
		undoMenuItem = new JMenuItem("Undo");
		undoMenuItem.addActionListener(this);
		undoMenuItem.setActionCommand("Undo");
		editMenu.add(undoMenuItem);
		
		redoMenuItem = new JMenuItem("Redo");
		redoMenuItem.addActionListener(this);
		redoMenuItem.setActionCommand("Redo");
		editMenu.add(redoMenuItem);


	}
	
	public void createFormatMenu() {
		wordWrapMenuItem = new JMenuItem("Word Wrap: Off");
		wordWrapMenuItem.addActionListener(this);
		wordWrapMenuItem.setActionCommand("WordWrap");
		formatMenu.add(wordWrapMenuItem);
		
		fontMenu = new JMenu("Font");
		formatMenu.add(fontMenu);
		
		arialFont = new JMenuItem("Arial");
		arialFont.addActionListener(this);
		arialFont.setActionCommand("Arial");
		fontMenu.add(arialFont);
		
		comicSansMSFont = new JMenuItem("Comic Sans MS");
		comicSansMSFont.addActionListener(this);
		comicSansMSFont.setActionCommand("Comic Sans MS");
		fontMenu.add(comicSansMSFont);
		
		timesNewRomanFont = new JMenuItem("Times New Roman");
		timesNewRomanFont.addActionListener(this);
		timesNewRomanFont.setActionCommand("Times New Roman");
		fontMenu.add(timesNewRomanFont);
		
		fontSizeMenu = new JMenu("Font Size");
		formatMenu.add(fontSizeMenu);
		
		fontSize8 = new JMenuItem("8");
		fontSize8.addActionListener(this);
		fontSize8.setActionCommand("Size8");
		fontSizeMenu.add(fontSize8);
		
		fontSize12 = new JMenuItem("12");
		fontSize12.addActionListener(this);
		fontSize12.setActionCommand("Size12");
		fontSizeMenu.add(fontSize12);
		
		fontSize16 = new JMenuItem("16");
		fontSize16.addActionListener(this);
		fontSize16.setActionCommand("Size16");
		fontSizeMenu.add(fontSize16);
		
		fontSize20 = new JMenuItem("20");
		fontSize20.addActionListener(this);
		fontSize20.setActionCommand("Size20");
		fontSizeMenu.add(fontSize20);
		
		fontSize24 = new JMenuItem("24");
		fontSize24.addActionListener(this);
		fontSize24.setActionCommand("Size24");
		fontSizeMenu.add(fontSize24);
		
		fontSize28 = new JMenuItem("28");
		fontSize28.addActionListener(this);
		fontSize28.setActionCommand("Size28");
		fontSizeMenu.add(fontSize28);
		
	}
	
	public void createThemeMenu() {
		lightTheme = new JMenuItem("Light");
		lightTheme.addActionListener(this);
		lightTheme.setActionCommand("Light");
		themeMenu.add(lightTheme);
		
		darkTheme = new JMenuItem("Dark");
		darkTheme.addActionListener(this);
		darkTheme.setActionCommand("Dark");
		themeMenu.add(darkTheme);
		
		highContrastTheme = new JMenuItem("High Contrast");
		highContrastTheme.addActionListener(this);
		highContrastTheme.setActionCommand("High Contrast");
		themeMenu.add(highContrastTheme);
		
		abyssTheme = new JMenuItem("Abyss");
		abyssTheme.addActionListener(this);
		abyssTheme.setActionCommand("Abyss");
		themeMenu.add(abyssTheme);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch(command) {
		case "New": file.newFile(); break;
		case "Open": file.open(); break;
		case "SaveAs": file.saveAs(); break;
		case "Save": file.save(); break;
		case "Exit": file.exit(); break;
		case "Undo": edit.undo(); break;
		case "Redo": edit.redo(); break;
		case "WordWrap": format.wordWrap(); break;
		case "Arial": format.setFont(command); break;
		case "Comic Sans MS": format.setFont(command); break;
		case "Times New Roman": format.setFont(command); break;
		case "Size8": format.setFontSize(8); break;
		case "Size12": format.setFontSize(12); break;
		case "Size16": format.setFontSize(16); break;
		case "Size20": format.setFontSize(20); break;
		case "Size24": format.setFontSize(24); break;
		case "Size28": format.setFontSize(28); break;
		case "Light": theme.setTheme(command); break;
		case "Dark": theme.setTheme(command); break;
		case "High Contrast": theme.setTheme(command); break;
		case "Abyss": theme.setTheme(command); break;


		}
		
	}

}
