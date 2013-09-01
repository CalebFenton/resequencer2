package resequencer;

public class Operation {
    public enum OperationType {
        MATCH,
        FIND,
        INSERT,
        REPLACE
    }

    OperationType Type;
    String Name;
    String BeforeOp;
    String InsideOp;
    String AfterOp;
    String Value;
    String OldValue; // Only used for REPLACE

    public Operation(OperationType type, String name, String value) {
        this(type, name, null, null, null, value, null);
    }

    public Operation(OperationType type, String name, String beforeOp, String insideOp, String afterOp, String value,
                    String oldValue) {
        Type = type;
        Name = name;
        BeforeOp = beforeOp;
        InsideOp = insideOp;
        AfterOp = afterOp;
        Value = value;
        OldValue = oldValue;
    }
}
