package models.entities;

import io.ebean.*;
import play.data.validation.Constraints;
import javax.persistence.*;

@Entity
public class Routes extends Model {

    @Id
    private Integer route_id;
    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "agency_id")
    private Agency agency_id; //foreign key to Agency.agency_id
    @Column(columnDefinition = "VARCHAR")
    private String route_long_name;

    private String route_desc;
    @Column(columnDefinition = "VARCHAR")
    private String route_type;
    @Column(columnDefinition = "VARCHAR")
    private String route_color;

    public static final Finder<Integer, Routes> find = new Finder<>(Routes.class);


    public Integer getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Integer route_id) {
        this.route_id = route_id;
    }

    public Agency getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(Agency agency_id) {
        this.agency_id = agency_id;
    }

    public String getRoute_long_name() {
        return route_long_name;
    }

    public void setRoute_long_name(String route_long_name) {
        this.route_long_name = route_long_name;
    }

    public String getRoute_desc() {
        return route_desc;
    }

    public void setRoute_desc(String route_desc) {
        this.route_desc = route_desc;
    }

    public String getRoute_type() {
        return route_type;
    }

    public void setRoute_type(String route_type) {
        this.route_type = route_type;
    }

    public String getRoute_color() {
        return route_color;
    }

    public void setRoute_color(String route_color) {
        this.route_color = route_color;
    }
}