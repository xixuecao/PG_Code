
public class Test {
	
	public static void main(String[] args) {
		
		int x = 0;
		int y = 0;
		while (x<5) {
			if ( y < 5 ) {
				  x = x + 1;
				  if ( y < 3 ) {                           
				    x = x - 1;                               
				  }                                        
				}                                        
				y = y + 2;     
			System.out.print(x + " "+ y + " ");
			x = x + 1;	
		}		
	}
}
/*
00 11 21 32 42
y = x - y;                               22 46
                                         02 14 26 38
11 34 59                                 11 21 32 42 53
x = x + 1;                                
y = y + x;

00 11 23 36 410  
y = y + x;                               
                          
02 14 25 36 47                                        
y = y + 2;                               
if( y > 4 ) {                            
   y = y - 1;                            
}      
                                  
02 14 36 48
if ( y < 5 ) {
  x = x + 1;
  if ( y < 3 ) {                           
    x = x - 1;                               
  }                                        
}                                        
y = y + 2;
*/