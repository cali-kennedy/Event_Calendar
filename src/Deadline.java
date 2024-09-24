import java.time.LocalDateTime;

public class Deadline extends Event {

    private boolean complete;
    private String name;

    // Constructor
    public Deadline(String name, LocalDateTime dateTime){
        super(name, dateTime);
        this.name = name;

    }

    public void complete()
    {
        this.complete = true;
    }
    public boolean isComplete()
    {
        return this.complete;
    }
    @Override
    public String getName() {
        return this.name;
    }
}
