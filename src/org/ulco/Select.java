package org.ulco;
public class Select {
    public static GraphicsObjects select(Document document, Point p, double distance) {
        GraphicsObjects list = new GraphicsObjects();
        for(Layer layer : document.getLayers()) {
            list.addAll(select(layer, p, distance));
        }
        return list;
    }
    public static GraphicsObjects select(Layer layer, Point pt, double distance) {
        GraphicsObjects list = new GraphicsObjects();
        for (GraphicsObject object : layer.getM_list()) {
            if (object.isClosed(pt, distance)) {
                list.add(object);
            }
            if(object instanceof Group) {
                for (GraphicsObject ob : ((Group) object).getElements()) {
                    if (ob.isClosed(pt, distance)) {
                        list.add(object);
                    }
                }
            }
        }
        return list;
    }
}