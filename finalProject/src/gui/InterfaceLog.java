package gui;

public interface InterfaceLog {

	// LogType enumeration
	public enum enumLogType {
		INFO, WARN, ERROR
	}

	// Write to GUI Log area
	public void addLog(enumLogType logType, String text);

	// Update progress bar
	//public void updateProgress();

}
