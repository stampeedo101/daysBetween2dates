import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    @Test
    void main() {

        calculateDaysBetween();
        sameYearAndDifferentMonth();
        allDifferent();
        itsValidInput();
    }

    @Test
    void calculateDaysBetween() {
        //bissextile

        //28 29 1 = 3
        assertEquals(3,main.calculateDaysBetween(28,1,2000,1,2,2000));

        //27 28 29 1 2 3 = 5
        assertEquals(5,main.calculateDaysBetween(27,1,2000,2,2,2000));

        //31 +29  1 = 29 + 2 = 31
        assertEquals((29+2),main.calculateDaysBetween(31,0,2000,1,2,2000));

        //31 +29 +30 +31 +30 +1 = +1 + 29 + 31 + 30 + 31 +1 =
        assertEquals((+1 + 29 + 31 + 30 + 31 +1),main.calculateDaysBetween(31,0,2000,1,5,2000));
    }

    @Test
    void sameYearAndDifferentMonth() {
        //alg2

        //1/1 - 3/2 = +31 +3 =34
        assertEquals( (31+3),main.sameYearAndDifferentMonth(1,0,3,1, Main.monthsDaysNumbers));

        //1/1 - 3/2 = +31 +3 =34
        assertEquals((31+3), main.sameYearAndDifferentMonth(1,0,3,1, Main.monthsDaysNumbers));

        //29/1 - 3/2 = 29 30 31 1 2 3 = +3 +3 = 6
        assertEquals((3+3), main.sameYearAndDifferentMonth(29,0,3,1, Main.monthsDaysNumbers) );

        //29/1 - 3/2 = 29 30 31 1 2 3 = +3 +3 = 6
        assertEquals((3+3),main.sameYearAndDifferentMonth(29,0,3,1, Main.monthsDaysNumbers));

        //29/1 - 3/2 = 29 30 31 1 2 3 = +3 +3 = 6
        assertEquals((3+3),main.sameYearAndDifferentMonth(29,0,3,1, Main.monthsDaysNumbers));

        //29/1 - 3/2 = 29 30 31 1 2 3 = +3 +3 = 6
        assertEquals( (3+3) ,main.sameYearAndDifferentMonth(29,0,3,1, Main.monthsDaysNumbers));

        // 29/1 - 29/2 = 29 30 31 +29 = +3 +29
        assertEquals((3+29),main.sameYearAndDifferentMonth(29,0,29,1, Main.monthsDaysNumbers));

        //29/1 - 3/3 = +3 +28* +3
        assertEquals((3+28+3),main.sameYearAndDifferentMonth(29,0,3,2, Main.monthsDaysNumbers));

        //29/1 - 3/4 = +3 +28* +31 +3
        assertEquals((3 +28 +31 +3),main.sameYearAndDifferentMonth(29,0,3,3, Main.monthsDaysNumbers));

        //29/1 - 3/5 = +3 +28* +30 +31 +3
        assertEquals((+3 +28 +31 +30 +3), main.sameYearAndDifferentMonth(29,0,3,4, Main.monthsDaysNumbers));

        //                   2   3   4   5   6   7   8   9  10  11 12
        //29/1 - 3/12 = +3 +28 +31 +30 +31 +30 +31 +31 +30 +31 +30 +3
        assertEquals((+3 +28 +31 +30 +31 +30 +31 +31 +30 +31 +30 +3),main.sameYearAndDifferentMonth(29,0,3,11, Main.monthsDaysNumbers));

        //29/1 - 3/3 =
        assertEquals((+3 +28 +31 +30 +31 +30 +31 +31 +30 +31 +3),main.sameYearAndDifferentMonth(29,0,3,10, Main.monthsDaysNumbers));

        /*

//            //29/1 - 3/3 =
//            System.out.println("TEST ALG2 jan - jun - 29 - 3 = " + (main.alg2(29,0,3,5,monthsDaysNumbers)));
//            //29/1 - 3/3 =
//            System.out.println("TEST ALG2 jan - jul - 29 - 3 = " + (main.alg2(29,0,3,6,monthsDaysNumbers)));
//            //29/1 - 3/3 =
//            System.out.println("TEST ALG2 jan - aug - 29 - 3 = " + (main.alg2(29,0,3,7,monthsDaysNumbers)));
//            //29/1 - 3/3 =
//            System.out.println("TEST ALG2 jan - oct - 29 - 3 = " + (main.alg2(29,0,3,8,monthsDaysNumbers)));


                */
    }

    @Test
    void allDifferent() {
        //alg3

        // 29/12/2001 - 3/1/2002 = 29 30 31 1 2 3 = 6
        assertEquals(6, main.allDifferent(29,11,2001,3,0,2002));

        // 29/12/2002 - 3/3/2003 = 29 30 31 +31 +28  1 2 3 = +3 +31 +28 +3
        assertEquals((+3 +31 +28 +3), main.allDifferent(29,11,2002,3,2,2003));

        // 29/12/2003 - 3/3/2004 = 29 30 31 +31 +29  1 2 3 = +3 +31 +29 +3
        assertEquals((+3 +31 +29 +3),main.allDifferent(29,11,2003,3,2,2004));

        //                                  2002 2003 2004
        // 29/12/2001 - 3/3/2005 = 29 30 31 +365 +365 +366 +31 +28  1 2 3 = +3 +365 +365 +366 +31 +28 +3
        assertEquals((+3 +365 +365 +366 +31 +28 +3),main.allDifferent(29,11,2001,3,2,2005));

        // 15 - 1 = 14 - 3 -1 = 10*365
        // 2004 2008 2012 = 3*366
        // 29/12/2001 - 3/1/2015 =
        assertEquals((+3 +31 +28 +3 +10*365 +3*366),main.allDifferent(29,11,2001,3,2,2015));

    }

    @Test
    void itsValidInput(){

        //31 +29 +30 +31 +30 +1 = +1 + 29 + 31 + 30 + 31 +1 =
        //error d1 > 31
        assertEquals(0, main.calculateDaysBetween(32,0,2000,1,5,2000));

        //31 +29 +30 +31 +30 +1 = +1 + 29 + 31 + 30 + 31 +1 =
        //error m1 > 11
        assertEquals(0,main.calculateDaysBetween(31,12,2000,1,5,2000));

        //31 +29 +30 +31 +30 +1 = +1 + 29 + 31 + 30 + 31 +1 =
        assertEquals(0,main.calculateDaysBetween(31,0,0,1,5,2000));

    }


}