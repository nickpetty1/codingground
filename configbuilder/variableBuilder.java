import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class variableBuilder {

	public static void main(String[] args) throws IOException {
		config config = new config();
		config.openConfig("6513.txt","output.txt", false);
		config.findVariables();
		config.buildTemplate("6513.txt","template.txt");
		
		//config.buildConfig("template.txt", "config1.txt")
	}
	
	public static class config {
		public BufferedReader in;
		public BufferedReader readOut;
		public Writer out;
		
		public config (){
			in = null;
			out = null;
			readOut = null;
		}
		
		public void openConfig(String fileIn, String fileOut, Boolean ow) throws IOException {
			File input = new File(fileIn);
			FileOutputStream output = new FileOutputStream(fileOut, ow);
			this.in = new BufferedReader(new FileReader(input));
			this.out = new BufferedWriter(new OutputStreamWriter(output));
			File readOutput = new File(fileOut);
			this.readOut = new BufferedReader(new FileReader(readOutput));
		}
		
		public void findVariables() throws IOException {
			String line = null;
			while ((line = this.in.readLine()) != null) {
				if(line.startsWith("hostname ")){
					System.out.println(line.substring(9, line.length()));
					this.out.write(line.substring(9, line.length()) + '\n');
					//this.out.write("\n");
				}else if(line.startsWith("interface ")) {
					System.out.println(line.substring(10,line.length()));
					this.out.write(line.substring(10,line.length()) + '\n');
					do {
						line = this.in.readLine();
						if(line.startsWith(" description")){
							System.out.println(line);
							this.out.write(line.substring(13,line.length()) + '\n');
						}else if (line.startsWith(" ip address ")){
							System.out.println(line);
							this.out.write(line.substring(12,line.length()) + '\n');
						} else if(line.startsWith(" switchport access ")){
							System.out.println(line);
							this.out.write(line.substring(19,line.length()) + '\n');
						} else if(line.contains("trunk")){
							System.out.println(line);
							this.out.write("trunk" + '\n');
						}
						if (line.startsWith(" shutdown")){
							System.out.println(line);
							this.out.write("shutdown" + '\n');
						}
					}while(line.startsWith(" "));
				} 
			this.out.flush();
			}
		}
		
		public void buildTemplate(String outputFile, String templateFile) throws IOException {
		    File config = new File(outputFile);
		    FileOutputStream template = new FileOutputStream(templateFile, false);
		    BufferedReader configIn = new BufferedReader(new FileReader(outputFile));
		    Writer configOut = new BufferedWriter(new OutputStreamWriter(template));
		    
		    String line = null;
			while ((line = configIn.readLine()) != null) {
				if(line.startsWith("hostname ")){
					System.out.println("hostname %HOSTNAME%");
					configOut.write("hostname %hostname%" + '\n');
				}else if(line.startsWith("interface ")) {
					System.out.println("interface %INTERFACE%");
					configOut.write("interface %INTERFACE%" + '\n');
					do {
						line = configIn.readLine();
						if(line.startsWith(" description")){
							System.out.println("description %DESCRIPTION%");
							configOut.write(" description %DESCRIPTION%" + '\n');
						}else if (line.startsWith(" ip address ")){
							System.out.println(" ip address %IP_ADDRESS%");
							configOut.write(" ip address %IP_ADDRESS%" + '\n');
						} else if(line.startsWith(" switchport access ")){
							System.out.println(" switchport access vlan %VLAN%");
							configOut.write(" switchport access vlan %VLAN%" + '\n');
						} else if(line.contains("trunk")){
							System.out.println("trunk");
							configOut.write(" switchport mode trunk" + '\n');
						} else{
						    configOut.write(line + '\n');
						}
					}while(line.startsWith(" "));
				} else{
				    configOut.write(line + '\n');
				}
			configOut.flush();
			}
		}
		
		public void buildConfig(String inputTemplate, String outputConfig) throws IOException {
		    File templateFile = new File(inputTemplate);
		    FileOutputStream newConfigFile = new FileOutputStream(outputConfig, false);
		    BufferedReader template = new BufferedReader(new FileReader(templateFile));
		    Writer newConfig = new BufferedWriter(new OutputStreamWriter(newConfigFile));
		    
		    //Still thinking of best way to store the variables so that building the template is dynamic
		    //Go directly from existing config to file?
		    // - may not have existing config
		    //Build spreadsheet with configs and then pull from that to template
		    // - would allow to fill in variables manually in to spreadsheet
		    
		}
		
		//TODO public void vlanMapping
		    //build spreadsheet with a switchport to vlan mapping
		
		//TODO public void remoteGather
		    //ssh to a device or devices and gather variables or build template
		    //Stream show run directly though the other methods? or do I need to copy to local file first?
		
		//TODO public void cliInput
		    //make a CLI input to allow user to control flow
		
		//TODO create a GUI to use program
	}
}
