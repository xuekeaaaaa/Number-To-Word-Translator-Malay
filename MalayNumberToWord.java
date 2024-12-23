import cn.hutool.core.convert.Convert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 支持千万以下的数值转换
 * 1、数值先转换为英文
 * 2、英文再转马来文
 * 依赖 hutool
 *          <dependency>
 *             <groupId>cn.hutool</groupId>
 *             <artifactId>hutool-all</artifactId>
 *             <version>5.8.27</version>
 *         </dependency>
 */
public class MalayNumberToWord {
    /**
     * 先转换 一百、一千、一万、十万、百万
     */
    private static final Map<String, String> FIRST_MAP = new HashMap<>();

    /**
     * 再转换 几千、几百、几十，最后转换one、two、three这些
     */
    private static final Map<String, String> MAP = new HashMap<>();

    static {

        FIRST_MAP.put("ONE HUNDRED", "seratus");
        FIRST_MAP.put("ONE THOUSAND", "seribu");
        FIRST_MAP.put("ONE HUNDRED THOUSAND", "sejuta");
        FIRST_MAP.put("HUNDRED", "ratus");
        FIRST_MAP.put("THOUSAND", "ribu");
        MAP.put("ELEVEN", "sebelas");
        MAP.put("TWELVE", "dua belas");
        MAP.put("THIRTEEN", "tiga belas");
        MAP.put("FOURTEEN", "empat belas");
        MAP.put("FIFTEEN", "lima belas");
        MAP.put("SIXTEEN", "enam belas");
        MAP.put("SEVENTEEN", "tujuh belas");
        MAP.put("EIGHTEEN", "lapan belas");
        MAP.put("NINETEEN", "sembilan belas");
        MAP.put("TWENTY", "dua puluh");
        MAP.put("TWENTY ONE", "dua puluh satu");
        MAP.put("TWENTY TWO", "dua puluh dua");
        MAP.put("TWENTY THREE", "dua puluh tiga");
        MAP.put("TWENTY FOUR", "dua puluh empat");
        MAP.put("TWENTY FIVE", "dua puluh lima");
        MAP.put("TWENTY SIX", "dua puluh enam");
        MAP.put("TWENTY SEVEN", "dua puluh tujuh");
        MAP.put("TWENTY EIGHT", "dua puluh lapan");
        MAP.put("TWENTY NINE", "dua puluh sembilan");
        MAP.put("THIRTY", "tiga puluh");

        MAP.put("THIRTY ONE", "tiga puluh satu");
        MAP.put("THIRTY TWO", "tiga puluh dua");
        MAP.put("THIRTY THREE", "tiga puluh tiga");
        MAP.put("THIRTY FOUR", "tiga puluh empat");
        MAP.put("THIRTY FIVE", "tiga puluh lima");
        MAP.put("THIRTY SIX", "tiga puluh enam");
        MAP.put("THIRTY SEVEN", "tiga puluh tujuh");
        MAP.put("THIRTY EIGHT", "tiga puluh lapan");
        MAP.put("THIRTY NINE", "tiga puluh sembilan");
        MAP.put("FORTY", "empat puluh");

        MAP.put("FORTY ONE", "empat puluh satu");
        MAP.put("FORTY TWO", "empat puluh dua");
        MAP.put("FORTY THREE", "empat puluh tiga");
        MAP.put("FORTY FOUR", "empat puluh empat");
        MAP.put("FORTY FIVE", "empat puluh lima");
        MAP.put("FORTY SIX", "empat puluh enam");
        MAP.put("FORTY SEVEN", "empat puluh tujuh");
        MAP.put("FORTY EIGHT", "empat puluh lapan");
        MAP.put("FORTY NINE", "empat puluh sembilan");
        MAP.put("FIFTY", "lima puluh");

        MAP.put("FIFTY ONE", "lima puluh satu");
        MAP.put("FIFTY TWO", "lima puluh dua");
        MAP.put("FIFTY THREE", "lima puluh tiga");
        MAP.put("FIFTY FOUR", "lima puluh empat");
        MAP.put("FIFTY FIVE", "lima puluh lima");
        MAP.put("FIFTY SIX", "lima puluh enam");
        MAP.put("FIFTY SEVEN", "lima puluh tujuh");
        MAP.put("FIFTY EIGHT", "lima puluh lapan");
        MAP.put("FIFTY NINE", "lima puluh sembilan");
        MAP.put("SIXTY", "enam puluh");

        MAP.put("SIXTY ONE", "enam puluh satu");
        MAP.put("SIXTY TWO", "enam puluh dua");
        MAP.put("SIXTY THREE", "enam puluh tiga");
        MAP.put("SIXTY FOUR", "enam puluh empat");
        MAP.put("SIXTY FIVE", "enam puluh lima");
        MAP.put("SIXTY SIX", "enam puluh enam");
        MAP.put("SIXTY SEVEN", "enam puluh tujuh");
        MAP.put("SIXTY EIGHT", "enam puluh lapan");
        MAP.put("SIXTY NINE", "enam puluh sembilan");
        MAP.put("SEVENTY", "tujuh puluh");

        MAP.put("SEVENTY ONE", "tujuh puluh satu");
        MAP.put("SEVENTY TWO", "tujuh puluh dua");
        MAP.put("SEVENTY THREE", "tujuh puluh tiga");
        MAP.put("SEVENTY FOUR", "tujuh puluh empat");
        MAP.put("SEVENTY FIVE", "tujuh puluh lima");
        MAP.put("SEVENTY SIX", "tujuh puluh enam");
        MAP.put("SEVENTY SEVEN", "tujuh puluh tujuh");
        MAP.put("SEVENTY EIGHT", "tujuh puluh lapan");
        MAP.put("SEVENTY NINE", "tujuh puluh sembilan");
        MAP.put("EIGHTY", "lapan puluh");

        MAP.put("EIGHTY ONE", "lapan puluh satu");
        MAP.put("EIGHTY TWO", "lapan puluh dua");
        MAP.put("EIGHTY THREE", "lapan puluh tiga");
        MAP.put("EIGHTY FOUR", "lapan puluh empat");
        MAP.put("EIGHTY FIVE", "lapan puluh lima");
        MAP.put("EIGHTY SIX", "lapan puluh enam");
        MAP.put("EIGHTY SEVEN", "lapan puluh tujuh");
        MAP.put("EIGHTY EIGHT", "lapan puluh lapan");
        MAP.put("EIGHTY NINE", "lapan puluh sembilan");
        MAP.put("NINETY", "sembilan puluh");

        MAP.put("NINETY ONE", "sembilan puluh satu");
        MAP.put("NINETY TWO", "sembilan puluh dua");
        MAP.put("NINETY THREE", "sembilan puluh tiga");
        MAP.put("NINETY FOUR", "sembilan puluh empat");
        MAP.put("NINETY FIVE", "sembilan puluh lima");
        MAP.put("NINETY SIX", "sembilan puluh enam");
        MAP.put("NINETY SEVEN", "sembilan puluh tujuh");
        MAP.put("NINETY EIGHT", "sembilan puluh lapan");
        MAP.put("NINETY NINE", "sembilan puluh sembilan");
        MAP.put("ONE", "satu");
        MAP.put("TWO", "dua");
        MAP.put("THREE", "tiga");
        MAP.put("FOUR", "empat");
        MAP.put("FIVE", "lima");
        MAP.put("SIX", "enam");
        MAP.put("SEVEN", "tujuh");
        MAP.put("EIGHT", "lapan");
        MAP.put("NINE", "sembilan");
        MAP.put("TEN", "sepuluh");
    }

    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal("8550");
        BigDecimal num2 = new BigDecimal("8550.50");

        String ntw1 = numberToEnglishWord(num1);
        System.out.println("8550");
        System.out.println(ntw1);
        System.out.println("LAPAN RIBU LIMA RATUS LIMA PULUH -- 正确的");
        System.out.println(convert(ntw1, num1));
        System.out.println("------------------------------");
        String ntw2 = numberToEnglishWord(num2);
        System.out.println("8550.50");
        System.out.println(ntw2);
        System.out.println("LAPAN RIBU LIMA RATUS LIMA PULUH DAN SEN LIMA PULUH -- 正确的");
        System.out.println(convert(ntw2, num2));


        System.out.println("------------------------------");
        BigDecimal num3 = new BigDecimal("18550");
        String ntw3 = numberToEnglishWord(num3);
        System.out.println("18550");
        System.out.println(ntw3);
        System.out.println(convert(ntw3, num3));

        System.out.println("------------------------------");
        BigDecimal num4 = new BigDecimal("18550.53");
        String ntw4 = numberToEnglishWord(num4);
        System.out.println("18550.53");
        System.out.println(ntw4);
        System.out.println(convert(ntw4, num4));

        System.out.println("------------------------------");
        BigDecimal num5 = new BigDecimal("11111.11");
        String ntw5 = numberToEnglishWord(num5);
        System.out.println(num5);
        System.out.println(ntw5);
        System.out.println(convert(ntw5, num5));

        System.out.println("------------------------------");
        BigDecimal num6 = new BigDecimal("11111.00");
        String ntw6 = numberToEnglishWord(num6);
        System.out.println(num6);
        System.out.println(ntw6);
        System.out.println(convert(ntw6, num6));

        System.out.println("------------------------------");
        BigDecimal num7 = new BigDecimal("111111.00");
        String ntw7 = numberToEnglishWord(num7);
        System.out.println(num7);
        System.out.println(ntw7);
        System.out.println(convert(ntw7, num7));


        System.out.println("------------------------------");
        BigDecimal num8 = new BigDecimal("201111.00");
        String ntw8 = numberToEnglishWord(num8);
        System.out.println(num8);
        System.out.println(ntw8);
        System.out.println(convert(ntw8, num8));
    }

    public static String numberToEnglishWord(BigDecimal number) {
        BigDecimal stripped = number.stripTrailingZeros();
        if (stripped.scale() > 0) {
            // 小数 > 0 而非.00 ，去掉hutool自带的only ，替换（分） cents（如美国、欧洲用） 为 sen（马来西亚、新加坡、印度尼西亚用）
            return Convert.numberToWord(number).replace(" ONLY", " ").replace("CENTS", "SEN");
        }else {
            return Convert.numberToWord(number.intValue()).replace(" ONLY", " ");
        }
    }

    public static String convert(String englishWord, BigDecimal number) {
        for (String s : FIRST_MAP.keySet()) {
            if (englishWord.contains(s)) {
                englishWord = englishWord.replace(s, FIRST_MAP.get(s));
            }
        }
        for (String s : MAP.keySet()) {
            if (englishWord.contains(s)) {
                englishWord = englishWord.replace(s, MAP.get(s));
            }
        }
        BigDecimal stripped = number.stripTrailingZeros();
        if (stripped.scale() > 0) {
            // 小数 > 0 而非.00 ，替换最后一个and为DAN
            englishWord = replaceLastAnd(englishWord);
        }
        englishWord = englishWord.replace("AND ", "");
        return englishWord.toUpperCase(Locale.ENGLISH);
    }

    private static String replaceLastAnd(String input) {
        return input.replaceFirst("(?s)(.*)\\bAND\\b", "$1DAN");
    }
}
