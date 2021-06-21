import java.io.*;
import java.util.*;

public class PalindromeReoder {

	public static void main(String[] args) {
		String line = ns();

		if (line.length() == 1) {
			System.out.println(line);
			return;
		}

		Map<Character, Integer> listChars = new HashMap<Character, Integer>();

		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);

			if (listChars.containsKey(c)) {
				listChars.put(c, listChars.get(c) + 1);
				continue;
			}

			listChars.put(c, 1);
		}

		int oddCount = 0;
		String oddChar = "";

		for (char c : listChars.keySet()) {
			if (listChars.get(c) % 2 == 1) {
				oddCount++;
				oddChar += c;
			}
		}

		if (oddCount > 1) {
			System.out.println("NO SOLUTION");
			return;
		}

		if (oddCount == 1 && line.length() % 2 == 0) {
			System.out.println("NO SOLUTION");
			return;
		}

		StringBuilder output = new StringBuilder();
		StringBuilder half = new StringBuilder();

		output.append(oddChar);

		for (char c : listChars.keySet()) {
			int p = listChars.get(c);

			if (p == 1) {
				continue;
			}
			
			half.append(String.valueOf(c).repeat(p/2));
		}
		
		output.insert(0, half);
		output.append(half.reverse());
		
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
