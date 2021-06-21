import java.util.*;
import java.io.*;

class Permutation {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();

		StringBuffer output = new StringBuffer();

		if (n <= 3 && n > 1) {
			System.out.println("NO SOLUTION");
			return;
		}

		int[] evens = new int[n / 2 + 1];
		int[] odds = new int[n / 2 + 1];

		int evenIndex = 0;
		int oddIndex = 0;
		int i = 1;

		while (i <= n) {
			if (i % 2 == 0) {
				evens[evenIndex++] = i;
				i++;
			} else {
				odds[oddIndex++] = i;
				i++;
			}
		}

		for (int j = 0; j < evenIndex; j++) {
			output.append(evens[j]).append(" ");
		}

		for (int j = 0; j < oddIndex; j++) {
			output.append(odds[j]).append(" ");
		}

		System.out.println(output);
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}