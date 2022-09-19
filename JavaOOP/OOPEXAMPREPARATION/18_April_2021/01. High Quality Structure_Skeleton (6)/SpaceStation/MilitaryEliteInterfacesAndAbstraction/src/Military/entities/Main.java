package Military.entities;

import Military.entities.PrivateImpl;
import Military.interfaces.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Private> privateMap = new LinkedHashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            String profession = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            Corps corps;
            switch (profession) {
                case "Private":
                    Private priv = new PrivateImpl(id, firstName, lastName, Double.parseDouble(tokens[4]));
                    privateMap.put(id, priv);
                    break;
                case "Commando":
                    corps = creatingCorps(tokens[5]);
                    Commando commando = new CommandoImpl(id, firstName, lastName, Double.parseDouble(tokens[4]), corps);
                    for (int i = 6; i < tokens.length; i+=2) {
                        Mission mission = new MissionImpl(tokens[i], findingMissionState(tokens[i + 1]));
                        commando.addMission(mission);
                    }
                    privateMap.put(id,commando);
                    break;
                case "Engineer":
                    corps = creatingCorps(tokens[5]);
                    Engineer engineer = new EngineerImpl(id, firstName, lastName, Double.parseDouble(tokens[4]), corps);
                    for (int i = 6; i < tokens.length; i+=2) {
                        String repairPart = tokens[i];
                        int repairHours = Integer.parseInt(tokens[i+1]);
                        RepairImpl repair = new RepairImpl(repairPart, repairHours);
                        engineer.addRepair(repair);
                    }
                  privateMap.put(id,engineer);

                    break;
                case "LieutenantGeneral":
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, Double.parseDouble(tokens[4]));
                    for (int i = 5; i < tokens.length; i++) {
                        int idNumber = Integer.parseInt(tokens[i]);
                        lieutenantGeneral.addPrivate(privateMap.get(idNumber));
                    }

                    privateMap.put(id, lieutenantGeneral);
                    break;
                case "Spy":
                    Spy spy = new SpyImpl(id, firstName, lastName, tokens[4]);
                    privateMap.put(id, spy);

                    break;
            }


            input = scanner.nextLine();
        }
        privateMap.values().stream().forEach(System.out::println);
    }

    private static MissionState findingMissionState(String token) {
        if (token.equals("finished")) {
            return MissionState.FINISHED;
        }
        return MissionState.IN_PROGRESS;
    }


    private static Corps creatingCorps(String token) {
        if (token.equals("Airforces")) {
            return Corps.AIRFORCES;
        }
        return Corps.MARINES;
    }
}
