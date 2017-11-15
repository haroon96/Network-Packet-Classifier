package com.haroon.ui;

import com.haroon.chart.LineChart;
import com.haroon.config.Configuration;
import com.haroon.packetdump.PacketDump;
import com.haroon.packetdump.WinDump;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.sun.deploy.util.SystemUtils;
import javafx.embed.swing.JFXPanel;
import javafx.scene.chart.XYChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class MainWindow {
	
	private JPanel panel1;
	private JPanel graphPanel;
	private JButton start_stop_btn;
	private JButton log_btn;
	private JButton exit_btn;
	private JButton settings_btn;
	private JFrame frame;
	private JFXPanel jfxPanel;
	
	private boolean started;
	
	private HashMap<String, XYChart.Series> hashmap;
	
	public JFrame getFrame() {
		return frame;
	}
	
	public MainWindow() {
		hashmap = new HashMap<>();
		jfxPanel = new JFXPanel();
		started = false;
	}
	
	public void show() {
		setListeners();
		frame = new JFrame("Network Packet Classifier");
		frame.setMinimumSize(new Dimension(800, 500));
		frame.setContentPane(panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfxPanel.setScene(LineChart.getScene());
		graphPanel.add(jfxPanel);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	private void setListeners() {
		exit_btn.addActionListener((ActionEvent e)->{
			System.exit(0);
		});
		settings_btn.addActionListener((ActionEvent e)->{
		
		});
		start_stop_btn.addActionListener((ActionEvent e)->{
			if (started) {
				// stop
			} else {
				// start
				PacketDump packetDump;
				if (Configuration.getOS() == Configuration.WINDOWS) {
					packetDump = new WinDump()
				}
			}
			
			started = !started;
		});
	}
	
	public void hide() {
		frame.setVisible(false);
	}
	
	public boolean isVisible() {
		return frame.isVisible();
	}
	
	
	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}
	
	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(2, 1, new Insets(10, 10, 10, 10), -1, -1));
		panel1.setBackground(new Color(-723724));
		graphPanel = new JPanel();
		graphPanel.setLayout(new BorderLayout(0, 0));
		graphPanel.setBackground(new Color(-723724));
		panel1.add(graphPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
		panel2.setBackground(new Color(-723724));
		panel1.add(panel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		start_stop_btn = new JButton();
		start_stop_btn.setText("Button");
		panel2.add(start_stop_btn, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		log_btn = new JButton();
		log_btn.setText("Button");
		panel2.add(log_btn, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
	}
	
	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return panel1;
	}
}