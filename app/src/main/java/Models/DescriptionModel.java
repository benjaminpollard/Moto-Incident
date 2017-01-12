package Models;

import io.realm.RealmObject;

/**
 * Created by Ben on 05/01/2017.
 */

public class DescriptionModel  extends RealmObject {

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

}
