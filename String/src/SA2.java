import java.util.*;

public class SA2 {
	static int MAX_N = 1000010;
	static char[] T; 
	static int n;                                        // 문자열 길이
	static int[] RA = new int[MAX_N], tempRA = new int[MAX_N];        // 랭크값 배열 / 임시 배열
	static int[] SA = new int[MAX_N], tempSA = new int[MAX_N];    // 접미어 배열 / 임시 배열
	static int[] c = new int[MAX_N];                                    // 카운트 배열

	static int[] Phi = new int[MAX_N];                      // for computing longest common prefix
	static int[] PLCP = new int[MAX_N];
	static int[] LCP = new int[MAX_N];  // LCP[i] stores the LCP between previous suffix T+SA[i-1]

	static void countingSort(int k) {                                          // O(n)
		int i, sum, maxi = Math.max(300, n);   // 255 ASCII 문자수 or 문자열길이
		//for(i = 0; i < n; i++) c[i] = 0;
		
		for (i = 0; i < n; i++)       // 랭크 값의 빈도수 계산
			c[i + k < n ? RA[i + k] : 0]++;
		
		for (i = sum = 0; i < maxi; i++) {
			int t = c[i]; c[i] = sum; sum += t;
		}
		for (i = 0; i < n; i++)          // shuffle the suffix array if necessary
			tempSA[c[SA[i] + k < n ? RA[SA[i] + k] : 0]++] = SA[i];
		for (i = 0; i < n; i++)                     // update the suffix array SA
			SA[i] = tempSA[i];
	}

	static void constructSA() {         // this version can go up to 100000 characters
		int i, k, r;
		for (i = 0; i < n; i++) RA[i] = T[i];                 // initial rankings
		for (i = 0; i < n; i++) SA[i] = i;     // initial SA: {0, 1, 2, ..., n-1}
		for (k = 1; k < n; k <<= 1) {       // repeat sorting process log n times
			countingSort(k);  // actually radix sort: sort based on the second item
			countingSort(0);          // then (stable) sort based on the first item
			tempRA[SA[0]] = r = 0;             // re-ranking; start from rank r = 0
			for (i = 1; i < n; i++)                    // compare adjacent suffixes
				tempRA[SA[i]] = // if same pair => same rank r; otherwise, increase r
				(RA[SA[i]] == RA[SA[i - 1]] && RA[SA[i] + k] == RA[SA[i - 1] + k]) ? r : ++r;
			for (i = 0; i < n; i++)                     // update the rank array RA
				RA[i] = tempRA[i];
			if (RA[SA[n - 1]] == n - 1) break;               // nice optimization trick
		}
	}

	static void computeLCP() {
		int i, L;
		Phi[SA[0]] = -1;                                         // default value
		for (i = 1; i < n; i++)                            // compute Phi in O(n)
			Phi[SA[i]] = SA[i - 1];    // remember which suffix is behind this suffix
		
		for (i = L = 0; i < n; i++) {             // compute Permuted LCP in O(n)
			
			if (Phi[i] == -1) { PLCP[i] = 0; continue; }            // special case
			
			while (T[i + L] == T[Phi[i] + L]) L++;       // L increased max n times
			
			PLCP[i] = L;
			
			L = Math.max(L - 1, 0);                             // L decreased max n times
		}
		for (i = 0; i < n; i++)                            // compute LCP in O(n)
			LCP[i] = PLCP[SA[i]];   // put the permuted LCP to the correct position
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		String str = sc.next();
		str.concat("$");
		n = str.length();
		str.concat("\0\0\0\0\0\0");
		T = str.toCharArray();
		
		constructSA();                                              // O(n log n)	
		computeLCP();                                                     // O(n)

		int sum = 0;
		for (int i = 1; i < n; i++)
			sum += (n - SA[i] - 1) - LCP[i];
		System.out.printf("%d\n", sum);
		
		sc.close();
	}
}
