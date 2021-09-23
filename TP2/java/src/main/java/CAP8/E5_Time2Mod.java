package CAP8;

/*
(Modifying the Internal Data Representation of a Class) It would be perfectly reasonable
for the Time2 class of Fig. 8.5 to represent the time internally as the number of seconds since mid-
night rather than the three integer values hour, minute and second. Clients could use the same pub-
lic methods and get the same results. Modify the Time2 class of Fig. 8.5 to implement the time as
the number of seconds since midnight and show that no change is visible to the clients of the class.
*/

public class E5_Time2Mod {
    public static void main(String[] args) {
        Time2 time = new Time2(18,15,55);
        System.out.println(time.toUniversalString());
        time.setMinute(33);
        System.out.println(time.toUniversalString());
    }
}

class Time2 {
    private int seconds; // Seconds since midnight

    // Time2 no-argument constructor:
    // initializes each instance variable to zero
    public Time2() {
        this(0, 0, 0); // invoke constructor with three arguments
    }

    // Time2 constructor: hour supplied, minute and second defaulted to 0
    public Time2(int hour) {
        this(hour, 0, 0); // invoke constructor with three arguments
    }

    // Time2 constructor: hour and minute supplied, second defaulted to 0
    public Time2(int hour, int minute) {
        this(hour, minute, 0); // invoke constructor with three arguments
    }

    // Time2 constructor: hour, minute and second supplied
    public Time2(int hour, int minute, int second) {
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

    // Time2 constructor: another Time2 object supplied
    public Time2(Time2 time) {
        // Gets the seconds from time and copy to the new Time2 object.
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
}
