import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode5_28 {

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.equals("")) {
            return list;
        }

        foo("",digits.toCharArray());
        return list;
    }

    public void foo(String string, char[] chars) {


        for (char c : phone(chars[0]).toCharArray()) {
            StringBuilder sb = new StringBuilder(string);
            sb.append(c);
            if(chars.length<=1){
                list.add(sb.toString());
                return;
            }
            foo(sb.toString(), Arrays.copyOfRange(chars, 1, chars.length));
        }

    }

    public String phone(char num) {
        String result;
        switch (num) {
            case '2':
                result = "abc";
                break;
            case '3':
                result = "def";
                break;
            case '4':
                result = "ghi";
                break;
            case '5':
                result = "jkl";
                break;
            case '6':
                result = "mno";
                break;
            case '7':
                result = "pqrs";
                break;
            case '8':
                result = "tuv";
                break;
            case '9':
                result = "wxyz";
                break;
            default:
                result = "abc";
                break;
        }
        return result;
    }
}
