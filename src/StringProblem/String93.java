package StringProblem;

import java.util.ArrayList;
import java.util.List;

public class String93 {
    public List<String> restoreIpAddresses(String s) {
        List result=new ArrayList();
        if(s.length()<4 || s.length()>12){
            return  result;
        }
        for(int i=1;i<s.length()-2 && i<4;i++){
            for (int j=i+1;j<s.length()-1&&j<i+4;j++){
                for (int k=j+1;k<s.length()&&k<j+4;k++){
                    String s1=s.substring(0,i);
                    String s2=s.substring(i,j);
                    String s3=s.substring(j,k);
                    String s4=s.substring(k);
                    if(isLegal(s1)&&isLegal(s2)&&isLegal(s3)&&isLegal(s4)){
                        result.add(s1+'.'+s2+'.'+s3+'.'+s4);
                    }
                }
            }
        }
        return result;
    }
    private static boolean isLegal(String str){
        if(str.charAt(0)=='0'&& str.length()>1 || Integer.parseInt(str)>255){
            return false;
        }
        return true;
    }
}
