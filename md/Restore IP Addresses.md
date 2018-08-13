# Restore IP Addresses 

将一个字符串分解成若干部分，对每一部分都有规则的限制，求解所有可能的分解方式。

对于IP地址而言 分解的长度固定（分成四份），分解的每一部分长度范围固定（长度最小为1，最大为3） 分解部分域范围固定（0到255之间  且如果不为0则第一位不可为0）



总体的思路分为两部分

1. 将字符串按照上述规则进行划分
2. 将划分结束的字符串每一部分进行验证是否合法

就划分而言维护3个游标，作为划分边界 第一个游标起始位置为1（因为substring

.(0,i),位置i处的不会被取到），同时最大为3（长度超过3不合法），并且要为后续游标留足至少每个一位的数字。后续游标的起始均为前一游标位置加一。

对于验证而言 因为划分的时候保证了每一部分都至少有一位数字，所以验证的时候直接转化为int比较是否大于255（这里注意可以联想到char类型的数字字符减去'0'可直接得到数字本身），同时如果字符串首位是0，则其只能是0才合理。

```
class Solution {
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
        if(str.charAt(0)=='0'&& str.length()>1 ||Integer.parseInt(str)>255){
            return false;
        }
        return true;
    }
}
```

