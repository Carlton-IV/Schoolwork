import java.util.*;
public class span2 {
  public static void main(String[] args) {
     int[] x = new int[100000];
     Random rnd = new Random();
     for(int i = 0; i < x.length; i++) { x[i] = rnd.nextInt(100); }
     System.out.println("Input  : "+Arrays.toString(x));
     long startTime = System.currentTimeMillis();
     int[] result = run(x,x.length);
     long endTime = System.currentTimeMillis();
     System.out.println("Result : "+Arrays.toString(result));
     long t = endTime-startTime;
     System.out.println("\nLength: "+x.length+ "\nRuntime: "+(t));
  }
  
  @SuppressWarnings("unchecked")
  public static int[] run(int[] X, int n) {
    stack<Integer> A = new stack<>();
    int[] S = new int[n];
    for(int i = 0; i < n; i++) {
      while (!A.isEmpty() && X[A.top()] <= X[i]) {
        A.pop();
      }
      if(A.isEmpty()) { S[i] = i+1; }
      else { S[i] = i-A.top(); }
      A.push(i);
    }
    return S;
  }
}
