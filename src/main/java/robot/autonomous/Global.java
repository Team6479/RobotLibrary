package robot.autonomous;

import java.io.File;

public class Global {
	
	private static Global instance = new Global();
	
	//make construcotr private
	private Global() {
		//setup folders
		dynamicFolder();
		dslFolder();
	}
	
	public static Global getInstance() {
		return instance;
	}
	
	private final String HOME_DIR_PATH = "/home/lvuser/";
	private final String AUTO_DIR_PATH = HOME_DIR_PATH + "autonomous/";
	public final String DYNAMIC_DIR_PATH = AUTO_DIR_PATH + "dynamic/";
	public final String DSL_DIR_PATH = AUTO_DIR_PATH + "dsl/";
	
	public File dynamicFolder;
	private void dynamicFolder() {
		File f = new File(DYNAMIC_DIR_PATH);
		//if the dir doesnt exist, make it
		if(!f.exists()) {
			f.mkdirs();
		}
		dynamicFolder = f;
	}
	
	public File dslFolder;
	private void dslFolder() {
		File f = new File(DSL_DIR_PATH);
		//if the dir doesnt exist, make it
		if(!f.exists()) {
			f.mkdirs();
		}
		dslFolder = f;
	}
}
