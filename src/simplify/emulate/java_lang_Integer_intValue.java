package simplify.emulate;

import simplify.exec.MethodExecutionContext;
import simplify.exec.RegisterStore;
import simplify.exec.UnknownValue;

public class java_lang_Integer_intValue implements EmulatedMethod {

    public void execute(MethodExecutionContext ectx) {
        int paramStart = ectx.getParameterStart();
        RegisterStore thiz = ectx.peekRegister(paramStart);

        if (thiz.getValue() instanceof UnknownValue) {
            ectx.setReturnRegister(new RegisterStore("I", new UnknownValue()));
            return;
        }

        Integer value = (Integer) thiz.getValue();
        RegisterStore result = new RegisterStore("I", value.intValue());
        ectx.setReturnRegister(result);
    }

}
