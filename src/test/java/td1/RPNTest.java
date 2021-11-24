package td1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RPNTest {

    @Test
    void rpn_expression_containing_only_a_number_should_be_added_to_the_stack() {
        ArrayList<Integer> stacks = new ArrayList<>();
        stacks.add(3);
        stacks.add(2);

        RPN rpn = new RPN(stacks);
        assertEquals(5, rpn.evaluate("5").get(2));
    }

    @Test
    void rpn_expression_containing_two_number_and_one_operand_should_pop_out_last_two_numbers_and_add_result() {
        ArrayList<Integer> stacks = new ArrayList<>();
        RPN rpn = new RPN(stacks);

        assertEquals(5, rpn.evaluate("3 2 +").get(0));
    }

    @Test
    void rpn_expression_containing_one_number_and_addition_operand_should_pop_out_last_two_numbers_and_add_result() {
        ArrayList<Integer> stacks = new ArrayList<>();
        stacks.add(3);
        RPN rpn = new RPN(stacks);

        assertEquals(5, rpn.evaluate("2 +").get(0));
    }

    @Test
    void rpn_expression_containing_one_number_and_subtract_operand_should_pop_out_last_two_numbers_and_add_result() {
        ArrayList<Integer> stacks = new ArrayList<>();
        stacks.add(3);
        RPN rpn = new RPN(stacks);

        assertEquals(1, rpn.evaluate("2 -").get(0));
    }

    @Test
    void rpn_expression_containing_one_number_and_divide_operand_should_pop_out_last_two_numbers_and_add_result() {
        ArrayList<Integer> stacks = new ArrayList<>();
        stacks.add(10);
        RPN rpn = new RPN(stacks);

        assertEquals(2, rpn.evaluate("5 /").get(0));
    }

    @Test
    void rpn_expression_containing_one_number_and_multiplication_operand_should_pop_out_last_two_numbers_and_add_result() {
        ArrayList<Integer> stacks = new ArrayList<>();
        stacks.add(10);
        RPN rpn = new RPN(stacks);

        assertEquals(20, rpn.evaluate("2 *").get(0));
    }

    @Test
    void rpn_expression_with_wrong_operand_should_throw_illegal_argument_exception() {
        ArrayList<Integer> stacks = new ArrayList<>();
        RPN rpn = new RPN(stacks);
        String wrongOperandExpression = "2 3 )";

        assertThrows(IllegalArgumentException.class, ()-> rpn.evaluate(wrongOperandExpression));
    }

    @Test
    void rpn_expression_with_too_much_argument_should_throw_exception() {
        ArrayList<Integer> stacks = new ArrayList<>();
        RPN rpn = new RPN(stacks);
        String wrongSyntaxExpression = "2 3 + 3";

        assertThrows(IllegalArgumentException.class, ()-> rpn.evaluate(wrongSyntaxExpression));
    }

}
