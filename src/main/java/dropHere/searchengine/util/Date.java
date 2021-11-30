package dropHere.searchengine.util;

public class Date {
    private int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        if (!isValidDate(day, month, year)) {
            System.out.println("Der " + this + " ist kein valides Datum");
            this.day = -1;
            this.month = -1;
            this.year = -1;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int yearsUntil(Date other) {
        if (!Date.isValidDate(other.day, other.month, other.year) || !Date.isValidDate(day, month, year)) {
            System.out.println("Methode auf ungültigem Datum aufgerufen!");
        }

        Date past = Date.smallestDate(this, other).copy();
        Date fut = Date.greatestDate(this, other).copy();

        int years = fut.getYear()-past.getYear();

        int pYear = past.year;
        past.year = fut.year;

        //years += fut.isSmallerThan(past) ? -1 : 0;
        years += fut.daysUntil(past) > 0 ? -1 : 0; // used daysUntil

        past.year = pYear;

        return past.equals(this) ? years : -years-1;
    }

    public int daysUntil(Date other) {
        if (!Date.isValidDate(other.day, other.month, other.year) || !Date.isValidDate(day, month, year)) {
            System.out.println("Methode auf ungültigem Datum aufgerufen!");
        }

        if (this.year == other.year) {
            return other.daysPassedThisYear()-this.daysPassedThisYear();
        }

        int days = 0;
        Date past = Date.smallestDate(this, other);
        Date fut = Date.greatestDate(this, other);

        int minYears = fut.getYear()-past.getYear()-1;

        days += past.daysLeftThisYear();

        for (int i = 1; i <= minYears; i++) {
            days += daysInYear(i+past.getYear());
        }

        days += fut.daysPassedThisYear();

        return past==this ? days : -days;
    }

    public boolean equals(Date other) {
        if (this == other) return true;
        if (other == null) return false;

        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public String toString() {
        return String.format("%s.%s.%s", day, month, year);
    }

    public static Date today() {
        return dateMillisecondsAfterNewYear1970(System.currentTimeMillis());
    }

    // <|================ HILFSMETHODEN ================|>

    public static Date dateMillisecondsAfterNewYear1970(long millis) {
        int days;
        if (millis >= 0) {
            days = (int)(millis/(1000.0*24.0*3600.0));
        } else {
            days = (int)(millis/(1000.0*24.0*3600.0))-1;
        }

        Date fix = new Date(1,1,1970);

        return Date.int2Day(Date.date2Int(fix)+days);
    }

    public int daysLeftThisYear() {
        if (!Date.isValidDate(day, month, year)) {
            System.out.println("Methode auf ungültigem Datum aufgerufen!");
        }

        int days = 0;
        for (int i = this.month+1; i <= 12; i++) {
            days += daysInMonth(i, this.year);
        }
        days += daysInMonth(this.month, this.year) - this.day;
        return days;
    }

    public int daysPassedThisYear() {
        if (!Date.isValidDate(day, month, year)) {
            System.out.println("Methode auf ungültigem Datum aufgerufen!");
        }

        int days = 0;
        for (int i = 1; i < this.month; i++) {
            days += daysInMonth(i, this.year);
        }
        days += this.day;
        return days;
    }

    public boolean isGreaterThan(Date b) {
        if (year > b.year || (year == b.year && month > b.month) ||
                (year == b.year && month == b.month && day > b.day)) {
            return true;
        }
        return false;
    }

    public boolean isSmallerThan(Date b) {
        if (year < b.year || (year == b.year && month < b.month) ||
                (year == b.year && month == b.month && day < b.day)) {
            return true;
        }
        return false;
    }

    // return a deep copy of invalid and valid Dates
    private Date copy() {
        Date d = new Date(1,1,1);
        d.day = day; d.month = month; d.year = year;
        return d;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static int daysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> -1; // invalid
        };
    }

    public static int daysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    public static boolean isValidDate(int day, int month, int year) {
        return !(month <= 0 || month > 12 || day > Date.daysInMonth(month, year) || day <= 0);
    }

    // when equal returns b
    private static Date smallestDate(Date a, Date b) {
        if (a.isSmallerThan(b)) {
            return a;
        }

        return b;
    }

    // when equal returns b
    private static Date greatestDate(Date a, Date b) {
        if (a.isGreaterThan(b)) {
            return a;
        }

        return b;
    }

    // reference day (1,1,0) = day 0; (2,1,0) = day 1 etc...
    public static int date2Int(Date d) {
        return new Date(1,1,0).daysUntil(d);
    }

    public static Date int2Day(int d) {
        // estimate roughly:
        int years = d/365;

        Date date = new Date(1,1,years);

        int c = Date.date2Int(date);
        while (c!=d) {
            if (c<d) {
                date.addOneDay();
            } else {
                date.subOneDay();
            }
            c = Date.date2Int(date);
        }

        return date;
    }

    public void addOneDay() {
        if (isValidDate(day+1, month, year)) {
            day += 1;
            return;
        } else if (isValidDate(day, month+1, year)) {
            month += 1;
            day = 1;
            return;
        } else if (isValidDate(day, month, year+1)) {
            month = 1;
            day = 1;
            year += 1;
            return;
        }

        throw new Error("Programm should not get here!");
    }

    public void subOneDay() {
        if (isValidDate(day-1, month, year)) {
            day -= 1;
            return;
        } else if (isValidDate(daysInMonth(month-1, year), month-1, year)) {
            month -= 1;
            day = daysInMonth(month, year);
            return;
        } else if (isValidDate(daysInMonth(month, year-1), month, year-1)) {
            year -= 1;
            month = 12;
            day = daysInMonth(month, year);
            return;
        }

        throw new Error("Programm should not get here!");
    }

}
