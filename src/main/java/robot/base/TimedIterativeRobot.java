package robot.base;

import edu.wpi.first.wpilibj.IterativeRobotBase;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tInstances;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.hal.HAL;

//class to switch between Timed and Iterative
public class TimedIterativeRobot extends IterativeRobotBase 
{

	public TimedIterativeRobot()
	{
		HAL.report(tResourceType.kResourceType_Framework, tInstances.kFramework_Iterative);
	}

	@Override
	public void startCompetition() {

		robotInit();

		// Tell the DS that the robot is ready to be enabled
		HAL.observeUserProgramStarting();


		
		//loop control
		while(true) {

			//if in timed mode, start the loop
			if(currentMode == RobotMode.Timed) {
				
				//if the mode has changed, start the loop
				if(modeChanged) {
				// Loop forever, calling the appropriate mode-dependent function
				m_startLoop = true;
				m_loop.startPeriodic(m_period);
				
				//responded to change event, false
				modeChanged = false;
				}
			}
			//if in iterative mode
			else {
				//if the mode changed to iterative, need to stop timer
				if(modeChanged) {
					m_startLoop = false;
					m_loop.stop();
					
					//responded to change event, false
					modeChanged = false;
				}
				// Wait for new data to arrive
				m_ds.waitForData();
				loopFunc();
			}
		}
	}
	
	private 	boolean modeChanged = true;

	enum RobotMode {
		Timed, Iterative;
	}
	private RobotMode currentMode = RobotMode.Iterative;
	public RobotMode getCurrentMode() {
		return currentMode;
	}
	public void setCurrentMode(RobotMode currentMode) {
		modeChanged = true;
		this.currentMode = currentMode;
	}

	//TIMED
	public static final double DEFAULT_PERIOD = 0.02;

	private double m_period = DEFAULT_PERIOD;

	// Prevents loop from starting if user calls setPeriod() in robotInit()
	private boolean m_startLoop = false;

	private Notifier m_loop = new Notifier(() -> {
		loopFunc();
	});
	public void setPeriod(double period) {
		m_period = period;

		//if in iteratve mdoe, do not call, return
		if(currentMode == RobotMode.Iterative) {
			return;
		}

		//if the loop has started, restart with new time
		if (m_startLoop) {
			m_loop.startPeriodic(m_period);
		}
	}


	//iterative
}
