package code;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Matrix {
    public static int counter = 0;

    public static String genGrid() {
        ArrayList<String> cellsTaken = new ArrayList<String>();
        // Random rand = new Random();
        // int m = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
        // int n = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
        int m = 5;
        int n = 5;
        cellsTaken.add("(" + m + "," + n + ")");
        int c = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
        int neoX = (int) Math.floor(Math.random() * (m - 0 + 1));
        int neoY = (int) Math.floor(Math.random() * (n - 0 + 1));
        cellsTaken.add("(" + neoX + "," + neoY + ")");
        int telephoneX = (int) Math.floor(Math.random() * (m - 0 + 1));
        int telephoneY = (int) Math.floor(Math.random() * (n - 0 + 1));
        String telephone = "(" + telephoneX + "," + telephoneY + ")";
        while (cellsTaken.indexOf(telephone) != -1) {
            telephoneX = (int) Math.floor(Math.random() * (m - 0 + 1));
            telephoneY = (int) Math.floor(Math.random() * (n - 0 + 1));
            telephone = "(" + telephoneX + "," + telephoneY + ")";
        }
        String outPutFirst = m + "," + n + ";" + c + ";" + neoX + "," + neoY + ";" + telephoneX + "," + telephoneY
                + ";";
        String outPutHostages = "";
        int hostagesNumber = (int) Math.floor(Math.random() * (10 - 3 + 1) + 3);
        for (int i = 0; i < hostagesNumber; i++) {
            int hostageX = (int) Math.floor(Math.random() * (m - 0 + 1));
            int hostageY = (int) Math.floor(Math.random() * (n - 0 + 1));
            int hostageDmg = (int) Math.floor(Math.random() * (99 - 1 + 1) + 1);
            String hostage = "(" + hostageX + "," + hostageY + ")";
            while (cellsTaken.indexOf(hostage) != -1) {
                hostageX = (int) Math.floor(Math.random() * (m - 0 + 1));
                hostageY = (int) Math.floor(Math.random() * (n - 0 + 1));
                hostage = "(" + hostageX + "," + hostageY + ")";
            }
            cellsTaken.add(hostage);
            if (hostagesNumber - i == 1) {
                outPutHostages += hostageX + "," + hostageY + "," + hostageDmg + ";";
            } else {
                outPutHostages += hostageX + "," + hostageY + "," + hostageDmg + ",";

            }

        }
        String outPutPills = "";
        int pillsNumber = (int) Math.floor(Math.random() * (hostagesNumber - 1 + 1) + 1);
        for (int i = 0; i < pillsNumber; i++) {
            int pillX = (int) Math.floor(Math.random() * (m - 0 + 1));
            int pillY = (int) Math.floor(Math.random() * (n - 0 + 1));
            String pill = "(" + pillX + "," + pillY + ")";
            while (cellsTaken.indexOf(pill) != -1) {
                pillX = (int) Math.floor(Math.random() * (m - 0 + 1));
                pillY = (int) Math.floor(Math.random() * (n - 0 + 1));
                pill = "(" + pillX + "," + pillY + ")";
            }
            cellsTaken.add(pill);
            if (pillsNumber - i == 1) {
                outPutPills += pillX + "," + pillY + ";";
            } else {

                outPutPills += pillX + "," + pillY + ",";

            }

        }

        String agentsString = "";
        int agentsNumberMax = (m * n) - cellsTaken.size() - 2;
        int agentsNumber = (int) Math.floor(Math.random() * (agentsNumberMax - 1 + 1) + 1);
        for (int i = 0; i < agentsNumber; i++) {
            int agentX = (int) Math.floor(Math.random() * (m - 0 + 1));
            int agentY = (int) Math.floor(Math.random() * (n - 0 + 1));
            String agent = "(" + agentX + "," + agentY + ")";
            while (cellsTaken.indexOf(agent) != -1) {
                agentX = (int) Math.floor(Math.random() * (m - 0 + 1));
                agentY = (int) Math.floor(Math.random() * (n - 0 + 1));
                agent = "(" + agentX + "," + agentY + ")";
            }
            cellsTaken.add(agent);
            if (agentsNumber - i == 1) {
                agentsString += agentX + "," + agentY + ";";
            } else {

                agentsString += agentX + "," + agentY + ",";

            }

        }
        String padsString = "";
        int padsNumberMax = (int) Math.floor(((m * n) - cellsTaken.size()) / 2);
        int padsNumber = (int) Math.floor(Math.random() * (padsNumberMax - 1 + 1) + 1);
        for (int i = 0; i < padsNumber; i++) {
            int pad1x = (int) Math.floor(Math.random() * (m - 0 + 1));
            int pad1y = (int) Math.floor(Math.random() * (n - 0 + 1));
            String pad1 = "(" + pad1x + "," + pad1y + ")";
            int pad2x = (int) Math.floor(Math.random() * (m - 0 + 1));
            int pad2y = (int) Math.floor(Math.random() * (n - 0 + 1));
            String pad2 = "(" + pad1x + "," + pad1y + ")";
            while (cellsTaken.indexOf(pad1) != -1 && cellsTaken.indexOf(pad2) != -1 && pad1 != pad2) {
                pad1x = (int) Math.floor(Math.random() * (m - 0 + 1));
                pad1y = (int) Math.floor(Math.random() * (n - 0 + 1));
                pad1 = "(" + pad1x + "," + pad1y + ")";
                pad2x = (int) Math.floor(Math.random() * (m - 0 + 1));
                pad2y = (int) Math.floor(Math.random() * (n - 0 + 1));
                pad2 = "(" + pad1x + "," + pad1y + ")";
            }
            cellsTaken.add(pad1);
            cellsTaken.add(pad2);

            if (padsNumber - i == 1) {
                padsString += pad1x + "," + pad1y + "," + pad2x + "," + pad2y + "," + pad2x + "," + pad2y + "," + pad1x
                        + "," + pad1y + ";";
            } else {

                padsString += pad1x + "," + pad1y + "," + pad2x + "," + pad2y + "," + pad2x + "," + pad2y + "," + pad1x
                        + "," + pad1y + ",";

            }

        }
        return outPutFirst + agentsString + outPutPills + padsString + outPutHostages;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // getters for current state
    ////////////////////////////////////////////////////////////////////////////////////////
    public static int getGridSizeX(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");

        int gridSizeX = Integer.parseInt(temp[0]);
        return gridSizeX;
    }

    public static int getGridSizeY(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");

        int gridSizeY = Integer.parseInt(temp[1]);
        return gridSizeY;
    }

    public static int getCap(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int cap = Integer.parseInt(temp[2]);
        return cap;
    }

    public static int getNeoX(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int neoPositionX = Integer.parseInt(temp[3]);
        return neoPositionX;
    }

    public static int getNeoY(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int neoPositionY = Integer.parseInt(temp[4]);
        return neoPositionY;
    }

    public static int getTelephoneX(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int telephoneX = Integer.parseInt(temp[5]);
        return telephoneX;
    }

    public static int getTelephoneY(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int telephoneY = Integer.parseInt(temp[6]);
        return telephoneY;
    }

    public static int[] getAgentsX(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int[] agentsX;
        if (temp[7].length() > 1) {
            String[] agentsXString = temp[7].split(",");
            agentsX = new int[agentsXString.length];
            for (int i = 0; i < agentsXString.length; i++) {
                agentsX[i] = Integer.parseInt(agentsXString[i]);
            }
        } else {
            agentsX = new int[1];

            agentsX[0] = Integer.parseInt((temp[7]));
        }
        return agentsX;

    }

    public static int[] getAgentsY(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int[] agentsY;
        if (temp[8].length() > 1) {
            String[] agentsYString = temp[8].split(",");
            agentsY = new int[agentsYString.length];
            for (int i = 0; i < agentsYString.length; i++) {
                agentsY[i] = Integer.parseInt(agentsYString[i]);
            }
        } else {
            agentsY = new int[1];
            agentsY[0] = Integer.parseInt(temp[8]);

        }
        return agentsY;

    }

    public static int[] getPillsX(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int[] pillsX;
        if (temp[9].length() > 1) {

            String[] pillsXString = temp[9].split(",");
            pillsX = new int[pillsXString.length];

            for (int i = 0; i < pillsXString.length; i++) {
                pillsX[i] = Integer.parseInt(pillsXString[i]);
            }
        } else {
            pillsX = new int[1];
            pillsX[0] = Integer.parseInt(temp[9]);
        }
        return pillsX;
    }

    public static int[] getPillsY(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int[] pillsY;
        if (temp[10].length() > 1) {
            String[] pillsYString = temp[10].split(",");
            pillsY = new int[pillsYString.length];

            for (int i = 0; i < pillsYString.length; i++) {
                pillsY[i] = Integer.parseInt(pillsYString[i]);
            }
        } else {
            pillsY = new int[1];
            pillsY[0] = Integer.parseInt(temp[10]);
        }
        return pillsY;
    }

    public static boolean[] getPillsTaken(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int[] pillsX;
        boolean[] pillTaken;
        if (temp[11].length() > 1) {

            String[] pillsTakenString = temp[11].split(",");
            pillTaken = new boolean[pillsTakenString.length];

            for (int i = 0; i < pillsTakenString.length; i++) {
                pillTaken[i] = Boolean.parseBoolean(pillsTakenString[i]);
            }
        } else {
            pillTaken = new boolean[1];
            pillTaken[0] = Boolean.parseBoolean(temp[11]);
        }
        return pillTaken;
    }

    public static int[] getPadsX(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        String[] padsXString = temp[12].split(",");
        int[] padsX = new int[padsXString.length];

        for (int i = 0; i < padsXString.length; i++) {
            padsX[i] = Integer.parseInt(padsXString[i]);
        }
        return padsX;
    }

    public static int[] getPadsY(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        String[] padsYString = temp[13].split(",");
        int[] padsY = new int[padsYString.length];

        for (int i = 0; i < padsYString.length; i++) {
            padsY[i] = Integer.parseInt(padsYString[i]);
        }

        return padsY;
    }

    public static int[] getHostagesX(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int[] hostagesX;
        if (temp[14].length() > 1) {

            String[] hostagXString = temp[14].split(",");
            hostagesX = new int[hostagXString.length];

            for (int i = 0; i < hostagXString.length; i++) {
                hostagesX[i] = Integer.parseInt(hostagXString[i]);
            }
        } else {
            hostagesX = new int[1];
            hostagesX[0] = Integer.parseInt(temp[14]);
        }
        return hostagesX;
    }

    public static int[] getHostagesY(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int[] hostagesY;
        if (temp[15].length() > 1) {

            String[] hostagXString = temp[15].split(",");
            hostagesY = new int[hostagXString.length];

            for (int i = 0; i < hostagXString.length; i++) {
                hostagesY[i] = Integer.parseInt(hostagXString[i]);
            }
        } else {
            hostagesY = new int[1];
            hostagesY[0] = Integer.parseInt(temp[15]);
        }
        return hostagesY;
    }

    public static int[] getHostagesDmg(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int[] hostagesDmg;
        if (temp[16].length() > 1) {

            String[] hostageDmgString = temp[16].split(",");
            hostagesDmg = new int[hostageDmgString.length];

            for (int i = 0; i < hostageDmgString.length; i++) {
                hostagesDmg[i] = Integer.parseInt(hostageDmgString[i]);
            }
        } else {
            hostagesDmg = new int[1];
            hostagesDmg[0] = Integer.parseInt(temp[16]);
        }
        return hostagesDmg;
    }

    public static boolean[] getHostagesCarried(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        boolean[] hostagesCarried;
        if (temp[18].length() > 1) {

            String[] hostageCarriedString = temp[18].split(",");
            hostagesCarried = new boolean[hostageCarriedString.length];

            for (int i = 0; i < hostageCarriedString.length; i++) {
                hostagesCarried[i] = Boolean.parseBoolean(hostageCarriedString[i]);
            }
        } else

        {
            hostagesCarried = new boolean[1];
            hostagesCarried[0] = Boolean.parseBoolean(temp[18]);
        }
        return hostagesCarried;
    }

    public static boolean[] getHostagesAgent(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        boolean[] hostageAgent;
        if (temp[19].length() > 1) {

            String[] hostageAgentString = temp[19].split(",");
            hostageAgent = new boolean[hostageAgentString.length];

            for (int i = 0; i < hostageAgentString.length; i++) {
                hostageAgent[i] = Boolean.parseBoolean(hostageAgentString[i]);
            }
        } else

        {
            hostageAgent = new boolean[1];
            hostageAgent[0] = Boolean.parseBoolean(temp[19]);
        }
        return hostageAgent;
    }

    public static boolean[] getHostageAgentKilled(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        boolean[] hostageAgentKilled;
        if (temp[20].length() > 1) {

            String[] hostageAgentKilledString = temp[20].split(",");
            hostageAgentKilled = new boolean[hostageAgentKilledString.length];

            for (int i = 0; i < hostageAgentKilledString.length; i++) {
                hostageAgentKilled[i] = Boolean.parseBoolean(hostageAgentKilledString[i]);
            }
        } else

        {
            hostageAgentKilled = new boolean[1];
            hostageAgentKilled[0] = Boolean.parseBoolean(temp[20]);
        }
        return hostageAgentKilled;
    }

    public static int getCurrentHostages(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        // int telephoneX = getTelephoneX(x);
        // int telephoneY = getTelephoneY(x);

        int currentHostages = Integer.parseInt(temp[17]);

        // int[] hostagesX = getHostagesX(x);
        // int[] hostagesY = getHostagesY(x);
        // boolean[] hostageAgentKilled = getHostageAgentKilled(x);

        // for (int i = 0; i < hostagesX.length; i++) {
        // if (!(hostageAgentKilled[i] || (hostagesX[i] == telephoneX && hostagesY[i] ==
        // telephoneY))) {
        // currentHostages++;
        // }
        // }
        return currentHostages;
    }

    public static boolean[] getAgentDead(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        boolean[] agentDead;

        if (temp[21].length() > 1) {

            String[] agentDeadString = temp[21].split(",");
            agentDead = new boolean[agentDeadString.length];

            for (int i = 0; i < agentDeadString.length; i++) {
                agentDead[i] = Boolean.parseBoolean(agentDeadString[i]);
            }
        } else {
            agentDead = new boolean[1];

            agentDead[0] = Boolean.parseBoolean(temp[21]);
        }
        return agentDead;
    }

    public static int getNeoDmg(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int neoDmg = Integer.parseInt(temp[22]);
        return neoDmg;
    }

    public static int getCarryCount(String x) {
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(" ", "");

        String[] temp = x.split(";");
        int carryCount = Integer.parseInt(temp[23]);
        return carryCount;
    }

    public static Pair addDmg(int[] hostageDmg, boolean[] hostageAgent, boolean[] carried, int[] hostageX,
            int[] hostageY, int telephoneX, int telephoneY, boolean[] hostageAgentKilled) {
        for (int i = 0; i < hostageY.length; i++) {
            if (!(hostageX[i] == telephoneX && hostageY[i] == telephoneY)) {
                hostageDmg[i] += 2;
            }
            if (hostageDmg[i] >= 100) {
                hostageDmg[i] = 100;
                if (!carried[i] && !(hostageX[i] == telephoneX && hostageY[i] == telephoneY)) {
                    if (!hostageAgentKilled[i]) {
                        hostageAgent[i] = true;
                    }
                }
            }

        }
        Pair out = new Pair<int[], boolean[]>(hostageDmg, hostageAgent);
        return out;
    }

    public static String up(String x, MyTreeNode parent) {

        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        //////////////////////////////////////////////////////////////////////////////////

        boolean up = false;
        if (parent.action != "down") {
            if (neoPositionX - 1 >= 0) {
                up = true;
                for (int i = 0; i < agentsX.length; i++) {
                    if (agentsX[i] == neoPositionX - 1 && agentsY[i] == neoPositionY && !agentDead[i]) {
                        up = false;
                    }
                }
                for (int i = 0; i < hostagesDmg.length; i++) {
                    if (hostagesDmg[i] >= 98 && hostagesCarried[i]) {
                        up = false;
                    }

                }
                for (int i = 0; i < hostageAgent.length; i++) {
                    if (hostageAgent[i]) {
                        if (hostagesX[i] == neoPositionX - 1 && hostagesY[i] == neoPositionY
                                && !hostageAgentKilled[i]) {
                            up = false;
                        }

                    }
                }
                // add damage
                Pair HostDmg = addDmg(hostagesDmg, hostageAgent, hostagesCarried, hostagesX, hostagesY, telephoneX,
                        telephoneY, hostageAgentKilled);
                hostagesDmg = (int[]) HostDmg.a;
                hostageAgent = (boolean[]) HostDmg.b;
                if (up) {
                    neoPositionX -= 1;

                    // for (int i = 0; i < hostagesCarried.length; i++) {
                    // if (hostagesCarried[i]) {
                    // hostagesX[i] = neoPositionX;
                    // }
                    // }
                    String newState = gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY
                            + ";" + telephoneX + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";"
                            + Arrays.toString(agentsY) + ";" + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY)
                            + ";" + Arrays.toString(pillTaken) + ";" + Arrays.toString(padsX) + ";"
                            + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX) + ";"
                            + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages
                            + ";" + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                            + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg
                            + ";" + carryCount;

                    return newState;
                }

            }
        }
        return null;
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    public static String down(String x, MyTreeNode parent) {

        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        //////////////////////////////////////////////////////////////////////////////////

        boolean down = false;
        if (parent.action != "up") {
            if (neoPositionX + 1 < gridSizeX) {

                down = true;
                for (int i = 0; i < agentsX.length; i++) {
                    if (agentsX[i] == neoPositionX + 1 && agentsY[i] == neoPositionY && !agentDead[i]) {
                        down = false;
                    }
                }
                for (int i = 0; i < hostagesDmg.length; i++) {
                    if (hostagesDmg[i] >= 98 && hostagesCarried[i]) {
                        down = false;
                    }

                }
                for (int i = 0; i < hostageAgent.length; i++) {
                    if (hostageAgent[i]) {
                        if (hostagesX[i] == neoPositionX + 1 && hostagesY[i] == neoPositionY
                                && !hostageAgentKilled[i]) {
                            down = false;
                        }

                    }
                }
                // add damage
                Pair HostDmg = addDmg(hostagesDmg, hostageAgent, hostagesCarried, hostagesX, hostagesY, telephoneX,
                        telephoneY, hostageAgentKilled);
                hostagesDmg = (int[]) HostDmg.a;
                hostageAgent = (boolean[]) HostDmg.b;
                if (down) {
                    neoPositionX += 1;

                    // for (int i = 0; i < hostagesCarried.length; i++) {
                    // if (hostagesCarried[i]) {
                    // // currentMatrix.hostagesX[i] -= 1;
                    // hostagesX[i] = neoPositionX;
                    // }
                    // }
                    String newState = gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY
                            + ";" + telephoneX + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";"
                            + Arrays.toString(agentsY) + ";" + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY)
                            + ";" + Arrays.toString(pillTaken) + ";" + Arrays.toString(padsX) + ";"
                            + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX) + ";"
                            + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages
                            + ";" + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                            + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg
                            + ";" + carryCount;

                    return newState;
                }

            }
        }
        return null;
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    public static String left(String x, MyTreeNode parent) {

        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        //////////////////////////////////////////////////////////////////////////////////
        boolean left = false;
        if ((parent != null && parent.action != "right") || parent == null) {

            if (neoPositionY - 1 >= 0) {

                left = true;
                for (int i = 0; i < agentsX.length; i++) {
                    if (agentsX[i] == neoPositionX && agentsY[i] == neoPositionY - 1 && !agentDead[i]) {
                        left = false;
                    }
                }
                for (int i = 0; i < hostagesDmg.length; i++) {
                    if (hostagesDmg[i] >= 98 && hostagesCarried[i]) {
                        left = false;
                    }

                }
                for (int i = 0; i < hostageAgent.length; i++) {
                    if (hostageAgent[i]) {
                        if (hostagesX[i] == neoPositionX && hostagesY[i] == neoPositionY - 1
                                && !hostageAgentKilled[i]) {
                            left = false;
                        }

                    }
                }
                // add damage
                Pair HostDmg = addDmg(hostagesDmg, hostageAgent, hostagesCarried, hostagesX, hostagesY, telephoneX,
                        telephoneY, hostageAgentKilled);
                hostagesDmg = (int[]) HostDmg.a;
                hostageAgent = (boolean[]) HostDmg.b;
                if (left) {
                    neoPositionY -= 1;

                    // for (int i = 0; i < hostagesCarried.length; i++) {
                    // if (hostagesCarried[i]) {
                    // // currentMatrix.hostagesX[i] -= 1;
                    // hostagesY[i] = neoPositionY;
                    // }
                    // }
                    String newState = gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY
                            + ";" + telephoneX + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";"
                            + Arrays.toString(agentsY) + ";" + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY)
                            + ";" + Arrays.toString(pillTaken) + ";" + Arrays.toString(padsX) + ";"
                            + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX) + ";"
                            + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages
                            + ";" + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                            + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg
                            + ";" + carryCount;

                    return newState;
                }

            }
        }
        return null;
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    public static String right(String x, MyTreeNode parent) {

        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        //////////////////////////////////////////////////////////////////////////////////
        boolean right = false;
        if ((parent != null && parent.action != "left") || parent == null) {

            if (neoPositionY + 1 < gridSizeY) {

                right = true;
                for (int i = 0; i < agentsX.length; i++) {
                    if (agentsX[i] == neoPositionX && agentsY[i] == neoPositionY + 1 && !agentDead[i]) {
                        right = false;
                    }
                }
                for (int i = 0; i < hostagesDmg.length; i++) {
                    if (hostagesDmg[i] >= 98 && hostagesCarried[i]) {
                        right = false;
                    }

                }
                for (int i = 0; i < hostageAgent.length; i++) {
                    if (hostageAgent[i]) {
                        if (hostagesX[i] == neoPositionX && hostagesY[i] == neoPositionY + 1
                                && !hostageAgentKilled[i]) {
                            right = false;
                        }

                    }
                }
                // add damage
                Pair HostDmg = addDmg(hostagesDmg, hostageAgent, hostagesCarried, hostagesX, hostagesY, telephoneX,
                        telephoneY, hostageAgentKilled);
                hostagesDmg = (int[]) HostDmg.a;
                hostageAgent = (boolean[]) HostDmg.b;
                if (right) {
                    neoPositionY += 1;

                    // for (int i = 0; i < hostagesCarried.length; i++) {
                    // if (hostagesCarried[i]) {
                    // // currentMatrix.hostagesX[i] -= 1;
                    // hostagesY[i] = neoPositionY;
                    // }
                    // }
                    String newState = gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY
                            + ";" + telephoneX + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";"
                            + Arrays.toString(agentsY) + ";" + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY)
                            + ";" + Arrays.toString(pillTaken) + ";" + Arrays.toString(padsX) + ";"
                            + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX) + ";"
                            + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages
                            + ";" + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                            + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg
                            + ";" + carryCount;

                    return newState;
                }

            }
        }
        return null;
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    public static String carry(String x, MyTreeNode parent) {

        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        //////////////////////////////////////////////////////////////////////////////////
        // add damage

        boolean carry = false;
        for (int i = 0; i < hostagesX.length; i++) {
            if (neoPositionX == hostagesX[i] && neoPositionY == hostagesY[i]) {
                if (!hostagesCarried[i]) {
                    if (!(hostagesX[i] == telephoneX && hostagesY[i] == telephoneY)) {
                        if (!hostageAgent[i]) {
                            if (!hostageAgentKilled[i]) {
                                if (carryCount < cap) {
                                    carryCount++;
                                    hostagesCarried[i] = true;
                                    carry = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        Pair HostDmg = addDmg(hostagesDmg, hostageAgent, hostagesCarried, hostagesX, hostagesY, telephoneX, telephoneY,
                hostageAgentKilled);
        hostagesDmg = (int[]) HostDmg.a;
        hostageAgent = (boolean[]) HostDmg.b;
        if (carry) {
            String newState = gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY + ";"
                    + telephoneX + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";" + Arrays.toString(agentsY)
                    + ";" + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY) + ";" + Arrays.toString(pillTaken)
                    + ";" + Arrays.toString(padsX) + ";" + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX)
                    + ";" + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages
                    + ";" + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                    + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg + ";"
                    + carryCount;
            return newState;
        }
        return null;
    }

    public static String drop(String x, MyTreeNode parent) {

        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        //////////////////////////////////////////////////////////////////////////////////

        boolean drop = false;
        if (parent.action != "drop") {
            for (int i = 0; i < hostagesX.length; i++) {
                if (neoPositionX == telephoneX && neoPositionY == telephoneY) {
                    if (hostagesCarried[i]) {
                        // if (hostagesX[i] == telephoneX && hostagesY[i] == telephoneY) {
                        carryCount--;
                        currentHostages--;
                        hostagesX[i] = telephoneX;
                        hostagesY[i] = telephoneY;
                        hostagesCarried[i] = false;
                        drop = true;
                    }
                    // }
                }
            }
        }
        // add damage
        Pair HostDmg = addDmg(hostagesDmg, hostageAgent, hostagesCarried, hostagesX, hostagesY, telephoneX, telephoneY,
                hostageAgentKilled);
        hostagesDmg = (int[]) HostDmg.a;
        hostageAgent = (boolean[]) HostDmg.b;
        if (drop) {
            String newState = gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY + ";"
                    + telephoneX + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";" + Arrays.toString(agentsY)
                    + ";" + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY) + ";" + Arrays.toString(pillTaken)
                    + ";" + Arrays.toString(padsX) + ";" + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX)
                    + ";" + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages
                    + ";" + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                    + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg + ";"
                    + carryCount;
            return newState;
        }
        return null;
    }

    public static String takePill(String x, MyTreeNode parent) {

        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        //////////////////////////////////////////////////////////////////////////////////
        // add damage

        boolean takePill = false;
        for (int i = 0; i < pillsX.length; i++) {
            if (neoPositionX == pillsX[i] && neoPositionY == pillsY[i]) {
                if (!pillTaken[i]) {
                    takePill = true;
                    pillTaken[i] = true;
                    // break;

                }
            }
        }
        if (takePill) {
            neoDmg = Math.max(0, neoDmg - 20);
            for (int i = 0; i < hostagesDmg.length; i++) {
                if (hostagesDmg[i] < 100) {
                    hostagesDmg[i] = Math.max(0, hostagesDmg[i] - 20);
                }

            }
            String newState = gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY + ";"
                    + telephoneX + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";" + Arrays.toString(agentsY)
                    + ";" + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY) + ";" + Arrays.toString(pillTaken)
                    + ";" + Arrays.toString(padsX) + ";" + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX)
                    + ";" + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages
                    + ";" + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                    + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg + ";"
                    + carryCount;
            return newState;
        }

        return null;
    }

    public static String fly(String x, MyTreeNode parent) {

        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        //////////////////////////////////////////////////////////////////////////////////

        boolean fly = false;
        // System.out.println(neoPositionX+","+neoPositionY);
        // System.out.println(Arrays.toString(padsX));
        // System.out.println(Arrays.toString(padsY));
        if (parent.action != "fly") {
            for (int i = 0; i < padsX.length; i += 2) {
                if (neoPositionX == padsX[i] && neoPositionY == padsY[i] && !fly) {
                    neoPositionX = padsX[i + 1];
                    neoPositionY = padsY[i + 1];
                    fly = true;
                    break;
                }
            }
        }
        // add damage
        Pair HostDmg = addDmg(hostagesDmg, hostageAgent, hostagesCarried, hostagesX, hostagesY, telephoneX, telephoneY,
                hostageAgentKilled);
        hostagesDmg = (int[]) HostDmg.a;
        hostageAgent = (boolean[]) HostDmg.b;
        /////////////
        if (fly) {
            String newState = gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY + ";"
                    + telephoneX + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";" + Arrays.toString(agentsY)
                    + ";" + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY) + ";" + Arrays.toString(pillTaken)
                    + ";" + Arrays.toString(padsX) + ";" + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX)
                    + ";" + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages
                    + ";" + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                    + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg + ";"
                    + carryCount;
            return newState;
        }
        return null;
    }

    public static String kill(String x, MyTreeNode parent) {

        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        //////////////////////////////////////////////////////////////////////////////////
        // add damage

        boolean kill = false;
        boolean canKill = true;
        if (parent.action == "kill") {
            canKill = false;
        }
        for (int i = 0; i < hostagesX.length; i++) {
            if (hostagesX[i] == neoPositionX && hostagesY[i] == neoPositionY) {
                if (hostagesDmg[i] >= 98) {
                    // canKill = false;
                }
            }

        }
        if (canKill) {
            // check on living agents in the surrounding cells to kill
            for (int i = 0; i < agentsX.length; i++) {
                if (neoPositionX == agentsX[i] + 1 && neoPositionY == agentsY[i]) {
                    if (!agentDead[i]) {
                        agentDead[i] = true;
                        kill = true;
                    }
                }
                if (neoPositionX == agentsX[i] - 1 && neoPositionY == agentsY[i]) {
                    if (!agentDead[i]) {
                        agentDead[i] = true;
                        kill = true;
                    }
                }
                if (neoPositionX == agentsX[i] && neoPositionY == agentsY[i] + 1) {
                    if (!agentDead[i]) {
                        agentDead[i] = true;
                        kill = true;
                    }
                }
                if (neoPositionX == agentsX[i] && neoPositionY == agentsY[i] - 1) {
                    if (!agentDead[i]) {
                        agentDead[i] = true;
                        kill = true;
                    }
                }
            }
            // check on any hostage agent that can be killed, if in the surrounding cells
            for (int i = 0; i < hostageAgent.length; i++) {
                if (hostageAgent[i]) {
                    if (neoPositionX == hostagesX[i] + 1 && neoPositionY == hostagesY[i]) {
                        if (!hostageAgentKilled[i]) {
                            hostageAgentKilled[i] = true;
                            currentHostages--;
                            kill = true;
                        }
                    }
                    if (neoPositionX == hostagesX[i] - 1 && neoPositionY == hostagesY[i]) {
                        if (!hostageAgentKilled[i]) {
                            hostageAgentKilled[i] = true;
                            kill = true;
                            currentHostages--;
                        }
                    }
                    if (neoPositionX == hostagesX[i] && neoPositionY == hostagesY[i] + 1) {
                        if (!hostageAgentKilled[i]) {
                            hostageAgentKilled[i] = true;
                            kill = true;
                            currentHostages--;
                        }
                    }
                    if (neoPositionX == hostagesX[i] && neoPositionY == hostagesY[i] - 1) {
                        if (!hostageAgentKilled[i]) {
                            hostageAgentKilled[i] = true;
                            kill = true;
                            currentHostages--;
                        }
                    }

                }
            }
        }
        Pair HostDmg = addDmg(hostagesDmg, hostageAgent, hostagesCarried, hostagesX, hostagesY, telephoneX, telephoneY,
                hostageAgentKilled);
        hostagesDmg = (int[]) HostDmg.a;
        hostageAgent = (boolean[]) HostDmg.b;

        if (kill) {
            neoDmg += 20;
            String newState = gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY + ";"
                    + telephoneX + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";" + Arrays.toString(agentsY)
                    + ";" + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY) + ";" + Arrays.toString(pillTaken)
                    + ";" + Arrays.toString(padsX) + ";" + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX)
                    + ";" + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages
                    + ";" + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                    + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg + ";"
                    + carryCount;
            return newState;
        }
        return null;
    }

    public static String newHash(String x) {
        // String str =
        // ""+neo[0]+neo[1]+neo[2]+numberOfAgents+numberOfHostages+numberOfPills+numberOfCarriedHostages;
        int numberOfAgents = 0;
        boolean[] agentDead = getAgentDead(x);
        for (int i = 0; i < agentDead.length; i++) {
            if (!agentDead[i]) {
                numberOfAgents++;
            }
        }
        int currentHostages = getCurrentHostages(x);
        int numberOfCarriedHostages = 0;
        boolean hostagesCarried[] = getHostagesCarried(x);
        for (int i = 0; i < hostagesCarried.length; i++) {
            if (hostagesCarried[i]) {
                numberOfCarriedHostages++;
            }
        }
        int availablePills = 0;
        boolean[] pillTaken = getPillsTaken(x);
        for (int i = 0; i < pillTaken.length; i++) {
            if (!pillTaken[i]) {
                availablePills++;
            }
        }
        return "" + getNeoX(x) + getNeoY(x) + getNeoDmg(x) + numberOfAgents + currentHostages + numberOfCarriedHostages
                + availablePills;
        // +Arrays.toString(getPillsTaken(x))
        // +Arrays.toString(getAgentDead(x))
        // +Arrays.toString(getHostageAgentKilled(x));

        // + Arrays.toString(getHostagesDmg(x));

    }

    public static String bfs(Queue<MyTreeNode> queue, boolean visualize) {
        String root = queue.peek().currentState;
        HashSet<String> hash = new HashSet<>();
        int currentHostages;
        int neoPositionX;
        int neoPositionY;
        int telephoneX;
        int telephoneY;
        String x = "";
        MyTreeNode parent;
        boolean done = false;
        boolean noSol = false;
        do {
            // increment the counter to count the branches of the search
            counter++;
            // remove first node from queu
            parent = queue.remove();
            x = parent.currentState;
            hash.add(newHash(x));
            /////////////////////////////////////////////////////////////////////////////////
            neoPositionX = getNeoX(x);
            neoPositionY = getNeoY(x);
            telephoneX = getTelephoneX(x);
            telephoneY = getTelephoneY(x);
            currentHostages = getCurrentHostages(x);
            // System.out.println(currentHostages);
            int neoDmg = getNeoDmg(x);
            /////////////////////////////////////////////////////////////////////////////////
            // up
            if (neoDmg < 100) {
                // System.out.println(counter);
                String newState = up(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("UP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "up");
                        queue.add(tree);

                    }
                }
                // down
                newState = down(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("Down: Before : "+ x);
                        // System.out.println("After: "+newState);
                        // System.out.println("Test"+Arrays.toString(getHostagesX(newState))+"vs"+Arrays.toString(getHostagesX(x)));
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "down");
                        queue.add(tree);

                    }
                }
                // left
                newState = left(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("LEFT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "left");
                        queue.add(tree);

                    }
                }
                // right
                newState = right(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("RIGHT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "right");
                        queue.add(tree);

                    }
                }
                // carry
                newState = carry(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("CARRY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "carry");
                        queue.add(tree);

                    }
                }
                // drop
                newState = drop(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("DROP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "drop");
                        queue.add(tree);

                    }
                }
                // takepill
                newState = takePill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("TAKEPILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "takePill");
                        queue.add(tree);

                    }
                }
                // fly
                newState = fly(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("FLY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "fly");
                        queue.add(tree);

                    }
                }
                // kill
                newState = kill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("KILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "kill");
                        queue.add(tree);

                    }
                }
            }
            if (currentHostages == 0) {
                if (neoPositionX == telephoneX && neoPositionY == telephoneY) {
                    done = true;
                }
            }
            if (!done && queue.size() == 0) {
                noSol = true;
            }
        } while (!done && queue.size() > 0);
        String out = "";
        if (noSol) {
            out = "No Solution";
        } else {
            if (!visualize) {
                int kills = 0;
                int death = 0;
                boolean[] agentDead = getAgentDead(x);
                int[] hostagesDmg = getHostagesDmg(x);
                boolean[] hostageAgentKilled = getHostageAgentKilled(x);

                for (boolean dead : agentDead) {
                    if (dead) {
                        kills++;
                    }
                }

                for (boolean dead : hostageAgentKilled) {
                    if (dead) {
                        kills++;
                    }
                }

                for (int i = 0; i < hostagesDmg.length; i++) {
                    // if (!hostageAgentKilled[i]) {
                    if (hostagesDmg[i] == 100) {
                        death++;
                        // }
                    }

                }
                while (parent.action != "root") {
                    out = "," + parent.action + out;
                    parent = parent.parent;
                }
                out = out.substring(1);
                // death--;
                out += ";" + death + ";" + kills + ";" + counter;

                return out;
            } else {
                ArrayList<String> out2 = new ArrayList<>();
                // String[] out2=new String[50];
                // for (int i = 0; i < out2.length; i++) {
                while (parent != null) {
                    out2.add(parent.currentState);
                    parent = parent.parent;
                    ;
                }
                Collections.reverse(out2);
                new visualize(out2);

            }

            return "";
        }

        return out;
    }

    public static String dfs(Stack<MyTreeNode> queue, boolean visualize) {
        String root = queue.peek().currentState;
        HashSet<String> hash = new HashSet<>();
        int currentHostages;
        int neoPositionX;
        int neoPositionY;
        int telephoneX;
        int telephoneY;
        String x = "";
        MyTreeNode parent;
        boolean done = false;
        boolean noSol = false;
        do {
            // increment the counter to count the branches of the search
            counter++;
            // remove first node from queu
            parent = queue.pop();
            x = parent.currentState;
            hash.add(newHash(x));
            /////////////////////////////////////////////////////////////////////////////////
            neoPositionX = getNeoX(x);
            neoPositionY = getNeoY(x);
            telephoneX = getTelephoneX(x);
            telephoneY = getTelephoneY(x);
            currentHostages = getCurrentHostages(x);
            // System.out.println(currentHostages);
            int neoDmg = getNeoDmg(x);
            /////////////////////////////////////////////////////////////////////////////////
            // up
            if (neoDmg < 100) {
                // System.out.println(counter);
                String newState = up(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("UP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "up");
                        queue.add(tree);

                    }
                }
                // down
                newState = down(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("Down: Before : "+ x);
                        // System.out.println("After: "+newState);
                        // System.out.println("Test"+Arrays.toString(getHostagesX(newState))+"vs"+Arrays.toString(getHostagesX(x)));
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "down");
                        queue.add(tree);

                    }
                }
                // left
                newState = left(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("LEFT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "left");
                        queue.add(tree);

                    }
                }
                // right
                newState = right(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("RIGHT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "right");
                        queue.add(tree);

                    }
                }
                // carry
                newState = carry(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("CARRY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "carry");
                        queue.add(tree);

                    }
                }
                // drop
                newState = drop(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("DROP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "drop");
                        queue.add(tree);

                    }
                }
                // takepill
                newState = takePill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("TAKEPILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "takePill");
                        queue.add(tree);

                    }
                }
                // fly
                newState = fly(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("FLY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "fly");
                        queue.add(tree);

                    }
                }
                // kill
                newState = kill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("KILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        MyTreeNode tree = new MyTreeNode(newState, parent, "kill");
                        queue.add(tree);

                    }
                }
            }
            if (currentHostages == 0) {
                if (neoPositionX == telephoneX && neoPositionY == telephoneY) {
                    done = true;
                }
            }
            if (!done && queue.size() == 0) {
                noSol = true;
            }
        } while (!done && queue.size() > 0);
        String out = "";
        if (noSol) {
            out = "No Solution";
        } else {
            if (!visualize) {
                int kills = 0;
                int death = 0;
                boolean[] agentDead = getAgentDead(x);
                int[] hostagesDmg = getHostagesDmg(x);
                boolean[] hostageAgentKilled = getHostageAgentKilled(x);

                for (boolean dead : agentDead) {
                    if (dead) {
                        kills++;
                    }
                }

                for (boolean dead : hostageAgentKilled) {
                    if (dead) {
                        kills++;
                    }
                }

                for (int i = 0; i < hostagesDmg.length; i++) {
                    // if (!hostageAgentKilled[i]) {
                    if (hostagesDmg[i] == 100) {
                        death++;
                        // }
                    }

                }
                while (parent.action != "root") {
                    out = "," + parent.action + out;
                    parent = parent.parent;
                }
                out = out.substring(1);
                // death--;
                out += ";" + death + ";" + kills + ";" + counter;
            } else {
                ArrayList<String> out2 = new ArrayList<>();
                // String[] out2=new String[50];
                // for (int i = 0; i < out2.length; i++) {
                while (parent != null) {
                    out2.add(parent.currentState);
                    parent = parent.parent;
                    ;
                }
                Collections.reverse(out2);
                new visualize(out2);

            }

            return "";
        }

        return "out";

    }

    public static String ID(Stack<MyTreeNode> queue, boolean visualize) {
        int maxDepth = 0;
        String done = "No Solution";
        MyTreeNode root = queue.peek();

        while (done.equals("No Solution")) {
            done = IDBranching(queue, maxDepth, visualize);
            maxDepth++;
            queue = new Stack<MyTreeNode>();
            queue.add(root);
        }
        return done;
    }

    public static String IDBranching(Stack<MyTreeNode> queue, int maxDepth, boolean visualize) {
        int counter = 0;
        MyTreeNode parent;
        HashSet<String> hash = new HashSet<>();
        boolean done = false;
        String out = "";
        // keep on branching as long as the queue is not empty
        while (!queue.isEmpty()) {
            parent = queue.pop();
            String x = parent.currentState;
            int currentDepth = parent.depth;
            counter++;
            int neoDmg = getNeoDmg(x);
            int currentHostages = getCurrentHostages(x);
            int neoPositionX = getNeoX(x);
            int neoPositionY = getNeoY(x);
            int telephoneX = getTelephoneX(x);
            int telephoneY = getTelephoneY(x);
            hash.add(newHash(x));
            // check if the current node lead to a goal state, if yes, done is true and an
            // output is returned
            if (currentHostages == 0) {
                if (neoPositionX == telephoneX && neoPositionY == telephoneY) {
                    done = true;
                }
            }
            if (done) {
                if (!visualize) {
                    int kills = 0;
                    int death = 0;
                    boolean[] agentDead = getAgentDead(x);
                    int[] hostagesDmg = getHostagesDmg(x);
                    boolean[] hostageAgentKilled = getHostageAgentKilled(x);

                    for (boolean dead : agentDead) {
                        if (dead) {
                            kills++;
                        }
                    }

                    for (boolean dead : hostageAgentKilled) {
                        if (dead) {
                            kills++;
                        }
                    }

                    for (int i = 0; i < hostagesDmg.length; i++) {
                        if (hostagesDmg[i] == 100) {
                            death++;
                        }

                    }
                    while (parent.action != "root") {
                        out = "," + parent.action + out;
                        parent = parent.parent;
                    }
                    out = out.substring(1);
                    out += ";" + death + ";" + kills + ";" + counter;
                    return out;
                } else {
                    ArrayList<String> out2 = new ArrayList<>();
                    // String[] out2=new String[50];
                    // for (int i = 0; i < out2.length; i++) {
                    while (parent != null) {
                        out2.add(parent.currentState);
                        parent = parent.parent;
                        ;
                    }
                    Collections.reverse(out2);
                    new visualize(out2);
                    return "";

                }

            }
            if (parent.depth < maxDepth) {
                // If entered here, then, we can branch more
                if (neoDmg < 100) {
                    // up
                    String newState = up(x, parent);
                    if (newState != null) {
                        if (!hash.contains(newHash(newState))) {
                            hash.add(newHash(newState));
                            MyTreeNode tree = new MyTreeNode(newState, parent, "up", currentDepth + 1);
                            queue.add(tree);

                        }
                    }
                    // down
                    newState = down(x, parent);
                    if (newState != null) {
                        if (!hash.contains(newHash(newState))) {
                            hash.add(newHash(newState));
                            MyTreeNode tree = new MyTreeNode(newState, parent, "down", currentDepth + 1);
                            queue.add(tree);

                        }
                    }
                    // left
                    newState = left(x, parent);
                    if (newState != null) {
                        if (!hash.contains(newHash(newState))) {
                            hash.add(newHash(newState));
                            MyTreeNode tree = new MyTreeNode(newState, parent, "left", currentDepth + 1);
                            queue.add(tree);

                        }
                    }
                    // right
                    newState = right(x, parent);
                    if (newState != null) {
                        if (!hash.contains(newHash(newState))) {
                            hash.add(newHash(newState));
                            MyTreeNode tree = new MyTreeNode(newState, parent, "right", currentDepth + 1);
                            queue.add(tree);

                        }
                    }
                    // carry
                    newState = carry(x, parent);
                    if (newState != null) {
                        if (!hash.contains(newHash(newState))) {
                            hash.add(newHash(newState));
                            MyTreeNode tree = new MyTreeNode(newState, parent, "carry", currentDepth + 1);
                            queue.add(tree);

                        }
                    }
                    // drop
                    newState = drop(x, parent);
                    if (newState != null) {
                        if (!hash.contains(newHash(newState))) {
                            hash.add(newHash(newState));
                            MyTreeNode tree = new MyTreeNode(newState, parent, "drop", currentDepth + 1);
                            queue.add(tree);

                        }
                    }
                    // takepill
                    newState = takePill(x, parent);
                    if (newState != null) {
                        if (!hash.contains(newHash(newState))) {
                            hash.add(newHash(newState));
                            MyTreeNode tree = new MyTreeNode(newState, parent, "takePill", currentDepth + 1);
                            queue.add(tree);

                        }
                    }
                    // fly
                    newState = fly(x, parent);
                    if (newState != null) {
                        if (!hash.contains(newHash(newState))) {
                            hash.add(newHash(newState));
                            MyTreeNode tree = new MyTreeNode(newState, parent, "fly", currentDepth + 1);
                            queue.add(tree);

                        }
                    }
                    // kill
                    newState = kill(x, parent);
                    if (newState != null) {
                        if (!hash.contains(newHash(newState))) {
                            hash.add(newHash(newState));
                            MyTreeNode tree = new MyTreeNode(newState, parent, "kill", currentDepth + 1);
                            queue.add(tree);

                        }
                    }
                }

            }

        }

        return "No Solution";

    }

    public static int getCost(String x) {
        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        int kills = 0;
        int death = 0;
        for (boolean dead : agentDead) {
            if (dead) {
                kills++;
            }
        }

        for (boolean dead : hostageAgentKilled) {
            if (dead) {
                kills++;
            }
        }

        for (int i = 0; i < hostagesDmg.length; i++) {
            // if (!hostageAgentKilled[i]) {
            if (hostagesDmg[i] == 100) {
                death++;
                // }
            }
        }

        int cost = (death * (hostagesX.length + agentsX.length + 1) + kills);
        return cost;
    }

    public static int getG1(String x) {
        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        int cost = 0;
        int deaths = 0;
        int pills = 0;
        for (int i = 0; i < hostagesX.length; i++) {
            if (!(hostagesX[i] == telephoneX && hostagesY[i] == telephoneY)) {
                int costtemp = 0;
                int padstemp = 0;
                costtemp += Math.abs(hostagesX[i] - neoPositionX);
                costtemp += Math.abs(hostagesY[i] - neoPositionY);
                for (int j = 0; j < padsX.length; j += 2) {
                    padstemp += Math.abs(padsX[j] - neoPositionX);
                    padstemp += Math.abs(padsY[j] - neoPositionY);
                    if (padstemp < costtemp) {
                        padstemp += Math.abs(padsX[j + 1] - hostagesX[i]);
                        padstemp += Math.abs(padsY[j + 1] - hostagesY[i]);
                        if (padstemp < costtemp) {
                            costtemp = padstemp;
                        }
                    }

                }
                cost += costtemp;
                neoPositionX = hostagesX[i];
                neoPositionY = hostagesY[i];

            }
        }
        int costBooth = 0;
        costBooth += Math.abs(neoPositionX - telephoneX);
        costBooth += Math.abs(neoPositionY - telephoneY);
        for (int j = 0; j < padsX.length; j += 2) {
            int padstemp = 0;
            padstemp += Math.abs(padsX[j] - neoPositionX);
            padstemp += Math.abs(padsY[j] - neoPositionY);
            if (padstemp < costBooth) {
                padstemp += Math.abs(padsX[j + 1] - telephoneX);
                padstemp += Math.abs(padsY[j + 1] - telephoneY);
                if (padstemp < costBooth) {
                    costBooth = padstemp;
                }
            }

        }
        cost *= 2;
        for (boolean i : pillTaken) {
            if (!i) {
                pills++;
            }
        }
        cost -= (22 * pills);

        for (int i = 0; i < hostagesX.length; i++) {
            if (!(hostagesX[i] == telephoneX && hostagesY[i] == telephoneY)) {
                hostagesDmg[i] += cost;
            }
        }
        for (int i = 0; i < hostagesX.length; i++) {
            if (!(hostagesX[i] == telephoneX && hostagesY[i] == telephoneY)) {
                if (hostagesDmg[i] == 100) {
                    deaths++;
                }
            }

        }
        return deaths;
    }

    public static int getG2(String x) {
        int gridSizeX = getGridSizeX(x);
        int gridSizeY = getGridSizeY(x);
        int neoPositionX = getNeoX(x);
        int neoPositionY = getNeoY(x);
        int cap = getCap(x);
        int telephoneX = getTelephoneX(x);
        int telephoneY = getTelephoneY(x);
        int[] agentsX = getAgentsX(x);
        int[] agentsY = getAgentsY(x);
        boolean[] agentDead = getAgentDead(x);
        int[] hostagesX = getHostagesX(x);
        int[] hostagesY = getHostagesY(x);
        int[] hostagesDmg = getHostagesDmg(x);
        boolean[] hostageAgent = getHostagesAgent(x);
        boolean[] hostageAgentKilled = getHostageAgentKilled(x);
        boolean[] hostagesCarried = getHostagesCarried(x);
        int[] pillsX = getPillsX(x);
        int[] pillsY = getPillsY(x);
        boolean[] pillTaken = getPillsTaken(x);
        int[] padsX = getPadsX(x);
        int[] padsY = getPadsY(x);
        int currentHostages = getCurrentHostages(x);
        int neoDmg = getNeoDmg(x);
        int carryCount = getCarryCount(x);

        int cost = 0;
        int deaths = 0;
        int cost2 = 0;
        int kills = 0;
        int pills = 0;

        for (int i = 0; i < hostageAgent.length; i++) {
            if (hostageAgent[i] && !hostageAgentKilled[i]) {
                cost += Math.abs(hostagesX[i] - neoPositionX);
                cost += Math.abs(hostagesY[i] - neoPositionY);
                kills++;
            }
        }
        for (int i = 0; i < hostagesX.length; i++) {
            if (!(hostagesX[i] == telephoneX && hostagesY[i] == telephoneY)) {
                cost += Math.abs(hostagesX[i] - neoPositionX);
                cost += Math.abs(hostagesY[i] - neoPositionY);
                neoPositionX = hostagesX[i];
                neoPositionY = hostagesY[i];

            }
        }
        cost += Math.abs(neoPositionX - telephoneX);
        cost += Math.abs(neoPositionY - telephoneY);
        cost *= 2;
        for (boolean i : pillTaken) {
            if (!i) {
                pills++;
            }
        }
        cost -= (22 * pills);

        for (int i = 0; i < hostagesX.length; i++) {
            if (!(hostagesX[i] == telephoneX && hostagesY[i] == telephoneY)) {
                hostagesDmg[i] += cost;
            }
        }
        for (int i = 0; i < hostagesX.length; i++) {
            if (!(hostagesX[i] == telephoneX && hostagesY[i] == telephoneY)) {
                if (hostagesDmg[i] == 100) {
                    deaths++;
                }
            }

        }
        return deaths + kills;
    }

    public static String UC(ArrayList<MyTreeNode> queue, boolean visualize) {
        String root = queue.get(0).currentState;
        HashSet<String> hash = new HashSet<>();
        int currentHostages;
        int neoPositionX;
        int neoPositionY;
        int telephoneX;
        int telephoneY;
        String x = "";
        MyTreeNode parent;
        boolean done = false;
        boolean noSol = false;
        do {
            // increment the counter to count the branches of the search
            counter++;
            // Comparator<MyTreeNode> employeeNameComparator=
            // Comparator.comparing(MyTreeNode::getCost);
            queue.sort(Comparator.comparing(MyTreeNode::getCost));
            // remove first node from queu
            parent = queue.remove(0);
            x = parent.currentState;
            hash.add(newHash(x));
            /////////////////////////////////////////////////////////////////////////////////
            neoPositionX = getNeoX(x);
            neoPositionY = getNeoY(x);
            telephoneX = getTelephoneX(x);
            telephoneY = getTelephoneY(x);
            currentHostages = getCurrentHostages(x);
            // System.out.println(currentHostages);
            int neoDmg = getNeoDmg(x);
            /////////////////////////////////////////////////////////////////////////////////
            // up
            if (neoDmg < 100) {
                // System.out.println(counter);
                String newState = up(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("UP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getCost(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost + parent.getCost(), "up");
                        queue.add(tree);

                    }
                }
                // down
                newState = down(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("Down: Before : "+ x);
                        // System.out.println("After: "+newState);
                        // System.out.println("Test"+Arrays.toString(getHostagesX(newState))+"vs"+Arrays.toString(getHostagesX(x)));
                        hash.add(newHash(newState));
                        int cost = getCost(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost + parent.getCost(), "down");
                        queue.add(tree);

                    }
                }
                // left
                newState = left(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("LEFT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getCost(newState);

                        MyTreeNode tree = new MyTreeNode(newState, parent, cost + parent.getCost(), "left");
                        queue.add(tree);

                    }
                }
                // right
                newState = right(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("RIGHT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getCost(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost + parent.getCost(), "right");
                        queue.add(tree);

                    }
                }
                // carry
                newState = carry(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("CARRY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getCost(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost + parent.getCost(), "carry");
                        queue.add(tree);

                    }
                }
                // drop
                newState = drop(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("DROP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getCost(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost + parent.getCost(), "drop");
                        queue.add(tree);

                    }
                }
                // takepill
                newState = takePill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("TAKEPILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getCost(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost + parent.getCost(), "takePill");
                        queue.add(tree);

                    }
                }
                // fly
                newState = fly(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("FLY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getCost(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost + parent.getCost(), "fly");
                        queue.add(tree);

                    }
                }
                // kill
                newState = kill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("KILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getCost(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost + parent.getCost(), "kill");
                        queue.add(tree);

                    }
                }
            }
            if (currentHostages == 0) {
                if (neoPositionX == telephoneX && neoPositionY == telephoneY) {
                    done = true;
                }
            }
            if (!done && queue.size() == 0) {
                noSol = true;
            }
        } while (!done && queue.size() > 0);
        String out = "";
        if (noSol) {
            out = "No Solution";
        } else {
            if (!visualize) {
                int kills = 0;
                int death = 0;
                boolean[] agentDead = getAgentDead(x);
                int[] hostagesDmg = getHostagesDmg(x);
                boolean[] hostageAgentKilled = getHostageAgentKilled(x);

                for (boolean dead : agentDead) {
                    if (dead) {
                        kills++;
                    }
                }

                for (boolean dead : hostageAgentKilled) {
                    if (dead) {
                        kills++;
                    }
                }

                for (int i = 0; i < hostagesDmg.length; i++) {
                    // if (!hostageAgentKilled[i]) {
                    if (hostagesDmg[i] == 100) {
                        death++;
                        // }
                    }

                }
                while (parent.action != "root") {
                    out = "," + parent.action + out;
                    parent = parent.parent;
                }
                out = out.substring(1);
                // death--;
                out += ";" + death + ";" + kills + ";" + counter;
            } else {
                ArrayList<String> out2 = new ArrayList<>();
                // String[] out2=new String[50];
                // for (int i = 0; i < out2.length; i++) {
                while (parent != null) {
                    out2.add(parent.currentState);
                    parent = parent.parent;
                    ;
                }
                Collections.reverse(out2);
                new visualize(out2);

            }

            return "";
        }

        return "out";

    }

    public static String GR1(ArrayList<MyTreeNode> queue, boolean visualize) {
        String root = queue.get(0).currentState;
        HashSet<String> hash = new HashSet<>();
        int currentHostages;
        int neoPositionX;
        int neoPositionY;
        int telephoneX;
        int telephoneY;
        String x = "";
        MyTreeNode parent;
        boolean done = false;
        boolean noSol = false;
        do {
            // increment the counter to count the branches of the search
            counter++;
            // Comparator<MyTreeNode> employeeNameComparator=
            // Comparator.comparing(MyTreeNode::getCost);
            queue.sort(Comparator.comparing(MyTreeNode::getCost));
            // remove first node from queu
            parent = queue.remove(0);
            x = parent.currentState;
            hash.add(newHash(x));
            /////////////////////////////////////////////////////////////////////////////////
            neoPositionX = getNeoX(x);
            neoPositionY = getNeoY(x);
            telephoneX = getTelephoneX(x);
            telephoneY = getTelephoneY(x);
            currentHostages = getCurrentHostages(x);
            // System.out.println(currentHostages);
            int neoDmg = getNeoDmg(x);
            /////////////////////////////////////////////////////////////////////////////////
            // up
            if (neoDmg < 100) {
                // System.out.println(counter);
                String newState = up(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("UP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "up");
                        queue.add(tree);

                    }
                }
                // down
                newState = down(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("Down: Before : "+ x);
                        // System.out.println("After: "+newState);
                        // System.out.println("Test"+Arrays.toString(getHostagesX(newState))+"vs"+Arrays.toString(getHostagesX(x)));
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "down");
                        queue.add(tree);

                    }
                }
                // left
                newState = left(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("LEFT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);

                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "left");
                        queue.add(tree);

                    }
                }
                // right
                newState = right(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("RIGHT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "right");
                        queue.add(tree);

                    }
                }
                // carry
                newState = carry(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("CARRY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "carry");
                        queue.add(tree);

                    }
                }
                // drop
                newState = drop(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("DROP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "drop");
                        queue.add(tree);

                    }
                }
                // takepill
                newState = takePill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("TAKEPILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "takePill");
                        queue.add(tree);

                    }
                }
                // fly
                newState = fly(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("FLY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "fly");
                        queue.add(tree);

                    }
                }
                // kill
                newState = kill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("KILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "kill");
                        queue.add(tree);

                    }
                }
            }
            if (currentHostages == 0) {
                if (neoPositionX == telephoneX && neoPositionY == telephoneY) {
                    done = true;
                }
            }
            if (!done && queue.size() == 0) {
                noSol = true;
            }
        } while (!done && queue.size() > 0);
        String out = "";
        if (noSol) {
            out = "No Solution";
        } else {
            if (!visualize) {
                int kills = 0;
                int death = 0;
                boolean[] agentDead = getAgentDead(x);
                int[] hostagesDmg = getHostagesDmg(x);
                boolean[] hostageAgentKilled = getHostageAgentKilled(x);

                for (boolean dead : agentDead) {
                    if (dead) {
                        kills++;
                    }
                }

                for (boolean dead : hostageAgentKilled) {
                    if (dead) {
                        kills++;
                    }
                }

                for (int i = 0; i < hostagesDmg.length; i++) {
                    // if (!hostageAgentKilled[i]) {
                    if (hostagesDmg[i] == 100) {
                        death++;
                        // }
                    }

                }
                while (parent.action != "root") {
                    out = "," + parent.action + out;
                    parent = parent.parent;
                }
                out = out.substring(1);
                // death--;
                out += ";" + death + ";" + kills + ";" + counter;
            } else {
                ArrayList<String> out2 = new ArrayList<>();
                // String[] out2=new String[50];
                // for (int i = 0; i < out2.length; i++) {
                while (parent != null) {
                    out2.add(parent.currentState);
                    parent = parent.parent;
                    ;
                }
                Collections.reverse(out2);
                new visualize(out2);

            }

            return "";
        }

        return "out";

    }

    public static String GR2(ArrayList<MyTreeNode> queue, boolean visualize) {
        String root = queue.get(0).currentState;
        HashSet<String> hash = new HashSet<>();
        int currentHostages;
        int neoPositionX;
        int neoPositionY;
        int telephoneX;
        int telephoneY;
        String x = "";
        MyTreeNode parent;
        boolean done = false;
        boolean noSol = false;
        do {
            // increment the counter to count the branches of the search
            counter++;
            // Comparator<MyTreeNode> employeeNameComparator=
            // Comparator.comparing(MyTreeNode::getCost);
            queue.sort(Comparator.comparing(MyTreeNode::getCost));
            // remove first node from queu
            parent = queue.remove(0);
            x = parent.currentState;
            hash.add(newHash(x));
            /////////////////////////////////////////////////////////////////////////////////
            neoPositionX = getNeoX(x);
            neoPositionY = getNeoY(x);
            telephoneX = getTelephoneX(x);
            telephoneY = getTelephoneY(x);
            currentHostages = getCurrentHostages(x);
            // System.out.println(currentHostages);
            int neoDmg = getNeoDmg(x);
            /////////////////////////////////////////////////////////////////////////////////
            // up
            if (neoDmg < 100) {
                // System.out.println(counter);
                String newState = up(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("UP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "up");
                        queue.add(tree);

                    }
                }
                // down
                newState = down(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("Down: Before : "+ x);
                        // System.out.println("After: "+newState);
                        // System.out.println("Test"+Arrays.toString(getHostagesX(newState))+"vs"+Arrays.toString(getHostagesX(x)));
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "down");
                        queue.add(tree);

                    }
                }
                // left
                newState = left(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("LEFT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);

                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "left");
                        queue.add(tree);

                    }
                }
                // right
                newState = right(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("RIGHT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "right");
                        queue.add(tree);

                    }
                }
                // carry
                newState = carry(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("CARRY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "carry");
                        queue.add(tree);

                    }
                }
                // drop
                newState = drop(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("DROP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "drop");
                        queue.add(tree);

                    }
                }
                // takepill
                newState = takePill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("TAKEPILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "takePill");
                        queue.add(tree);

                    }
                }
                // fly
                newState = fly(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("FLY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "fly");
                        queue.add(tree);

                    }
                }
                // kill
                newState = kill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("KILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "kill");
                        queue.add(tree);

                    }
                }
            }
            if (currentHostages == 0) {
                if (neoPositionX == telephoneX && neoPositionY == telephoneY) {
                    done = true;
                }
            }
            if (!done && queue.size() == 0) {
                noSol = true;
            }
        } while (!done && queue.size() > 0);
        String out = "";
        if (noSol) {
            out = "No Solution";
        } else {
            if (!visualize) {
                int kills = 0;
                int death = 0;
                boolean[] agentDead = getAgentDead(x);
                int[] hostagesDmg = getHostagesDmg(x);
                boolean[] hostageAgentKilled = getHostageAgentKilled(x);

                for (boolean dead : agentDead) {
                    if (dead) {
                        kills++;
                    }
                }

                for (boolean dead : hostageAgentKilled) {
                    if (dead) {
                        kills++;
                    }
                }

                for (int i = 0; i < hostagesDmg.length; i++) {
                    // if (!hostageAgentKilled[i]) {
                    if (hostagesDmg[i] == 100) {
                        death++;
                        // }
                    }

                }
                while (parent.action != "root") {
                    out = "," + parent.action + out;
                    parent = parent.parent;
                }
                out = out.substring(1);
                // death--;
                out += ";" + death + ";" + kills + ";" + counter;
            } else {
                ArrayList<String> out2 = new ArrayList<>();
                // String[] out2=new String[50];
                // for (int i = 0; i < out2.length; i++) {
                while (parent != null) {
                    out2.add(parent.currentState);
                    parent = parent.parent;
                    ;
                }
                Collections.reverse(out2);
                new visualize(out2);

            }

            return "";
        }

        return "out";

    }

    public static String AS1(ArrayList<MyTreeNode> queue, boolean visualize) {
        String root = queue.get(0).currentState;
        HashSet<String> hash = new HashSet<>();
        int currentHostages;
        int neoPositionX;
        int neoPositionY;
        int telephoneX;
        int telephoneY;
        String x = "";
        MyTreeNode parent;
        boolean done = false;
        boolean noSol = false;
        do {
            // increment the counter to count the branches of the search
            counter++;
            // Comparator<MyTreeNode> employeeNameComparator=
            // Comparator.comparing(MyTreeNode::getCost);
            queue.sort(Comparator.comparing(MyTreeNode::getCost));
            // remove first node from queu
            parent = queue.remove(0);
            x = parent.currentState;
            hash.add(newHash(x));
            /////////////////////////////////////////////////////////////////////////////////
            neoPositionX = getNeoX(x);
            neoPositionY = getNeoY(x);
            telephoneX = getTelephoneX(x);
            telephoneY = getTelephoneY(x);
            currentHostages = getCurrentHostages(x);
            // System.out.println(currentHostages);
            int neoDmg = getNeoDmg(x);
            /////////////////////////////////////////////////////////////////////////////////
            // up
            if (neoDmg < 100) {
                // System.out.println(counter);
                String newState = up(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("UP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "up");
                        queue.add(tree);

                    }
                }
                // down
                newState = down(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("Down: Before : "+ x);
                        // System.out.println("After: "+newState);
                        // System.out.println("Test"+Arrays.toString(getHostagesX(newState))+"vs"+Arrays.toString(getHostagesX(x)));
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "down");
                        queue.add(tree);

                    }
                }
                // left
                newState = left(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("LEFT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "left");
                        queue.add(tree);

                    }
                }
                // right
                newState = right(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("RIGHT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "right");
                        queue.add(tree);

                    }
                }
                // carry
                newState = carry(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("CARRY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "carry");
                        queue.add(tree);

                    }
                }
                // drop
                newState = drop(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("DROP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "drop");
                        queue.add(tree);

                    }
                }
                // takepill
                newState = takePill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("TAKEPILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "takePill");
                        queue.add(tree);

                    }
                }
                // fly
                newState = fly(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("FLY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "fly");
                        queue.add(tree);

                    }
                }
                // kill
                newState = kill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("KILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "kill");
                        queue.add(tree);

                    }
                }
            }
            if (currentHostages == 0) {
                if (neoPositionX == telephoneX && neoPositionY == telephoneY) {
                    done = true;
                }
            }
            if (!done && queue.size() == 0) {
                noSol = true;
            }
        } while (!done && queue.size() > 0);
        String out = "";
        if (noSol) {
            out = "No Solution";
        } else {
            if (!visualize) {
                int kills = 0;
                int death = 0;
                boolean[] agentDead = getAgentDead(x);
                int[] hostagesDmg = getHostagesDmg(x);
                boolean[] hostageAgentKilled = getHostageAgentKilled(x);

                for (boolean dead : agentDead) {
                    if (dead) {
                        kills++;
                    }
                }

                for (boolean dead : hostageAgentKilled) {
                    if (dead) {
                        kills++;
                    }
                }

                for (int i = 0; i < hostagesDmg.length; i++) {
                    // if (!hostageAgentKilled[i]) {
                    if (hostagesDmg[i] == 100) {
                        death++;
                        // }
                    }

                }
                while (parent.action != "root") {
                    out = "," + parent.action + out;
                    parent = parent.parent;
                }
                out = out.substring(1);
                // death--;
                out += ";" + death + ";" + kills + ";" + counter;
            } else {
                ArrayList<String> out2 = new ArrayList<>();
                // String[] out2=new String[50];
                // for (int i = 0; i < out2.length; i++) {
                while (parent != null) {
                    out2.add(parent.currentState);
                    parent = parent.parent;
                    ;
                }
                Collections.reverse(out2);
                new visualize(out2);

            }

            return "";
        }

        return "out";

    }

    public static String AS2(ArrayList<MyTreeNode> queue, boolean visualize) {
        String root = queue.get(0).currentState;
        HashSet<String> hash = new HashSet<>();
        int currentHostages;
        int neoPositionX;
        int neoPositionY;
        int telephoneX;
        int telephoneY;
        String x = "";
        MyTreeNode parent;
        boolean done = false;
        boolean noSol = false;
        do {
            // increment the counter to count the branches of the search
            counter++;
            // Comparator<MyTreeNode> employeeNameComparator=
            // Comparator.comparing(MyTreeNode::getCost);
            queue.sort(Comparator.comparing(MyTreeNode::getCost));
            // remove first node from queu
            parent = queue.remove(0);
            x = parent.currentState;
            hash.add(newHash(x));
            /////////////////////////////////////////////////////////////////////////////////
            neoPositionX = getNeoX(x);
            neoPositionY = getNeoY(x);
            telephoneX = getTelephoneX(x);
            telephoneY = getTelephoneY(x);
            currentHostages = getCurrentHostages(x);
            // System.out.println(currentHostages);
            int neoDmg = getNeoDmg(x);
            /////////////////////////////////////////////////////////////////////////////////
            // up
            if (neoDmg < 100) {
                // System.out.println(counter);
                String newState = up(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("UP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG2(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "up");
                        queue.add(tree);

                    }
                }
                // down
                newState = down(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("Down: Before : "+ x);
                        // System.out.println("After: "+newState);
                        // System.out.println("Test"+Arrays.toString(getHostagesX(newState))+"vs"+Arrays.toString(getHostagesX(x)));
                        hash.add(newHash(newState));
                        int cost = getG1(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "down");
                        queue.add(tree);

                    }
                }
                // left
                newState = left(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("LEFT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG2(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "left");
                        queue.add(tree);

                    }
                }
                // right
                newState = right(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("RIGHT: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG2(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "right");
                        queue.add(tree);

                    }
                }
                // carry
                newState = carry(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("CARRY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG2(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "carry");
                        queue.add(tree);

                    }
                }
                // drop
                newState = drop(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("DROP: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG2(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "drop");
                        queue.add(tree);

                    }
                }
                // takepill
                newState = takePill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("TAKEPILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG2(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "takePill");
                        queue.add(tree);

                    }
                }
                // fly
                newState = fly(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("FLY: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG2(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "fly");
                        queue.add(tree);

                    }
                }
                // kill
                newState = kill(x, parent);
                if (newState != null) {
                    if (!hash.contains(newHash(newState))) {
                        // System.out.println("KILL: Before : "+ x);
                        // System.out.println("After: "+newState);
                        hash.add(newHash(newState));
                        int cost = getG2(newState);
                        cost += getCost(newState);
                        cost += getCost(x);
                        MyTreeNode tree = new MyTreeNode(newState, parent, cost, "kill");
                        queue.add(tree);

                    }
                }
            }
            if (currentHostages == 0) {
                if (neoPositionX == telephoneX && neoPositionY == telephoneY) {
                    done = true;
                }
            }
            if (!done && queue.size() == 0) {
                noSol = true;
            }
        } while (!done && queue.size() > 0);
        String out = "";
        if (noSol) {
            out = "No Solution";
        } else {
            if (!visualize) {
                int kills = 0;
                int death = 0;
                boolean[] agentDead = getAgentDead(x);
                int[] hostagesDmg = getHostagesDmg(x);
                boolean[] hostageAgentKilled = getHostageAgentKilled(x);

                for (boolean dead : agentDead) {
                    if (dead) {
                        kills++;
                    }
                }

                for (boolean dead : hostageAgentKilled) {
                    if (dead) {
                        kills++;
                    }
                }

                for (int i = 0; i < hostagesDmg.length; i++) {
                    // if (!hostageAgentKilled[i]) {
                    if (hostagesDmg[i] == 100) {
                        death++;
                        // }
                    }

                }
                while (parent.action != "root") {
                    out = "," + parent.action + out;
                    parent = parent.parent;
                }
                out = out.substring(1);
                // death--;
                out += ";" + death + ";" + kills + ";" + counter;
            } else {
                ArrayList<String> out2 = new ArrayList<>();
                // String[] out2=new String[50];
                // for (int i = 0; i < out2.length; i++) {
                while (parent != null) {
                    out2.add(parent.currentState);
                    parent = parent.parent;
                    ;
                }
                Collections.reverse(out2);
                new visualize(out2);

            }

            return "";
        }

        return "out";

    }

    // Change grid to a string to be used
    public static String stringifyGrid(String grid) {
        String[] gridSplit = grid.split(";");
        String[] gridSize = gridSplit[0].split(",");
        String capacity = gridSplit[1];
        String[] neoPosition = gridSplit[2].split(",");
        String[] telephone = gridSplit[3].split(",");
        String[] agents = gridSplit[4].split(",");
        String[] pills = gridSplit[5].split(",");
        String[] pads = gridSplit[6].split(",");
        String[] hostages = gridSplit[7].split(",");
        int neoDmg = 0;
        int gridSizeX = Integer.parseInt(gridSize[0]);
        int gridSizeY = Integer.parseInt(gridSize[1]);
        int cap = Integer.parseInt(capacity);
        int neoPositionX = Integer.parseInt(neoPosition[0]);
        int neoPositionY = Integer.parseInt(neoPosition[1]);
        int telephoneX = Integer.parseInt(telephone[0]);
        int telephoneY = Integer.parseInt(telephone[1]);
        int[] agentsX = new int[agents.length / 2];
        int[] agentsY = new int[agents.length / 2];
        boolean[] agentDead = new boolean[agents.length / 2];
        for (int i = 0; i < agentsX.length; i++) {
            agentsX[i] = Integer.parseInt(agents[i * 2]);
            agentsY[i] = Integer.parseInt(agents[i * 2 + 1]);
            agentDead[i] = false;
        }
        int[] pillsX = new int[pills.length / 2];
        int[] pillsY = new int[pills.length / 2];
        boolean[] pillTaken = new boolean[pills.length / 2];
        for (int i = 0; i < pillsX.length; i++) {
            pillsX[i] = Integer.parseInt(pills[i * 2]);
            pillsY[i] = Integer.parseInt(pills[i * 2 + 1]);
            pillTaken[i] = false;
        }
        int[] padsX = new int[pads.length / 2];
        int[] padsY = new int[pads.length / 2];
        for (int i = 0; i < padsX.length; i++) {
            padsX[i] = Integer.parseInt(pads[i * 2]);
            padsY[i] = Integer.parseInt(pads[i * 2 + 1]);
        }
        int[] hostagesX = new int[hostages.length / 3];
        int[] hostagesY = new int[hostages.length / 3];
        int[] hostagesDmg = new int[hostages.length / 3];
        boolean[] hostagesCarried = new boolean[hostages.length / 3];
        boolean[] hostageAgent = new boolean[hostages.length / 3];
        boolean[] hostageAgentKilled = new boolean[hostages.length / 3];

        for (int i = 0; i < hostagesX.length; i++) {
            hostagesX[i] = Integer.parseInt(hostages[i * 3]);
            hostagesY[i] = Integer.parseInt(hostages[i * 3 + 1]);
            hostagesDmg[i] = Integer.parseInt(hostages[i * 3 + 2]);
            hostagesCarried[i] = false;
            hostageAgent[i] = false;
            hostageAgentKilled[i] = false;
        }
        int currentHostages = hostagesX.length;
        int carryCount = 0;
        return "" + gridSizeX + ";" + gridSizeY + ";" + cap + ";" + neoPositionX + ";" + neoPositionY + ";" + telephoneX
                + ";" + telephoneY + ";" + Arrays.toString(agentsX) + ";" + Arrays.toString(agentsY) + ";"
                + Arrays.toString(pillsX) + ";" + Arrays.toString(pillsY) + ";" + Arrays.toString(pillTaken) + ";"
                + Arrays.toString(padsX) + ";" + Arrays.toString(padsY) + ";" + Arrays.toString(hostagesX) + ";"
                + Arrays.toString(hostagesY) + ";" + Arrays.toString(hostagesDmg) + ";" + currentHostages + ";"
                + Arrays.toString(hostagesCarried) + ";" + Arrays.toString(hostageAgent) + ";"
                + Arrays.toString(hostageAgentKilled) + ";" + Arrays.toString(agentDead) + ";" + neoDmg + ";"
                + carryCount;

    }

    public static String solve(String grid, String strategy, boolean visualize) throws Exception {
        // Neo's Damage is initially zero
        int neoDmg = 0;
        // Split the grid and output the structure of the state that'll be used in the
        // rest of the functionalities
        String stateIn = stringifyGrid(grid);
        // Create the rood node with the initial state of the grid after being
        // organized, giving it a null parent, and an action of root then, adding it to
        // the queue
        MyTreeNode tree = new MyTreeNode(stateIn, null, "root");
        Queue<MyTreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        Stack<MyTreeNode> stack = new Stack<>();
        stack.add(tree);
        // create another node with depth into consideration,where root has depth of 0
        MyTreeNode tree2 = new MyTreeNode(stateIn, null, "root", 0);
        Stack<MyTreeNode> stackID = new Stack<>();
        stackID.add(tree2);
        ArrayList<MyTreeNode> array = new ArrayList<>();
        MyTreeNode tree3 = new MyTreeNode(stateIn, null, 0, "root");
        array.add(tree3);

        switch (strategy) {
            case "BF":
                return (bfs(queue, visualize));
            case "DF":
                return (dfs(stack, visualize));
            case "ID":
                return (ID(stackID, visualize));
            case "UC":
                return (UC(array, visualize));
            case "GR1":
                return (GR1(array, visualize));
            case "GR2":
                return (GR2(array, visualize));
            case "AS1":
                return (AS1(array, visualize));
            case "AS2":
                return (AS2(array, visualize));

        }
        return "";

    }

    public static void main(String[] args) throws Exception {
        // for (int i = 0; i < 10; i++) {
        // String grid = genGrid();
        String grid = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String grid1 = "5,5;1;1,4;1,0;0,4;0,0,2,2;3,4,4,2,4,2,3,4;0,2,32,0,1,38";
        String grid5 = "5,5;2;0,4;3,4;3,1,1,1;2,3;3,0,0,1,0,1,3,0;4,2,54,4,0,85,1,0,43";
        String grid0 = "5,5;2;3,4;1,2;0,3,1,4;2,3;4,4,0,2,0,2,4,4;2,2,91,2,4,62";
        String grid9 = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String grid2 = "5,5;2;3,2;0,1;4,1;0,3;1,2,4,2,4,2,1,2,0,4,3,0,3,0,0,4;1,1,77,3,4,34";
        String grid3 = "5,5;1;0,4;4,4;0,3,1,4,2,1,3,0,4,1;4,0;2,4,3,4,3,4,2,4;0,2,98,1,2,98,2,2,98,3,2,98,4,2,98,2,0,1";
        String grid6 = "5,5;2;3,0;4,3;2,1,2,2,3,1,0,0,1,1,4,2,3,3,1,3,0,1;2,4,3,2,3,4,0,4;4,4,4,0,4,0,4,4;1,4,57,2,0,46";

        // solve(grid1, "BFS", false);
        // System.out.println("hi");
        String out = solve(grid6, "ID", true);
        System.out.println(out);

        // }
    }
}