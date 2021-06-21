import java.io.*;
import java.util.*;

public class CreatingString {

	public static void main(String[] args) {
		String line = ns();

		char[] charOfline = line.toCharArray();
		Arrays.sort(charOfline);

		StringBuilder output = new StringBuilder();

		int count = 0;

		while (true) {
			output.append(new String(charOfline)).append("\n");
			count++;

			if (!nextPermutation(charOfline)) {
				break;
			}
		}

		output.insert(0, count + "\n");

		System.out.println(output);

	}

	static boolean nextPermutation(char[] charsOfLine) {
		int i = charsOfLine.length - 1;

		while (charsOfLine[i - 1] >= charsOfLine[i]) {
			if (--i == 0) {
				return false;
			}
		}

		int j = charsOfLine.length - 1;

		while (j > i && charsOfLine[j] <= charsOfLine[i - 1]) {
			j--;
		}

		swap(charsOfLine, i - 1, j);

		reverse(charsOfLine, i, charsOfLine.length - 1);

		return true;
	}

	static void swap(char[] charsOfLine, int i, int j) {
		char ch = charsOfLine[i];
		charsOfLine[i] = charsOfLine[j];
		charsOfLine[j] = ch;
	}

	static void reverse(char[] charsOfLine, int from, int to) {
		for (; from < to; from++, to--) {
			swap(charsOfLine, from, to);
		}
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