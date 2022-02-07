public class DateObj {

    private int year;
    private int month;//1,2,3,4,5,6,7,8,9,10,11,12
    private int day;
    private int[] monthLengths = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public DateObj(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        validate();
    }

    public DateObj() {

    }


    public DateObj nextDate() {
        
        if (this.day<this.monthLengths[this.month-1]){//1,2,3 correspond to 0,1,2
            return new DateObj(this.year, this.month, this.day+1);

        }
        else if (this.day==this.monthLengths[this.month-1]&&this.month!=12){//make sure month doesn't turn 13
            if(this.month==2&&this.day==this.monthLengths[this.month-1]&&this.year%4==0){
                return new DateObj(this.year, 2, 29);
            }
            else if (this.month==2&&this.day==29&&this.year%4==0){
                return new DateObj(this.year, 3,1);
            }
            else{
            return new DateObj(this.year, this.month+1, 1);}
        }
         if (this.month==12 && this.day==31){ 
            return new DateObj (this.year+1, 1, 1);

        }else return null;
        
    }

    @Override
    public String toString() {
        return String.format("Date[year: %d, month: %d, day: %d]", year, month, day);
    }

    private void validate() {
        if (this.month>0&&this.month<=12&&this.day>0&&this.day<=monthLengths[this.month-1]){
            System.out.println("Valid");
        }else if (this.month==2&&this.year%4==0&&this.day==29){
            System.out.println("Valid");}else{
                throw new IllegalArgumentException("Invalid");
            
            
        }
      
    }

    public static void main(String[] args) {
        DateObj day1 = new DateObj(2020,4,30);
        DateObj day2 = new DateObj(2020,12,31);
        DateObj day3 = new DateObj(2020,2,28);
        DateObj day4 = new DateObj(2021,5,20);

        DateObj dayNext1 = day1.nextDate();
        DateObj dayNext2 = day2.nextDate();
        DateObj dayNext3 = day3.nextDate();
        DateObj dayNext4 = day4.nextDate();

        System.out.println("Initial date is "+day1+" next date is "+dayNext1);
        System.out.println("Initial date is "+day2+" next date is "+dayNext2);
        System.out.println("Initial date is "+day3+" next date is "+dayNext3);
        System.out.println("Initial date is "+day4+" next date is "+dayNext4);

    }

}
