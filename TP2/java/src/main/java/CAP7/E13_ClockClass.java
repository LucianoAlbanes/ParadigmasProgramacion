package CAP7;

/*
(Clock Class) Create a class called Clock that includes three instance variables—an hour
(type int), a minute (type int) and a second (type int). Provide a constructor that initializes the
three instance variables and assumes that the values provided are correct. Provide a set and a get
method for each instance variable. The set method should set the value of all three variables to 0 if
the value of hour is more than 23, the value of minute is more than 59, and the value of second is
more than 59. Provide a method displayTime that display the time in an “hh:mm:ss” format.
Write a test app that demonstrates class Clock’s capabilities.
*/

public class E13_ClockClass {
    public static void main(String[] args) {
        Clock clk = new Clock(18, 55, 40);

        System.out.print("Given parameters = (18,55,40).\tdisplayTime: ");
        clk.displayTime();

        System.out.printf("%nSetting hour to 24 and second to 50.\tdisplayTime: ");
        clk.setHour(24);
        clk.setSecond(50);
        clk.displayTime();
        System.out.printf("%n");
    }
}

class Clock {
    // Attributes
    private int hour;
    private int minute;
    private int second;

    // Constructor
    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Getters and Setters
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour > 0 && hour < 24) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute > 0 && minute < 60) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second > 0 && second < 60) {
            this.second = second;
        } else {
            this.second = 0;
        }
    }

    // Methods
    public void displayTime() {
        // Display the time in an “hh:mm:ss” format (no line break at end).
        System.out.printf("%d:%d:%d", hour, minute, second);
    }
}
