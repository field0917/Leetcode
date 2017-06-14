// Description:

// Count the number of prime numbers less than a non-negative number, n.

public class Solution {
  public int countPrimes(int n) {
   	boolean[] isPrime = new boolean[n];
   	for (int i = 2; i < n; i++) {
   		isPrime[i] = true;
   	}

   	for (int i = 2; i * i < n; i++) {
   		
   		if (!isPrime[i]) continue; // eg: multiple of 4 is also multiple of 2, which
   															 // is already been checked, no need to do the 
   															 // following for iteration
   		
   		for (int j = i; i * j < n; j++) {
   			isPrime[i * j] = false;
   		}
   	}

   	int count = 0;
   	for (int i = 2; i < n; i++) {
   		if (isPrime[i]) count++;
   	}
   	return count;
  }
}