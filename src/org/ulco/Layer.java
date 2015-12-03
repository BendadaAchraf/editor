package org.ulco;
import java.util.Vector;

public class Layer  {
    public Layer() {
        m_list = new Vector<GraphicsObject>();
        m_ID = ID.instance();
    }



    public Vector<GraphicsObject> getM_list() { return m_list;}
    public Layer(String json) {
        m_list= new Vector<GraphicsObject>();
        String str = json.replaceAll("\\s+","");
        int objectsIndex = str.indexOf("objects");
        int endIndex = str.lastIndexOf("}");
        parseObjects(str.substring(objectsIndex + 9, endIndex - 1));
    }
    public void add(GraphicsObject o) {
        m_list.add(o);
    }

    public GraphicsObject get(int index) {
        return m_list.elementAt(index);
    }
    public int getObjectNumber() {
        return m_list.size();
    }
    public int getID() {
        return m_ID;
    }





    public void parseObjects(String objectsStr) {
        while (!objectsStr.isEmpty()) {
            int separatorIndex = Group.searchSeparator(objectsStr);
            String objectStr;
            if (separatorIndex == -1) {
                objectStr = objectsStr;
            } else {
                objectStr = objectsStr.substring(0, separatorIndex);
            }
            m_list.add(JSON.parse(objectStr));
            if (separatorIndex == -1) {
                objectsStr = "";
            } else {
                objectsStr = objectsStr.substring(separatorIndex + 1);
            }
        }
    }

    public String toJson() {
        String str = "{ type: layer, objects : { ";
        for (int i = 0; i < m_list.size(); ++i) {
            GraphicsObject element = m_list.elementAt(i);
            str += element.toJson();
            if (i < m_list.size() - 1) {
                str += ", ";
            }
        }
        return str + " } }";
    }



    private Vector<GraphicsObject> m_list;
    private int m_ID;
}