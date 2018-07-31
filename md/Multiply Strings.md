# Multiply Strings 

对于字符串相乘肯定不能转化为int类型（存储范围限制），因此需要对每一位字符进行单独处理。

tips：对每一位字符 如'3'-'0'可得3，即0到9之间的字符，与字符'0'相减可得该数字本身int型值。

tips：在做乘积的时候，最终结果第m位上的数字一定等于所有i+j=m位上的数字之和，比如123*456 在结果的第0位（从最右边看做是第0位）为 num1[0] * num2[0]

结果的第一位为 num1[0] * num2[1] + num1[1]* num2[0]  为了方便处理可以将结果先进行保存 最后一起处理进位的问题。

```
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
            buffer.deleteCharAt(0); //删除全部的不必要‘0’
       }
       return  buffer.length()==0? "0": buffer.toString();
    }
```

