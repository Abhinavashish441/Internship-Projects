import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class KBC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ques[] = {"Capital of India -> 1.Delhi 2.Lucknow 3.Madras 4.Calcutta", "Capital of Jharkhand -> 1.Patna 2.Ranchi 3.Kanpur 4.Delhi", "Smallest in area -> 1.Chandigarh 2.Dadra and Nagaer Haveli 3.Daman and Diu 4.Lakshadweep", "Sundarbans or Mangrove forest are found in --> 1.Kutch Peninsula 2.Western Ghats 3.Konkan Coast 4.Deltaic West Bengal"};
        int ans[] = {1, 2, 4, 4};
        String demo_ques[] = {"PM of India -> 1.Narendra Sharma 2.Narendra Modi 3.Yogi AdityaNath 4.None","CM of UP -> 1.Narendra Sharma 2.Narendra Modi 3.Yogi AdityaNath 4.None"};
        int demo_ans[] = {2,3};
        int a, highscore=0;
        System.out.println("WELCOME TO KBC - Kaun Banega Crorepatti");
        
        String name="",mobile=""; int age=0;
        
        if(Integer.parseInt(readFile(0))==-1){
            System.out.println("High Score : 0");
            System.out.print("Enter Your Name : ");
            name = in.nextLine();
            System.out.print("Enter Your Age : ");
            age = in.nextInt();
            System.out.print("Enter Your Mobile No : ");
            mobile = in.nextLine();
            mobile = in.nextLine();
        }else {
            System.out.println("High Score : " + readFile(0) + "\t|\tHigh Scorer Name : " + readFile(1));
            System.out.println("Confirm your details : ");
            System.out.println("\tName : "+readFile(2));
            System.out.println("\tAge : "+readFile(3));
            System.out.println("\tMobile : "+readFile(4));
            System.out.println("\nEnter 1 to confirm / 0 to reenter : ");
            int confirm = in.nextInt();
            if(confirm==0){
                System.out.print("Enter Your Name : ");
                name = in.nextLine();
                name = in.nextLine();
                System.out.print("Enter Your Age : ");
                age = in.nextInt();
                System.out.print("Enter Your Mobile No : ");
                mobile = in.nextLine();
                mobile = in.nextLine();
            }else{
                name=readFile(2);
                age=Integer.parseInt(readFile(3));
                mobile=readFile(4);
                highscore=Integer.parseInt(readFile(0));
            }
        }
        System.out.println("");
        System.out.print("0 to Demo / 1 to Start Quiz : ");
        int choice = in.nextInt();
        int score = 0;
        if (choice == 1) {
            System.out.println("Test Started : ");
            for (int i = 0; i < ques.length; i++) {
                System.out.println(ques[i]);
                System.out.print("Answer : ");
                a = in.nextInt();
                if (a == ans[i]){
                    score += 10;
                    System.out.println("Right\n");
                }else {
                    System.out.println("Wrong\n");
                }
            }
        }else{
            System.out.println("Demo Test Started : ");
            for (int i = 0; i < demo_ques.length; i++) {
                System.out.println(demo_ques[i]);
                System.out.print("Answer : ");
                a = in.nextInt();
                if (a == ans[i]) {
                    System.out.println("Right\n");
                }else {
                System.out.println("Wrong\n");
                }
            }
            System.out.println("\nThanks");
            System.exit(0);
        }

        System.out.println("\n");

        if (score >= highscore) {
            highscore = score;
            String highscorer = name;
            System.out.println("You Topped the quiz!");
        }
        writeFile(highscore, name, name, age, mobile);
        System.out.println("Final Score : " + score);

    }

    public static void writeFile(int highscore, String high_scorer, String name, int age, String mobile) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("==>" + highscore + "---" + high_scorer + "<==" + "<-" + name + "-*" + age + "*-" + "-^" + mobile + "^-" + "->");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public static String readFile(int choice) {
        String alltext="";
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                alltext += data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            return "-1";
        }

        String highscoreString = alltext.substring(alltext.indexOf("==>") + 3, alltext.indexOf("<=="));
        String highscorer_name = highscoreString.substring(highscoreString.indexOf("---") + 3);
        String highscore_value = highscoreString.substring(0, highscoreString.indexOf("---"));

        String detailString = alltext.substring(alltext.indexOf("<-") + 2, alltext.indexOf("->"));
        String name = detailString.substring(0, detailString.indexOf("-*"));
        String age = detailString.substring(detailString.indexOf("-*") + 2,detailString.indexOf("*-"));
        String mobile = detailString.substring(detailString.indexOf("-^") + 2,detailString.indexOf("^-"));

        if(choice==0){
            return highscore_value;
        }else if(choice==1){
            return  highscorer_name;
        }else if(choice==2){
            return name;
        }else if(choice==3){
            return age;
        }else if(choice==4){
            return mobile;
        }

        return "-1";
    }
}
