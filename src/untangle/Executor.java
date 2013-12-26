package untangle;

import java.util.HashSet;
import java.util.Set;

public class Executor {
	
	private int localMaxDepth;
	private int externalMaxDepth;

	private Stack stack = new Stack();
	
	private final MethodContainer methods;
	
	public Executor(MethodContainer methods) {
		this.methods = methods;
		
		localMaxDepth = 100;
		externalMaxDepth = 100;
	}
	
	public void setLocalMaxDepth(int depth) {
		localMaxDepth = depth;
	}
	
	public void setExternalMaxDepth(int depth) {
		externalMaxDepth = depth;
	}
	
	public void execute() {
		Set<String> signatures = methods.getMethodSignatures();
		
		for ( String signature : signatures ) {
			// execute each method
		}
	}

}
