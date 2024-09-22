import java.time.LocalDateTime;

// An application that represents an event calendar
// The calendar is able to add and remove vents of different types
public class Main {
    public static void main(String[] args) {
// Create LocalDateTime objects for start and end times
        LocalDateTime startDateTime = LocalDateTime.now();  // Current time
        LocalDateTime endDateTime = startDateTime.plusHours(1);  // 1 hour later

        // Create a Meeting object
        Meeting meeting = new Meeting("Team Sync", startDateTime, endDateTime, "Conference Room A");

        // Test methods
        System.out.println("Meeting Name: " + meeting.getName());
        System.out.println("Meeting Start Time: " + meeting.getDateTime());
        System.out.println("Meeting End Time: " + meeting.getEndTime());
        System.out.println("Meeting Duration: " + meeting.getDuration() + " minutes");
        System.out.println("Meeting Location: " + meeting.getLocation());

        // Mark the meeting as complete
        meeting.complete();
        System.out.println("Is the meeting complete? " + meeting.isComplete());
    }

        }

