package simplify.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.OffsetInstruction;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.instruction.SwitchPayload;
import org.jf.dexlib2.iface.instruction.TwoRegisterInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction11n;
import org.jf.dexlib2.iface.instruction.formats.Instruction11x;
import org.jf.dexlib2.iface.instruction.formats.Instruction12x;
import org.jf.dexlib2.iface.instruction.formats.Instruction21c;
import org.jf.dexlib2.iface.instruction.formats.Instruction21s;
import org.jf.dexlib2.iface.instruction.formats.Instruction21t;
import org.jf.dexlib2.iface.instruction.formats.Instruction22b;
import org.jf.dexlib2.iface.instruction.formats.Instruction22s;
import org.jf.dexlib2.iface.instruction.formats.Instruction22t;
import org.jf.dexlib2.iface.instruction.formats.Instruction23x;
import org.jf.dexlib2.iface.reference.StringReference;

import simplify.Simplifier;
import simplify.graph.InstructionNode;

public class InstructionExecutor {

    private static final Logger log = Logger.getLogger(Simplifier.class.getSimpleName());

    private static final int NEXT_INSTRUCTION = -1;

    public InstructionExecutor() {
        // TODO Auto-generated constructor stub
    }

    public static List<Integer> execute(InstructionNode node) {
        log.fine("Executing instruction: " + node);

        List<Integer> childOffsets = new ArrayList<Integer>();

        BuilderInstruction instruction = node.getInstruction();
        ExecutionContext ectx = node.getContext();
        int index = instruction.getLocation().getIndex();

        boolean handled = false;
        int[] offsets;
        switch (instruction.getOpcode()) {
        case ADD_DOUBLE:
            break;
        case ADD_DOUBLE_2ADDR:
            break;
        case ADD_FLOAT:
            break;
        case ADD_FLOAT_2ADDR:
            break;
        case ADD_INT:
            handle_ADD_INT(ectx, (Instruction23x) instruction, index);
            handled = true;
            break;
        case ADD_INT_2ADDR:
            handle_ADD_INT_2ADDR(ectx, (Instruction12x) instruction, index);
            handled = true;
            break;
        case ADD_INT_LIT16:
            handle_ADD_INT_LIT16(ectx, (Instruction22s) instruction, index);
            handled = true;
            break;
        case ADD_INT_LIT8:
            handle_ADD_INT_LIT8(ectx, (Instruction22b) instruction, index);
            handled = true;
            break;
        case ADD_LONG:
            break;
        case ADD_LONG_2ADDR:
            break;
        case AGET:
            break;
        case AGET_BOOLEAN:
            break;
        case AGET_BYTE:
            break;
        case AGET_CHAR:
            break;
        case AGET_OBJECT:
            break;
        case AGET_SHORT:
            break;
        case AGET_WIDE:
            break;
        case AND_INT:
            break;
        case AND_INT_2ADDR:
            break;
        case AND_INT_LIT16:
            break;
        case AND_INT_LIT8:
            break;
        case AND_LONG:
            break;
        case AND_LONG_2ADDR:
            break;
        case APUT:
            break;
        case APUT_BOOLEAN:
            break;
        case APUT_BYTE:
            break;
        case APUT_CHAR:
            break;
        case APUT_OBJECT:
            break;
        case APUT_SHORT:
            break;
        case APUT_WIDE:
            break;
        case ARRAY_LENGTH:
            break;
        case ARRAY_PAYLOAD:
            break;
        case CHECK_CAST:
            break;
        case CMPG_DOUBLE:
            break;
        case CMPG_FLOAT:
            break;
        case CMPL_DOUBLE:
            break;
        case CMPL_FLOAT:
            break;
        case CMP_LONG:
            break;
        case CONST:
            break;
        case CONST_16:
            handle_CONST_16(ectx, (Instruction21s) instruction, index);
            handled = true;
            break;
        case CONST_4:
            handle_CONST_4(ectx, (Instruction11n) instruction, index);
            handled = true;
            break;
        case CONST_CLASS:
            break;
        case CONST_HIGH16:
            break;
        case CONST_STRING:
            handle_CONST_STRING(ectx, (Instruction21c) instruction, index);
            handled = true;
        case CONST_STRING_JUMBO:
            break;
        case CONST_WIDE:
            break;
        case CONST_WIDE_16:
            break;
        case CONST_WIDE_32:
            break;
        case CONST_WIDE_HIGH16:
            break;
        case DIV_DOUBLE:
            break;
        case DIV_DOUBLE_2ADDR:
            break;
        case DIV_FLOAT:
            break;
        case DIV_FLOAT_2ADDR:
            break;
        case DIV_INT:
            break;
        case DIV_INT_2ADDR:
            break;
        case DIV_INT_LIT16:
            break;
        case DIV_INT_LIT8:
            break;
        case DIV_LONG:
            break;
        case DIV_LONG_2ADDR:
            break;
        case DOUBLE_TO_FLOAT:
            break;
        case DOUBLE_TO_INT:
            break;
        case DOUBLE_TO_LONG:
            break;
        case FILLED_NEW_ARRAY:
            break;
        case FILLED_NEW_ARRAY_RANGE:
            break;
        case FILL_ARRAY_DATA:
            break;
        case FLOAT_TO_DOUBLE:
            break;
        case FLOAT_TO_INT:
            break;
        case FLOAT_TO_LONG:
            break;
        case GOTO:
        case GOTO_16:
        case GOTO_32:
            childOffsets.add(handle_GOTO(instruction));
            handled = true;
            break;
        case IF_EQ:
        case IF_GE:
        case IF_GT:
        case IF_LE:
        case IF_LT:
        case IF_NE:
            offsets = handle_IF(ectx, (Instruction22t) instruction, index);
            for (int offset : offsets) {
                childOffsets.add(offset);
            }
            handled = true;
            break;
        case IF_EQZ:
        case IF_GEZ:
        case IF_GTZ:
        case IF_LEZ:
        case IF_LTZ:
        case IF_NEZ:
            offsets = handle_IFZ(ectx, (Instruction21t) instruction, index);
            for (int offset : offsets) {
                childOffsets.add(offset);
            }
            handled = true;
            break;
        case IGET:
            break;
        case IGET_BOOLEAN:
            break;
        case IGET_BYTE:
            break;
        case IGET_CHAR:
            break;
        case IGET_OBJECT:
            break;
        case IGET_SHORT:
            break;
        case IGET_WIDE:
            break;
        case INSTANCE_OF:
            break;
        case INT_TO_BYTE:
            break;
        case INT_TO_CHAR:
            break;
        case INT_TO_DOUBLE:
            break;
        case INT_TO_FLOAT:
            break;
        case INT_TO_LONG:
            break;
        case INT_TO_SHORT:
            break;
        case INVOKE_DIRECT:
            break;
        case INVOKE_DIRECT_RANGE:
            break;
        case INVOKE_INTERFACE:
            break;
        case INVOKE_INTERFACE_RANGE:
            break;
        case INVOKE_STATIC:
            break;
        case INVOKE_STATIC_RANGE:
            break;
        case INVOKE_SUPER:
            break;
        case INVOKE_SUPER_RANGE:
            break;
        case INVOKE_VIRTUAL:
            break;
        case INVOKE_VIRTUAL_RANGE:
            break;
        case IPUT:
            break;
        case IPUT_BOOLEAN:
            break;
        case IPUT_BYTE:
            break;
        case IPUT_CHAR:
            break;
        case IPUT_OBJECT:
            break;
        case IPUT_SHORT:
            break;
        case IPUT_WIDE:
            break;
        case LONG_TO_DOUBLE:
            break;
        case LONG_TO_FLOAT:
            break;
        case LONG_TO_INT:
            break;
        case MONITOR_ENTER:
            break;
        case MONITOR_EXIT:
            break;
        case MOVE:
        case MOVE_16:
        case MOVE_FROM16:
        case MOVE_OBJECT:
        case MOVE_OBJECT_16:
        case MOVE_OBJECT_FROM16:
        case MOVE_WIDE:
        case MOVE_WIDE_16:
        case MOVE_WIDE_FROM16:
            handle_MOVE(ectx, (TwoRegisterInstruction) instruction, index);
            handled = true;
            break;
        case MOVE_EXCEPTION:
            break;
        case MOVE_RESULT:
        case MOVE_RESULT_OBJECT:
        case MOVE_RESULT_WIDE:
            break;
        case MUL_DOUBLE:
            break;
        case MUL_DOUBLE_2ADDR:
            break;
        case MUL_FLOAT:
            break;
        case MUL_FLOAT_2ADDR:
            break;
        case MUL_INT:
            break;
        case MUL_INT_2ADDR:
            break;
        case MUL_INT_LIT16:
            break;
        case MUL_INT_LIT8:
            break;
        case MUL_LONG:
            break;
        case MUL_LONG_2ADDR:
            break;
        case NEG_DOUBLE:
            break;
        case NEG_FLOAT:
            break;
        case NEG_INT:
            break;
        case NEG_LONG:
            break;
        case NEW_ARRAY:
            break;
        case NEW_INSTANCE:
            break;
        case NOP:
            break;
        case NOT_INT:
            break;
        case NOT_LONG:
            break;
        case OR_INT:
            break;
        case OR_INT_2ADDR:
            break;
        case OR_INT_LIT16:
            break;
        case OR_INT_LIT8:
            break;
        case OR_LONG:
            break;
        case OR_LONG_2ADDR:
            break;
        case PACKED_SWITCH:
            break;
        case PACKED_SWITCH_PAYLOAD:
            break;
        case REM_DOUBLE:
            break;
        case REM_DOUBLE_2ADDR:
            break;
        case REM_FLOAT:
            break;
        case REM_FLOAT_2ADDR:
            break;
        case REM_INT:
            break;
        case REM_INT_2ADDR:
            break;
        case REM_INT_LIT16:
            break;
        case REM_INT_LIT8:
            break;
        case REM_LONG:
            break;
        case REM_LONG_2ADDR:
            break;
        case RETURN:
        case RETURN_WIDE:
        case RETURN_OBJECT:
            handle_RETURN(ectx, (Instruction11x) instruction, index);
            break;
        case RETURN_VOID:
            handled = true;
            break;
        case RSUB_INT:
            break;
        case RSUB_INT_LIT8:
            break;
        case SGET:
            break;
        case SGET_BOOLEAN:
            break;
        case SGET_BYTE:
            break;
        case SGET_CHAR:
            break;
        case SGET_OBJECT:
            break;
        case SGET_SHORT:
            break;
        case SGET_WIDE:
            break;
        case SHL_INT:
            break;
        case SHL_INT_2ADDR:
            break;
        case SHL_INT_LIT8:
            break;
        case SHL_LONG:
            break;
        case SHL_LONG_2ADDR:
            break;
        case SHR_INT:
            break;
        case SHR_INT_2ADDR:
            break;
        case SHR_INT_LIT8:
            break;
        case SHR_LONG:
            break;
        case SHR_LONG_2ADDR:
            break;
        case SPARSE_SWITCH:
            break;
        case SPARSE_SWITCH_PAYLOAD:
            break;
        case SPUT:
            break;
        case SPUT_BOOLEAN:
            break;
        case SPUT_BYTE:
            break;
        case SPUT_CHAR:
            break;
        case SPUT_OBJECT:
            break;
        case SPUT_SHORT:
            break;
        case SPUT_WIDE:
            break;
        case SUB_DOUBLE:
            break;
        case SUB_DOUBLE_2ADDR:
            break;
        case SUB_FLOAT:
            break;
        case SUB_FLOAT_2ADDR:
            break;
        case SUB_INT:
            break;
        case SUB_INT_2ADDR:
            break;
        case SUB_LONG:
            break;
        case SUB_LONG_2ADDR:
            break;
        case THROW:
            break;
        case USHR_INT:
            break;
        case USHR_INT_2ADDR:
            break;
        case USHR_INT_LIT8:
            break;
        case USHR_LONG:
            break;
        case USHR_LONG_2ADDR:
            break;
        case XOR_INT:
            break;
        case XOR_INT_2ADDR:
            break;
        case XOR_INT_LIT16:
            break;
        case XOR_INT_LIT8:
            break;
        case XOR_LONG:
            break;
        case XOR_LONG_2ADDR:
            break;
        default:
            break;

        }

        if (instruction.getOpcode().canContinue() && (childOffsets.size() == 0)) {
            childOffsets.add(NEXT_INSTRUCTION);
        }

        if (!handled) {
            // TODO: actually implement this

            if (instruction instanceof OffsetInstruction) {
                int branchOffset = ((OffsetInstruction) instruction).getCodeOffset();
                int codeAddress = instruction.getLocation().getCodeAddress();
                childOffsets.add(codeAddress + branchOffset);
            } else if (instruction instanceof SwitchPayload) {
                List<? extends SwitchElement> elements = ((SwitchPayload) instruction).getSwitchElements();
                for (SwitchElement element : elements) {
                    childOffsets.add(element.getOffset());
                }
            }
        }

        return childOffsets;
    }

    private static int handle_GOTO(BuilderInstruction instruction) {
        int codeAddress = instruction.getLocation().getCodeAddress();
        int branchOffset = ((OffsetInstruction) instruction).getCodeOffset();

        return codeAddress + branchOffset;
    }

    private static void handle_CONST_16(ExecutionContext ectx, Instruction21s instruction, int index) {
        ectx.addRegister(instruction.getRegisterA(), "I", instruction.getNarrowLiteral(), index);
    }

    private static void handle_CONST_4(ExecutionContext ectx, Instruction11n instruction, int index) {
        ectx.addRegister(instruction.getRegisterA(), "I", instruction.getNarrowLiteral(), index);
    }

    private static void handle_CONST_STRING(ExecutionContext ectx, Instruction21c instruction, int index) {
        StringReference stringRef = (StringReference) instruction.getReference();
        ectx.addRegister(instruction.getRegisterA(), "java.lang.String", stringRef.getString(), index);
    }

    private static void handle_ADD_INT(ExecutionContext ectx, Instruction23x instruction, int index) {
        Object B = ectx.getRegisterValue(instruction.getRegisterB(), index);
        Object C = ectx.getRegisterValue(instruction.getRegisterC(), index);
        if ((B instanceof UnknownValue) || (C instanceof UnknownValue)) {
            ectx.updateOrAddRegister(instruction.getRegisterA(), "I", new UnknownValue(), index);
        } else {
            ectx.updateOrAddRegister(instruction.getRegisterA(), "I", (Integer) B + (Integer) C, index);
        }
    }

    private static void handle_ADD_INT_2ADDR(ExecutionContext ectx, Instruction12x instruction, int index) {
        Integer A = (Integer) ectx.getRegisterValue(instruction.getRegisterA(), index);
        Integer B = (Integer) ectx.getRegisterValue(instruction.getRegisterB(), index);
        ectx.updateOrAddRegister(instruction.getRegisterA(), "I", A + B, index);
    }

    private static void handle_ADD_INT_LIT16(ExecutionContext ectx, Instruction22s instruction, int index) {
        Integer B = (Integer) ectx.getRegisterValue(instruction.getRegisterB(), index);
        int C = instruction.getNarrowLiteral();
        ectx.updateOrAddRegister(instruction.getRegisterA(), "I", B + C, index);
    }

    private static void handle_ADD_INT_LIT8(ExecutionContext ectx, Instruction22b instruction, int index) {
        Integer B = (Integer) ectx.getRegisterValue(instruction.getRegisterB(), index);
        int C = instruction.getNarrowLiteral();
        ectx.updateOrAddRegister(instruction.getRegisterA(), "I", B + C, index);
    }

    private static void handle_RETURN(ExecutionContext ectx, Instruction11x instruction, int index) {
        ectx.setReturnRegister(instruction.getRegisterA(), index);
    }

    private static void handle_MOVE(ExecutionContext ectx, TwoRegisterInstruction instruction, int index) {
        ectx.addRegister(instruction.getRegisterA(), ectx.getRegister(instruction.getRegisterB(), index));
    }

    private static int[] handle_IF(ExecutionContext ectx, Instruction22t instruction, int index) {
        Object A = ectx.getRegisterValue(instruction.getRegisterA(), index);
        Object B = ectx.getRegisterValue(instruction.getRegisterB(), index);

        int codeAddress = ((BuilderInstruction) instruction).getLocation().getCodeAddress();
        int branchOffset = ((OffsetInstruction) instruction).getCodeOffset();
        int targetAddress = codeAddress + branchOffset;

        if ((A instanceof UnknownValue) || (B instanceof UnknownValue)) {
            return new int[] { targetAddress, -1 };
        }

        int cmp = CompareToBuilder.reflectionCompare(A, B);
        System.out.println("comparing: " + A + " vs " + B + " = " + cmp);
        String ifType = instruction.getOpcode().name;
        int result[] = new int[1];
        if (ifType.endsWith("eq")) {
            result[0] = cmp == 0 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("ne")) {
            result[0] = cmp != 0 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("lt")) {
            result[0] = cmp == -1 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("ge")) {
            result[0] = cmp >= 0 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("gt")) {
            result[0] = cmp == 1 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("le")) {
            result[0] = cmp == -1 ? targetAddress : NEXT_INSTRUCTION;
        }

        return result;
    }

    private static int[] handle_IFZ(ExecutionContext ectx, Instruction21t instruction, int index) {
        // ASSUME: *z if's are always integers..
        Object registerA = ectx.getRegisterValue(instruction.getRegisterA(), index);

        int codeAddress = ((BuilderInstruction) instruction).getLocation().getCodeAddress();
        int branchOffset = ((OffsetInstruction) instruction).getCodeOffset();
        int targetAddress = codeAddress + branchOffset;

        if (registerA instanceof UnknownValue) {
            return new int[] { targetAddress, NEXT_INSTRUCTION };
        }

        Integer A = (Integer) registerA;
        String ifType = instruction.getOpcode().name;
        int[] result = new int[1];
        if (ifType.endsWith("eqz")) {
            result[0] = A == 0 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("nez")) {
            result[0] = A != 0 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("ltz")) {
            result[0] = A < 0 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("gez")) {
            result[0] = A >= 0 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("gtz")) {
            result[0] = A > 0 ? targetAddress : NEXT_INSTRUCTION;
        } else if (ifType.endsWith("lez")) {
            result[0] = A <= 0 ? targetAddress : NEXT_INSTRUCTION;
        }

        return result;
    }

}
