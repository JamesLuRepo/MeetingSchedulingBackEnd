package main.domian;

public class UserGps {
    private String userEmail;
    private Integer gpsGid;

    public UserGps() {
    }

    public UserGps(String userEmail, Integer gpsGid) {
        this.userEmail = userEmail;
        this.gpsGid = gpsGid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getGpsGid() {
        return gpsGid;
    }

    public void setGpsGid(Integer gpsGid) {
        this.gpsGid = gpsGid;
    }

    @Override
    public String toString() {
        return "UserGps{" +
                "userEmail='" + userEmail + '\'' +
                ", gpsGid=" + gpsGid +
                '}';
    }
}
