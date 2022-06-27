package Model;

public class Notification {

    private  String postid ;
    private  String userid ;
    private  String text ;
    private  boolean ispost ;

    public Notification() {
    }

    public Notification(String postid, String userid, String text, boolean ispost) {
        this.postid = postid;
        this.userid = userid;
        this.text = text;
        this.ispost = ispost;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isIspost() {
        return ispost;
    }

    public void setIspost(boolean ispost) {
        this.ispost = ispost;
    }
}
