package String;

public class StringPratice {
   public static void main(String args[]){
	   for(int i=0;i<=args.length;i++){
		   StringBuffer strBuffer =new StringBuffer(args[i]);
		   System.out.println(strBuffer.reverse());
	   }
   }
}
