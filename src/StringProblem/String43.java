package StringProblem;

public class String43 {
    public String multiply(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        int []result=new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int tmp1=num1.charAt(i)-'0';
                int tmp2=num2.charAt(j)-'0';
                result[i+j+1]+=tmp1*tmp2;
            }
        }
        int carry=0;
        StringBuffer buffer=new StringBuffer();
        for (int i=n1+n2-1;i>=0;i++){
             int num=(result[i]+carry)%10;
             carry=(result[i]+carry)/10;
             result[i]=num;
        }
       for (int num:result){
            buffer.append(num);
       }
       while (buffer.length()!=0&&buffer.charAt(0)=='0'){
            buffer.deleteCharAt(0);
       }
       return  buffer.length()==0? "0": buffer.toString();
    }
}
