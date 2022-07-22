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








        }

        public int calculateDaysBetween(
                int d1, int m1, int y1,
                int d2, int m2, int y2
        ){
            if(!(itsValidInput(d1,m1,y1,d2,m2,y2))){
                return 0;
            }

            if(y1 == y2){
                if(m1 == m2){
                    if(d1 == d2){
                        return 0;
                    }else{//alg1     d1 != d2
                        return d2-d1;
                    }
                }else{//alg2         m1 != m2
                    if(y1%4==0){
                        //year bissextile
                        return sameYearAndDifferentMonth(d1,m1,d2,m2,monthsDaysNumbersBi) ;
                    }
                    //year not bissextile
                    return sameYearAndDifferentMonth(d1,m1,d2,m2,monthsDaysNumbers) ;
                }
            }else{// alg3 ->    y1 != y2
                return allDifferent(d1,m1,y1,d2,m2,y2) ;
            }
        }

        public int sameYearAndDifferentMonth(int d1, int m1, int d2, int m2, int[] year){
            int result = 0;
            //sum of days from months between dates
            for(int i = m1;i<m2;i++){
                result = result+year[i];
            }
            result = result + (-d1 + 1) + d2;
            return result;

        }

        public int allDifferent(int d1, int m1, int y1,
                                int d2, int m2, int y2
        ){
            int result=0;
            //diff (d1/m1/y1 - 31/12/y1) + sumDayYearsBetween + alg2(01/01/y2 - d2/m2/y2)

            if(y2-y1 == 1){//days between date1 and last day of y1 + days between the first day in y2 and date2

                if(itIsBissextile(y1)){
                    //days between date1 and last day of y1
                    result = sameYearAndDifferentMonth(d1,m1,31,11,monthsDaysNumbersBi);

                    if(itIsBissextile(y2)){
                        //days between the first day in y2 and date2
                        result = result + sameYearAndDifferentMonth(01,0,d2,m2,monthsDaysNumbersBi);
                    }else {//y2 is not bissextile
                        result = result + sameYearAndDifferentMonth(01,0,d2,m2,monthsDaysNumbers);
                    }

                }else{ //y1 is not bissextile
                //days between date1 and last day of y1
                result = sameYearAndDifferentMonth(d1,m1,31,11,monthsDaysNumbers);

                    if(itIsBissextile(y2)){
                        //days between the first day and y2 and date2
                        result = result + sameYearAndDifferentMonth(01,0,d2,m2,monthsDaysNumbersBi);
                    }else {//y2 is not bissextile
                        result = result + sameYearAndDifferentMonth(01,0,d2,m2,monthsDaysNumbers);
                    }

                }

            }else{

                if(itIsBissextile(y1)){
                    //days between date1 and last day of y1
                    result = sameYearAndDifferentMonth(d1,m1,31,11,monthsDaysNumbersBi);

                    for (int i = (y1+1) ;i < y2; i++){ //sumDaysBetween y1 y2
                        if(i%4==0){
                            result = result + 366;
                        }else{
                            result = result + 365;
                        }

                    }
                    if(itIsBissextile(y2)){
                        //days between the first day in y2 and date2
                        result = result + sameYearAndDifferentMonth(01,0,d2,m2,monthsDaysNumbersBi);
                    }else {//y2 is not bissextile
                        result = result + sameYearAndDifferentMonth(01,0,d2,m2,monthsDaysNumbers);
                    }

                }else{ //y1 is not bissextile
                    //days between date1 and last day of y1
                    result = sameYearAndDifferentMonth(d1,m1,31,11,monthsDaysNumbers);

                    for (int i = (y1+1) ;i < y2; i++) { //sumDaysBetween y1 y2
                        if (i % 4 == 0) {
                            result = result + 366;
                        } else {
                            result = result + 365;
                        }
                    }

                    if(itIsBissextile(y2)){
                        //days between the first day in y2 and date2
                        result = result + sameYearAndDifferentMonth(01,0,d2,m2,monthsDaysNumbersBi);
                    }else {//y2 is not bissextile
                        result = result + sameYearAndDifferentMonth(01,0,d2,m2,monthsDaysNumbers);
                    }
                }
            }

//            System.out.println("result = " + result);
            return result;
        }

        private boolean itsValidInput(int d1, int m1, int y1, int d2, int m2, int y2){
            if(y1 < 1){
                System.out.println("y1 error");
                return false;
            }

            if(y2 < 1){
                System.out.println("y2 error");
                return false;
            }

            if(!(m1 >= 0 && m1 < 12)){
                System.out.println("m1 error");
                return false;
            }

            if(!(m2 >= 0 && m2 < 12)){
                System.out.println("m2 error");
                return false;
            }

            if(itIsBissextile(y1)){
                if(!(d1 > 0 && d1 <= monthsDaysNumbersBi[m1])){
                    System.out.println("d1 error");
                    return false;
                }

            }else {
                if(!(d1 > 0 && d1 <= monthsDaysNumbers[m1])){
                    System.out.println("d1 error");
                    return false;
                }
            }


            if(itIsBissextile(y2)){
                if(!(d2 > 0 && d2 <= monthsDaysNumbersBi[m2])){
                    System.out.println("d2 error");
                    return false;
                }

            }else {
                if(!(d2 > 0 && d2 <= monthsDaysNumbers[m2])){
                    System.out.println("d2 error");
                    return false;
                }
            }

            if(y1 == y2){
                if(m1 == m2){
                    if(d1 > d2) return false;
                }else{
                    if(m1 > m2) return false;
                }
            }else if(y1 > y2) return false;

            return true;
        }

        private boolean itIsBissextile(int year){
            return (year%4==0);
        }

}

