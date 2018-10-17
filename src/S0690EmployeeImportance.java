import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S0690EmployeeImportance {
    // Employee info
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        HashSet<Integer> subordinates = new HashSet<>();
        int res = employeeMap.get(id).importance;
        List<Integer> subs = employeeMap.get(id).subordinates;
        while (!subs.isEmpty()) {
            int subId = subs.remove(0);
            if (subordinates.contains(subId)) {
                continue;
            }

            res += employeeMap.get(subId).importance;
            subordinates.add(subId);
            subs.addAll(employeeMap.get(subId).subordinates);
        }
        return res;
    }
}
