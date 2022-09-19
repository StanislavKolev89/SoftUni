package Military.entities;

import Military.interfaces.Commando;
import Military.interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missionList;

    protected CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missionList = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
            this.missionList.add(mission);
    }

    @Override
    public Collection<Mission> getMission() {
        return Collections.unmodifiableCollection(this.missionList);
    }


    @Override
    public Corps getCorps() {
        return super.getCorps();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator());
        builder.append(String.format("Corps: %s", corps(getCorps()))).append(System.lineSeparator());
        builder.append(String.format("Missions:", this.getCorps())).append(System.lineSeparator());
        if(!missionList.isEmpty()) {
            missionList.stream().forEach(e -> builder.append(e.toString()).append(System.lineSeparator()));
        }
        return builder.toString().trim();
    }

    private String corps(Corps corps) {
        if(corps == Corps.AIRFORCES){
            return "Airforces";
        }
        return "Marines";
    }


}
