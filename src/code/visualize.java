package code;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyTableCellRenderer extends JLabel implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (String.valueOf(value).indexOf("Pill") != -1) {
            setForeground(Color.RED);
        } else if (String.valueOf(value).indexOf("Hostage") != -1) {
            setForeground(Color.ORANGE);
        } else if (String.valueOf(value).indexOf("pad") != -1) {
            setForeground(Color.GREEN);
        } else if (String.valueOf(value).indexOf("Agent") != -1) {
            setForeground(Color.MAGENTA);
        } else if (String.valueOf(value).indexOf("Neo") != -1) {
            setForeground(Color.white);
        } else if (String.valueOf(value).indexOf("TB") != -1) {
            setForeground(Color.BLUE);
        }
        if (String.valueOf(value) != "null") {
            setText(String.valueOf(value));
        } else {
            setText("");
        }
        setFont(new Font("Serif", Font.BOLD, 20));
        setHorizontalAlignment(JLabel.CENTER);
        setBackground(Color.black);

        return this;
    }
}

public class visualize extends Canvas {
    JFrame f;

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

        int currentHostages = Integer.parseInt(temp[17]);
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

    public int counter = 0;

    public String[][] generateData(String x) {

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
        f = new JFrame();
        String data[][] = new String[gridSizeX][gridSizeY];
        for (String[] row : data)
            Arrays.fill(row, "");
        // Arrays.fill(data, ".");
        String column[] = { "hi", "hi", "hi", "hi", "hi" };
        data[neoPositionX][neoPositionY] += "Neo (" + neoDmg + ")";
        data[telephoneX][telephoneY] += "TB";

        for (int i = 0; i < hostagesX.length; i++) {
            if (!hostagesCarried[i])
                data[hostagesX[i]][hostagesY[i]] += "Hostage(" + hostagesDmg[i] + ") - " + (i + 1);
        }
        for (int i = 0; i < pillsX.length; i++) {
            if (!pillTaken[i])
                data[pillsX[i]][pillsY[i]] += "Pill(" + (i + 1) + ")";
        }
        for (int i = 0; i < agentsX.length; i++) {
            if (!agentDead[i])
                data[agentsX[i]][agentsY[i]] += "Agent(" + (i + 1) + ")";
        }
        int c = 1;
        for (int i = 0; i < padsX.length; i += 4) {
            data[padsX[i]][padsY[i]] += "pad(" + (c) + ")";
            data[padsX[i + 1]][padsY[i + 1]] += "pad(" + (c) + ")";

            c++;

        }
        return data;
    }

    String[][] data = new String[0][0];

    public visualize(ArrayList<String> z) {
        String column[] = { "hi", "hi", "hi", "hi", "hi" };
        data = generateData(z.remove(0));
        JTable jt = new JTable(data, column);
        jt.setTableHeader(null);
        jt.setFont(new Font("Serif", Font.BOLD, 20));
        // jt.setForeground(Color.blue);

        MyTableCellRenderer centerRenderer = new MyTableCellRenderer();
        jt.setDefaultRenderer(Object.class, centerRenderer);

        // jt.setBounds(0, 0, 1000, 1000);
        jt.setSize(1000, 700);
        f.setBackground(Color.black);
        jt.setRowHeight(jt.getRowHeight() + 100);
        jt.setOpaque(false);
        Container pane = new Container();
        ;
        JScrollPane sp = new JScrollPane(jt);
        sp.getViewport().setBackground(Color.black);
        JButton b = new JButton("next");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String column[] = { "hi", "hi", "hi", "hi", "hi" };
                data = generateData(z.remove(0));
                JTable jt2 = new JTable(data, column);
                jt.setModel(jt2.getModel());
                f.revalidate();
                f.repaint();
                System.out.println(counter);
            }
        });
        b.setBounds(10, 750, 90, 30);
        // sp.add(b);
        // f.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        // sp.add(jt);
        // sp.add(b);
        // pane.setvie
        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
        f.add(sp);
        f.add(b);
        // f.add(b);
        f.setSize(1000, 1000);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        String grid1 = "5,5;1;1,4;1,0;0,4;0,0,2,2;3,4,4,2,4,2,3,4;0,2,32,0,1,38";
        String grid0 = "5,5;2;3,4;1,2;0,3,1,4;2,3;4,4,0,2,0,2,4,4;2,2,91,2,4,62";

        String x = stringifyGrid(grid1);
        String z = stringifyGrid(grid0);
        // String[] c = { x, z };
        // new visualize(c);
    }
}
