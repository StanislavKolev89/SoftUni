package Military.interfaces;

import Military.entities.MissionState;

import java.util.Collection;

public interface Mission {
    String getCodeName();
    MissionState getMissionState();
}
