import org.junit.Test;
import org.junit.runner.*;
import org.junit.runner.notification.*;




public class JunitTest {
    @Test
    public void normalNext(){
        DateObj date1 = new DateObj(2021,5,20);
        DateObj date2 = new DateObj(2021,5,21);
        
        org.junit.Assert.assertEquals(date1.nextDate().toString(), date2.toString());
    }

    @Test
    public void newMonth(){ 
        DateObj dateNewMonth1 = new DateObj(2020,4,30);
        DateObj dateNewMonth2 = new DateObj(2020,5,1);
        
        org.junit.Assert.assertEquals(dateNewMonth1.nextDate().toString(), dateNewMonth2.toString());

    }

    @Test
    public void newYear(){ 
        DateObj dateNewYear1 = new DateObj(2020,12,31);
        DateObj dateNewYear2 = new DateObj(2021,1,1);
        
        org.junit.Assert.assertEquals(dateNewYear1.nextDate().toString(), dateNewYear2.toString());

    }

    @Test
    public void February(){ 
        DateObj dateFeb = new DateObj(2020,2,28);
        DateObj dateFebNext = new DateObj(2020,2,29);
        
        org.junit.Assert.assertEquals(dateFeb.nextDate().toString(), dateFebNext.toString());

    }


    public static void main(String[] args){
        Result result = JUnitCore.runClasses(JunitTest.class);

        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());}

        System.out.println("total cases:" +result.getRunCount());
        System.out.println("failures:" +result.getFailures().size());

    }


}
