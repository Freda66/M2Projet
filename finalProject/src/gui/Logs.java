package gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Logs Interface : Show to users the applications steps. Class generate from
 * Netbeans Form Designer.
 * 
 * @author pev
 * @version 1.0.0
 */
public class Logs extends javax.swing.JFrame implements InterfaceLog {

	// ==============================================================
	// ATTRIBUTE
	// ==============================================================

	public static Logs logger = new Logs();
	private int progressTotal;
	private int progressCurrent;

	// ==============================================================
	// CONSTRUCTOR
	// ==============================================================

	/**
	 * Serialization
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form UI_Logs
	 */
	public Logs() {
		initComponents();
	}
	
	// ==============================================================
	// SETTERS / GETTERS
	// ==============================================================
	
	public int getProgressTotal() {
		return this.progressTotal;
	}
	
	public void setProgressTotal(int progressTotal) {
		this.progressTotal = progressTotal;
	}
	
	// --------------------------------------------------------------
	
	public int getProgressCurrent() {
		return this.progressCurrent;
	}
	
	public void setProgressCurrent(int progressCurrent) {
		this.progressCurrent = progressCurrent;
	}

	// ==============================================================
	// COMPONENTS
	// ==============================================================

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		panelMain = new javax.swing.JPanel();
		panelHeader = new javax.swing.JPanel();
		labelHeader = new javax.swing.JLabel();
		panelContent = new javax.swing.JPanel();
		scrollPane = new javax.swing.JScrollPane();
		areaLog = new javax.swing.JTextArea();
		panelBottom = new javax.swing.JPanel();
		btnEnd = new javax.swing.JButton();
		btnLogs = new javax.swing.JButton();
		btnResults = new javax.swing.JButton();
		panelProgressBar = new javax.swing.JPanel();
		progressBar = new javax.swing.JProgressBar();

		scrollPane.setViewportView(areaLog);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		panelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		labelHeader.setText("Execution");

		javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
		panelHeader.setLayout(panelHeaderLayout);
		panelHeaderLayout
				.setHorizontalGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelHeaderLayout.createSequentialGroup().addGap(154, 154, 154)
								.addComponent(labelHeader)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelHeaderLayout
				.setVerticalGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelHeaderLayout.createSequentialGroup().addContainerGap().addComponent(labelHeader)
								.addContainerGap(23, Short.MAX_VALUE)));

		javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
		panelContent.setLayout(panelContentLayout);
		panelContentLayout.setHorizontalGroup(panelContentLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(panelContentLayout
						.createSequentialGroup().addContainerGap().addComponent(scrollPane).addContainerGap()));
		panelContentLayout
				.setVerticalGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelContentLayout.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
								.addContainerGap()));

		btnEnd.setText("End");
		btnEnd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEndActionPerformed(evt);
			}
		});

		btnLogs.setText("Show Logs");
		btnLogs.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLogsActionPerformed(evt);
			}
		});

		btnResults.setText("Show Results");
		btnResults.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnResultsActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelBottomLayout = new javax.swing.GroupLayout(panelBottom);
		panelBottom.setLayout(panelBottomLayout);
		panelBottomLayout
				.setHorizontalGroup(panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								panelBottomLayout.createSequentialGroup().addContainerGap().addComponent(btnLogs)
										.addGap(18, 18, 18).addComponent(btnResults)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
										.addContainerGap()));
		panelBottomLayout.setVerticalGroup(panelBottomLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelBottomLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnEnd).addComponent(btnLogs).addComponent(btnResults))
						.addContainerGap(10, Short.MAX_VALUE)));

		javax.swing.GroupLayout panelProgressBarLayout = new javax.swing.GroupLayout(panelProgressBar);
		panelProgressBar.setLayout(panelProgressBarLayout);
		panelProgressBarLayout
				.setHorizontalGroup(
						panelProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelProgressBarLayout.createSequentialGroup().addContainerGap()
										.addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));
		panelProgressBarLayout
				.setVerticalGroup(panelProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelProgressBarLayout.createSequentialGroup().addContainerGap()
								.addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(7, Short.MAX_VALUE)));

		javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
		panelMain.setLayout(panelMainLayout);
		panelMainLayout
				.setHorizontalGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelMainLayout.createSequentialGroup().addContainerGap()
								.addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(panelProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelContent, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addComponent(panelBottom, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		panelMainLayout.setVerticalGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelMainLayout.createSequentialGroup().addContainerGap()
						.addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelContent, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelBottom, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(panelMain,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(panelMain,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap()));

		pack();
		setVisible(true);
	}// </editor-fold>

	// ==============================================================
	// BUTTONS
	// ==============================================================

	/**
	 * UI_Logs End button event
	 * 
	 * @param evt
	 */
	private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO UI_Logs - Show End
	}
	
	// --------------------------------------------------------------

	/**
	 * UI_Logs Show Logs file button event
	 * 
	 * @param evt
	 */
	private void btnLogsActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO UI_Logs - Show End
	}
	
	// --------------------------------------------------------------

	/**
	 * UI_Logs Show plotting results button event
	 * 
	 * @param evt
	 */
	private void btnResultsActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO UI_Logs - Show results
	}

	// ==============================================================
	// METHODS
	// ==============================================================

	/**
	 * Add log information to console.
	 * 
	 * @param logType
	 * @param text
	 */
	public void addLog(enumLogType logType, String text) {

		// Get date format
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date date = new Date();

		// Prepare new line
		String message = dateFormat.format(date) + "\t|" + logType.toString() + "\t|" + text;

		// Write in console
		System.out.println(message);

		// Write in areaLog
		areaLog.append(message + "\n");
	}

	/**
	 * Update the progress bar.
	 * 
	 * @param value
	 *            : Value to set on the progress bar (in %)
	 */
	public void updateProgress(int value) {
		
	}

	// ==============================================================
	// VARIABLES
	// ==============================================================

	// Variables declaration - do not modify
	private javax.swing.JButton btnEnd;
	private javax.swing.JButton btnLogs;
	private javax.swing.JButton btnResults;
	private javax.swing.JLabel labelHeader;
	private javax.swing.JPanel panelBottom;
	private javax.swing.JPanel panelContent;
	private javax.swing.JPanel panelHeader;
	private javax.swing.JPanel panelMain;
	private javax.swing.JPanel panelProgressBar;
	private javax.swing.JProgressBar progressBar;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JTextArea areaLog;
	// End of variables declaration

}
