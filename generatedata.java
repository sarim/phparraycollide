/**
 *
 * @author sarim
 */
public class generatedata {
    public static void main(String arg[]){
          long size =  (long) java.lang.Math.pow(2,16);
        long key,maxKey;
        key = 0 ; 
        maxKey = (size - 1) * size ;

        for (; key <= maxKey; key += size) {
            
        System.out.print( key );
        System.out.print("=0&");
        }
    }
}
