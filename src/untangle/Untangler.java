package untangle;

import java.util.List;

public class Untangler {
	
	public static void main(String[] argv) {
		MethodContainer container = MethodParser.parse(getSmaliFiles());
		
		Executor exec = new Executor(container);
		exec.execute();
		
		MethodSaver.saveMethods(container);
	}

	private static List<String> getSmaliFiles() {
		return null;
	}
}
