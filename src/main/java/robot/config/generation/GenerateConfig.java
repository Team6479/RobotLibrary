package robot.config.generation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.squareup.javapoet.JavaFile;

import robot.config.parser.ConfigParser;
import robot.config.tree.Robot;

//genrate robot map from the config
public class GenerateConfig {

	//use string args from command line
	public static void main(String[] args) {
		//define arguemnts
		Options options = new Options();
		Option helpOpt = Option.builder("h")
				.desc("help")
				.required(false)
				.build();
		Option packageOpt = Option.builder("p")
				.desc("package")
				.required(false)
				.numberOfArgs(1)
				.build();
		Option outputOpt = Option.builder("o")
				.desc("output directory")
				.required(false)
				.numberOfArgs(1)
				.build();
		Option xmlOpt = Option.builder("x")
				.desc("xml file")
				.required(false)
				.numberOfArgs(1)
				.build();

		options.addOption(helpOpt);
		options.addOption(packageOpt);
		options.addOption(outputOpt);
		options.addOption(xmlOpt);

		String packageName = "";
		String outputDirectory = "";
		String fileToParse = "";
		
		try {
			//parse
			CommandLineParser parser = new DefaultParser();
			CommandLine cmdLine = parser.parse(options, args);

			if (cmdLine != null) 
			{
				if(cmdLine.getOptions().length == 0) {
					throw new IllegalArgumentException("No options specified. Try using '-h'");
				}
				if(cmdLine.hasOption("h")) 
				{
					System.out.println("Help");
					for(Option opt : options.getOptions()) {
						System.out.printf("%s\t\t%s\n", opt.getOpt(), opt.getDescription());
					}
					System.exit(0);
				}
				if(cmdLine.hasOption("p")) 
				{
					packageName = cmdLine.getOptionValue("p");
				}
				if(cmdLine.hasOption("o")) 
				{
					outputDirectory = cmdLine.getOptionValue("o");
				}
				if(cmdLine.hasOption("x")) {
					fileToParse = cmdLine.getOptionValue("x");
				}
			} 
			else 
			{
				throw new IllegalArgumentException("Unknown option. Try using '-h'");
			}
		}
		catch (ParseException e) {
			System.out.println(e.getMessage());
			System.out.println("Try '-h' for details");
			System.exit(1);
		}
		
		Robot parsedXml = ConfigParser.parseXML(new File(fileToParse));
		JavaFile robotMapBase = ConfigParser.generateJavaFile(parsedXml, packageName);
		
		try {
			robotMapBase.writeTo(new File(outputDirectory));
		}
		catch (IOException e) {
			System.out.println("Unable to write to output");
			System.exit(1);
		}
		
		System.exit(0);
	}

	public static void help() {
		System.out.println("");
	}

}
