package Military.entities;

import Military.interfaces.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private MissionState missionState;

    public MissionImpl(String codeName, MissionState missionState) {
        this.codeName = codeName;
        this.missionState = missionState;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public MissionState getMissionState() {
        return this.missionState;
    }

    @Override
    public String toString(){
        return String.format("  Code Name: %s State: %s",this.getCodeName(),creatingState(this.getMissionState().toString()));
    }

    private String creatingState(String toString) {
        if(toString.equals("FINISHED")) {
            return "finished";
        }
        return "inProgress";
    }
}
