package robot.autonomous.dynamic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//playback the autonomous rotuine specidefiec by the file
public class AutoPlayback {
	
	private RobotControl robotControl;
	private BufferedReader read;
	private String autoName;
	
	//make with a robotControl object and a autoName
	public AutoPlayback(RobotControl robotControl, String autoName) {
		this.robotControl = robotControl;
		this.autoName = autoName;
	}
	
	//return true if successful
	public boolean open() {
		try 
		{
			read = new BufferedReader(new FileReader(AutoFileUtil.getInstance().getAutoFileName(autoName)));
			
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
			read.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	//called every cycle, reads the log and gets the value of the speed controller and sets the speed controller to it
	//returns false when end of file is reached, or when error is encounterred
	public boolean run() {
		
		//store read in speeds here
		String input = "";
		boolean endOfLine = false;
		while(!endOfLine) {
			int next;
			try {
				next = read.read();
			} catch (IOException e) {
				e.printStackTrace();
				//if there was a IO error, end auto routine immediately
				return false;
			}
			//10 is ascii for \n
			//if next char is a new line, end the cycle and calculate speed, otherwise keep adding the characters to input
			if(next == '\n') {
				endOfLine = true;
			}
			//if end of file, return false
			else if(next == -1)	{
				return false;
			}
			else {
				input += (char)next;
			}
		}
		
		//send the input to the robotControl
		robotControl.set(input);
		
		return true;
	}
}
