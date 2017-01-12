package Models;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by Ben on 05/01/2017.
 */
@RealmClass
public class RealmStringWrapper implements RealmModel
{


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    private String string;
}
