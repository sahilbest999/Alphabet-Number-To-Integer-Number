import java.util.*;


class Parser {
static int t_length=1;
 public static List<String> splitThem(String str)
  {
    String words[] = str.replace(" and "," ").split("( )+");
    ArrayList<String> s_words = new ArrayList<String>();
    int highest_inx=-1,size_added=0;
    String highest="none";
    
       for(int i = 0;i<words.length-1;i++)
       {
         s_words.add(words[i]);
         if(!(words[i+1].equals("hundred") || words[i+1].equals("thousand") ||words[i+1].equals("million")))
         s_words.add("+");
         else
         s_words.add("*");
       }
       
       s_words.add(words[words.length - 1]);       
      
       if(s_words.contains("million") && (s_words.contains("hundred") || s_words.contains("thousand")))
        {
           if(s_words.indexOf("hundred")<s_words.indexOf("million") || s_words.indexOf("thousand")<s_words.indexOf("million"))
            {
                highest="million";
                highest_inx=s_words.indexOf("million");
            }
        }
        else if(s_words.contains("thousand")  && s_words.contains("hundred"))
        {
            if(s_words.indexOf("hundred")<s_words.indexOf("thousand"))
            {
                highest="thousand";
                highest_inx=s_words.indexOf("thousand");
            }
        }
    
    if(highest_inx!=-1 )
            {
                for(int i = 0;i<s_words.size();i++)
                {

                     if((s_words.get(i).equals("hundred") || s_words.get(i).equals("thousand") || s_words.get(i).equals("million")))
                        {
                            s_words.add(1,highest);
                            s_words.add(1,"*");
                            break;
                        }
                }
            }
         
       return s_words;
  }
  
  public static String con_cal(String words)
  {
      if(words.contains("-"))
      {
          Integer num=0;
          for (String temp_var : words.replace("-"," ").split(" "))
          num+=Integer.parseInt(con_cal(temp_var));
          return Integer.toString(num);
      }
     
         switch(words){ 
         case "+":
         return "ADD";
         case "*":
         return "MUL";
         case "one":
         return "1";
         case "two":
         return "2";
         case "three":
         return "3";
         case "four":
         return "4";
         case "five":
         return "5" ;
         case "six":
         return "6";
         case "seven":
         return "7";
         case "eight":
         return "8"; 
         case "nine":
         return "9";
         case "ten":
         return "10";
         case "eleven":
         return "11";
         case "twelve":
         return "12";
         case "thirteen":
         return "13";
         case "fourteen":
         return "14";
         case "fifteen":
         return "15";
         case "sixteen":
         return "16";
         case "seventeen":
         return "17";
         case "eighteen":
         return "18";
         case "nineteen":
         return "19";
         case "twenty":
         return "20";
         case "thirty":
         return "30";
         case "forty":
         return  "40";   
         case "fifty":
         return  "50";
         case "sixty":
         return  "60";
         case "seventy":
         return  "70";
         case "eighty":
         return  "80"; 
         case "ninty":
         return  "90";
         case "hundred":
         return  "100";
         case "thousand":
         return  "1000";
         case "million":
         return "1000000";}

         return words;
     }


public static int parseInt(String str)
    {
        
        if(str.equals("")||str.equals(null))
            return 0;
        
       int num=1,ADD=0;
       List<String> words = splitThem(str);
         
   
   for(int i = 0;i<words.size();i++)
   { 
       try
       { 
           if(words.get(i).contains("-") && (Arrays.asList(words.get(i).split("-")).contains("hundred") || Arrays.asList(words.get(i).split("-")).contains("thousand") || Arrays.asList(words.get(i).split("-")).contains("million")))
           {
             String temp[] = words.get(i).split("-");
             if(!temp[0].equals("hundred") && !temp[0].equals("thousand") && !temp[0].equals("million")  )
             {
             words.remove(i);
             words.add(i,temp[1]);
             words.add(i,"*");
             words.add(i,temp[0]);
             }
           }
       if(words.get(i).equals("*") && ADD==0)
       {
       
       num = num*Integer.parseInt(con_cal(words.get(i-1)))*Integer.parseInt(con_cal(words.get(i+1)));
//       System.out.println(con_cal(words.get(i-1))+" x "+con_cal(words.get(i+1)+" = "+num));  //ENABLE FOR DEBUGGING MULTIPLICATION
       words.remove(i+1);
       words.remove(i-1);
       words.remove(i-1);
       words.add(i-1,Integer.toString(num));
       
       if(words.size()==1)
           return num;
       
       num=1;
       i=0;
       continue;
       }
       
       if(ADD==1)
       {
           num+=Integer.parseInt(words.get(i));
//         System.out.println("ADDING = "+num); // ENABLE FOR DEBUGGING ADDITION
           continue;
       }
       
       }
       catch(Exception e)
       {continue;}
       
        if(i==words.size()-1 && ADD==0){
          words.add(i,con_cal(words.get(i)));
          words.remove(i+1);
          i=-1;
          ADD=1;
          num=0;
        }
   }
  
   
//   System.out.println(words); //ENABLE TO CHECK LAST ANSWER ARRAY I MEAN JUST TRY IT YOU'LL GET IT
    return num;
     }
       
       
}
    
public class Temp {

    public static void parse_str(String str,int ans)
    {
         try
        {
            int your_ans=Parser.parseInt(str);
            
            System.out.println("it's correct? - "+(your_ans==ans));
            if(Parser.parseInt(str)!=ans)
                System.out.println("Your Answer = "+your_ans);
        }
        catch(Exception e)
        {System.err.println("Exception Caught\n");}
    }
    
    public static void main(String[] args){
        
        parse_str("one",1);
        parse_str("twenty",20);
        parse_str("two hundred forty-six",246);
        parse_str("seven hundred eighty-three thousand nine hundred and nineteen",783919);
        parse_str("seven hundred",700);
        parse_str("hundred-ninty",190);
        parse_str("two million seventy-three",2000073);
        parse_str("two thousand four-hundred and eighty-six",2486);
    }
}
