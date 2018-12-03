package com.hackerrank.practice;

public class NewYearChaos {
    public static void main(String[] args) {
        NewYearChaos newYearChaos = new NewYearChaos();
//        newYearChaos.minimumBribes(new int[]{2, 1, 5, 3, 4});
//        newYearChaos.minimumBribes(new int[]{2, 5, 1, 3, 4});
        newYearChaos.minimumBribes(new int[]{1 ,2 ,5 ,3 ,7 ,8 ,6 ,4});


    }

    static void minimumBribes(int[] q) {
        int bribes = 0;
        boolean isChaotic = false;
        for (int i = 0; i < q.length; i++) {
            int correctVal = i + 1;
            int newVal = q[i];

            if (newVal - correctVal > 2) {
                isChaotic = true;
                break;
            }

            if (newVal > correctVal) {
                bribes += (newVal - correctVal);
            } else  if(newVal < correctVal){
                int i1 = correctVal - newVal - 2;
                if(i1 > 0){
                    bribes+= i1;
                }
            }

        }
        if (isChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }

    }
}
