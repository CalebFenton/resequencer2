package simplify.emulate;

import simplify.exec.ExecutionContext;

public class java_lang_Integer_init implements EmulatedVirtualMethod {
    public void execute(ExecutionContext ectx) {
        int paramStart = ectx.getParameterStart();
        System.out.println("init! : " + paramStart);
        Object value = ectx.peekRegisterValue(paramStart + 1);
        ectx.updateOrAddRegister(paramStart, "java.lang.Integer", value, 0);
    }
}