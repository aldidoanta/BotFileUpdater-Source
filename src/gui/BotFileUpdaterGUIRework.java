package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

import core.BuildReader;
import core.BuildSaver;
import core.FileUpdater;
import core.BotImpl;
import core.ItemRecipe;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class BotFileUpdaterGUIRework implements ActionListener{

	private JFrame frame;
	JButton loadOldFile, createNewFile, saveBuild, addItem;
	JTextArea botEditor, debug;
	JCheckBox useOldBuild;
	JRadioButton rdbtnCore, rdbtnExtension, rdbtnLuxury;
	JScrollPane botEditorScrollPane, debugScrollPane;
	JLabel saveLabel;
	JFileChooser fc;
	String oldFilePath, newFilePath, saveFilePath;
	JComboBox<String> chooseBotFile, itemBox; 
	File currentEditorFile;
	private JButton loadInEditor;
	private JButton saveFromEditor;
	DefaultComboBoxModel<String> chooseBotFileModel = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<String> addItemModel = new DefaultComboBoxModel<String>();
	HashMap<String, ItemRecipe> itemMap;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotFileUpdaterGUIRework window = new BotFileUpdaterGUIRework();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BotFileUpdaterGUIRework() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadOldFile = new JButton();
		loadOldFile.setBounds(57, 39, 200, 50);
		loadOldFile.setText("Load old file");
		loadOldFile.addActionListener(this);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(loadOldFile);

		createNewFile = new JButton();
		createNewFile.setBounds(57, 513, 200, 50);
		createNewFile.setText("Create new file ");
		createNewFile.addActionListener(this);
		frame.getContentPane().add(createNewFile);

		botEditor = new JTextArea();
		botEditor.setBounds(323, 16, 635, 593);
		botEditor.setText("");
		botEditor.setRows(5);
		botEditor.setColumns(5);
		botEditorScrollPane = new JScrollPane();
		botEditorScrollPane.setViewportView(botEditor);
		botEditorScrollPane.setBounds(323, 16, 801, 593);
		frame.getContentPane().add(botEditorScrollPane);
		
		debug = new JTextArea();
		debug.setBounds(10, 620, 906, 130);
		debug.setEditable(false);
		debug.setText("");
		debugScrollPane = new JScrollPane();
		debugScrollPane.setViewportView(debug);
		debugScrollPane.setBounds(10, 620, 590, 130);
		frame.getContentPane().add(debugScrollPane);
		
		useOldBuild = new JCheckBox();
		useOldBuild.setBounds(57, 96, 154, 34);
		useOldBuild.setText("use saved hero builds");
		useOldBuild.setSelected(true);
		useOldBuild.addActionListener(this);
		frame.getContentPane().add(useOldBuild);

		saveBuild = new JButton();
		saveBuild.setBounds(198, 397, 100, 50);
		saveBuild.setText("Save");
		saveBuild.addActionListener(this);
		frame.getContentPane().add(saveBuild);

		saveLabel = new JLabel();
		saveLabel.setBounds(30, 412, 181, 20);
		saveLabel.setText("Save currently loaded build: ");
		frame.getContentPane().add(saveLabel);
		
		this.getBuildFiles();
		chooseBotFile = new JComboBox<String>(chooseBotFileModel);
		chooseBotFile.setBounds(30, 187, 227, 25);
		frame.getContentPane().add(chooseBotFile);
		
		loadInEditor = new JButton("Load in Editor");
		loadInEditor.setBounds(30, 221, 227, 25);
		loadInEditor.addActionListener(this);
		frame.getContentPane().add(loadInEditor);
		
		saveFromEditor = new JButton("Save from Editor");
		saveFromEditor.setBounds(30, 253, 227, 25);
		saveFromEditor.addActionListener(this);
		frame.getContentPane().add(saveFromEditor);
		
		JLabel debugLable = new JLabel("Log:");
		debugLable.setBounds(10, 595, 46, 14);
		frame.getContentPane().add(debugLable);
		
		this.initAddItemModel();
		itemBox = new JComboBox<String>(addItemModel);
		itemBox.setBounds(676, 643, 227, 20);
		frame.getContentPane().add(itemBox);
		
		addItem = new JButton("Add Item");
		addItem.setBounds(913, 642, 89, 23);
		addItem.addActionListener(this);
		frame.getContentPane().add(addItem);
		
		rdbtnCore = new JRadioButton("Core");
		rdbtnCore.setSelected(true);
		buttonGroup.add(rdbtnCore);
		rdbtnCore.setBounds(676, 678, 60, 23);
		frame.getContentPane().add(rdbtnCore);
		
		rdbtnExtension = new JRadioButton("Extension");
		buttonGroup.add(rdbtnExtension);
		rdbtnExtension.setBounds(738, 678, 93, 23);
		frame.getContentPane().add(rdbtnExtension);
		
		rdbtnLuxury = new JRadioButton("Luxury");
		buttonGroup.add(rdbtnLuxury);
		rdbtnLuxury.setBounds(833, 678, 109, 23);
		frame.getContentPane().add(rdbtnLuxury);
		
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

		frame.setTitle("BotFile Tool");
		frame.setSize(1151,800);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}

	private void initAddItemModel() {
		List<String> itemList = new ArrayList<String>();
		this.itemMap = new HashMap<String, ItemRecipe>();
		String itemString = "";
		for (ItemRecipe i : ItemRecipe.values()){
			itemString = i.getName();
			itemList.add(itemString);
			this.itemMap.put(itemString, i);
		}
		Collections.sort(itemList);
		for (String s : itemList){
			addItemModel.addElement(s);
		}
		return;		
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
		if (e.getSource() == saveFromEditor){
			this.saveFromEditor();
		}
		if (e.getSource() == loadInEditor){
			this.loadInEditor();
		}
		if (e.getSource() == addItem){
			this.addItem();
		}
	}

	private String getComponentStrings(ItemRecipe item, String buildString){
		StringBuilder builder = new StringBuilder();
		if (item.getItemComponents() == null){
			for (String s : item.getComponents()){
				builder.append("\"" + s + "\"").append(buildString).append("\n\t\t");
			}
			builder.append("\"" + item.getFinishedItem() + "\"").append("\t\t\"ITEM_DERIVED\"\n");
			return builder.toString();
		} else {
			for (ItemRecipe recipe : item.getItemComponents()){
				builder.append(getComponentStrings(recipe, buildString)).append("\t\t");
			}
			String[] extraStrings = item.getFinishedItem().split(";");
			for (String s : extraStrings){
				builder.append("\"" + s + "\"").append(buildString).append("\n\t\t");
			}
			if (extraStrings[extraStrings.length - 1].contains("recipe")){
				builder.append("\"" + new String(extraStrings[extraStrings.length - 1].replace("_recipe", "")) + "\"");
				builder.append("\t\t\"ITEM_DERIVED\"\n\t\t");
			} else {
				builder.replace(builder.lastIndexOf(buildString), builder.lastIndexOf(buildString) + buildString.length(), "\t\t\"ITEM_DERIVED\"\n\t\t");
			}
			return builder.toString();
		}
	}
	private void addItem() {
		String buildString = "";
		if (rdbtnCore.isSelected()){
			buildString = "\t\t\"ITEM_CORE\"";
		}
		if (rdbtnExtension.isSelected()){
			buildString = "\t\t\"ITEM_EXTENSION\"";
		}
		if (rdbtnLuxury.isSelected()){
			buildString = "\t\t\"ITEM_LUXURY\"";
		}
		StringBuilder builder = new StringBuilder();
		ItemRecipe item = itemMap.get(itemBox.getSelectedItem());
		if (item.getItemComponents() == null){
			for (String s : item.getComponents()){
				builder.append("\"" + s + "\"").append(buildString).append("\n\t\t");
			}
			builder.append("\"" + item.getFinishedItem() + "\"").append("\t\t\"ITEM_DERIVED\"\n");
		} else {
			builder.append(this.getComponentStrings(item, buildString));
		}
		botEditor.insert(builder.toString(), botEditor.getCaretPosition());
				
	}

	private void loadInEditor(){
		try {
			String currentFilePath = "builds/" + (String) chooseBotFile.getSelectedItem() + ".txt";
			currentEditorFile = new File(currentFilePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(currentEditorFile)));
			String lineIn;
			StringBuilder builder = new StringBuilder();
			int i = 1;
			while (!((lineIn = reader.readLine()) == null)){
				System.out.println("line " +  i + ":" + lineIn);
				i++;
				lineIn = lineIn.replaceFirst("\t", "");
				lineIn = lineIn.replaceFirst("\t", "");
				builder.append(lineIn).append("\n");
			}
			botEditor.setText(builder.toString());
			debug.append("Loaded into Editor: " + currentEditorFile.getAbsolutePath() + "\n");
			debug.setBackground(Color.WHITE);
			reader.close();
		} catch (FileNotFoundException e) {
			debug.append("File not found.");
		} catch (IOException e) {
			debug.append("I/O Exception.");
		}
	}
	
	private void saveFromEditor(){
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currentEditorFile),"UTF-8"));
			String[] buffer = botEditor.getText().split("\n");
			for (String s : buffer){
				writer.write("\t\t" + s + "\n");
			}
			debug.append("Saved Editor content to: " + currentEditorFile.getAbsolutePath() + "\n");
			debug.setBackground(Color.WHITE);
			writer.flush();
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void loadOldFile(){
		fc.setCurrentDirectory(new File("C:\\Program Files (x86)\\Steam\\SteamApps\\common\\dota 2 beta\\dota\\scripts\\npc"));
		int returnVal = fc.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			oldFilePath = fc.getSelectedFile().getPath();
			debug.append("Opened file: " + oldFilePath + "\n");
			debug.setBackground(Color.WHITE);
		} else {
			debug.append("File selection cancelled by user\n");
			debug.setBackground(Color.WHITE);
		}
	}

	private void createNewFile(){
		if (this.oldFilePath == null && !useOldBuild.isSelected()){
			debug.append("Open old file or use saved hero builds\n");
		} else {
			if (!useOldBuild.isSelected()){
				int returnVal = fc.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					newFilePath = fc.getSelectedFile().getPath();
					debug.setBackground(Color.WHITE);
					debug.append("Opened file: " + newFilePath + "\n");
					debug.append("Creating file...\n");
					try {
						FileUpdater updater = new FileUpdater(newFilePath);
						BuildReader reader = new BuildReader(oldFilePath);
						updater.update(reader.readBuilds());
					} catch (Exception e){
						debug.append("Exception encountered!\n" + e + "\n");
						debug.setBackground(Color.RED);
						return;
					}
					debug.append("File creation successful: " + newFilePath + "\n");
					debug.setBackground(Color.GREEN);
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
					int returnVal = fc.showOpenDialog(frame);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						newFilePath = fc.getSelectedFile().getPath();
						debug.setBackground(Color.WHITE);
						debug.append("Opened file: " + newFilePath + "\n");
						debug.append("Creating file...\n");
						try {
							FileUpdater updater = new FileUpdater(newFilePath);
							updater.updateFromSavedBuild();
						} catch (Exception e){
							debug.append("Exception encountered!\n" + e + "\n");
							debug.setBackground(Color.RED);
							return;
						}
						debug.setBackground(Color.GREEN);
						debug.append("File creation successful. Updated File:  " + newFilePath + "\n");
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
					this.getBuildFiles();
				} catch (Exception e){
					debug.append("Exception encountered!\n" + e + "\n");
					debug.setBackground(Color.WHITE);
					return;
				}
				debug.append("Build saved.\n");
				debug.setBackground(Color.WHITE);
			} else {
				int n = JOptionPane.showOptionDialog(frame,
						"Do you really want overwrite your saved build?", "Confirmation",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, null, null);
				if (n == 0){
					try{
						BuildSaver saver = new BuildSaver(oldFilePath);
						saver.saveBuilds();
						this.getBuildFiles();
					} catch (Exception e){
						debug.append("Exception encountered!\n" + e + "\n");
						debug.setBackground(Color.WHITE);
						return;
					}
					debug.append("New build saved.\n");
					debug.setBackground(Color.WHITE);
				} else {
					debug.append("Aborted saving build\n");
					debug.setBackground(Color.WHITE);
				}
			}
		}
	}
	
	private void getBuildFiles(){
		
		File buildFile;
		List<String> buildList = new ArrayList<String>();
		for (BotImpl bot : BotImpl.values()){
			String buildString = bot.getFlavorName();
			buildFile = new File("builds/" + buildString.substring(6) + ".txt");
			if (buildFile.exists()){
				buildList.add(buildString.substring(6));
			};
		}
		Collections.sort(buildList);
		chooseBotFileModel.removeAllElements();
		for (String s : buildList){
			chooseBotFileModel.addElement(s);
		}
		
		return;
	}
}
