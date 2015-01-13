import java.util.Scanner;

public class Doomsday {
    public enum DayOfWeek {
        DAY_SUNDAY("Sunday"),
        DAY_MONDAY("Monday"),
        DAY_TUESDAY("Tuesday"),
        DAY_WEDNESDAY("Wednesday"),
        DAY_THURSDAY("Thursday"),
        DAY_FRIDAY("Friday"),
        DAY_SATURDAY("Saturday");

        private final String name;

        private DayOfWeek(String dayName) {
            name = dayName;
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Doomsday Calculator!");

        boolean validYear = false;
        int year = 0;

        while (!validYear) {
            System.out.print("What year are you looking for? ");

            if (!input.hasNextInt()) {
                System.out.println("That isn't valid! Please enter the year as "
                                   + "an integer.");

                input.next();

                continue;
            }

            year = input.nextInt();

            if (year < 1) {
                System.out.println("That isn't valid! Please enter a year "
                                   + "within the Common Era.");

                continue;
            }

            validYear = true;
            break;
        }

        boolean validMonth = false;
        int month = 0;

        while (!validMonth) {
            System.out.print("What month (1-12)? ");

            if (!input.hasNextInt()) {
                System.out.println("That isn't valid! Please enter the month "
                                   + "as an integer.");

                input.next();

                continue;
            }

            month = input.nextInt();

            if (month < 1 || month > 12) {
                System.out.println("That isn't valid! Please enter the month "
                                   + "as an integer from 1 to 12 where January "
                                   + "= 1, February = 2, ..., December = 12.");

                continue;
            }

            validMonth = true;
            break;
        }

        boolean validDay = false;
        int day = 0;

        while (!validDay) {
            System.out.print("What day? ");

            if (!input.hasNextInt()) {
                System.out.println("That isn't valid! Please enter the day as "
                                   + "an integer.");

                input.next();

                continue;
            }

            day = input.nextInt();

            if (day < 1 || day > getDaysInMonth(year, month)) {
                System.out.println("That isn't valid! Please enter a day "
                                   + "within the month you specified earlier.");

                continue;
            }

            validDay = true;
            break;
        }

        DayOfWeek dayOfWeek = getDayOfWeek(year, month, day);

        System.out.println("");
        System.out.println(String.format("%04d", year) + "-"
                           + String.format("%02d", month) + "-"
                           + String.format("%02d", day) + " was on a "
                           + dayOfWeek + ".");
    }

    static DayOfWeek getDayOfWeek(int year, int month, int day) {
        int a = (year % 100) / 12;
        int b = (year % 100) % 12;
        int c = b / 4;

        int anchor = (5 * ((year / 100) % 4)) + 2;

        int doomsday = (a + b + c + anchor);

        int dayOfWeek = doomsday;
        if (month == 1) {
            if (isLeapYear(year)) {
                dayOfWeek += day - 4;
            } else {
                dayOfWeek += day - 3;
            }
        } else if (month == 2) {
            if (isLeapYear(year)) {
                dayOfWeek += day - 29;
            } else {
                dayOfWeek += day - 28;
            }
        } else if (month == 3) {
            dayOfWeek += day - 7;
        } else if (month == 4) {
            dayOfWeek += day - 4;
        } else if (month == 5) {
            dayOfWeek += day - 9;
        } else if (month == 6) {
            dayOfWeek += day - 6;
        } else if (month == 7) {
            dayOfWeek += day - 11;
        } else if (month == 8) {
            dayOfWeek += day - 8;
        } else if (month == 9) {
            dayOfWeek += day - 5;
        } else if (month == 10) {
            dayOfWeek += day - 10;
        } else if (month == 11) {
            dayOfWeek += day - 7;
        } else if (month == 12) {
            dayOfWeek += day - 12;
        }

        dayOfWeek = dayOfWeek % 7;
        if (dayOfWeek < 0) {
            dayOfWeek += 7;
        }

        return DayOfWeek.values()[dayOfWeek];
    }

    static int getDaysInMonth(int year, int month) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                return true;
            }
        }

        return false;
    }
}
