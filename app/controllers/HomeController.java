package controllers;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import javax.inject.Inject;
import models.*;

import java.io.IOException;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    Boolean once = true;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Inject
    FormFactory formFactory;
    public Result index() {
       /* if (once) {
            once=false;
            initializeDB.insertDataToDB();
        }*/
        initializeDB initial_db= initializeDB.getInstance();
        return ok(views.html.index.render());
    }
    public Result passengersCount() {
        Form<PassengersCountForm> form = formFactory.form(PassengersCountForm.class);
        return ok(views.html.Visualizations.passengersCount.render(form));
    }
    public Result deviationSched() {
        Form<DevSchedForm> form = formFactory.form(DevSchedForm.class);
        return ok(views.html.Visualizations.deviationSched.render(form));    }


}
