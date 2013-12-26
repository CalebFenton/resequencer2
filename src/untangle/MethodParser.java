package untangle;

import java.util.List;

public class MethodParser {

	public static MethodContainer parse(List<String> smaliFiles) {
		MethodContainer container = new MethodContainer();
		
		for ( String smaliFile : smaliFiles ) {
			// load smali file into string
			
			// find .method's + method body
			
			// add method to container
		}
		
		return container;
	}

}