import java.io.*;
import java.util.*;


public class SumOfTwoValue {

	public static void main(String[] args) {
		int n = ni();
		int x = ni();

		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Integer> tempNumbers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			numbers.add(ni());
			tempNumbers.add(numbers.get(i));
		}

		Collections.sort(numbers);

		int i = 0;
		int j = n - 1;

		int number1 = 0;
		int number2 = 0;

		while (j > i) {
			int sum = numbers.get(i) + numbers.get(j);

			if (sum == x) {
				number1 = numbers.get(i);
				number2 = numbers.get(j);
				break;
			}

			if (sum < x) {
				i++;
				continue;
			}

			j--;
		}

		StringBuilder output = new StringBuilder();

		if (number1 != 0 && number2 != 0) {
			int index1 = tempNumbers.indexOf(numbers.get(i)) + 1;
			int index2 = tempNumbers.lastIndexOf(numbers.get(j)) + 1;

			output.append(index1).append(" ");
			output.append(index2);
		} else {
			output.append("IMPOSSIBLE");
		}

		System.out.println(output);

	}

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}