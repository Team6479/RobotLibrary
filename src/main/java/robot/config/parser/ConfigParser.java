package robot.config.parser;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.squareup.javapoet.*;
import com.squareup.javapoet.TypeSpec.Builder;

import robot.config.tree.Component;
import robot.config.tree.DoubleSolenoid;
import robot.config.tree.Motor;
import robot.config.tree.Robot;
import robot.config.tree.Solenoid;
import robot.config.tree.Subsystem;

public class ConfigParser {
	
	//static method to parse and return a robot object
	public static Robot parseXML(File xml) {
		try 
        {	
        		//read the xml
    			SAXReader reader = new SAXReader();
			Document document = reader.read(xml);
			
			//get all subsystems
			List<Node> subsystemNodes = document.selectNodes("/robot/subsystem");
			Map<String, Subsystem> subsystems = new HashMap<String, Subsystem>();
			for(Node node: subsystemNodes) {
				Subsystem sub = new Subsystem(node);
				subsystems.put(sub.getId(), sub);
			}
			//make a robot
			Robot robot = new Robot(subsystems);
			return robot;

		}
		catch(DocumentException e)
        {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//static method to parse a Robot object to a java class
	public static JavaFile generateJavaFile(Robot robot, String packageDec) {
		
		
		//make the class builder
		Builder robotMapBaseBuilder = TypeSpec.classBuilder("RobotMapBase")
				.addModifiers(Modifier.PUBLIC);
		
		//run a loop through the components
		for(Subsystem subsystem : robot.getSubsystems().values()) {
			for(Component component : subsystem.getComponents().values()) {
				
				//get the specfic compoennt
				if(component instanceof Motor) {
					Motor motor = (Motor)component;
					FieldSpec field = FieldSpec.builder(int.class, motor.getVariableName())
							.addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
							.initializer("$L", motor.getPort())
							.build();
					robotMapBaseBuilder.addField(field);
				}
				else if(component instanceof Solenoid) {
					Solenoid solenoid = (Solenoid)component;
					FieldSpec field = FieldSpec.builder(int.class, solenoid.getVariableName())
							.addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
							.initializer("$L", solenoid.getPort())
							.build();
					robotMapBaseBuilder.addField(field);
				}
				else if(component instanceof DoubleSolenoid) {
					DoubleSolenoid dsolenoid = (DoubleSolenoid)component;
					FieldSpec field1 = FieldSpec.builder(int.class, dsolenoid.getVariableName() + "On")
							.addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
							.initializer("$L", dsolenoid.getPortOn())
							.build();
					robotMapBaseBuilder.addField(field1);
					
					FieldSpec field2 = FieldSpec.builder(int.class, dsolenoid.getVariableName() + "On")
							.addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
							.initializer("$L", dsolenoid.getPortOff())
							.build();
					robotMapBaseBuilder.addField(field2);
				}
				
			}
		}
		
		TypeSpec robotMapBaseClass = robotMapBaseBuilder.build();
		
		JavaFile robotMapBase = JavaFile.builder(packageDec, robotMapBaseClass).build();
		
		return robotMapBase;
	}
}
