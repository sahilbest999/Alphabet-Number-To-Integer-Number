import java.util.*;


class Parser {

  public static List<String> splitThem(String str)
  {
    String words[] =str.replace(" and "," ").split("( )+");
    ArrayList<String> temp = new ArrayList<String>();
       
       for(int i = 0;i<words.length - 1;i++)
       {
         temp.add(words[i]);
         if(!(words[i+1].equals("hundred") || words[i+1].equals("thousand") ||words[i+1].equals("million")))
         temp.add("+");
         else
         temp.add("*");
       }
 
       return temp;
  }

  public static int con_cal(String words)
  {
      if(words.contains("-"))
      {
          int num=0;
          for (String temp_var : words.replace("-"," ").split(" "))
            num +=con_cal(temp_var);
          return num;
      }
     
         switch(words){ 
             
         case "one":
         return 1;
           
           case "two":
           return 2;
           
           
           case "three":
            return  3;
           
           
           case "four":
              return  4;
           
           
           case "five":
            return 5;
           
           
           case "six":
           return  6;
           
           
           case "seven":
            return  7;
           
           
           case "eight":
             return  8; 
           
           
            case "nine":
            return 9;
           
           
           case "ten":
           return 10;
           
           
           case "eleven":
           return  11;
           
           
           case "twelve":
           return  12;
           
           
           case "thirteen":
           return  13;
           
           
           case "fourteen":
           return 14;
           
             
           case "fifteen":
           return 15;
           
           
           case "sixteen":
           return 16;
           
           
           case "seventeen":
           return 17;
           
           
           case "eighteen":
           return 18;
           
           
           case "nineteen":
           return 19;
           
             
           case "twenty":
           return 20;
           
           
            case "thirty":
            return  30;
           
           
              case "forty":
           return  40;   
           
           
            case "fifty":
            return  50;
           
           
           case "sixty":
           return  60;
           
           
            case "seventy":
            return 70;
           
           
              case "eighty":
             return 80; 
           
           
            case "ninty":
            return 90;
           
           
           case "hundred":
           return  100;
           
           
           case "thousand":
           return 1000;
           
           
           case "million":
           return 1000000;
         }

         return Integer.parseInt(words);
     }


public static int parseInt(String str)
    {
        
        if(str.equals("")||str.equals(null))
            return 0;
        
       int num=1,ADD=0;
       List<String> words = splitThem(str);
       List<String> temp = words;
   
   for(int i = 0;i<words.size();i++)  // TRY TO CHANGE CONDITION i<words.size() TO i<words.size()-1 TO FIX THE PROBLEM
   {
       try
       { 
       if(words.get(i).equals("*") && ADD==0)
       {
       num = num*con_cal(words.get(i-1))*con_cal(words.get(i+1));
//     System.out.println(con_cal(words.get(i-1))+" x "+con_cal(words.get(i+1)+" = "+num);  ENABLE FOR DEBUGGING MULTIPLICATION
       words.remove(i+1);
       words.remove(i-1);
       words.remove(i-1);
       words.add(i-1,Integer.toString(num));
       num=1;
       continue;
       }
       
       if(ADD==1)
       {
           num+=Integer.parseInt(words.get(i));
//         System.out.println("ADDING = "+num);  ENABLE FOR DEBUGGING MULTIPLICATION
           continue;
       }
       
       }
       catch(Exception e)
       {continue;}
       
        if(i==words.size()-1 && ADD==0){
          words.add(i,Integer.toString(con_cal(words.get(i))));
          words.remove(i+1);
          i=-1;
          ADD=1;
          num=0;
        }
   }
  
   
    // System.out.println(words); ENABLE TO CHECK LAST ANSWER ARRAY I MEAN JUST TRY IT YOU'LL GET IT
    return num;
     }
       
       
}
     
public class Temp {

    public static void main(String[] args){
        
        try
        {
        System.out.println("MY ANSWER = "+Parser.parseInt("one"));
        System.out.println("CORRECT ANSWER = 1\n");
        }
        catch(Exception e)
        {System.err.println("Exception Caught at Problem 1\n");}
        
        try
        {
        System.out.println("MY ANSWER = "+Parser.parseInt("twenty"));
        System.out.println("CORRECT ANSWER = 20\n");
        }
        catch(Exception e)
        {System.err.println("Exception Caught at Problem 2\n");}
        
        try
        {
        System.out.println("MY ANSWER = "+Parser.parseInt("two hundred forty six"));
        System.out.println("CORRECT ANSWER = 246\n");
        }
        catch(Exception e)
        {System.err.println("Exception Caught at Problem 3\n");}
        
        try
        {
        System.out.println("MY ANSWER = "+Parser.parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
        System.out.println("CORRECT ANSWER = 783919\n");
        }
        catch(Exception e)
        {System.err.println("Exception Caught at Problem 4\n");}
        
    }
    
}


