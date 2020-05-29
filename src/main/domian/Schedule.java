package main.domian;

public class Schedule {

    private String userEmail;
    private Integer meetingId;

    public Schedule() {
    }

    public Schedule(String userEmail, Integer meetingId) {
        this.userEmail = userEmail;
        this.meetingId = meetingId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "userEmail='" + userEmail + '\'' +
                ", meetingId=" + meetingId +
                '}';
    }
}
