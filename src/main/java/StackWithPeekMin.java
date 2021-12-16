import java.util.EmptyStackException;
import java.util.Stack;

public class StackWithPeekMin {

    private Stack<Integer> stack;
    private Integer minElement;

    public StackWithPeekMin() {
        this.stack = new Stack<>();
    }

    Integer peek() {

        if (stack.isEmpty()) throw new EmptyStackException();

        Integer top = stack.peek();
        if (top < minElement) {
            return minElement;
        } else {
            return top;
        }
    }

    Integer pop() {

        if (stack.isEmpty()) throw new EmptyStackException();
        Integer top = stack.pop();
        if (top < minElement) {
            Integer tempMinElement = minElement;
            minElement = 2 * minElement - top;
            return tempMinElement;
        } else
            return top;
    }

    void push(Integer element) {

        if (stack.isEmpty()) minElement = element;
        if (element < minElement) {
            stack.push(2 * element - minElement);
            minElement = element;
        } else {
            stack.push(element);
        }
    }

    Integer peekMin() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return minElement;
    }

}
