public class Main {

        //                                 1  2  3  4  5  6  7  8  9 10 11 12
        static int[] monthsDaysNumbers = {31,28,31,30,31,30,31,31,30,31,30,31};
        static int[] monthsDaysNumbersBi = {31,29,31,30,31,30,31,31,30,31,30,31};

        public static void main(String[] args) {

            int lastDay = 1;
            int lastMonth = 0;
            int lastYear = 2000;

            int currentDay = 2;
            int currentMonth = 0;
            int currentYear = 2000;

            int daysBetween = 0;

            Main main = new Main();

            daysBetween = main.calculateDaysBetween(lastDay,lastMonth,lastYear,currentDay,currentMonth,currentYear);

            System.out.println("daysBetween = " + daysBetween);

            System.out.println("TEST Y1 == y2 m1 == m2 d1 == d2  " +
                    (main.calculateDaysBetween(1,1,2000,1,1,2000) == 0));
            System.out.println("TEST Y1 == y2 m1 == m2 d1 != d2  " +
                    (main.calculateDaysBetween(1,1,2000,3,1,2000) == 2));


            System.out.println();
            System.out.println("alg2");
            //alg2

            //1/1 - 3/2 = +31 +3 =34
            System.out.println("TEST ALG2 jan - feb - 1 - 3 = " +
                    (main.alg2(1,0,3,1,monthsDaysNumbers) == (31+3)));
            //29/1 - 3/2 = 29 30 31 1 2 3 = +3 +3 = 6
            System.out.println("TEST ALG2 jan - feb - 29 - 3 = " +
                    (main.alg2(29,0,3,1,monthsDaysNumbers) == (3+3)));
            // 29/1 - 29/2 = 29 30 31 +29 = +3 +29
            System.out.println("TEST ALG2 jan - feb - 29 - 29 = " +
                    (main.alg2(29,0,29,1,monthsDaysNumbers) == (3+29)));
            //29/1 - 3/3 = +3 +28* +3
            System.out.println("TEST ALG2 jan - mar - 29 - 3 = " +
                    (main.alg2(29,0,3,2,monthsDaysNumbers) == (3+28+3)));
            //29/1 - 3/4 = +3 +28* +31 +3
            System.out.println("TEST ALG2 jan - apr - 29 - 3 = " +
                    (main.alg2(29,0,3,3,monthsDaysNumbers)==3 +28 +31 +3));
            //29/1 - 3/5 = +3 +28* +30 +31 +3
            System.out.println("TEST ALG2 jan - may - 29 - 3 = " +
                    (main.alg2(29,0,3,4,monthsDaysNumbers) == +3 +28 +31 +30 +3));
//            //29/1 - 3/3 =
//            System.out.println("TEST ALG2 jan - jun - 29 - 3 = " + (main.alg2(29,0,3,5,monthsDaysNumbers)));
//            //29/1 - 3/3 =
//            System.out.println("TEST ALG2 jan - jul - 29 - 3 = " + (main.alg2(29,0,3,6,monthsDaysNumbers)));
//            //29/1 - 3/3 =
//            System.out.println("TEST ALG2 jan - aug - 29 - 3 = " + (main.alg2(29,0,3,7,monthsDaysNumbers)));
//            //29/1 - 3/3 =
//            System.out.println("TEST ALG2 jan - oct - 29 - 3 = " + (main.alg2(29,0,3,8,monthsDaysNumbers)));
//            //29/1 - 3/3 =
            System.out.println("TEST ALG2 jan - nov - 29 - 3 = " + (main.alg2(29,0,3,10,monthsDaysNumbers)== +3 +28 +31 +30 +31 +30 +31 +31 +30 +31 +3));
            //                   2   3   4   5   6   7   8   9  10  11 12
            //29/1 - 3/12 = +3 +28 +31 +30 +31 +30 +31 +31 +30 +31 +30 +3
            System.out.println("TEST ALG2 jan - dez - 29 - 3 = " + (main.alg2(29,0,3,11,monthsDaysNumbers) == +3 +28 +31 +30 +31 +30 +31 +31 +30 +31 +30 +3));

            System.out.println();

            //alg3
            System.out.println("alg3");

            // 29/12/2001 - 3/1/2002 = 29 30 31 1 2 3 = 6
            System.out.println("TEST ALG3 dez - jan - 29 - 3 -2001 - 2002 = " +
                    (main.alg3(29,11,2001,3,0,2002)==6));

            // 29/12/2002 - 3/3/2003 = 29 30 31 +31 +28  1 2 3 = +3 +31 +28 +3
            System.out.println("TEST ALG3 dez - apr - 29 - 3 -2002 - 2003 = " +
                    (main.alg3(29,11,2002,3,2,2003) == +3 +31 +28 +3));

            // 29/12/2003 - 3/3/2004 = 29 30 31 +31 +29  1 2 3 = +3 +31 +29 +3
            System.out.println("TEST ALG3 dez - apr - 29 - 3 -2002 - 2003 = " +
                    (main.alg3(29,11,2003,3,2,2004) == +3 +31 +29 +3));

            //                                  2002 2003 2004
            // 29/12/2001 - 3/3/2005 = 29 30 31 +365 +365 +366 +31 +28  1 2 3 = +3 +365 +365 +366 +31 +28 +3
            System.out.println("TEST ALG3 dez - mar - 29 - 3 -2001 - 2005 = " +
                    (main.alg3(29,11,2001,3,2,2005)==+3 +365 +365 +366 +31 +28 +3));

            // 15 - 1 = 14 - 3 -1 = 10*365
            // 2004 2008 2012 = 3*366
            // 29/12/2001 - 3/1/2015 =
            System.out.println("TEST ALG3 dez - mar - 29 - 3 -2001 - 2015 = " +
                    (main.alg3(29,11,2001,3,2,2015)==
                            +3 +31 +28 +3 +10*365 +3*366));

            //bissextile
            System.out.println();
            System.out.println("bissextile");
            //28 29 1 = 3
            System.out.println("TEST Y1 == Y2 feb mar 28 - 1 = " +
                    (main.calculateDaysBetween(28,1,2000,1,2,2000)==3));
            //27 28 29 1 2 3 = 5
            System.out.println("TEST Y1 == Y2 feb mar 27 - 2  = " +
                    (main.calculateDaysBetween(27,1,2000,2,2,2000) == 5));
            //31 +29  1 = 29 + 2 = 31
            System.out.println("TEST Y1 == Y2 jan mar 31 - 1  = " +
                    (main.calculateDaysBetween(31,0,2000,1,2,2000) == (29+2) ));
            //31 +29 +30 +31 +30 +1 = +1 + 29 + 31 + 30 + 31 +1 =
            System.out.println("TEST Y1 == Y2 jan jun 31 - 1  = " +
                    (main.calculateDaysBetween(31,0,2000,1,5,2000) == (+1 + 29 + 31 + 30 + 31 +1) ));

            System.out.println();
            //alg3

            System.out.println("alg3");
            System.out.println("Test alg3 1/1/2000 - 1/1/2001 = " +
                    main.alg3(1,0,2000,1,0,2001));

        }

        public int calculateDaysBetween(
                int d1, int m1, int y1,
                int d2, int m2, int y2
        ){

            if(y1 == y2){
                if(m1 == m2){
                    if(d1 == d2){
                        return 0;
                    }else{//alg1     d1!= d2
                        return d2-d1;
                    }
                }else{//alg2         m1!= m2
                    if(y1%4==0){
                        return alg2(d1,m1,d2,m2,monthsDaysNumbersBi) ;
                    }
                    //year not bissextile
                    return alg2(d1,m1,d2,m2,monthsDaysNumbers) ;
                }
            }else{// alg3 ->    y1 != y2
                return alg3(d1,m1,y1,d2,m2,y2) ;
            }
        }

        public int alg2(int d1, int m1, int d2, int m2, int[] a){
            int result = 0;
            for(int i = m1;i<m2;i++){
                result = result+a[i];
            }
            result = result + (-d1 + 1) + d2;
            return result;


        }

        public int alg3(int d1, int m1, int y1,
                        int d2, int m2, int y2
        ){
            int result=0;
            //diff (d1/m1/y1 - 31/12/y1) + sDayYearBetween + alg2(01/01/y2 - d2/m2/y2)

            if(y2-y1==1){//days between date1 and last day of y1

                if(itIsBissextile(y1)){
                    // date1 < 29/02 and date2 > 28/02
                    //days from date1 to last day of y1
                    result = alg2(d1,m1,31,11,monthsDaysNumbersBi);

                    if(itIsBissextile(y2)){
                        //days from first day in y2 and date2
                        result = result + alg2(01,0,d2,m2,monthsDaysNumbersBi);
                    }else {//y2 is not bissextile
                        result = result + alg2(01,0,d2,m2,monthsDaysNumbers);
                    }

                }else{ //y1 is not bissextile
                // date1 < 29/02 and date2 > 28/02
                //days from date1 to last day of y1
                result = alg2(d1,m1,31,11,monthsDaysNumbers);

                    if(itIsBissextile(y2)){
                        //days from first day in y2 and date2
                        result = result + alg2(01,0,d2,m2,monthsDaysNumbersBi);
                    }else {//y2 is not bissextile
                        result = result + alg2(01,0,d2,m2,monthsDaysNumbers);
                    }

                }

            }else if(y2-y1>1){

                if(itIsBissextile(y1)){
                    // date1 < 29/02 and date2 > 28/02
                    //days from date1 to last day of y1
                    result = alg2(d1,m1,31,11,monthsDaysNumbersBi);

                    for (int i = (y1+1) ;i < y2; i++){ //sumDaysBetween y1 y2
                        if(i%4==0){
                            result = result + 366;
                        }else{
                            result = result + 365;
                        }

                    }
                    if(itIsBissextile(y2)){
                        //days from first day in y2 and date2
                        result = result + alg2(01,0,d2,m2,monthsDaysNumbersBi);
                    }else {//y2 is not bissextile
                        result = result + alg2(01,0,d2,m2,monthsDaysNumbers);
                    }

                }else{ //y1 is not bissextile
                    // date1 < 29/02 and date2 > 28/02
                    //days from date1 to last day of y1
                    result = alg2(d1,m1,31,11,monthsDaysNumbers);

                    for (int i = (y1+1) ;i < y2; i++) { //sumDaysBetween y1 y2
                        if (i % 4 == 0) {
                            result = result + 366;
                        } else {
                            result = result + 365;
                        }
                    }

                    if(itIsBissextile(y2)){
                        //days from first day in y2 and date2
                        result = result + alg2(01,0,d2,m2,monthsDaysNumbersBi);
                    }else {//y2 is not bissextile
                        result = result + alg2(01,0,d2,m2,monthsDaysNumbers);
                    }
                }
            }

//            System.out.println("result = " + result);
            return result;
        }

        private boolean itIsBissextile(int year){
            return (year%4==0);
        }

}

