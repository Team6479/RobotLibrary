package robot.autonomous.dynamic;

import java.io.File;

public class AutoFileUtil {
	
	//make construcotr private
	private AutoFileUtil() {
		//setup folders
		dynamicFolder();
	}
	
	private static AutoFileUtil instance;
	public static AutoFileUtil getInstance() {
		if(instance == null) {
			instance = new AutoFileUtil();
		}
		return instance;
	}
	
	private static final String HOME_DIR_PATH = "/home/lvuser/";
	public static final String AUTO_DIR_PATH = HOME_DIR_PATH + "autonomous/";
	
	public File dynamicFolder;
	//setups up the folder if it doesnt 
	private void dynamicFolder() {
		dynamicFolder = new File(AUTO_DIR_PATH);
		//if the dir doesnt exist, make it
		if(!dynamicFolder.exists()) {
			dynamicFolder.mkdirs();
		}
	}
	private static final String AUTO_SUFFIX = ".auto";
	public File getAutoFile(String autoName) {
		return new File(getAutoFileName(autoName));
	}
	public String getAutoFileName(String autoName) {
		return (AUTO_DIR_PATH + autoName + AUTO_SUFFIX);
	}
}
