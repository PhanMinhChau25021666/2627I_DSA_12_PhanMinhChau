import java.util.Scanner;
import java.util.Stack;

public class SimpleStackEditor {
    private String S = "";
    private Stack<Integer> undo_operation = new Stack<>();
    private Stack<String>  undo_string = new Stack<>();
    public void append(String W){
        undo_operation.push(1);
        undo_string.push(W);
        S = S + W;
    }
    public void delete(int k){
        undo_operation.push(2);
        undo_string.push(S.substring(S.length()-k));
        S = S.substring(0,k-1);
    }
    public void print(int k){
        System.out.println(S.charAt(k-1));
    }
    public void undo(){
        int o = undo_operation.pop();
        String s = undo_string.pop();
        if (o == 1) S = S.substring(0,S.length()-s.length()+1);
        if (o == 2) S += s;
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleStackEditor editor = new SimpleStackEditor();
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int operation = scanner.nextInt();
            if (operation == 1) {
                String W = scanner.next();
                editor.append(W);
            } else if (operation == 2) {
                int K = scanner.nextInt();
                editor.delete(K);
            } else if (operation == 3) {
                int K = scanner.nextInt();
                editor.print(K);
            } else if (operation == 4) {
                editor.undo();
            }
        }
    }
}
