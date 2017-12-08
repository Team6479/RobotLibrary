package org.usfirst.frc.team6479.robot.custom;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//class to track button states
public class ButtonTracker extends JoystickButton {

	 static private ArrayList<ButtonTracker> allButtons = new ArrayList<ButtonTracker>();
	
	//current state
	private boolean mNow;
	//prevous state
	private boolean mLast;
	
	public ButtonTracker(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
		allButtons.add(this);
	}

	public boolean isPressed() {
		//get the value of the button
		return get();
	}

	public boolean wasJustPressed() {
		//if the button is currently pressed but was just not pressed
		return (mNow && (!mLast));
	}

	public boolean wasJustReleased() {
		//if the button is currently not pressed but was just pressed
		return (!mNow && mLast);
	}
	//reset the values for mNow and mLast
	public void update() {
		mLast = mNow;
		mNow = get();
	}
	
	//method to update all buttons
	public static void updateAll() {
		for(ButtonTracker button: allButtons) {
			button.update();
		}
	}
}
