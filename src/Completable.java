/**
 * The Completable interface represents tasks or events that can be marked as complete.
 * Classes implementing this interface should provide the functionality to mark an event
 * or task as complete and check whether it has been completed.
 *
 * This interface is typically used for events such as deadlines or meetings
 * that have a notion of completion.
 */
 public interface Completable {

    /**
     * Marks the task or event as complete.
     * Implementing classes should set the internal state to indicate that the task
     * or event has been finished.
     */
    void complete();

    /**
     * Checks whether the task or event has been completed.
     *
     * @return True if the task or event is complete, false otherwise.
     */
    boolean isComplete();
}
