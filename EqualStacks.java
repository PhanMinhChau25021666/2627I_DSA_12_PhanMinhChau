import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {
    private Stack<Integer> totalStack(int[] h){
        Stack<Integer> stack = new Stack<>();
        int x = 0;
        for (int i = h.length-1; i >= 0; i--){
            x += h[i];
            stack.push(x);
        }
        return stack;
    }
    public int equalStacks(int[] h1, int[] h2, int[] h3){
        Stack<Integer> stack1 = totalStack(h1);
        Stack<Integer> stack2 = totalStack(h2);
        Stack<Integer> stack3 = totalStack(h3);
        while (stack1.size() > 0 && stack2.size() > 0 && stack3.size() > 0){
            int min = Math.min(stack3.peek(),Math.min(stack2.peek(),stack1.peek()));
            if (stack1.peek() == min && stack2.peek() == min && stack3.peek() == min){
                return min;
            }else {
                if (stack1.peek() != min) stack1.pop();
                if (stack2.peek() != min) stack2.pop();
                if (stack3.peek() != min) stack3.pop();
            }
        }
        return 0;
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        for (int i = 0; i < n1; i++) {
            h1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            h2[i] = scanner.nextInt();
        }
        for (int i = 0; i < n3; i++) {
            h3[i] = scanner.nextInt();
        }

        EqualStacks equalStacks = new EqualStacks();
        int result = equalStacks.equalStacks(h1, h2, h3);
        System.out.println(result);
    }
}
