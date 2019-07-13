package exercise1_5;

public class Test {
    private static int seachLeft(int key,int[] a, int lo, int hi){
        int mid = 0;
        while(lo <= hi){//遍历左侧增长序列
            mid = lo + (hi-lo)/2;
            if(key > a[mid]) lo = mid +1;
            else if(key < a[mid]) hi = mid -1;
            else return mid;
        }
        return -1;
    }
    private static int searchRight(int key, int[] a, int lo, int hi){
        int mid = 0;
        while(lo <= hi){
            mid = lo + (hi-lo)/2;
            if(key > a[mid]) hi = mid -1;
            else if(key < a[mid]) lo = mid +1;
            else return mid;
        }
        return -1;
    }
    
    //worst case use 3lgn
    public static int findNormal(int key, int[] a){
        int lo = 0;
        int hi = a.length -1;
        int mid = 0;
        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(a[mid]==key) return mid;
            else{
                if(mid==0 || mid==a.length-1) return -1;
                if(a[mid]>a[mid-1] && a[mid]>a[mid+1]){//mid刚好取到最大数
                    break;
                }else if(a[mid]>a[mid-1] && a[mid]<a[mid+1]){//mid取在增长序列
                    lo = mid +1;
                }else{//mid取在衰减序列
                    hi = mid -1;
                }
            }
        }
        //循环结束，但没有return，说明key未找到，并且mid此时已经是取到最大数
        int maxValIndex = mid;
        if(key > a[maxValIndex]) return -1;//key大于a[i]中最大值，key肯定不在数组中
        if(key < a[0] && key < a[a.length -1]) return -1;
        int findValue = seachLeft(key,a,0,maxValIndex-1);
        if(findValue == -1)
            findValue = searchRight(key,a,maxValIndex+1,a.length-1);
        
        return findValue;
    }
    
    public static int findFast(int key, int[] a){
        int lo = 0;
        int hi = a.length -1;
        int mid = 0;
        int findValue = -1;
        while(lo<=hi){
            mid = lo + (hi-lo)/2;
            if(a[mid]==key) return mid;
            else if(a[mid] > key){
                if(a[mid]>a[mid+1] && a[mid]>a[mid-1]){
                    findValue = seachLeft(key,a,0,mid-1);
                    if(findValue != -1) return findValue;
                    else return searchRight(key,a,mid+1,a.length-1);
                }else if(a[mid]>a[mid+1] && a[mid]<a[mid-1]){
                    hi = mid-1;
                }else{
                    lo = mid +1;
                }
            }else{//说明key值可能在a[mid]的两边
                findValue = seachLeft(key,a,0,mid-1);
                if(findValue != -1) return findValue;
                else return searchRight(key,a,mid+1,a.length-1);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = {0,1,2,3,5,6,7,8,9,3,2,1,0};
        System.out.println(Test.findNormal(4, a));
        System.out.println(Test.findFast(9, a));
    }
}