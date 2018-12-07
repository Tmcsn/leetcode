package DPProblem;

public class DP91 {
    public int numDecodings(String s) {
        int num=s.length();
        int [] total=new int[num+1];
        total[0]=1;
        total[1]=s.charAt(0)=='0'?0:1;
        for(int i=1;i<num;i++){
            if(s.charAt(i)>'0'){
                total[i+1]+=total[i];
            }
            if(Integer.parseInt(s.substring(i-1,i+1))>=10 &&Integer.parseInt(s.substring(i-1,i+1))<=26){
                total[i+1]+=total[i-1];
            }
        }
        return total[num];


    }


    public static void main(String[] args) {
      DP91 dp=new DP91();
      System.out.println(dp.numDecodings("10"));
    }

}
