package practice.week01.StringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int returnNum(String strNum) {
        int castedNum = 0;

        // 6. 빈 문자열 또는 null이 입력되면 0을 반환한다.
        if (strNum == null || strNum.length()==0) return 0;

        if (strNum.matches("[+-]?\\d*(\\.\\d+)?")) {
            // 숫자일 때
            castedNum = Integer.parseInt(strNum);
            if (castedNum < 0) {
                throw new RuntimeException();
            }
        } else {
            // 숫자 아닐 때
            if (strNum.matches(".*//.*\\n.*|.*,.*|.*:.*")) {
                // 구분자를 포함할 때
                castedNum = getSeparator(strNum);
            } else {
                // 구분자를 포함하지 않을 때
                throw new RuntimeException();
            }
        }

        return castedNum;
    }

    // 구분자 판별
    public int getSeparator (String strNum){
        // 3. 커스텀 구분자가 없으면 ','과':'를 구분자로 사용한다. (기본 구분자)
        String separator=",|:";
        // 2. 입력 문자열 앞부분에 '//'와 '\n' 사이에 문자가 위치하면 커스텀 구분자로 사용한다.
        if(strNum.contains("//") && strNum.contains("\n")){
            Pattern pattern = Pattern.compile("//(.*?)\n");
            Matcher matcher = pattern.matcher(strNum);
            while (matcher.find()){
                separator = matcher.group(1);
                if (matcher.group(1) == null) {
                    break;
                }
            }
            strNum = strNum.replace("//","").replace("\n","").replaceFirst("\\"+separator,"");
            if(!strNum.contains(separator)) throw new RuntimeException();
        }
        return getCastedNum(strNum, "\\" + separator);
    }

    // 구분자로 나눈 수의 합 더하기
    private static int getCastedNum(String strNum, String separator) {
        int castedNum = 0;
        String[] arr = strNum.split(separator);
        for (String arrNum : arr){
            int newNum = Integer.parseInt(arrNum);
            castedNum += newNum;
        }
        return castedNum;
    }

}