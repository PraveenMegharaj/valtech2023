package day5;

public class ArrayMountain {
	
	public boolean ascending(int[] a) {
		int index = 0;
		int max = 0;
		int i,maxIndex = 0;
		for(i=0;i<a.length;i++) {
			if(max<a[i]) {
				max=a[i];
				maxIndex=i;
			}
		}
		
		for(i=0;i<maxIndex-1;i++) {
			if(a[i]>a[i+1]) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean descending(int[] a) {
		int index = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]<a[i+1]) {
				return false;
			}
		}
		return true;
		
	}
	
	public int isMountain(int[] a) {
		int max = 0;
		int i,maxIndex = 0;
		for(i=0;i<a.length;i++) {
			if(max<a[i]) {
				max=a[i];
				maxIndex=i;
			}
		}
		
		
		return maxIndex;
		
	}
	public static void main(String[] args) {
		
	}
	

}


