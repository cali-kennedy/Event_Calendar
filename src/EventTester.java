// An application that represents an event calendar
// The calendar is able to add and remove vents of different types
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class EventTester {

    public static void main(String[] args) {
        // Call individual test methods
        testEvent();
        testDeadline();
        testMeeting();
    }

    // Test the general Event class functionality
    public static void testEvent() {
        LocalDateTime eventDateTime = LocalDateTime.now();  // Current date and time
        Deadline event = new Deadline("Generic Event", eventDateTime);  // Use Deadline to test

        System.out.println("Testing Event class:");
        System.out.println("Event Name: " + event.getName());  // Should return "Generic Event"
        System.out.println("Event DateTime: " + event.getDateTime());  // Should return current date and time

        // Test setters and getters
        event.setName("Updated Event");
        event.setDate(LocalDateTime.of(2023, 12, 31, 23, 59));  // Update dateTime to a specific date
        System.out.println("Updated Event Name: " + event.getName());  // Should return "Updated Event"
        System.out.println("Updated Event DateTime: " + event.getDateTime());

        System.out.println("------");
    }

    // Test the Deadline class functionality
    public static void testDeadline() {
        LocalDateTime deadlineDateTime = LocalDateTime.now();  // Current date and time
        Deadline deadline = new Deadline("Project Submission", deadlineDateTime);

        System.out.println("Testing Deadline class:");
        System.out.println("Deadline Name: " + deadline.getName());  // Should return "Project Submission"
        System.out.println("Deadline DateTime: " + deadline.getDateTime());  // Should return current date and time
        System.out.println("Is Complete: " + deadline.isComplete());  // Should return false

        deadline.complete();  // Mark as complete
        System.out.println("Is Complete after marking complete: " + deadline.isComplete());  // Should return true

        // Test compareTo with a future date
        LocalDateTime futureDateTime = LocalDateTime.now().plusDays(1);  // 1 day in the future
        Deadline futureDeadline = new Deadline("Future Project", futureDateTime);
        System.out.println("Comparing deadlines (current vs future): " + deadline.compareTo(futureDeadline));  // Should return a negative number

        System.out.println("------");
    }

    // Test the Meeting class functionality
    public static void testMeeting() {
        LocalDateTime startDateTime = LocalDateTime.now();  // Current date and time
        LocalDateTime endDateTime = startDateTime.plusHours(1);  // 1 hour later
        Meeting meeting = new Meeting("Team Meeting", startDateTime, endDateTime, "Conference Room");

        System.out.println("Testing Meeting class:");
        System.out.println("Meeting Name: " + meeting.getName());  // Should return "Team Meeting"
        System.out.println("Meeting Location: " + meeting.getLocation());  // Should return "Conference Room"
        System.out.println("Meeting Start DateTime: " + meeting.getDateTime());  // Should return current date and time
        System.out.println("Meeting End DateTime: " + meeting.getEndTime());  // Should return end time (1 hour later)

        // Get duration in minutes
        long duration = Duration.between(startDateTime, endDateTime).toMinutes();
        System.out.println("Meeting Duration: " + duration + " minutes");  // Should return 60 minutes

        meeting.complete();  // Mark as complete
        System.out.println("Is Complete: " + meeting.isComplete());  // Should return true

        // Test location change
        meeting.setLocation("Updated Conference Room");
        System.out.println("Updated Meeting Location: " + meeting.getLocation());  // Should return "Updated Conference Room"

        System.out.println("------");
    }
}

