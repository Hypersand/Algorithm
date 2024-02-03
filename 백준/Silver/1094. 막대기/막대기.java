import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		int stick = 64;
		int count = 0;

		while (X > 0) {
			if (stick > X) {
				stick /= 2;

			} else {
				X -= stick;
				count++;
			}
		}

		System.out.println(count);
		
	}

}