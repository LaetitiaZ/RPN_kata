package td1;

import java.util.Arrays;
import java.util.List;

public class RPN {

    private final List<Integer> stacks;
    private final List<String> operands = Arrays.asList("+", "-", "/", "*");

    public RPN(List<Integer> stacks) {
        this.stacks = stacks;
    }

    public List<Integer> evaluate(String sequence) {
        String[] s = sequence.split(" ");
        int number = Integer.parseInt(s[0]);
        stacks.add(number);

        checkSequenceFormat(s);

        if(s.length > 1)  {
            String operand;
            if (operands.contains(s[1])) {
                operand = s[1];
            }
            else {
                int secondNumber = Integer.parseInt(s[1]);
                stacks.add(secondNumber);
                operand = s[2];
            }

            stacks.add(calculate(operand));
            return stacks;
        }
        return stacks;
    }

    private Integer removeAndReturnLastElement() {
        return stacks.remove(stacks.size() - 1);
    }

    private void checkSequenceFormat(String[] s) {
        if(s.length > 3) {
            throw new IllegalArgumentException("Too many arguments");
        }
    }

    private int calculate(String operand) {

        int second = removeAndReturnLastElement();
        int first = removeAndReturnLastElement();

        switch (operand) {
            case "+":
                return first + second;
            case "/":
                return first / second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            default:
                throw new IllegalArgumentException("Not a recognized operand");
        }
    }
}
