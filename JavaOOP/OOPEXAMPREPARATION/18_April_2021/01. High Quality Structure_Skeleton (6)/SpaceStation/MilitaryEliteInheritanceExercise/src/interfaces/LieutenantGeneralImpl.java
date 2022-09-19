package interfaces;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LieutenantGeneralImpl extends PrivateImpl{
    private int id;
    private String firstName;
    private String lastName;
    private Map<String, Private> privateSet;

    public LieutenantGeneralImpl(int id,String firstName, String lastName) {
       super(id,firstName,lastName);
        this.privateSet = new LinkedHashMap<>();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return ;
    }

    @Override
    public String getLastName() {
        return null;
    }

    public void addPrivate(Private priv){
        privateSet.put(priv.getFirstName(),priv);
    }
}
