import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParenthesesChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parentheses string: ");
        String input = scanner.nextLine();
        
        if (isBalanced(input)) {
            System.out.println("Balanced and paired.");
        } else {
            System.out.println("Not balanced or paired.");
        }
        scanner.close();
    }
    
    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!((top == '(' && ch == ')') || 
                      (top == '{' && ch == '}') || 
                      (top == '[' && ch == ']'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}