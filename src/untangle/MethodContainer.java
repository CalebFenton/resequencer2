package untangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MethodContainer {
	
	private HashMap<String, Method> methods;
	private Set<String> modifiedMethods;
	
	public MethodContainer() {
		modifiedMethods = new HashSet<String>();
	}
	
	// returns null if no more instructions
	public String getLine(String signature, int line) {
		return null;
	}
	
	public String getParentFile(String signature) {
		return methods.get(signature).getParentFile();
	}
	
	public Set<String> getModifiedMethods() {
		return modifiedMethods;
	}
	
	public Set<String> getMethodSignatures() {
		return methods.keySet();
	}
	
	public void setLine(String signature, int line, String value) {
		methods.get(signature).setLine(line, value);
	}
	
	public void removeLine(String signature, int line) {
		methods.get(signature).removeLine(line);
	}
	
	public void addMethod(String signature, String parentFile, List<String> lines) {
		Method m = new Method(parentFile, lines);
		methods.put(signature, m);
	}

}
