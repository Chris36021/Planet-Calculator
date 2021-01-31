/**
 * 
 * Created and designed by Christopher Castillo. 
 * Copyright © 2021 Chris36021. All rights reserved.
 * Created in 2019. Edited in 2021.
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class PlanetCalculator {

	private JFrame frmPlanetCalculator;
	private JTextField txtPlanetradius;
	private JTextField txtVolume;
	private JTextField txtTempK;
	private JTextField txtTempC;
	private JTextField txtTempF;
	private JTextField txtPressureInPA;
	private JTextField txtTorrPressureOut;
	private JTextField txtlightYears;
	private JTextField txtKmdistance;
	private JTextField txtMilesDistance;
	private JTextField txtAtmpressureout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanetCalculator window = new PlanetCalculator();
					window.frmPlanetCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlanetCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlanetCalculator = new JFrame();
		frmPlanetCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage(PlanetCalculator.class.getResource("/Sheet/planetpng.png")));
		frmPlanetCalculator.setTitle("Planet Calculator");
		frmPlanetCalculator.setBounds(400, 50, 500, 600);
		frmPlanetCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmPlanetCalculator.setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JRadioButtonMenuItem rdbtnmntmDefaultTheme = new JRadioButtonMenuItem("Default Theme");
		rdbtnmntmDefaultTheme.setSelected(true);
		mnOptions.add(rdbtnmntmDefaultTheme);
		
		JRadioButtonMenuItem rdbtnmntmDarkTheme = new JRadioButtonMenuItem("Dark Theme");
		mnOptions.add(rdbtnmntmDarkTheme);
		
		ButtonGroup themeGroup = new ButtonGroup();
		themeGroup.add(rdbtnmntmDefaultTheme);
		themeGroup.add(rdbtnmntmDarkTheme);
		
		JMenu mnTools = new JMenu("Tools");
		mnTools.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnTools);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPlanetradius.setText("0");
				txtVolume.setText("");
				txtlightYears.setText("0");
				txtKmdistance.setText("");
				txtMilesDistance.setText("");
				txtTempK.setText("0");
				txtTempC.setText("");
				txtTempF.setText("");
				txtPressureInPA.setText("0");
				txtTorrPressureOut.setText("");
				txtAtmpressureout.setText("");
			}
		});
		mnTools.add(mntmClear);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmFaqs = new JMenuItem("FAQs");
		mnHelp.add(mntmFaqs);
		mntmFaqs.setToolTipText("<html>" + "Controls: <br> Press the Enter key while on a text field to calculate. <br>" +
								"Press the Tab key to switch between text fields." + "</html>");
		
		JMenuItem mntmCredits = new JMenuItem("Credits");
		mnHelp.add(mntmCredits);
		mntmCredits.setToolTipText("<html> This app was created and designed by CCC \u263A </html>");

		JMenuItem mntmQuitApp = new JMenuItem("Quit App");
		mntmQuitApp.setHorizontalAlignment(SwingConstants.CENTER);
		mnHelp.add(mntmQuitApp);
		mntmQuitApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

//------------------------------------------ start of Volume Panel ------------------------------------------------------------------------

		JLabel lblTitle = new JLabel("Planet Calculator");
		lblTitle.setOpaque(true);
		lblTitle.setForeground(SystemColor.desktop);
		lblTitle.setBackground(SystemColor.activeCaption);
		lblTitle.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		frmPlanetCalculator.getContentPane().add(lblTitle, BorderLayout.NORTH);

		JPanel mainPanel = new JPanel();
		frmPlanetCalculator.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel volumePanel = new JPanel();
		volumePanel.setBackground(SystemColor.activeCaption);
		volumePanel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), 
							  "Volume (Assumed to be perfect sphere)", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		mainPanel.add(volumePanel);
		volumePanel.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblPlanetradius = new JLabel("Planet Radius (In Meters):");
		lblPlanetradius.setOpaque(true);
		lblPlanetradius.setForeground(SystemColor.desktop);
		lblPlanetradius.setBackground(SystemColor.inactiveCaption);
		lblPlanetradius.setHorizontalAlignment(SwingConstants.TRAILING);
		volumePanel.add(lblPlanetradius);

		txtPlanetradius = new JTextField("0");
		volumePanel.add(txtPlanetradius);
		txtPlanetradius.setColumns(10);

		JLabel lblPlanetvolume = new JLabel("Planet Volume (In m^3):");
		lblPlanetvolume.setOpaque(true);
		lblPlanetvolume.setForeground(SystemColor.desktop);
		lblPlanetvolume.setBackground(SystemColor.inactiveCaption);
		lblPlanetvolume.setHorizontalAlignment(SwingConstants.TRAILING);
		volumePanel.add(lblPlanetvolume);

		txtVolume = new JTextField();
		txtVolume.setHorizontalAlignment(SwingConstants.CENTER);
		txtVolume.setEditable(false);
		volumePanel.add(txtVolume);
		txtVolume.setColumns(10);

		txtPlanetradius.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String planetRadius = txtPlanetradius.getText();
					int radiusNum = Integer.parseInt(planetRadius);
					double planetVolume = (4.0/3.0) * Math.PI * Math.pow(radiusNum, 3);
					DecimalFormat resultRounding = new DecimalFormat("#,###.00");
					txtVolume.setText(resultRounding.format(planetVolume));
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		});

//------------------------------------------ end of Volume Panel --------------------------------------------------------------------------
//------------------------------------------ start of Distance Panel ----------------------------------------------------------------------

		JPanel distancePanel = new JPanel();
		distancePanel.setBackground(SystemColor.activeCaption);
		distancePanel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), 
								"Distance", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		mainPanel.add(distancePanel);
		distancePanel.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblLightyeard = new JLabel("Distance in Light Years:");
		lblLightyeard.setForeground(SystemColor.desktop);
		lblLightyeard.setBackground(SystemColor.inactiveCaption);
		lblLightyeard.setOpaque(true);
		lblLightyeard.setHorizontalAlignment(SwingConstants.TRAILING);
		distancePanel.add(lblLightyeard);

		txtlightYears = new JTextField("0");
		distancePanel.add(txtlightYears);
		txtlightYears.setColumns(10);

		JLabel lblDistancekm = new JLabel("Distance in Km:");
		lblDistancekm.setForeground(SystemColor.desktop);
		lblDistancekm.setBackground(SystemColor.inactiveCaption);
		lblDistancekm.setOpaque(true);
		lblDistancekm.setHorizontalAlignment(SwingConstants.TRAILING);
		distancePanel.add(lblDistancekm);

		txtKmdistance = new JTextField();
		txtKmdistance.setEditable(false);
		txtKmdistance.setHorizontalAlignment(SwingConstants.CENTER);
		distancePanel.add(txtKmdistance);
		txtKmdistance.setColumns(10);

		JLabel lblMilesdistance = new JLabel("Distance In Miles:");
		lblMilesdistance.setForeground(SystemColor.desktop);
		lblMilesdistance.setBackground(SystemColor.inactiveCaption);
		lblMilesdistance.setOpaque(true);
		lblMilesdistance.setHorizontalAlignment(SwingConstants.TRAILING);
		distancePanel.add(lblMilesdistance);

		txtMilesDistance = new JTextField();
		txtMilesDistance.setEditable(false);
		txtMilesDistance.setHorizontalAlignment(SwingConstants.CENTER);
		distancePanel.add(txtMilesDistance);
		txtMilesDistance.setColumns(10);

		txtlightYears.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String distanceInput = txtlightYears.getText();
					int distanceNumber = Integer.parseInt(distanceInput);
					double meterResult = distanceNumber * 9.461e+12;
					double mileResult = distanceNumber * 5.879e+12;
					DecimalFormat resultRounding = new DecimalFormat("#,###.00");
					txtKmdistance.setText(resultRounding.format(meterResult));
					txtMilesDistance.setText(resultRounding.format(mileResult));
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		});
		
//------------------------------------------ end of Distance Panel ------------------------------------------------------------------------
//------------------------------------------ start of Misc. Panel -------------------------------------------------------------------------

		JPanel miscPanel = new JPanel();
		miscPanel.setBackground(SystemColor.activeCaption);
		miscPanel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), 
							"Misc.", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		mainPanel.add(miscPanel);
		miscPanel.setLayout(new GridLayout(6, 2, 0, 0));

		JLabel lblPlanetTempK = new JLabel("Planet Temperature (In K):");
		lblPlanetTempK.setForeground(SystemColor.desktop);
		lblPlanetTempK.setBackground(SystemColor.inactiveCaption);
		lblPlanetTempK.setOpaque(true);
		lblPlanetTempK.setHorizontalAlignment(SwingConstants.TRAILING);
		miscPanel.add(lblPlanetTempK);

		txtTempK = new JTextField("0");
		miscPanel.add(txtTempK);
		txtTempK.setColumns(10);

		JLabel lblPlanetTempC = new JLabel("Planet Temperature (In \u00B0C):");
		lblPlanetTempC.setForeground(SystemColor.desktop);
		lblPlanetTempC.setBackground(SystemColor.inactiveCaption);
		lblPlanetTempC.setOpaque(true);
		lblPlanetTempC.setHorizontalAlignment(SwingConstants.TRAILING);
		miscPanel.add(lblPlanetTempC);

		txtTempC = new JTextField("");
		txtTempC.setHorizontalAlignment(SwingConstants.CENTER);
		txtTempC.setEditable(false);
		miscPanel.add(txtTempC);
		txtTempC.setColumns(10);

		JLabel lblPlanetTempF = new JLabel("Planet Temperature (In \u00B0F):");
		lblPlanetTempF.setForeground(SystemColor.desktop);
		lblPlanetTempF.setBackground(SystemColor.inactiveCaption);
		lblPlanetTempF.setOpaque(true);
		lblPlanetTempF.setHorizontalAlignment(SwingConstants.TRAILING);
		miscPanel.add(lblPlanetTempF);

		txtTempF = new JTextField("");
		txtTempF.setHorizontalAlignment(SwingConstants.CENTER);
		txtTempF.setEditable(false);
		miscPanel.add(txtTempF);
		txtTempF.setColumns(10);

		JLabel lblPressurePA = new JLabel("Planet Pressure (In PA):");
		lblPressurePA.setForeground(SystemColor.desktop);
		lblPressurePA.setBackground(SystemColor.inactiveCaption);
		lblPressurePA.setOpaque(true);
		lblPressurePA.setHorizontalAlignment(SwingConstants.TRAILING);
		miscPanel.add(lblPressurePA);

		txtPressureInPA = new JTextField();
		txtPressureInPA.setText("0");
		txtPressureInPA.setHorizontalAlignment(SwingConstants.LEFT);
		miscPanel.add(txtPressureInPA);
		txtPressureInPA.setColumns(10);

		JLabel lblPlanetPressureT = new JLabel("Planet Pressure (In Torr):");
		lblPlanetPressureT.setForeground(SystemColor.desktop);
		lblPlanetPressureT.setBackground(SystemColor.inactiveCaption);
		lblPlanetPressureT.setOpaque(true);
		lblPlanetPressureT.setHorizontalAlignment(SwingConstants.TRAILING);
		miscPanel.add(lblPlanetPressureT);

		txtTorrPressureOut = new JTextField();
		txtTorrPressureOut.setHorizontalAlignment(SwingConstants.CENTER);
		txtTorrPressureOut.setEditable(false);
		miscPanel.add(txtTorrPressureOut);
		txtTorrPressureOut.setColumns(10);
		
		JLabel lblAtmPressureOut = new JLabel("Planet Pressure (In atm:)");
		lblAtmPressureOut.setForeground(SystemColor.desktop);
		lblAtmPressureOut.setBackground(SystemColor.inactiveCaption);
		lblAtmPressureOut.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAtmPressureOut.setOpaque(true);
		miscPanel.add(lblAtmPressureOut);
		
		txtAtmpressureout = new JTextField();
		txtAtmpressureout.setHorizontalAlignment(SwingConstants.CENTER);
		txtAtmpressureout.setEditable(false);
		miscPanel.add(txtAtmpressureout);
		txtAtmpressureout.setColumns(10);

		txtTempK.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String planetTemp = txtTempK.getText();
					int PTempInput = Integer.parseInt(planetTemp);
					double PTempCResult = PTempInput - 273.15;
					double PTempFResult = PTempCResult * (9.0/5.0) + 32;
					DecimalFormat resultRounding = new DecimalFormat("#,###.00");
					txtTempC.setText(resultRounding.format(PTempCResult));
					txtTempF.setText(resultRounding.format(PTempFResult));	
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		});
		
		txtPressureInPA.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String planetPressure = txtPressureInPA.getText();
					int PPressureInput = Integer.parseInt(planetPressure);
					double PPressureAtm = PPressureInput * 0.00000986923;
					double PPressureTorr =  PPressureAtm * 760;
					DecimalFormat resultRounding = new DecimalFormat("#,###.00000");
					txtTorrPressureOut.setText(resultRounding.format(PPressureTorr));
					txtAtmpressureout.setText(resultRounding.format(PPressureAtm));	
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		});
		
		rdbtnmntmDefaultTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitle.setOpaque(true);
				lblTitle.setForeground(SystemColor.desktop);
				lblTitle.setBackground(SystemColor.activeCaption);
				volumePanel.setBackground(SystemColor.activeCaption);
				volumePanel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), 
				"Volume (Assumed to be perfect sphere)", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
				lblPlanetradius.setForeground(SystemColor.desktop);
				lblPlanetradius.setBackground(SystemColor.inactiveCaption);
				lblPlanetvolume.setForeground(SystemColor.desktop);
				lblPlanetvolume.setBackground(SystemColor.inactiveCaption);
				distancePanel.setBackground(SystemColor.activeCaption);
				distancePanel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), 
				"Distance", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
				lblLightyeard.setForeground(SystemColor.desktop);
				lblLightyeard.setBackground(SystemColor.inactiveCaption);
				lblDistancekm.setForeground(SystemColor.desktop);
				lblDistancekm.setBackground(SystemColor.inactiveCaption);
				lblMilesdistance.setForeground(SystemColor.desktop);
				lblMilesdistance.setBackground(SystemColor.inactiveCaption);
				miscPanel.setBackground(SystemColor.activeCaption);
				miscPanel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), 
				"Misc.", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
				lblPlanetTempK.setForeground(SystemColor.desktop);
				lblPlanetTempK.setBackground(SystemColor.inactiveCaption);
				lblPlanetTempC.setForeground(SystemColor.desktop);
				lblPlanetTempC.setBackground(SystemColor.inactiveCaption);
				lblPlanetTempF.setForeground(SystemColor.desktop);
				lblPlanetTempF.setBackground(SystemColor.inactiveCaption);
				lblPressurePA.setForeground(SystemColor.desktop);
				lblPressurePA.setBackground(SystemColor.inactiveCaption);
				lblPlanetPressureT.setForeground(SystemColor.desktop);
				lblPlanetPressureT.setBackground(SystemColor.inactiveCaption);
				lblAtmPressureOut.setForeground(SystemColor.desktop);
				lblAtmPressureOut.setBackground(SystemColor.inactiveCaption);
			}
		});
		
		rdbtnmntmDarkTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitle.setForeground(SystemColor.white);
				lblTitle.setBackground(SystemColor.black);
				volumePanel.setBackground(SystemColor.black);
				volumePanel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), 
				"Volume (Assumed to be perfect sphere)", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.white));
				lblPlanetradius.setForeground(SystemColor.white);
				lblPlanetradius.setBackground(SystemColor.black);
				lblPlanetvolume.setForeground(SystemColor.white);
				lblPlanetvolume.setBackground(SystemColor.black);
				distancePanel.setBackground(SystemColor.black);
				distancePanel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), 
				"Distance", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.white));
				lblLightyeard.setForeground(SystemColor.white);
				lblLightyeard.setBackground(SystemColor.black);
				lblDistancekm.setForeground(SystemColor.white);
				lblDistancekm.setBackground(SystemColor.black);
				lblMilesdistance.setForeground(SystemColor.white);
				lblMilesdistance.setBackground(SystemColor.black);
				miscPanel.setBackground(SystemColor.black);
				miscPanel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), 
				"Misc.", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.white));
				lblPlanetTempK.setForeground(SystemColor.white);
				lblPlanetTempK.setBackground(SystemColor.black);
				lblPlanetTempC.setForeground(SystemColor.white);
				lblPlanetTempC.setBackground(SystemColor.black);
				lblPlanetTempF.setForeground(SystemColor.white);
				lblPlanetTempF.setBackground(SystemColor.black);
				lblPressurePA.setForeground(SystemColor.white);
				lblPressurePA.setBackground(SystemColor.black);
				lblPlanetPressureT.setForeground(SystemColor.white);
				lblPlanetPressureT.setBackground(SystemColor.black);
				lblAtmPressureOut.setForeground(SystemColor.white);
				lblAtmPressureOut.setBackground(SystemColor.black);
			}
		});
//------------------------------------------ end of Misc. Panel ---------------------------------------------------------------------------
	}
}
//Created and Designed by CCC