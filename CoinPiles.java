import java.util.*;

import java.io.*;

class CoinPiles {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int t = reader.nextInt();

		for (int i = 0; i < t; i++) {
			int a = reader.nextInt();
			int b = reader.nextInt();

			if ((a + b) % 3 == 0 && Math.max(a, b) <= 2 * Math.min(a, b)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
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