package indiasarihouse.indiasarihouse;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by SachinF on 1/22/2016.
 */
public class StarterApp extends Application {
    @Override
    public void onCreate(){
        Parse.initialize(this, "rKRcpC6uqKDvqyMob9MJVGLrV9Db0XjLblSzfNP1", "IgYq91MYFzNOeg9XosbZtZmnSTYvoa9T0QcPO5hc");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        // PushService.setDefaultPushCallback(this, SplashActivity.class);
        super.onCreate();
    }

}
