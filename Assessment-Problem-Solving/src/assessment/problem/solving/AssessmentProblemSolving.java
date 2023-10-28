/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment.problem.solving;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class AssessmentProblemSolving {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        System.out.println("Enter Your String :");
//        String yourString = input.nextLine();
        StringBuilder reverse = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean flag = false;

        do {
            
            flag = false;
            System.out.println("Enter Your String :");
            String yourString = input.nextLine();
            
            if (yourString.length() < 1 && yourString.length() > 2000) {
                System.err.println("Your String must be greater than or equal 1 and less than or equal 2000 .");
                flag = true;
                break;
            }

            for (int i = 0; i < yourString.toCharArray().length; i++) {
                if (Character.isUpperCase(yourString.toCharArray()[i])) {
                    System.err.println("Your String must all characters in lower case .");
                    flag = true;
                    break;
                }
            }
            
            
            
            if (flag == false) {
                for (int i = 0; i < yourString.toCharArray().length; i++) {
                    if ("(".equals(String.valueOf(yourString.toCharArray()[i]))) {
                        String answer = yourString.substring(i + 1, yourString.indexOf(")"));
                        for (int j = answer.toCharArray().length - 1; j >= 0; j--) {
                            reverse.append(answer.toCharArray()[j]);
                        }
                        yourString = yourString.replace(answer, reverse);
                        result.append(yourString.substring(0, yourString.indexOf(")") + 1));
                        i = -1;
                        yourString = yourString.substring(yourString.indexOf(")") + 1);
                        reverse = new StringBuilder();
                    }
                }
                result.append(yourString);
                if(result.length() != 0)
                    System.out.println(result);
                else
                    System.out.println(yourString);
                flag = false;
            }

        } while (flag == true);

    }

}
