import java.util.*;
import java.io.*;

class Repetitions {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		String dna = reader.nextLine();

		int tempCount = 1;
		List<Integer> count = new ArrayList<>();

		for (int i = 0; i < dna.length() - 1; i++) {
			if (dna.length() == 1) {
				break;
			}

			Character a = dna.charAt(i);
			Character b = dna.charAt(i + 1);

			if (a.equals(b)) {
				tempCount++;
				continue;
			}

			count.add(tempCount);

			tempCount = 1;
		}
		
		count.add(tempCount);

		Collections.sort(count);

		System.out.println(count.get(count.size() - 1));

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