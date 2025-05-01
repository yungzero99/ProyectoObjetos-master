package es.makigas.ModeracionAula.run;

import org.openxava.util.*;

/** fghjkklk
 * Execute this class to start the application.
 *
 * With OpenXava Studio/
 * Eclipse: Right mouse button > Run As > Java Application
 *
 */

public class ModeracionAula {

	public static void main(String[] args) throws Exception {
		//DBServer.start("ModeracionAula-db"); // To use your own database comment this line and configure src/main/webapp/META-INF/context.xml
		AppServer.run("ModeracionAula"); // Use AppServer.run("") to run in root context
	}

}
