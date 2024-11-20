/* ---------------------------------- Ostern.java ---------------------------------- *\

  Pfingsten ist sieben Wochen später (49 Tage )
  Gegeben : jahr  (das Jahr)
  Es geht um die Berechnung der Größen d und e

  p = jahr div 100
  q = p div 3
  r = p div 4

  x = (15+p-q-r) mod 30
  y = (4+p-r) mod 7

  a = jahr mod 19
  b = jahr mod 4
  c = jahr mod 7

  d = (19*a+x) mod 30
  e = (2*b+4*c+6*d+y) mod 7

  ist nun

  d==29 && e==6  => Ostern am 19.April
  d==28 && e==6  => Ostern am 18.April

  ansonsten gilt

  22+d+e < 32  =>  Ostern am (22+d+e).März

  22+d+e >=32  =>  Ostern am (d+e-9).April

  Die Formel ergibt :

  frühester Ostertermin :  22.03.1598
  spätester Ostertermin :  25.04.1666

  Ostern => Pfingsten

  22.03. => 10.05.
  31.03. => 19.05.
  01.04. => 20.05.
  12.04. => 31.05.
  13.04. => 01.06.
  25.04. => 13.06.

  if (monat==3)
  {
      ptag = tag-12; pmonat=5;
  }
  else if (monat==4 && tag < 13)
  {
      ptag = tag+19 ; pmonat=5;
  }
  else
  {
      ptag = tag-12 ; pmonat = 6 ;
  }
\* ---------------------------------- Ostern.java ---------------------------------- */

import java.util.Scanner;
public class Ostern
{
  public static void main(String[] args)
  {
      int a, b, c, d, e, p, q, r, x, y, tag, monat, jahr ;
      int ptag, pmonat ;

      System.out.println("Berechnung des Osterdatums nach Gauss");
      System.out.print("Jahreszahl : ");
      Scanner scanObj = new Scanner(System.in);
      jahr = scanObj.nextInt();
      scanObj.close();

      //Es geht um die Berechnung der Größen d und e
      //Dazu braucht man die 9 Hilfsgrößen a, b, c, p, n, q, r, x, y !!

      p = jahr/100 ;

      q = p/3 ;       r = p/4 ;

      x = (15+p-q-r)%30 ;     y = (4+p-r)%7 ;

      a = jahr%19 ;   b = jahr%4 ;    c = jahr%7 ;

      d = (19*a+x)%30 ;
      e = (2*b+4*c+6*d+y)%7 ;

      if (d==29 && e==6)
      {
          //=> Ostern am 19.April
          tag=19; monat=4;
      }
      else if (d==28 && e==6)
      {
          //=> Ostern am 18.April
          tag=18; monat=4;
      }
      else if (22+d+e < 32) //ansonsten gilt
      {
          //=>  Ostern am (22+d+e).März
          tag=22+d+e; monat=3;
      }
      else
      {
          // =>  Ostern am (d+e-9).April
          tag=d+e-9; monat=4;
      }

      System.out.print("Ostern ist/war am ");

      if (tag < 10)
          System.out.println("0"+tag+"."+"0"+monat+"."+jahr) ;
      else
          System.out.println(""+tag+"."+"0"+monat+"."+jahr) ;

      /* Berechnung des Pfingsdatums
      if (monat==3)
      {
          ptag = tag-12; pmonat=5;
      }
      else if (monat==4 && tag < 13)
      {
          ptag = tag+19 ; pmonat=5;
      }
      else
      {
          ptag = tag-12 ; pmonat = 6 ;
      }

      System.out.print("Pfingsten ist/war am ");

      if (ptag < 10)
          System.out.println("0"+ptag+"."+"0"+pmonat+"."+jahr) ;
      else
          System.out.println(""+ptag+"."+"0"+pmonat+"."+jahr) ;
          */

  } // ende main

} // ende class