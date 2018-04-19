package robot.autonomous.dynamic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class AutoLogger {
	
	private BufferedWriter write;
	private RobotControl robotControl;
	private String autoName;

	//make with a robotControl object and a autoName
	public AutoLogger(RobotControl robotControl, String autoName) {
		this.robotControl = robotControl;
		this.autoName = autoName;
	}
	
	//return true if successful
	public boolean open() {
		try 
		{
			write = new BufferedWriter(new PrintWriter(AutoFileUtil.getInstance().getAutoFileName(autoName)));
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//return true if successful
	public boolean close() {
		try 
		{
			write.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	//called every cycle, write the current values to the log
	//this just calls the log fucntion of the robotControl to get the values in the proper format, then writes it to the file
	//return false if error occurs
	public boolean log() {
		
		//get values
		String values = robotControl.log();
		
		try 
		{
			//write to file
			write.write(values);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		
		//no error found
		return true;
	}
}
