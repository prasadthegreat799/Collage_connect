package com.prasadthegreat.ourcampus;

public class homemodel {

    String notificationtitle;
    String notificationmsg;
    String name;
    String attendance;
    String cgpa;
    String id;
    String section;
    String profilepic;

    public homemodel() {
    }

    public homemodel(String notificationtitle, String notificationmsg, String name, String attendance, String cgpa, String id, String section, String profilepic) {
        this.notificationtitle = notificationtitle;
        this.notificationmsg = notificationmsg;
        this.name = name;
        this.attendance = attendance;
        this.cgpa = cgpa;
        this.id = id;
        this.section = section;
        this.profilepic = profilepic;
    }

    public String getNotificationtitle() {
        return notificationtitle;
    }

    public void setNotificationtitle(String notificationtitle) {
        this.notificationtitle = notificationtitle;
    }

    public String getNotificationmsg() {
        return notificationmsg;
    }

    public void setNotificationmsg(String notificationmsg) {
        this.notificationmsg = notificationmsg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }
}
