import java.io.*;
import java.util.*;

public class MSA {

	public static void main(String[] args) {
		int n = ni();

		long numbers[] = new long[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = nl();
		}

//		prefixSum(numbers, n);
		twoPointers(numbers, n);
	}

	static void twoPointers(long numbers[], int n) {
		int i = 0;
		int j = 0;

		long sum = 0;
		long maxSum = Integer.MIN_VALUE;

		for (; j < n; j++) {
			sum += numbers[j];

			if (i < j && (sum < 0 || numbers[i] < 0)) {
				sum = numbers[j];
				i = j;
			}
			
			maxSum = Math.max(maxSum, sum);
		}
		
		System.out.println(maxSum);
	}

	static void prefixSum(long numbers[], int n) {
		long prefix[] = new long[n];
		prefix[0] = numbers[0];

		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] + numbers[i];
		}

		long minPrefix = 0;
		long answer = Long.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, prefix[i] - minPrefix);
			minPrefix = Math.min(minPrefix, prefix[i]);
		}

		System.out.println(answer);
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