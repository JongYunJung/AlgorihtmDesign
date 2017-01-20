#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void make_input()
{
	FILE * fp = fopen("quickselect.in", "w");

	if (fp == NULL) return;
	srand(time(NULL));
	int MOD = 10000;
	int arr[10001];
	for (int i = 0; i < 10000; i++)	
		arr[i] = i + 1;
	
	
	for (int i = 0; i < 3000; i++)
	{
		int a = rand() % 10000;
		int b = rand() % 10000;
		int tmp = arr[a]; arr[a] = arr[b]; arr[b] = tmp;
	}
	for (int i = 0; i < 10000; i++)
		fprintf(fp, "%d ", arr[i]);
	
	fclose(fp);
}
inline void swap(int & a, int & b)
{
	int t = a; a = b; b = t;
}
int quickSelect(int arr[], int lo, int hi, int kth)
{
	//do 
	//{
	//	int i = lo - 1;
	//	for (int j = lo; j < hi; j++)
	//	{
	//		if (arr[j] < arr[hi])
	//			swap(arr[++i], arr[j]);
	//	}
	//	swap(arr[++i], arr[hi]);
	//	if (i < kth)
	//		lo = i + 1;
	//	else
	//		hi = i - 1;

	//} while (hi != kth);

	
	int i, j;
	do
	{
		i = lo, j = hi;
		while (i < j)
		{
			while (i <= hi && arr[i] <= arr[lo]) i++;
			while (arr[j] > arr[lo]) j--;

			if (i < j)
				swap(arr[i], arr[j]);
		}
		swap(arr[lo], arr[j]);
		if (j < kth) lo = j + 1;
		else hi = j - 1;
	} while (j != kth);
	return arr[j];
}
int main()
{
	
	//make_input();
	int arr[10001]; int cnt[10001] = { 0, };
	freopen("quickselect.in", "r", stdin);
	for (int i = 1; i <= 10000; i++)
	{
		scanf("%d", &arr[i]);
		cnt[arr[i]]++;
	}
	int kth = 111;
	printf("%d-th = %d\n", kth, quickSelect(arr, 1, 10000, kth));
	
	return 0;
}