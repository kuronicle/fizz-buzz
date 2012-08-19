package net.kuronicle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FizzBuzz {
    
    private static Log log = LogFactory.getLog(FizzBuzz.class);
    
    private static final int FIZZ_BASE = 3;
    
    private static final int BUZZ_BASE = 5;
    
    public static void main(String[] args) {
        
        if(args.length!=1) {
            System.err.println("引数が1つではありません。引数には値が1以上の整数を1つ指定してください。");
            log.info("引数が1つ以外です。");
            return;
        }
        
        try {
            int num = Integer.parseInt(args[0]);
            
            if(num <= 0) {
                System.err.println("引数の値が0以下です。引数には値が1以上の整数を1つ入力してください。");
                log.info("引数の値が1以上でありません。");
                return;
            }
            
            for(int i=1; i<=num; i++) {
                if(i!=1) System.out.print(", ");
                System.out.print(convertFizzBuzz(i));
            }
            System.out.println("");
            
        } catch(NumberFormatException e) {
            System.err.println("引数が整数ではありません。引数には値が1以上の整数を1つ入力してください。");
            log.info("引数が整数ではありません。", e);
            return;
        }
        
    }

    private static String convertFizzBuzz(int i) {
        if(i < 1) throw new IllegalArgumentException();
        
        if(i % (FIZZ_BASE * BUZZ_BASE) == 0) {
            return "FizzBuzz";
        } else if (i % FIZZ_BASE == 0) {
            return "Fizz";
        } else if (i % BUZZ_BASE == 0) {
            return "Buzz";
        } else {
            return String.valueOf(i);
        }
    }

}
