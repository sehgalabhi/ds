package com.hackerrank.dynamicprog;

public class Abbreviation {

    public static void main(String[] args) {
        new Abbreviation().test();
    }

    private void test() {
        String a = "hHhAhhcahhacaccacccahhchhcHcahaahhchhhchaachcaCchhchcaccccchhhcaahhhhcaacchccCaahhaahachhacaahhaachhhaaaCalhhchaccaAahHcchcazhachhhaaahaahhaacchAahccacahahhcHhccahaachAchahacaahcahacaahcahacaHhccccaahaahacaachcchhahhacchahhhaahcacacachhahchcaAhhcaahchHhhaacHcacahaccccaaahacCHhChchhhahhchcahaaCccccahhcaachhhacaaahcaaaccccaacaaHachaahcchaahhchhhcahahahhcaachhchacahhahahahAahaAcchahaahcaaaaahhChacahcacachacahcchHcaahchhcahaachnachhhhcachchahhhacHhCcaHhhhcaCccccaaahcahacahchahcaachcchaachahhhhhhhhcahhacacCcchahccaaaaaHhhccaAaaaCchahhccaahhacaccchhcahhcahaahhgacahcahhchcaaAccchahhhaahhccaaHcchaccacahHahChachhcaaacAhacacaacacchhchchacchchcacchachacaahachccchhhaccahcacchaccaahaaaccccccaaaaaaaHhcahcchmcHchcchaaahaccchaaachchHahcaccaaccahcacacahAhaacaacaccaccaaacahhhcacAhaCchcaacCcccachhchchcchhchahchchahchchhchcacaachahhccacachaAhaaachchhchchchhaachahaahahachhaaaccacahhcacchhhaaachaaacAahhcachchachhhcacchacaaChCahhhccahChaachhcahacchanaaacchhhccacacchcahccchAcahacaaachhacchachccaaHacaacAhahcCh";
        String b = "HAHHCHAACCCAHCHHAHHAHCACCHCCHHCAAHHCACCCAHHHACAAHHHHCHHCAHHAHHAAAHAACAAHAHHCAHAHACHACHCHACACHAAHHAAAHCAHHACACAACHHHCHAHCAHCHHHAHAHACCAAAHCHHCHHCCAACCCCAACHACAACAAHACHCHAHHACCHCAHHHAAACHACAACHCACACAHHCCHAHACCCACCAACHCHHHCCCCCHCCAHHCAAHHAHHHHHHHAACCCCAHCCAAAAAHHHAAAACCAHHCAHACACCHHCHAHAHHCHAACHHHHHCCHCCAHAHCHCAAACCACCCCHACCACHHACHHACACHACCAACCCCAAAAHHAHCHHHCCAHCCHACHHAHCCACACCHAHAAACACCCCAHCCAHACCCCCCHCCHHCHHHHCHCHCAHHHACHAHAACCCAAAACHAACAAAHHAAHAAAHACHHCACHCCHCHAACHACACHHCCCCCAHCACHAAAHCHCAHACAAC";
//        String a = "AcccDE";
//        String b = "ADE";

        int aLength = a.length();
        int bLength = b.length();

        if (a.length() < b.length()) {
            System.out.println("NO");
        }

        int currentIndex = 0;
        int remainingChars = bLength;
        int bIndex = 0;
        boolean isContinue = true;
        while (currentIndex < a.length() && isContinue && remainingChars > 0) {
            isContinue = false;

            int tempIndex = currentIndex;
            while ((aLength - tempIndex) >= remainingChars && remainingChars > 0) {

                if (((int) a.charAt(tempIndex) == (int) b.charAt(bIndex)) || (((int) a.charAt(tempIndex) - 32 == (int) b.charAt(bIndex)))) {

                    remainingChars--;
                    bIndex++;
                    tempIndex++;
                    isContinue = true;
                    break;
                } else {
                    if((int) a.charAt(tempIndex) >= 65 && (int) a.charAt(tempIndex) <= 90){
                        break;
                    }
                    tempIndex++;
                }
            }
            currentIndex = tempIndex;
        }

        while(currentIndex < a.length()) {
            if((int) a.charAt(currentIndex) >= 65 && (int) a.charAt(currentIndex) <= 90){
                isContinue = false;
                break;
            }
            currentIndex++;
        }

        if(isContinue){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
