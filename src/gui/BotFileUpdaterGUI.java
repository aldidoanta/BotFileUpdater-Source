package gui;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import core.BuildReader;
import core.BuildSaver;
import core.FileUpdater;

public class BotFileUpdaterGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = -1617833812852810630L;
	JButton loadOldFile;
	JButton createNewFile;
	JTextArea debug, botEditor;
	JCheckBox useOldBuild;
	JButton saveBuild;
	JLabel label;
	JFileChooser fc;
	String oldFilePath, newFilePath, saveFilePath;
	
	public BotFileUpdaterGUI(){
		getContentPane().setLayout(null);
	    setupGUI();
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void setupGUI(){
		loadOldFile = new JButton();
		loadOldFile.setLocation(57,39);
		loadOldFile.setSize(200,50);
		loadOldFile.setText("Load old file");
		loadOldFile.addActionListener(this);
		getContentPane().add(loadOldFile);

		createNewFile = new JButton();
		createNewFile.setLocation(63,528);
		createNewFile.setSize(200,50);
		createNewFile.setText("Create new file ");
		createNewFile.addActionListener(this);
		getContentPane().add(createNewFile);

		botEditor = new JTextArea();
		botEditor.setLocation(323,16);
		botEditor.setSize(635,593);
		botEditor.setEditable(false);
		botEditor.setText("");
		botEditor.setRows(5);
		botEditor.setColumns(5);
		getContentPane().add(botEditor);
		
		debug = new JTextArea();
		debug.setLocation(63, 620);
		debug.setSize(400,20);
		debug.setEditable(false);
		debug.setText("");
		getContentPane().add(debug);
		
		useOldBuild = new JCheckBox();
		useOldBuild.setLocation(56,94);
		useOldBuild.setSize(154,58);
		useOldBuild.setText("use saved hero builds");
		useOldBuild.setSelected(true);
		useOldBuild.addActionListener(this);
		getContentPane().add(useOldBuild);

		saveBuild = new JButton();
		saveBuild.setLocation(63,306);
		saveBuild.setSize(100,50);
		saveBuild.setText("Save");
		saveBuild.addActionListener(this);
		getContentPane().add(saveBuild);

		label = new JLabel();
		label.setLocation(62,270);
		label.setSize(247,25);
		label.setText("Save currently loaded build: ");
		getContentPane().add(label);
		
		fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File file) {
				return file.getName().endsWith(".txt") || file.isDirectory();
			}

			@Override
			public String getDescription() {
				return ".txt";
			}

		});

		setTitle("BotFile Tool");
		setSize(1000,800);
		setVisible(true);
		setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loadOldFile) {
			this.loadOldFile();
		}
		if (e.getSource() == createNewFile) {
			this.createNewFile();
		}
		if (e.getSource() == saveBuild) {
			this.saveBuild();
		}
	}  
	
	private void loadOldFile(){
		fc.setCurrentDirectory(new File("C:\\Program Files (x86)\\Steam\\SteamApps\\common\\dota 2 beta\\dota\\scripts\\npc"));
		int returnVal = fc.showOpenDialog(BotFileUpdaterGUI.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			oldFilePath = fc.getSelectedFile().getPath();
			debug.append("Opened file: " + oldFilePath + "\n");
		} else {
			debug.append("File selection cancelled by user\n");
		}
	}

	private void createNewFile(){
		if (this.oldFilePath == null && !useOldBuild.isSelected()){
			debug.append("Open old file or use saved hero builds\n");
		} else {
			if (!useOldBuild.isSelected()){
				int returnVal = fc.showOpenDialog(BotFileUpdaterGUI.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					newFilePath = fc.getSelectedFile().getPath();
					debug.append("Opened file: " + newFilePath + "\n");
					debug.append("Creating file...\n");
					try {
						FileUpdater updater = new FileUpdater(newFilePath);
						BuildReader reader = new BuildReader(oldFilePath);
						updater.update(reader.readBuilds());
					} catch (Exception e){
						debug.append("Exception encountered!\n" + e + "\n");
						debug.setBackground(Color.RED);
						debug.setText("Exception encountered!\n" + e);
						return;
					}
					debug.append("File creation successful.\n");
					debug.setBackground(Color.GREEN);
					debug.setText("File creation successful.");
					return;
				} else {
					debug.append("File selection cancelled by user\n");
					return;
				}
			} else {
				File test = new File("builds\\Bane.txt");
				if (!test.exists()){
					debug.append("No old build to load\n");
				} else {
					int returnVal = fc.showOpenDialog(BotFileUpdaterGUI.this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						newFilePath = fc.getSelectedFile().getPath();
						debug.append("Opened file: " + newFilePath + "\n");
						debug.append("Creating file...\n");
						try {
							FileUpdater updater = new FileUpdater(newFilePath);
							updater.updateFromSavedBuild();
						} catch (Exception e){
							debug.append("Exception encountered!\n" + e + "\n");
							debug.setBackground(Color.RED);
							debug.setText("Exception encountered!\n" + e);
							return;
						}
						debug.append("File creation successful.\n");
						debug.setBackground(Color.GREEN);
						debug.setText("File creation successful.");
						return;
					} else {
						debug.append("File selection cancelled by user\n");
						return;
					}
				}
			}
		}
	} 
	
	private void saveBuild(){
		if (oldFilePath == null){
			debug.append("Load old file first\n");
		} else {
			File test = new File("builds\\Bane.txt");
			if (!test.exists()){
				try{
					BuildSaver saver = new BuildSaver(oldFilePath);
					saver.saveBuilds();
				} catch (Exception e){
					debug.append("Exception encountered!\n" + e + "\n");
					return;
				}
				debug.append("Build saved.\n");
			} else {
				int n = JOptionPane.showOptionDialog(this,
						"Do you really want overwrite your saved build?", "Confirmation",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, null, null);
				if (n == 0){
					try{
						BuildSaver saver = new BuildSaver(oldFilePath);
						saver.saveBuilds();
					} catch (Exception e){
						debug.append("Exception encountered!\n" + e + "\n");
						return;
					}
					debug.append("New build saved.\n");
				} else {
					debug.append("Aborted saving build\n");
				}
			}
		}
	}
}
