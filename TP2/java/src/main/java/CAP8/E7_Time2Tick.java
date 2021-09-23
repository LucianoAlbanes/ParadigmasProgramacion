package CAP8;

/*
(Enhancing Class Time2) Modify class Time2 of Fig. 8.5 to include a tick method that increments
the time stored in a Time2 object by one second. Provide method incrementMinute to increment
the minute by one and method incrementHour to increment the hour by one. Write a
program that tests the tick method, the incrementMinute method and the incrementHour method
to ensure that they work correctly. Be sure to test the following cases:
    a) incrementing into the next minute,
    b) incrementing into the next hour and
    c) incrementing into the next day (i.e., 11:59:59 PM to 12:00:00 AM).
*/

public class E7_Time2Tick {
    public static void main(String[] args) {
        Time2T time = new Time2T(22,58,59);
        System.out.printf("Initial time: %s%n", time.toUniversalString());
        time.incrementHour();
        System.out.printf("+1 hour: %s%n", time.toUniversalString());
        time.incrementMinute();
        System.out.printf("+1 minute: %s%n", time.toUniversalString());
        time.tick();
        System.out.printf("+1 second: %s%n", time.toUniversalString());
    }
}

class Time2T {
    private static final int DAILY_TICKS = 60*60*24;
    private int seconds; // Seconds since midnight

    // Time2T no-argument constructor:
    // initializes each instance variable to zero
    public Time2T() {
        this(0, 0, 0); // invoke constructor with three arguments
    }

    // Time2T constructor: hour supplied, minute and second defaulted to 0
    public Time2T(int hour) {
        this(hour, 0, 0); // invoke constructor with three arguments
    }

    // Time2T constructor: hour and minute supplied, second defaulted to 0
    public Time2T(int hour, int minute) {
        this(hour, minute, 0); // invoke constructor with three arguments
    }

    // Time2T constructor: hour, minute and second supplied
    public Time2T(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }
        seconds = toSeconds(hour, minute, second);
    }

    // Time2T constructor: another Time2T object supplied
    public Time2T(Time2T time) {
        // Gets the seconds from time and copy to the new Time2T object.
        seconds = time.seconds;
    }

    // Set Methods
    // set a new time value using universal time;
    // validate the data
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }
        seconds = toSeconds(hour, minute, second);
    }

    // validate and set hour
    public void setHour(int hour) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        seconds -= toSeconds(getHour(),0,0);
        seconds += toSeconds(hour,0,0);
    }

    // validate and set minute
    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        seconds -= toSeconds(0,getMinute(),0);
        seconds += toSeconds(0,minute,0);
    }

    // validate and set second
    public void setSecond(int second) {
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }
        seconds -= toSeconds(0,0,getSecond());
        seconds += toSeconds(0,0,second);
    }

    // Get Methods
    // get hour value
    public int getHour() {
        return seconds/3600;
    }

    // get minute value
    public int getMinute() {
        return (seconds%3600)/60;
    }

    // get second value
    public int getSecond() {
        return (seconds%3600)%60;
    }

    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    // convert to String in standard-time format (H:MM:SS AM or PM)
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }

    // calculate the amount of seconds since midnight from a given time in format (HH:MM:SS)
    private static int toSeconds(int hour, int minute, int second) {
        return hour * 3600 + minute * 60 + second;
    }

    // Tick methods
    // Tick: Add one second.
    public void tick() {
        seconds = (seconds + 1) % DAILY_TICKS;
    }

    public void incrementMinute() {
        seconds = (seconds + 60) % DAILY_TICKS;
    }

    public void incrementHour() {
        seconds = (seconds + 3600) % DAILY_TICKS;
    }
}
