package resequencer;

import java.util.List;

public class Region {
    String Name;
    String BeginPattern;
    String EndPattern;
    List<Operation> Operations;

    public Region(String name, String beginPattern, String endPattern, List<Operation> operations) {
        Name = name;
        BeginPattern = beginPattern;
        EndPattern = endPattern;
        Operations = operations;
    }
}
