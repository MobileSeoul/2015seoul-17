package subway.ggikko.com.hellosubway.pojo;

/**
 * Created by ggikko on 2015-10-18.
 */
public class SubwayList {

    private String subwayname;
    private String subway_xPosition;
    private String subway_yPosition;

    public SubwayList(String subwayname, String subway_xPosition, String subway_yPosition) {
        this.subwayname = subwayname;
        this.subway_xPosition = subway_xPosition;
        this.subway_yPosition = subway_yPosition;
    }

    public String getSubwayname() {
        return subwayname;
    }

    public void setSubwayname(String subwayname) {
        this.subwayname = subwayname;
    }

    public String getSubway_xPosition() {
        return subway_xPosition;
    }

    public void setSubway_xPosition(String subway_xPosition) {
        this.subway_xPosition = subway_xPosition;
    }

    public String getSubway_yPosition() {
        return subway_yPosition;
    }

    public void setSubway_yPosition(String subway_yPosition) {
        this.subway_yPosition = subway_yPosition;
    }

    @Override
    public String toString() {
        return "SubwayList{" +
                "subwayname='" + subwayname + '\'' +
                ", subway_xPosition='" + subway_xPosition + '\'' +
                ", subway_yPosition='" + subway_yPosition + '\'' +
                '}';
    }
}
